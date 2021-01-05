package com.webadds.WebAdds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BlogAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
					SpringApplication.run(BlogAppApplication.class, args);
		
		System.out.println("Hellwo world");
		
	}

}
