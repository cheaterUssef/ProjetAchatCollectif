package com.websystique.springsecurity.service;

import com.websystique.springsecurity.model.Commentaire;

public interface CommentaireService {

//	Sujet findById(int id);
    
//  User findBySSO(String sso);
   
	void saveComment(Commentaire commentaire);

  	void deleteCommentById(Integer comment_id);
   
//  void updateUser(User user);

//	List<Sujet> findAllSujets(); 
   
//  boolean isUserSSOUnique(Integer id, String sso);
}
