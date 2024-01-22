package com.spring.securitypractice;

import com.spring.securitypractice.entity.Roles;
import com.spring.securitypractice.entity.User;
import com.spring.securitypractice.enums.Gender;
import com.spring.securitypractice.repo.RoleRepo;
import com.spring.securitypractice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
@EnableWebSecurity
public class SecuritypracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SecuritypracticeApplication.class, args);
	}


	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public void run(String... args) throws Exception {
		//Admin Role Creatino
		Roles adminRole = new Roles();
		adminRole.setName("ADMIN");
		roleRepo.save(adminRole);

		//User role creation
		Roles userRole = new Roles();
		userRole.setName("USER");
		roleRepo.save(userRole);

		//Creating password encoder
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		///Creating two users
		//***ADMIN
		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setPassword(passwordEncoder.encode("admin"));
		adminUser.setAddress("KTM");
		adminUser.setGender(Gender.FEMALE);
		adminUser.setRole(List.of(adminRole));
		userRepo.save(adminUser);

		//****User
		User user = new User();
		user.setUsername("user");
		user.setPassword(passwordEncoder.encode("user"));
		user.setAddress("KTM");
		user.setGender(Gender.MALE);
		user.setRole(List.of(userRole));
		userRepo.save(user);
	}
}
