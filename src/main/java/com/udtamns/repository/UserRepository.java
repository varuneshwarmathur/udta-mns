package com.udtamns.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udtamns.model.Users;



public interface UserRepository extends MongoRepository<Users, String>{

	public Users findByFirstname(String firstname);
	public List<Users> findByLastname(String lastname);
	public Users findByUsername(String username);

}
