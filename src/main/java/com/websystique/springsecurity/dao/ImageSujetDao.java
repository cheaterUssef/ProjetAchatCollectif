package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.ImageSujet;

public interface ImageSujetDao {
	
	  List<ImageSujet> findAll();
	     
	  ImageSujet findById(int id);
	     
	    void save(ImageSujet document);
	     
	    List<ImageSujet> findAllBySujetId(int userId);
	     
	    void deleteById(int id);

}
