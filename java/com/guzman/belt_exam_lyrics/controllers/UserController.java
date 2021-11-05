package com.guzman.belt_exam_lyrics.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guzman.belt_exam_lyrics.models.UsersSongsCollaborations;
import com.guzman.belt_exam_lyrics.models.User;
import com.guzman.belt_exam_lyrics.models.Song;
import com.guzman.belt_exam_lyrics.services.AppService;

@Controller
public class UserController {
	private final AppService appService;
	public UserController(AppService appService) {
		this.appService = appService;
	}
	
    @RequestMapping("/")
    public String index(Model model) {
    	return "index.jsp";
    }
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User newuser, BindingResult result, HttpSession session) {
    	if ( result.hasErrors() ) {
    		System.out.println(result);
    		return "index.jsp";
//    		redirectAttributes.addFlashAttribute( "errorMessage", "You need to provide name, last name and password." );
    	}
    	else {
    		System.out.println(result);
    		User currentUser = appService.createUser(newuser);
    		session.setAttribute("userId", currentUser.getUser_id());
    		return "redirect/homePage";
    	}
    }
    	
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(HttpSession session, Model model, @RequestParam("email") String email, @RequestParam("password") String password){ 
    boolean isAuthenticated = appService.authenticateUser(email,  password);
    
    if(isAuthenticated) {
    	User currentUser = appService.getByEmail(email);
    	System.out.println(currentUser);
    	session.setAttribute("user", currentUser.getUser_id());
    	return "redirect/home";
    }
    else {
    	model.addAttribute("error", "Invalid Credentials. Please try again.");
    	System.out.println(model);
    	return "index.jsp";
    }
   }
    	
    @RequestMapping("redirect/homePage")
    public String home(HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("userId");
    	User currentUser = appService.getUser(userId);
    	model.addAttribute("user", currentUser);
    	return "homePage.jsp";
    }
//    
//	@RequestMapping( value = "/logout", method = RequestMethod.POST )
//	public String logout( HttpSession session ) {
//		
//		session.invalidate();
//		
//		return "index.jsp";
//	}
//    
//    

}