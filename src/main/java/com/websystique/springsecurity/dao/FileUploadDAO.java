package com.websystique.springsecurity.dao;
 
import com.websystique.springsecurity.model.ImageSujet;
 
public interface FileUploadDAO {
    void save(ImageSujet uploadFile);
}