package com.webadds.WebAdds.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webadds.WebAdds.dao.AdvertiseDao;
import com.webadds.WebAdds.dao.ClientDao;
import com.webadds.WebAdds.dao.UserDao;
import com.webadds.WebAdds.entity.Advertise;
import com.webadds.WebAdds.entity.Client;
import com.webadds.WebAdds.entity.User;
import com.webadds.WebAdds.helper.ImageUpload;

@Service
public class AddServiceImpl implements AddService {
	
	@Autowired
	private AdvertiseDao addvertiseDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private ImageUpload imageUpload;
	
	private final String UPLOAD = new ClassPathResource("static/images").getFile().getAbsolutePath();
	
	public AddServiceImpl() throws IOException{
		super();
	}

	@Override
	public void registerAdd(Advertise advertise, String username, MultipartFile addImage) {
		
		String imagePath = this.UPLOAD+File.separator+addImage.getOriginalFilename();
		
		if(imageUpload.uploadImage(addImage)) {
			advertise.setImagePath(addImage.getOriginalFilename());
			
			Client client = clientDao.findByUsername(username);
			
			advertise.setClient(client);
			advertise.setImagePath("https://localhost:8080/images/"+addImage.getOriginalFilename());
			addvertiseDao.save(advertise);
		}else {
			System.out.println("Something went wrong");
		}
	}

}
