package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.ImageSujet;

public interface ImageSujetService {
	
	 ImageSujet findById(int id);
	 
	    List<ImageSujet> findAll();
	     
	    List<ImageSujet> findAllBySujetId(int id);
	     
	    void saveImage(ImageSujet image);
	     
	    void deleteById(int id);

}
