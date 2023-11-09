package com.owlapps.samarony.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.util.ResourceUtils;

public class FileUtils {

	public static InputStreamResource fetchDocument8(){
		
        try {
        	
            File file = ResourceUtils.getFile("classpath:documents/CONTRATO_DE_ADMINISTRACAO_6.docx");
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            
            return resource;
            
        } catch (IOException e) {
        	
        	System.out.println();
        }
        
        return null;
    }
	
}
