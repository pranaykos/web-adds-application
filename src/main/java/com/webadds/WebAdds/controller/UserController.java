package com.webadds.WebAdds.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webadds.WebAdds.pojos.ApplicationUser;
import com.webadds.WebAdds.service.AppUserService;

@Controller
@RequestMapping("user/")
public class UserController {

	@Autowired
	private AppUserService appUserService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}
	
	@GetMapping("profile")
	public String profilePage() {
		return "profile";
	}

	@PostMapping("register")
	public String registerUser(@Valid @ModelAttribute("applicationUser") ApplicationUser user, 
							BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}
		appUserService.registerUser(user);
		return "redirect:/";

	}
}
