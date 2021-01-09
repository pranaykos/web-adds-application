package com.webadds.WebAdds.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webadds.WebAdds.authService.ApplicationUserService;
import com.webadds.WebAdds.dao.AdvertiseDao;
import com.webadds.WebAdds.dao.RecordDao;
import com.webadds.WebAdds.dao.RedemptionDao;
import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.entity.AssignRecord;
import com.webadds.WebAdds.entity.Client;
import com.webadds.WebAdds.entity.Redemptionreq;
import com.webadds.WebAdds.pojos.ApplicationUser;
import com.webadds.WebAdds.service.AppUserService;
import com.webadds.WebAdds.service.AppUserServiceImpl;
import com.webadds.WebAdds.service.ClientService;


@Controller
@RequestMapping("admin/")
public class AdminController {

	@Autowired
	private AdvertiseDao advertiseDao;
	
	@Autowired
	private AppUserService userService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private RecordDao recordDao;
	
	@Autowired
	private RedemptionDao redemptionDao;
	
	/*@Autowired
	private SessionFactory sessionFactory;*/
	
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
		int points = advertiseDao.getAddpointById(addId);
		
		for(Integer userId : assignedUsersId) {
			recordDao.save(new AssignRecord(0, userId, addId, points, 0));
		}
		
		Optional<Advertise> result = advertiseDao.findById(addId);
		Advertise advertise = result.get();
		advertise.setIsAssigned(1);
		advertise.setTotalAssigned(this.assignedUsersId.size());
		advertiseDao.save(advertise);
		
		this.assignedUsersId = new ArrayList<>();
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
	
	@GetMapping("all-users")
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "all-users";
	}
	
	@GetMapping("all-clients")
	public String showAllClients(Model model) {
		model.addAttribute("clients", clientService.getAllClients());
		return "all-clients";
	}
	
	@GetMapping("redemptions")
	public String showRedemptions(Model model) {
		List<Redemptionreq> allAcceptedRedemptions = redemptionDao.getAllAcceptedRedemptions();
		model.addAttribute("redemptions", allAcceptedRedemptions);
		model.addAttribute("message", "All accepted Redemptions");
		return "redemptions-page";
	}
	
	@GetMapping("redemption-req")
	public String showRedemptionReq(Model model) {
		List<Redemptionreq> allRequests = redemptionDao.findAll();
		model.addAttribute("redemptions", allRequests);
		model.addAttribute("message", "All Redemptions");
		return "redemptions-page";
	}
	
	@PostMapping("approve")
	public String approveRedemption(@RequestParam("redemption-id") int redemptionId) {
		Optional<Redemptionreq> result = redemptionDao.findById(redemptionId);
		/*if(result.isPresent()) {
			Redemptionreq redemption = result.get();
			redemption.setIsAccepted(1);
			redemptionDao.save(redemption);
			
//			Delete all user related Assign Record in the database
			Session session = sessionFactory.openSession();
			int userId = redemption.getUserId();
			
			Query<AssignRecord> query = session.createQuery("DELETE AssignRecord a WHERE a.userId =:userId ");
			query.setParameter(":userId", userId);
			query.executeUpdate();
//			End of deleting the assign record
			
			return "redirect:redemption-req";
		}*/
		return "redirect:redemption-req";
	}
}
