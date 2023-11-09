package com.owlapps.samarony.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.owlapps.samarony.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByDocument(final String document);
//	User findByHighScore();
//	List<User> findTop15ByOrderByHighScoreDesc();
//	List<User> findTop3ByOrderByHighScoreDesc();
}
