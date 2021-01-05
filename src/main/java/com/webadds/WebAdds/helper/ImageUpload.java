package com.webadds.WebAdds.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUpload {

	private final String UPLOAD = new ClassPathResource("static/images").getFile().getAbsolutePath();

	public ImageUpload() throws IOException {
		super();
	}
	public boolean uploadImage(MultipartFile file) {
		boolean isUpload = false;
		try {
			Files.copy(file.getInputStream(), 
					Paths.get(UPLOAD+File.separator+file.getOriginalFilename()), 
					StandardCopyOption.REPLACE_EXISTING);
			isUpload = true;
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		
		return isUpload;
	}
}
