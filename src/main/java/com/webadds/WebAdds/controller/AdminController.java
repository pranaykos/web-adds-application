package com.webadds.WebAdds.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webadds.WebAdds.dao.AdvertiseDao;
import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.pojos.ApplicationUser;
import com.webadds.WebAdds.service.ApplicationUserServiceImpl;


@Controller
@RequestMapping("admin/")
public class AdminController {

	@Autowired
	private AdvertiseDao advertiseDao;
	
	@Autowired
	private ApplicationUserServiceImpl userService;
	
	@GetMapping("dashboard")
	public String adminDashboard() {
		return "dashboard";
	}
	
	private List<Integer> assignedUsersId;
	
	@PostConstruct
	public void initializeAssignedUsers() {
		this.assignedUsersId = new ArrayList<Integer>();
	}
	
	@GetMapping("all-adds")
	public String showAllAdds(Model model) {
		List<Advertise> advertises = advertiseDao.findAll();
		model.addAttribute("advertises", advertises);
		return "all-adds";
	}
	
	@GetMapping("add")
	public String doAddAsignment(@RequestParam("id") int addId,
								Model model) {
		Advertise advertise = null;
		List<ApplicationUser> users = null;
		List<ApplicationUser> assignedusers = null;
		Optional<Advertise> result = advertiseDao.findById(addId);
		if(result.isPresent()) {
			advertise = result.get();
			
			List<ApplicationUser> applicationUsers = userService.getAllUsers();
			
			
			
			model.addAttribute("advertise", advertise);
			
			if(this.assignedUsersId.isEmpty()) {				
				model.addAttribute("users", applicationUsers);
			}else {
				assignedusers = applicationUsers
				.stream()
				.filter(user -> this.assignedUsersId.contains(new Integer(user.getId()))).collect(Collectors.toList());
				
				users = applicationUsers
						.stream()
						.filter(user -> !this.assignedUsersId.contains(new Integer(user.getId()))).collect(Collectors.toList());
				
				model.addAttribute("users", users);
				model.addAttribute("assignedusers", assignedusers);
			}
			
			model.addAttribute("addId", addId);
			
			return "add-page";
		}else {
			return "all-adds";
		}
	}
	
	@PostMapping("assign-adds")
	public String assignAdds(@RequestParam("country") String[] userIds,
								@RequestParam("addId") int addId,
								Model model) {
//		System.out.println(country.getClass().getName());
		for(String id : userIds) {
			this.assignedUsersId.add(Integer.parseInt(id));
		}
		
		System.out.println(this.assignedUsersId);
		
//		model.addAttribute(addId);
		
		
		String redirectUrl = "redirect:add?id="+addId;
		return redirectUrl;
	}
	
	@GetMapping("assign-users")
	public String assignUsers(@RequestParam("addId") int addId) {
		System.out.println("submitted user are :"+this.assignedUsersId);
		System.out.println("for addId:"+addId);
		return "all-adds";
	}
}
