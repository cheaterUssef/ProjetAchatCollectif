package com.websystique.springsecurity.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springsecurity.model.Commentaire;
import com.websystique.springsecurity.service.CommentaireService;
import com.websystique.springsecurity.service.SujetService;
import com.websystique.springsecurity.service.UserService;

@Controller
@RequestMapping("/comment")
public class CommentaireController {

	@Autowired
	CommentaireService commentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SujetService sujetService;
	
	@RequestMapping(value = { "/{sujet_id}/newcomment" }, method = RequestMethod.POST)
    public String saveComment(@Valid Commentaire commentaire, BindingResult result, ModelMap model
    		, @PathVariable Integer sujet_id) {
        
		if (result.hasErrors()) {
			return "redirect:/sujet/"+sujet_id+"/show";
		}
		Date date = Calendar.getInstance().getTime();
    	commentaire.setDate_creation(date);
        commentaire.setUser(userService.findBySSO((( (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername())));
        commentaire.setSujet(sujetService.findById(sujet_id));
        commentService.saveComment(commentaire);
        return "redirect:/sujet/"+sujet_id+"/show";
    }
	
	@RequestMapping(value = { "/{comment_id}/delete" }, method = RequestMethod.POST)
    public String deleteComment(@PathVariable Integer comment_id, HttpServletRequest request) {
        commentService.deleteCommentById(comment_id);
        return "redirect:" + request.getHeader("Referer");
    }
}
