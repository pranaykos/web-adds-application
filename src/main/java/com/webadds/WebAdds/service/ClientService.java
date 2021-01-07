package com.webadds.WebAdds.service;

import java.util.List;

import com.webadds.WebAdds.entity.Client;
import com.webadds.WebAdds.pojos.ApplicationClient;

public interface ClientService {

	public void registerClient(ApplicationClient applicationClient);
	public List<Client> getAllClients();
}
