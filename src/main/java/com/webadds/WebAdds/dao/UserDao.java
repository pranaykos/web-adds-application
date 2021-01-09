package com.webadds.WebAdds.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webadds.WebAdds.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public User findByEmailId(String username);
	
	@Query("SELECT COUNT(*) FROM User")
	public int getTotalUserCount();
	
}
