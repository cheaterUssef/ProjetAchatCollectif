package com.websystique.springsecurity.dao;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.ImageSujet;

@Repository
public class FileUploadDAOImpl implements FileUploadDAO {
    @Autowired
    private SessionFactory sessionFactory;
     
    public FileUploadDAOImpl() {
    }
 
    public FileUploadDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Override
    @Transactional
    public void save(ImageSujet uploadFile) {
        sessionFactory.getCurrentSession().save(uploadFile);
    }

	
}