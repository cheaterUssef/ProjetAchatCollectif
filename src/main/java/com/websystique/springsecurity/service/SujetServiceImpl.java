package com.websystique.springsecurity.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.SujetDao;
import com.websystique.springsecurity.model.Sujet;
import com.websystique.springsecurity.model.User;

@Service("sujetService")
@Transactional
public class SujetServiceImpl implements SujetService{

	@Autowired
    private SujetDao dao;
	
	@Override
	public List<Sujet> findAllSujets() {
		return dao.findAllSujets();
	}

	@Override
	public void saveSujet(Sujet sujet) {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
//		System.out.println(sujet.getDate_expiration());
		dao.save(sujet);
	}

	@Override
	public Sujet findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void deleteSujetById(int id) {
		dao.deleteById(id);
	}

	@Override
	public void updateService(Sujet sujet) {
		Sujet entity = dao.findById(sujet.getId());
        if(entity!=null){
        	entity.setId(sujet.getId());
            entity.setAdherents(sujet.getAdherents());
            entity.setCommentaires(sujet.getCommentaires());
            entity.setDate_creation(sujet.getDate_creation());
            entity.setDescription(sujet.getDescription());
            entity.setDuree_validite(sujet.getDuree_validite());
            entity.setName(sujet.getName());
            entity.setPrix_original(sujet.getPrix_original());
            entity.setPrix_diminue(sujet.getPrix_diminue());
            entity.setUser(sujet.getUser());
            entity.setTaux_reduction(sujet.getTaux_reduction());
            entity.setNombre_adherent(sujet.getNombre_adherent());
            entity.setNombre_max_adherent(sujet.getNombre_max_adherent());
            entity.setSujet_type(sujet.getSujet_type());
        }
	}

}
