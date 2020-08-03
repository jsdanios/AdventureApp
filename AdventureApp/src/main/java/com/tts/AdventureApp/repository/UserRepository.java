package com.tts.AdventureApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.AdventureApp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
