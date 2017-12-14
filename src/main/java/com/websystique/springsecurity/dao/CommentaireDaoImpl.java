package com.websystique.springsecurity.dao;

import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Commentaire;

@Repository("commentaireDao")
public class CommentaireDaoImpl extends AbstractDao<Integer, Commentaire> implements CommentaireDao{

	@Override
	public void save(Commentaire commentaire) {
		persist(commentaire);
	}

}
