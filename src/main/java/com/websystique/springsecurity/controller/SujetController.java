package com.websystique.springsecurity.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.websystique.springsecurity.configuration.TypeToSujetTypeConverter;
import com.websystique.springsecurity.model.Commentaire;
import com.websystique.springsecurity.model.Sujet;
import com.websystique.springsecurity.model.SujetType;
import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.service.SujetService;
import com.websystique.springsecurity.service.SujetTypeService;
import com.websystique.springsecurity.service.UserService;

@Controller
@RequestMapping("/sujet")
@SessionAttributes("types")
public class SujetController {
	
	@Autowired
	SujetService sujetService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SujetTypeService sujetTypeService;

	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
		public String listSujets(ModelMap model) {
			
			List<Sujet> sujets = sujetService.findAllSujets();
			
			// à optimiser (juste si le user a le role user)
			User current_user = userService.findBySSO((( (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername())); 
			
			// just a Test
			for (Sujet sujet : current_user.getSujets_adheres()) {
				System.out.println("sujet adheres ***** "+ sujet.getName()+"***********");
			}
			// just a test end
			
			List<Integer> current_user_sujet_ids = new ArrayList<>();
			for (Sujet sujet : current_user.getSujets()) {
				current_user_sujet_ids.add(sujet.getId());
				System.out.println("current user :"+sujet.getId()+" "+sujet.getName());
			}
			
			List<Integer> current_user_sujets_adheres_ids = new ArrayList<>();
			for (Sujet sujet : current_user.getSujets_adheres()) {
				current_user_sujets_adheres_ids.add(sujet.getId());
				System.out.println("current user - sujets adheres :"+sujet.getId()+" "+sujet.getName());
			}
			
			model.addAttribute("sujets", sujets);
		    model.addAttribute("current_user_sujet_ids", current_user_sujet_ids);
		    model.addAttribute("current_user_sujets_adheres_ids", current_user_sujets_adheres_ids);
		    return "sujetslist";
	   	}
	
	@RequestMapping(value = { "/{sujet_id}/show" }, method = RequestMethod.GET)
    public String showSujet(ModelMap model, @PathVariable Integer sujet_id) {

        Sujet sujet = sujetService.findById(sujet_id);
        Commentaire commentaire = new Commentaire();
        model.addAttribute("commentaire", commentaire);
        
        User current_user = userService.findBySSO((( (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername())); 
		
        List<Integer> current_user_comments_ids = new ArrayList<>();
        for (Commentaire comment : current_user.getCommentaires()) {
        	current_user_comments_ids.add(comment.getId());
        	System.out.println("current comment ids "+ comment.getId()+ " "+ comment.getContenu());
		}
        model.addAttribute("sujet", sujet);
        model.addAttribute("comments", sujet.getCommentaires());
        
        model.addAttribute("current_user_comments_ids", current_user_comments_ids);
        
        return "show_sujet";
    }
	
	/**
     * This method will provide the medium to add a new sujet.
     */
    @RequestMapping(value = { "/newsujet" }, method = RequestMethod.GET)
    public String newSujet(ModelMap model) {
        Sujet sujet = new Sujet();
        model.addAttribute("sujet", sujet);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "new_sujet";
    }
    
    @RequestMapping(value = { "/{sujet_id}/delete" }, method = RequestMethod.POST)
    public String deleteSujet(@PathVariable Integer sujet_id) {
        sujetService.deleteSujetById(sujet_id);
        return "redirect:/sujet/all";
    }
    
    @RequestMapping(value = { "/{sujet_id}/adherer" }, method = RequestMethod.POST)
    public String adhererSujet(@PathVariable Integer sujet_id, HttpServletRequest request) {
    	User current_user = userService.findBySSO((( (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername())); 
    	Sujet sujet = sujetService.findById(sujet_id);
        
    	if(sujet.getNombre_max_adherent() > sujet.getNombre_adherent()) {
    		
	    	current_user.getSujets_adheres().add(sujet);
	    	
	    	sujet.getAdherents().add(current_user);
	    	sujet.setNombre_adherent(sujet.getNombre_adherent()+1);
	    	
	    	// algorithme de reduction : à modifier
	    	sujet.setPrix_diminue(sujet.getPrix_original() / sujet.getNombre_adherent());
	
	    	userService.updateUser(current_user);
	    	sujetService.updateService(sujet);
    	}
        
        return "redirect:" + request.getHeader("Referer");
    }
    
    @Autowired
    TypeToSujetTypeConverter typeToSujetTypeConverter;
    
    /**
     * This method will be called on form submission, handling POST request for
     * saving sujet in database. It also validates the user input
     */
    @RequestMapping(value = { "/newsujet" }, method = RequestMethod.POST)
    public String saveSujet(@Valid Sujet sujet, BindingResult result, ModelMap model) {
    	
    	if (result.hasErrors()) {
    		for (ObjectError iterable_element : result.getFieldErrors()) {
				System.out.println(iterable_element.getObjectName()+ " **** " + iterable_element.getDefaultMessage());
			}
            return "new_sujet";
        }
        
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = Calendar.getInstance().getTime();
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	c.add(Calendar.DATE, sujet.getDuree_validite());
    	Date dateExpiration = c.getTime();
    	System.out.println("*************************"+dateFormat.format(dateExpiration) +"*********************");
    	sujet.setDate_creation(date);
    	sujet.setPrix_diminue(sujet.getPrix_original());
    	sujet.setUser(userService.findBySSO((( (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername())));
    	
        sujetService.saveSujet(sujet);
 
        model.addAttribute("success", "Sujet" +sujet.getName()+"is registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "creation_sujet_success";
    }
    
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
    
    @ModelAttribute("types")
    public List<SujetType> initializeSujetTypes() {
        return sujetTypeService.findAllSujetTypes();
    }

}
