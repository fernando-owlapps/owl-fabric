package com.owlapps.samarony.controller;

import javax.ws.rs.FormParam;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.owlapps.samarony.model.Address;
import com.owlapps.samarony.model.Endereco;


@RestController
public class CepController {

	@GetMapping("/getZipcode")
	public ResponseEntity<Address> getZipcode(@FormParam("zipcode") String zipcode) {
		
		String URL_BASE = "https://viacep.com.br/ws/" + zipcode + "/json/";
		
		RestTemplate rt = new RestTemplate();
    	
    	HttpHeaders headers = new HttpHeaders();
    	
    	HttpEntity entity = new HttpEntity(zipcode, headers);

    	ResponseEntity<Endereco> response = rt.exchange(URL_BASE, HttpMethod.GET, entity, Endereco.class);
    	Endereco enderecoResponse = response.getBody();
    	
    	return new ResponseEntity<>(new Address(enderecoResponse), HttpStatus.ACCEPTED);
	}
}
