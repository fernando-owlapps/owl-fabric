package com.owlapps.samarony.util;
//package com.ummilhao.util;
//
//import java.util.Base64;
//
//import org.springframework.beans.factory.annotation.Value;
//
//public class AutenticationUtil {
//	
//	@Value("${credpago.api.user}")
//	private static String CREDPAGO_USER;
//  
//	@Value("${credpago.api.password}")
//	private static String CREDPAGO_PASSWORD;
//	
//	
//	public static String generateBasicAuthentication() {
//	  	
//		String headerValueToBeEncoded = CREDPAGO_USER + ":" + CREDPAGO_PASSWORD;
//		String encodedHeaderValue = Base64.getEncoder().encodeToString(headerValueToBeEncoded.getBytes());
//	
//		return "Basic " + encodedHeaderValue;
//	}
//	
//}
