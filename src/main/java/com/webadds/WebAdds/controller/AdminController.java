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
import com.webadds.WebAdds.dao.RecordDao;
import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.entity.AssignRecord;
import com.webadds.WebAdds.pojos.ApplicationUser;
import com.webadds.WebAdds.service.ApplicationUserServiceImpl;


@Controller
@RequestMapping("admin/")
public class AdminController {

	@Autowired
	private AdvertiseDao advertiseDao;
	
	@Autowired
	private ApplicationUserServiceImpl userService;
	
	@Autowired
	private RecordDao recordDao;
	
	@GetMapping("dashboard")
	public String adminDashboard() {
		return "dashboard";
	}
	
	private List<Integer> assignedUsersId;
	
	@PostConstruct
	public void initializeAssignedUsers() {
		this.assignedUsersId = new ArrayList<Integer>();
	}
	
	
	@GetMapping("add")
	public String doAddAsignment(@RequestParam("id") int addId,
								Model model) {
//		this.assignedUsersId = new ArrayList<>();
		
		List<AssignRecord> recordsForAddId = recordDao.getRecordsForAddId(addId);
		
		if(recordsForAddId != null) {
			for(AssignRecord record : recordsForAddId ) {
				this.assignedUsersId.add(record.getUserId());
			}
		}
		
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
		System.out.println(this.assignedUsersId+" have been assigned for "+addId+" addId");
		
		int points = advertiseDao.getAddpointById(addId);
		
		for(Integer userId : assignedUsersId) {
			recordDao.save(new AssignRecord(0, userId, addId, points, 0));
		}
		this.assignedUsersId = new ArrayList<>();
		
		Optional<Advertise> result = advertiseDao.findById(addId);
		Advertise advertise = result.get();
		advertise.setIsAssigned(1);
		advertiseDao.save(advertise);
		
		return "redirect:all-adds";
	}
	
	@GetMapping("all-adds")
	public String showAllAdds(Model model) {
		this.assignedUsersId = new ArrayList<>();
		List<Advertise> advertises = advertiseDao.findAll();
		model.addAttribute("advertises", advertises);
		return "all-adds";
	}
	
	@GetMapping("unasigned-adds")
	public String getUnassignedAdds(Model model) {
		this.assignedUsersId = new ArrayList<>();
		List<Advertise> advertises = advertiseDao.getUnAssignedAdds();
		model.addAttribute("advertises", advertises);
		return "all-adds";
	}
	
	@GetMapping("assigned-adds")
	public String getAssignedAdds(Model model) {
		this.assignedUsersId = new ArrayList<>();
		List<Advertise> advertises = advertiseDao.getAssignedAdds();
		model.addAttribute("advertises", advertises);
		return "all-adds";
	}
}
