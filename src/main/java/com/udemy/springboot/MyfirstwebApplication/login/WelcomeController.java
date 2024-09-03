package com.udemy.springboot.MyfirstwebApplication.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("name")
@Controller
public class WelcomeController {
	
//	private Logger logger = LoggerFactory.getLogger(getClass());

	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String gotoWelcomeController(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
		
	}
	
	
	
}
