package com.owlapps.samarony.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.owlapps.samarony.model.User;

@Repository
public interface UserDao extends MongoRepository<User, Long> {

}
