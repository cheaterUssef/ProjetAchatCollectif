package com.websystique.springsecurity.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.websystique.springsecurity.model.SujetType;
import com.websystique.springsecurity.model.UserProfile;
import com.websystique.springsecurity.service.SujetTypeService;

@Component
public class TypeToSujetTypeConverter implements Converter<Object, SujetType>{
	
	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
    @Autowired
    SujetTypeService sujetTypeService;
 
    public SujetType convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        SujetType sujetType = sujetTypeService.findById(id);
        logger.info("SujetType : {}",sujetType);
        return sujetType;
    }
}
