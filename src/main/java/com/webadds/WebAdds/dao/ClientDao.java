package com.webadds.WebAdds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webadds.WebAdds.entity.Client;

public interface ClientDao extends JpaRepository<Client, Integer> {
	public Client findByUsername(String username);
}
