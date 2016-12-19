
package com.udtamns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udtamns.repository.UserRepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	UserRepository user;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
