package com.webadds.WebAdds.service;

import java.util.List;

import com.webadds.WebAdds.pojos.ApplicationUser;

public interface AppUserService {

	public void registerUser(ApplicationUser user);
	public List<ApplicationUser> getAllUsers();
}
