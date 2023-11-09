package com.owlapps.samarony.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.FormParam;

import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.util.JSON;
import com.owlapps.samarony.model.CarModel;
import com.owlapps.samarony.model.District;
import com.owlapps.samarony.model.DistrictList;
import com.owlapps.samarony.model.Image;
import com.owlapps.samarony.repository.BrandRepository;
import com.owlapps.samarony.repository.CarRepository;
import com.owlapps.samarony.repository.DepartamentRepository;
import com.owlapps.samarony.repository.ImageRepository;
import com.owlapps.samarony.repository.SizeRepository;
import com.owlapps.samarony.service.CarService;
import com.owlapps.samarony.service.IImageService;
import com.owlapps.samarony.service.SequenceCarGeneratorService;
import com.owlapps.samarony.service.SequenceImageGeneratorService;
import com.owlapps.samarony.util.DateUtils;

@RestController
public class ProductController {
	
	@Autowired
	private CarService carService;
		
	@Autowired
    IImageService imageService;
	
	@Autowired
    CarRepository carRepository;
	
	@Autowired
    ImageRepository imageRepository;
	
	@Autowired
    SizeRepository sizeRepository;
	
	@Autowired
    DepartamentRepository departamentRepository;
	
	@Autowired
    BrandRepository brandRepository;
	
	@Autowired
	private SequenceCarGeneratorService seqCarGeneratorService;
	
	@Autowired
	private SequenceImageGeneratorService seqImageGeneratorService;
	
	String STORAGE_URL = "https://firebasestorage.googleapis.com/v0";
	String BUCKET_NAME = "/b/noprecinho-b76e5.appspot.com/o/";
	String MEDIA = "?alt=media";
	
    

	@GetMapping("/getCity")
	public ResponseEntity<District[]> getCity(@FormParam("uf") String uf) {
		
		String URL = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + uf + "/distritos?orderBy=nome";
    	
		RestTemplate rt = new RestTemplate();
    	
    	HttpHeaders headers = new HttpHeaders();
//    	headers.set("Content-Type", "application/json");
//    	headers.set("Authorization", AUTH_BEARER);
    	
    	HttpEntity entity = new HttpEntity(headers);
    	District[] result = null;
    	
    	
    	try {

    		ResponseEntity<District[]> response = rt.exchange(URL, HttpMethod.GET, entity, District[].class);
    		result = response.getBody();
    		
    		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    		
		} catch (Exception e) {

			System.err.println(e);
			return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
		}
    	
	}
	
	@PostMapping("/car")
	public ResponseEntity<CarModel> submitForm(@RequestBody CarModel carModel) {
		
		String createAt = DateUtils.dateToStr(Calendar.getInstance().getTime());
    	String updateAt = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
		
		CarModel carVerify = carRepository.findByPlate(carModel.getPlate());
    	
    	if(carVerify == null) {
    		
    		Long carId = seqCarGeneratorService.generateSequence(CarModel.SEQUENCE_NAME);
	    	
        	carModel.setId(carId);
        	
        	carModel.setCreateAt(createAt);
        	carModel.setUpdateAt(updateAt);
    	
    		carRepository.save(carModel);
    		
    		return new ResponseEntity<>(carModel, HttpStatus.ACCEPTED);
    		
    	}else {
    		
    		return new ResponseEntity<>(new CarModel(), HttpStatus.NOT_FOUND);
    	}
	}
	
