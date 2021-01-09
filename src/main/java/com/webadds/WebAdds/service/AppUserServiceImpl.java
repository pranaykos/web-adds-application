package com.webadds.WebAdds.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.webadds.WebAdds.dao.UserDao;
import com.webadds.WebAdds.entity.User;
import com.webadds.WebAdds.pojos.ApplicationUser;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserDao userDao;
	
	
	
	@Override
	public void registerUser(ApplicationUser applicationUser) {
		User user = getTheUser(applicationUser);
		userDao.save(user);
	}
	
	private User getTheUser(ApplicationUser applicationUser) {
		User user = new User();
		user.setName(applicationUser.getName());
		user.setEmailId(applicationUser.getEmailId());
		user.setPassword(encoder.encode(applicationUser.getPassword()));
		user.setFirstName(applicationUser.getFirstName());
		user.setLastName(applicationUser.getLastName());
		user.setAddress(applicationUser.getAddress());
		user.setCountry(applicationUser.getCountry());
		user.setMobileNo(applicationUser.getMobileNo());
		user.setRole("ROLE_USER");
		return user;
	}

	@Override
	public List<ApplicationUser> getAllUsers() {
		List<ApplicationUser> applicationUsers = userDao.findAll()
				.stream()
				.map(user -> new ApplicationUser(user.getId(), user.getName(), user.getEmailId(),
						"", user.getFirstName(), user.getLastName(), user.getAddress(), user.getCountry(), user.getMobileNo(), "", user.getPoints()))
				.collect(Collectors.toList());
		
		return applicationUsers;
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.findByEmailId(email);
	}

	@Override
	public boolean creditPointsToTheUserAccount(int userId, int points) {
		Optional<User> result = userDao.findById(userId);
		if(result.isPresent()) {
			User user = result.get();
			int currentCrefitPoints = user.getPoints();
			int newCreditPoints = currentCrefitPoints + points; 
			user.setPoints(newCreditPoints);
			userDao.save(user);
			return true;
		}
		return false;
	}

	
}
