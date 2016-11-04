package com.udtamns.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udtamns.model.TravelPool;

public interface TravelPoolRepository extends MongoRepository<TravelPool, String>{
	public TravelPool findByOracleID(String oracleID);
	public List<TravelPool> findByDomain(String Domain);
}
