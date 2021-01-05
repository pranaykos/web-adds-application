package com.webadds.WebAdds.authService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.webadds.WebAdds.dao.AdminDao;
import com.webadds.WebAdds.dao.ClientDao;
import com.webadds.WebAdds.dao.UserDao;
import com.webadds.WebAdds.entity.Admin;
import com.webadds.WebAdds.entity.Client;
import com.webadds.WebAdds.entity.User;

@Service("authServiceProvider")
public class ApplicationUserServiceImpl implements ApplicationUserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private AdminDao adminDao;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User foundUuser = userDao.findByEmailId(username);
		
		if(foundUuser != null) {
			AuthUser user = new AuthUser(com.webadds.WebAdds.authority.Role.USER.getAuthorities(),
					foundUuser.getEmailId(),
					foundUuser.getPassword(),
					true,
					true,
					true,
					true);
			return user;
		}

		Client foundClient = clientDao.findByUsername(username);
		
		if(foundClient != null) {					
			AuthClient client = new AuthClient(com.webadds.WebAdds.authority.Role.CLIENT.getAuthorities(),
					foundClient.getUsername(),
					foundClient.getPassword(),
					true,
					true,
					true,
					true);
			return client;
		}
		
		Admin foundAdmin = adminDao.findByUsername(username);
		if(foundAdmin != null) {
			AuthAdmin admin = new AuthAdmin(com.webadds.WebAdds.authority.Role.ADMIN.getAuthorities(),
					foundAdmin.getUsername(),
					foundAdmin.getPassword(),
					true,
					true,
					true,
					true);
			return admin;
		}
		
		throw new UsernameNotFoundException("Invalid Username or Password entered");
	}

	
	
}
