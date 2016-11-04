package com.udtamns.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udtamns.model.Assignment;

public interface AssignmentRepository extends MongoRepository<Assignment, String>{
	public Assignment findByOracleID(String oracleID);
}
