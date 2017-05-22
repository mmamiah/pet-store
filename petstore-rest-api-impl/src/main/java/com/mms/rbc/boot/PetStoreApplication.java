package com.mms.rbc.boot;

import java.util.Collection;
import com.mms.rbc.model.user.PetStoreUser;
import com.mms.rbc.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * PetStoreApplication
 */
//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ImportResource("classpath*:**/*ApplicationContext.xml")
@EnableJpaRepositories(basePackages = {"com.mms.rbc.dao"})
public class PetStoreApplication implements CommandLineRunner  {
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(PetStoreApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Collection<PetStoreUser> users = userService.findByUserName("mmamiah");
		System.out.println("Hello Word");
	}
}
