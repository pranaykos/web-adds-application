package com.webadds.WebAdds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webadds.WebAdds.entity.Admin;
import com.webadds.WebAdds.entity.User;

public interface AdminDao extends JpaRepository<Admin, Integer> {

	public Admin findByUsername(String username);
}
