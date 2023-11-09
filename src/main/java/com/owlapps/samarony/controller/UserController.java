package com.owlapps.samarony.controller;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.owlapps.samarony.dao.UserDao;
import com.owlapps.samarony.model.CarouselModel;
import com.owlapps.samarony.model.User;
import com.owlapps.samarony.repository.CarouselRepository;
import com.owlapps.samarony.repository.UserRepository;
import com.owlapps.samarony.request.AddUserRequest;
import com.owlapps.samarony.response.UserResponse;
import com.owlapps.samarony.service.SequenceCarouselGeneratorService;
import com.owlapps.samarony.service.SequenceUserGeneratorService;
import com.owlapps.samarony.util.DateUtils;

@RestController
public class UserController {
	
	private final int REGISTER_STEP_ACCESS = 1;
	private final int REGISTER_STEP_VALIDATE = 2;
	private final int REGISTER_STEP_TERMS = 3;
	
	@Value("${user.message.add.success}")
	private String MESSAGE_ADD_SUCCESS;
	
	@Value("${user.message.add.error}")
	private String MESSAGE_ADD_ERROR;
	
	@Value("${user.message.update.success}")
	private String MESSAGE_UPDATE_SUCCESS;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CarouselRepository carouselRepository;
	
	@Autowired
	private SequenceUserGeneratorService seqGeneratorService;
	
