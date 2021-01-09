package com.webadds.WebAdds.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.entity.Client;
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
	public String showProfilePage(Model model) {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		
		Client client = clientService.getClientByUsername(username);
		model.addAttribute("client",client);
		
		int assignedAdds = 0;
		
		for(Advertise advertise : client.getAdvertises()) {
			if(advertise.getIsAssigned() == 1) {
				assignedAdds++;
			}
		}
		
		model.addAttribute("totalAssigned", assignedAdds);
		return "client-profile";
	}
	
	
	@GetMapping("register")
	public String clientRegisterForm(Model model) {
		ApplicationClient client = new ApplicationClient();
		model.addAttribute("client", client);
		return "client-register-form";
	}
	
	@PostMapping("register")
	public String registerClient(@Valid @ModelAttribute("client") ApplicationClient client,
			BindingResult result) {
		if(result.hasErrors()) {
			return "client-register-form";	
		}
		clientService.registerClient(client);
		return "redirect:/";
	}
	
	@GetMapping("upload-add")
	public String uploadAddForm() {
		return "add-form";
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
		
		return "redirect:all-adds";
	}
	
	@GetMapping("all-adds")
	public String showAllUploadedAdds(Model model) {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		
		Client client = clientService.getClientByUsername(username);
		model.addAttribute("advertises", client.getAdvertises());
		return "all-uploaded-adds";
	}
	
	@GetMapping("add-report")
	public String addReport(Model model) {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		
		Client client = clientService.getClientByUsername(username);
		
		model.addAttribute("advertises", client.getAdvertises());
		return "add-report";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}
}
