
package com.udtamns.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udtamns.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	public Person findByFirstName(String firstName);
	public List<Person> findByLastName(String lastName);
	public Person findByOracleID(String oracleID);

}
