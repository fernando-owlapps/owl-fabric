package com.owlapps.samarony;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SamaronyServiceAplication {
	
//	@Value("${cloudinary.cloud_name}")
//	private String cloudName;
//
//	@Value("${cloudinary.api_key}")
//	private String apiKey;
//
//	@Value("${cloudinary.api_secret}")
//	private String apiSecret;


	public static void main(String[] args) {
		SpringApplication.run(SamaronyServiceAplication.class, args);
	}
	
	@Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("124MB");
        factory.setMaxRequestSize("124MB");
        return factory.createMultipartConfig();
    }
	
}
