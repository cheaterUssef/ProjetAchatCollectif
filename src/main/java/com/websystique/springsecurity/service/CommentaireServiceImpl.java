package com.websystique.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.CommentaireDao;
import com.websystique.springsecurity.model.Commentaire;

@Service("commentaireService")
@Transactional
public class CommentaireServiceImpl implements CommentaireService{

	@Autowired
    private CommentaireDao dao;
	
	@Override
	public void saveComment(Commentaire commentaire) {
		dao.save(commentaire);
	}

	@Override
	public void deleteCommentById(Integer comment_id) {
		dao.deleteById(comment_id);
	}

}
