package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import com.websystique.springsecurity.dao.AbstractDao;

import com.websystique.springsecurity.model.ImageSujet;

@Repository("imageSujetDao")
public class ImageSujetDaoImpl extends AbstractDao<Integer, ImageSujet> implements ImageSujetDao {

	@SuppressWarnings("unchecked")
	public List<ImageSujet> findAll() {
		 Criteria crit = createEntityCriteria();
	        return (List<ImageSujet>)crit.list();
	}

	@Override
	public ImageSujet findById(int id) {
		 return getByKey(id);
	}

	@Override
	public void save(ImageSujet document) {
		  persist(document);

	}

	 @SuppressWarnings("unchecked")
	public List<ImageSujet> findAllBySujetId(int userId) {
		 Criteria crit = createEntityCriteria();
	        Criteria userCriteria = crit.createCriteria("sujet");
	        userCriteria.add(Restrictions.eq("id", userId));
	        return (List<ImageSujet>)crit.list();
	}

	@Override
	public void deleteById(int id) {
		ImageSujet document =  getByKey(id);
        delete(document);

	}

}