	@PostMapping("/updateCar")
	public ResponseEntity<CarModel> updateCar(@RequestBody CarModel carModel) {
		
//		String createAt = DateUtils.dateToStr(Calendar.getInstance().getTime());
    	String updateAt = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
		
    	CarModel carRetrieve = carRepository.findByPlate(carModel.getPlate());
    	    	
    	carModel.setId(carRetrieve.getId());
//    	carRetrieve.setCreateAt(createAt);
    	carRetrieve.setUpdateAt(updateAt);
	
		carRepository.save(carModel);
		
		return new ResponseEntity<>(carModel, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getCars")
	public ResponseEntity<List<CarModel>> getCars() {
		
    	List<CarModel> carList = carRepository.findAll();
    	
    	List<CarModel> carNewList = new ArrayList<>();
    	
    	for (CarModel carModel : carList) {
			
    		Boolean isExcludedCar = (carModel.getSold() || carModel.getDisabled()) || carModel.getPause(); 
    		
    		if(!isExcludedCar) {
    		
	    		List<Image> images = getImagesForProductToView(carModel.getPlate());
	        	
	    		carModel.setImageUrlList(images);
	    		
	    		carNewList.add(carModel);
    		}
		}
    	
		return new ResponseEntity<>(carNewList, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getCarsProfile")
	public ResponseEntity<List<CarModel>> getCarsProfile(Long idUser) {
		
		if(idUser != null) {
			
			List<CarModel> carList = carRepository.findByIdUser(idUser);
	    	
	    	List<CarModel> carNewList = new ArrayList<>();
	    	
	    	for (CarModel carModel : carList) {
				
	    		List<Image> images = getImagesForProductToView(carModel.getPlate());
	        	
	    		carModel.setImageUrlList(images);
	    		
	    		carNewList.add(carModel);
			}
	    	
			return new ResponseEntity<>(carNewList, HttpStatus.ACCEPTED);
			
		}else {
			
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/images")
	public CarModel submitForm(@RequestParam ArrayList<MultipartFile> file, @RequestParam("idCar") Long idCar) {
		
		String createAt = DateUtils.dateToStr(Calendar.getInstance().getTime());
    	String updateAt = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
		
	    
//	    Long imageId = seqImageGeneratorService.generateSequence(Image.SEQUENCE_NAME);
	    
	    CarModel car = carRepository.findById(idCar).get();
	    
	    
	    try {
			
	    	for (MultipartFile multipartFile : file) {
	    		
	    		Long imageId = seqImageGeneratorService.generateSequence(Image.SEQUENCE_NAME);
			
	    		String imageName = imageService.save(multipartFile);
//	    		Long imageId = seqImageGeneratorService.generateSequence(Image.SEQUENCE_NAME);
	    		
	    		Image image = new Image(imageId, imageName, car.getPlate(), true, createAt, updateAt);
	    		imageRepository.save(image);
			}
	    	
		} catch (IOException e) {
			
			e.printStackTrace();
			
			return new CarModel();
		}
	    
	    List<Image> images = getImagesForProductToView(car.getPlate());
    	
	    car.setImageUrlList(images);
	    
	    
	    return car;
	}
	
//	@PostMapping("/imagesiOS")
//	public CarModel imagesiOS(@RequestBody ArrayList<MultipartFile> file, @RequestParam("idCar") Long idCar) {
//		
//		String createAt = DateUtils.dateToStr(Calendar.getInstance().getTime());
//    	String updateAt = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
//		
//	    
////	    Long imageId = seqImageGeneratorService.generateSequence(Image.SEQUENCE_NAME);
//	    
//	    CarModel car = carRepository.findById(idCar).get();
//	    
//	    
//	    try {
//			
//	    	for (MultipartFile multipartFile : file) {
//	    		
//	    		Long imageId = seqImageGeneratorService.generateSequence(Image.SEQUENCE_NAME);
//			
//	    		String imageName = imageService.save(multipartFile);
////	    		Long imageId = seqImageGeneratorService.generateSequence(Image.SEQUENCE_NAME);
//	    		
//	    		Image image = new Image(imageId, imageName, car.getPlate(), true, createAt, updateAt);
//	    		imageRepository.save(image);
//			}
//	    	
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//			
//			return new CarModel();
//		}
//	    
//	    List<Image> images = getImagesForProductToView(car.getPlate());
//    	
//	    car.setImageUrlList(images);
//	    
//	    
//	    return car;
//	}
	
	@PostMapping("/updateImages")
	public CarModel updateImages(@RequestParam("file") ArrayList<MultipartFile> file, @RequestParam("idCar") Long idCar, @RequestParam("imagesDelete") List<Long> imagesDelete) {
	    
		String createAt = DateUtils.dateToStr(Calendar.getInstance().getTime());
    	String updateAt = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
		
		
	    CarModel car = carRepository.findById(idCar).get();
	    
	    
	    if(imagesDelete != null && imagesDelete.size() > 1) {
	    
	    	for (Long idImage: imagesDelete) {
	    	
	    		Image imageRetrieve = imageRepository.findById(idImage);
	    		
	    		imageRetrieve.setUpdateAt(updateAt);
	    		imageRetrieve.setEnabled(false);
		    	imageRepository.save(imageRetrieve);
	    	}
	    }
	    
	    
//	    List<Image> imageRetrieveList = imageRepository.findByPlateAndEnabled(car.getPlate(), true);
//	    
//	    for (Image image : imageRetrieveList) {
//
//	    	image.setUpdateAt(updateAt);
//	    	image.setEnabled(false);
//	    	imageRepository.save(image);
//		}
	    
	    
	    try {
			
	    	for (MultipartFile multipartFile : file) {
	    		
	    		Long imageId = seqImageGeneratorService.generateSequence(Image.SEQUENCE_NAME);
			
	    		String imageName = imageService.save(multipartFile);
//	    		Long imageId = seqImageGeneratorService.generateSequence(Image.SEQUENCE_NAME);
	    		
	    		Image image = new Image(imageId, imageName, car.getPlate(), true, createAt, updateAt);
	    		imageRepository.save(image);
			}
	    	
		} catch (IOException e) {
			
			e.printStackTrace();
			
			return new CarModel();
		}
	    
	    List<Image> images = getImagesForProductToView(car.getPlate());
    	
	    car.setImageUrlList(images);
	    
	    
	    return car;
	}
	
	@PostMapping("/removeImages")
	public CarModel removeImages(@RequestParam("idCar") Long idCar, @RequestParam("imagesDelete") List<Long> imagesDelete) {
	    
		String createAt = DateUtils.dateToStr(Calendar.getInstance().getTime());
    	String updateAt = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
		
		
	    CarModel car = carRepository.findById(idCar).get();
	    
	    
	    if(imagesDelete != null && !imagesDelete.isEmpty()) {
	    
	    	for (Long idImage: imagesDelete) {
	    	
	    		Image imageRetrieve = imageRepository.findById(idImage);
	    		
	    		imageRetrieve.setUpdateAt(updateAt);
	    		imageRetrieve.setEnabled(false);
		    	imageRepository.save(imageRetrieve);
	    	}
	    }
	    
	    List<Image> images = getImagesForProductToView(car.getPlate());
    	
	    car.setImageUrlList(images);
	    
	    
	    return car;
	}
	
	private List<Image> getImagesForProductToView(String plate) {
		
    	List<Image> imageList = imageRepository.findByPlateAndEnabled(plate, true);
    	List<Image> imageNewList = new ArrayList<>();
    	
    	for (Image image : imageList) {
    		
    		String url = STORAGE_URL + BUCKET_NAME + image.getName() + MEDIA;
    		
    		image.setName(url);
    		imageNewList.add(image);
		}
    	
    	return imageNewList;
	}
	
//	private ProductModel getImagesForProductOriginal(ProductModel product) {
//		
//    	List<Image> imageList = imageRepository.findByProductId(product.getId());
//    	
//    	product.setImageList(imageList);
//		
//    	return product;
//	}
	
}
