package com.webadds.WebAdds.service;

import org.springframework.web.multipart.MultipartFile;

import com.webadds.WebAdds.entity.Advertise;

public interface AddService {

	public void registerAdd(Advertise advertise, String username, MultipartFile addImage);
}