	@Autowired
	private SequenceCarouselGeneratorService seqCarouselGeneratorService;
	
	
    /**
     * Register
     * 
     * @param addUserRequest
     * @return
     */
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest addUserRequest) {
    	
    	String date = DateUtils.dateToStr(Calendar.getInstance().getTime());
    	String dateLastAccess = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
    	
    	
    	UserResponse userResponse = new UserResponse(null, MESSAGE_ADD_ERROR);
    	
    	
    	User userRetrieve = userRepository.findByDocument(addUserRequest.getDocument());
    	
    	if(userRetrieve == null) {
    	
    		Long id = seqGeneratorService.generateSequence(User.SEQUENCE_NAME);
    		addUserRequest.setId(id);
    		addUserRequest.setCreateAt(date);
    		addUserRequest.setLastAccess(dateLastAccess);
    		
    		String[] names = addUserRequest.getFullName().split(" ");
    		String firstName = names[0];
    		String lastName = names[names.length-1];
    		
    		addUserRequest.setFirstName(firstName);
    		addUserRequest.setLastName(lastName);
    		
    		User userNew = new User(addUserRequest);
    		
    		userDao.save(userNew);
    		
    		userResponse.setUser(userNew);
    		userResponse.setMessage(MESSAGE_ADD_SUCCESS);
        	
        	return new ResponseEntity<>(userNew, HttpStatus.ACCEPTED);
    		
    	}else {
    		
    		String[] names = addUserRequest.getFullName().split(" ");
    		String firstName = names[0];
    		String lastName = names[names.length-1];
    		
    		userRetrieve.setFirstName(firstName);
    		userRetrieve.setLastName(lastName);
    		userRetrieve.setFullName(firstName + " " + lastName); 
    		
    		userRetrieve.setLastAccess(dateLastAccess);
    		userRetrieve.setUpdateAt(dateLastAccess);
    		
    		userDao.save(userRetrieve);
    		
    		userResponse.setMessage(MESSAGE_UPDATE_SUCCESS);
    		userResponse.setUser(userRetrieve);
    		
    		return new ResponseEntity<>(userRetrieve, HttpStatus.ACCEPTED);
    	}
    }
    
    /**
     * 
     * @param document
     * @return
     */
    @GetMapping("/user")
    public ResponseEntity<User> getClient(@FormParam("document") String document, @FormParam("password") String password, @FormParam("tokenPush") String tokenPush) {
	    
    	String dateLastAccess = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
    	
    	User user = userRepository.findByDocument(document);
    	
    	if(user.getPassword().equals(password)) {
    		  
    		user.setLastAccess(dateLastAccess);

    		if(!tokenPush.isEmpty()) {
    			user.setTokenPush(tokenPush);
    		}
        	
    		userRepository.save(user);
    		
    		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    		
    	}else {
    		
    		return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
    	}
    }
    
    /**
     * 
     * @param document
     * @return
     */
    @GetMapping("/userNewLogin")
    public ResponseEntity<User> getClient(@FormParam("document") String document, @FormParam("password") String password, @FormParam("appVersion") int appVersion, @FormParam("tokenPush") String tokenPush) {
	    
    	String dateLastAccess = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
    	
    	User user = userRepository.findByDocument(document);
    	
    	if(user.getPassword().equals(password)) {
    		  
    		user.setLastAccess(dateLastAccess);
    		user.setAppVersion(appVersion);

    		if(!tokenPush.isEmpty()) {
    			user.setTokenPush(tokenPush);
    		}
        	
    		userRepository.save(user);
    		
    		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    		
    	}else {
    		
    		return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
    	}
    }
    
    /**
     * 
     * @param document
     * @return
     */
    @GetMapping("/verifyUserBlock")
    public ResponseEntity<Boolean> verifyUserBlock(@FormParam("document") String document) {
	    
    	String dateLastAccess = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
    	
    	User user = userRepository.findByDocument(document);
    	
		user.setLastAccess(dateLastAccess);
        	
		userRepository.save(user);
		
		return new ResponseEntity<>(user.getBlock(), HttpStatus.ACCEPTED);
    }
    
    
    
    @GetMapping("/getOffersCarousel")
    public ResponseEntity<List<CarouselModel>> getOffersCarousel() {
	    
    	String dateLastAccess = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
    	
    	List<CarouselModel> carouselList = carouselRepository.findByEnabled(true);
		
		return new ResponseEntity<>(carouselList, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/addOffersCarousel")
    public ResponseEntity<CarouselModel> addOffersCarousel(@RequestBody CarouselModel carouselModel) {
    	
    	Long id = seqCarouselGeneratorService.generateSequence(User.SEQUENCE_NAME);
	    
    	String date = DateUtils.dateToStr(Calendar.getInstance().getTime());
    	String dateLastAccess = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
    	
    	carouselModel.setId(id);
    	carouselModel.setCreateAt(date);
    	carouselModel.setUpdateAt(dateLastAccess);
    	
    	carouselRepository.save(carouselModel);
		
		return new ResponseEntity<>(carouselModel, HttpStatus.ACCEPTED);
    }
    
    
    
    /**
     * 
     * @param addUserRequest
     * @return
     */
    @PostMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody AddUserRequest addUserRequest) {
    	
//    	String date = DateUtils.dateToStr(Calendar.getInstance().getTime());
    	String dateLastAccess = DateUtils.dateToStrLastAccess(Calendar.getInstance().getTime());
    	
    	UserResponse userResponse = new UserResponse(null, MESSAGE_ADD_ERROR);
    	    	
    	User userRetrieve = userRepository.findByDocument(addUserRequest.getDocument());
    	
		String[] names = addUserRequest.getFullName().split(" ");
		String firstName = names[0];
		String lastName = names[names.length-1];
		
		userRetrieve.setFirstName(firstName);
		userRetrieve.setLastName(lastName);
		userRetrieve.setFullName(firstName + " " + lastName);
		userRetrieve.setCellPhone(addUserRequest.getCellPhone());
		userRetrieve.setPassword(addUserRequest.getPassword());
		userRetrieve.setAppVersion(addUserRequest.getAppVersion());
		userRetrieve.setDeviceDna(addUserRequest.getDeviceDNA());
		
		if(!addUserRequest.getTokenPush().isEmpty()) {
			userRetrieve.setTokenPush(addUserRequest.getTokenPush());
		}
		
		userRetrieve.setUpdateAt(dateLastAccess);
		userRetrieve.setLastAccess(dateLastAccess);
				
		userRetrieve.setReadTermsAndCondition(addUserRequest.getReadTermsAndCondition());
		userRetrieve.setBlock(addUserRequest.getBlock());
		
		userDao.save(userRetrieve);
		
		userResponse.setMessage(MESSAGE_UPDATE_SUCCESS);
		userResponse.setUser(userRetrieve);
		
		return new ResponseEntity<>(userRetrieve, HttpStatus.ACCEPTED);
    }
    
    
}
