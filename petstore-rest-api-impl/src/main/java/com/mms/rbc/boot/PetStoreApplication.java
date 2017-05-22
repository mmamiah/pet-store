package com.mms.rbc.boot;

import com.mms.rbc.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * PetStoreApplication
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.mms.rbc")
public class PetStoreApplication implements CommandLineRunner  {
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
//		SpringApplication.run(PetStoreApplication.class, args);
		PetStoreApplication app = new PetStoreApplication();
		try {
			app.run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("Hello Word");
	}
}

