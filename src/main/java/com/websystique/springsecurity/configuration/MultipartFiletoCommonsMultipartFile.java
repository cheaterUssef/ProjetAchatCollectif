package com.websystique.springsecurity.configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.websystique.springsecurity.model.FileBucket;
import com.websystique.springsecurity.model.UserProfile;

@Component
public class MultipartFiletoCommonsMultipartFile implements Converter<Object, File> {

	@Override
	public File convert(Object file) {
		 FileOutputStream fos;
		 File convFile =null;
		 try {
		convFile = new File(((MultipartFile) file).getOriginalFilename());
		   
				convFile.createNewFile();
			
		
		    fos = new FileOutputStream(convFile); 
		    fos.write(((MultipartFile) file).getBytes());
		    fos.close();
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
		 
		 
	    return convFile;
		

	}


}
