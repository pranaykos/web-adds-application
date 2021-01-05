package com.webadds.WebAdds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.pojos.ApplicationClient;
import com.webadds.WebAdds.pojos.ApplicationUser;
import com.webadds.WebAdds.service.AddService;
import com.webadds.WebAdds.service.ClientService;

@Controller
@RequestMapping("client/")
public class ClientController {
	
	@Autowired
	private AddService addService;
	
	@Autowired
	private ClientService clientService;

	@GetMapping("profile")
	public String showProfilePage() {
		return "client-profile";
	}
	
	@GetMapping("upload-add")
	public String uploadAddForm() {
		return "add-form";
	}
	
	@GetMapping("register")
	public String clientRegisterForm(Model model) {
		ApplicationClient client = new ApplicationClient();
		model.addAttribute("client", client);
		return "client-register-form";
	}
	
	@PostMapping("register")
	public String registerClient(@ModelAttribute("client") ApplicationClient client) {
		System.out.println("Added client is "+client);
		clientService.registerClient(client);
		return "redirect:/";
	}
	
	@PostMapping("upload-add")
	public String saveAdd(@RequestParam("add-name") String addName,
						@RequestParam("add-image") MultipartFile addImage,
						@RequestParam("add-desc") String addDesc,
						@RequestParam("add-point") int points) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		
		Advertise advertise = new Advertise(0, addName, addDesc, 
											addImage.getOriginalFilename(), 
											points,username);
		
		addService.registerAdd(advertise, username, addImage);
		
		return "add-form";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}
}
