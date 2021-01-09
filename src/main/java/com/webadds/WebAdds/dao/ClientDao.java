package com.webadds.WebAdds.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webadds.WebAdds.entity.Client;

public interface ClientDao extends JpaRepository<Client, Integer> {
	public Client findByUsername(String username);
	
	@Query("SELECT COUNT(*) FROM Client")
	public int getTotalCLientCount();
}
