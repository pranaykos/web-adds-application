package com.webadds.WebAdds.service;

import java.util.List;

import com.webadds.WebAdds.entity.User;
import com.webadds.WebAdds.pojos.ApplicationUser;

public interface AppUserService {

	public void registerUser(ApplicationUser user);
	public List<ApplicationUser> getAllUsers();
	public User getUserByEmail(String email);
	public boolean creditPointsToTheUserAccount(int userId, int points);
}
