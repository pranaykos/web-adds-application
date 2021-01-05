package com.webadds.WebAdds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.webadds.WebAdds.pojos.ApplicationClient;
import com.webadds.WebAdds.pojos.ApplicationUser;
import com.webadds.WebAdds.pojos.FormUser;

@Controller
public class MainController {

	@GetMapping("/")
	public String homePage(Model model) {
		ApplicationUser user = new ApplicationUser();
		model.addAttribute("applicationUser", user);
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	
}
