
package com.udtamns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udtamns.model.Users;
import com.udtamns.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	UserRepository user;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		user.deleteAll();
		user.save(new Users("Admin", "Admin","adminuser","killerapp123"));
		
	}
}
