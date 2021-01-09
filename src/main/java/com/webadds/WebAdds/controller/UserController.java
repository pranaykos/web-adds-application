package com.webadds.WebAdds.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webadds.WebAdds.dao.AdvertiseDao;
import com.webadds.WebAdds.dao.RecordDao;
import com.webadds.WebAdds.dao.RedemptionDao;
import com.webadds.WebAdds.dao.UserDao;
import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.entity.AssignRecord;
import com.webadds.WebAdds.entity.Redemptionreq;
import com.webadds.WebAdds.entity.User;
import com.webadds.WebAdds.pojos.AdvertiseUserRecord;
import com.webadds.WebAdds.pojos.ApplicationUser;
import com.webadds.WebAdds.service.AppUserService;

@Controller
@RequestMapping("user/")
public class UserController {

	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private RecordDao recordDao;
	
	@Autowired
	private AdvertiseDao advertiseDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RedemptionDao redemptionDao;
	
	private User loggedUser;
	private String username;
	int points;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}
	
	@GetMapping("profile")
	public String profilePage(Model model) {
		String emailid;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			emailid = ((UserDetails)principal).getUsername();
		}else {
			emailid = principal.toString();
		}
		
		loggedUser = appUserService.getUserByEmail(emailid);
		username = loggedUser.getName();
		model.addAttribute("user", loggedUser);
		model.addAttribute("username", username);
		
		return "profile";
	}

	@GetMapping("advertises")
	public String showUserAdvertises(Model model) {
		 List<AssignRecord> userRecords = recordDao.getByUserId(loggedUser.getId());
		 List<AdvertiseUserRecord> advertiseUserRecords = new ArrayList<>();
		 
		 for(AssignRecord record : userRecords) {
			 Optional<Advertise> result = advertiseDao.findById(record.getAddId());
			 if(result.isPresent()) {
				 Advertise advertise = result.get();
				 advertiseUserRecords.add(new AdvertiseUserRecord(advertise, record));
			 }
		 }
		 
		model.addAttribute("advertises", advertiseUserRecords);
		model.addAttribute("username", username);
		if(this.points != 0) {
			model.addAttribute("points", points);
			points = 0;
		}
		return "user-advertises";
	}
	
	@GetMapping("advertise/{advertiseId}")
	public String showTheAdd(@PathVariable("advertiseId") int advertiseId,
					Model model) {
		Optional<Advertise> result = advertiseDao.findById(advertiseId);
		if(result.isPresent()) {
			Advertise advertise = result.get();
			model.addAttribute("advertise", advertise);
			model.addAttribute("username", username);
			return "add-show-page";
		}
		model.addAttribute("username", username);
		return "add-show-page";
	}
	
	@PostMapping("advertise/{advertiseId}")
	public String markAddSeen(@PathVariable("advertiseId") int advertiseId,
					Model model) {
		AssignRecord userRecord = recordDao.getByUserIdAndAddId(loggedUser.getId(), advertiseId);
		userRecord.setIsSeen(1);
		recordDao.save(userRecord);
		
		appUserService.creditPointsToTheUserAccount(loggedUser.getId(), userRecord.getPoints());
		this.points = userRecord.getPoints();
		return "redirect:/user/advertises";
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
	
	@GetMapping("claim-cash")
	public String claimCashHandler() {
		System.out.println("claim cash request");
		loggedUser.setIsCashClaimed(1);
		userDao.save(loggedUser);
		Redemptionreq req = new Redemptionreq(0, loggedUser.getId(), loggedUser.getPoints());
		redemptionDao.save(req);
		return "redirect:/user/profile";
	}
	
	@GetMapping("redemption-requests")
	public String showRedemptionRequests(Model model) {
		List<Redemptionreq> redemptions = redemptionDao.getByUserId(loggedUser.getId());
		model.addAttribute("redemptions", redemptions);
		model.addAttribute("length", redemptions.size());
		model.addAttribute("username", username);
		return "redemptions";
	}
	
}
