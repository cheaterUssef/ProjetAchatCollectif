package com.websystique.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.ImageSujetDao;
import com.websystique.springsecurity.model.ImageSujet;


@Service("imageSujetService")
@Transactional
public class ImageSujetServiceImpl implements ImageSujetService {
	
	
	@Autowired
    ImageSujetDao dao;

	@Override
	public ImageSujet findById(int id) {
		 return dao.findById(id);
	}

	@Override
	public List<ImageSujet> findAll() {
		return dao.findAll();
	}

	@Override
	public List<ImageSujet> findAllBySujetId(int id) {
		return dao.findAllBySujetId(id);
	}

	@Override
	public void saveImage(ImageSujet image) {
		dao.save(image);

	}

	@Override
	public void deleteById(int id) {
		 dao.deleteById(id);

	}

}
