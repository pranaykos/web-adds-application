package com.webadds.WebAdds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.webadds.WebAdds.dao.ClientDao;
import com.webadds.WebAdds.entity.Client;
import com.webadds.WebAdds.pojos.ApplicationClient;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void registerClient(ApplicationClient applicationClient) {
		Client client = getClient(applicationClient);
		clientDao.save(client);
	}
	
	private Client getClient(ApplicationClient applicationClient) {
		Client client = new Client();
		client.setEmail(applicationClient.getEmail());
		client.setCompanyName(applicationClient.getCompanyName());
		client.setUsername(applicationClient.getUsername());
		client.setPassword(encoder.encode(applicationClient.getPassword()));
		client.setRole("ROLE_CLIENT");
		
		return client;
	}

	@Override
	public List<Client> getAllClients() {
		return clientDao.findAll();
	}
}
