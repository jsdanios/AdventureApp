package com.tts.AdventureApp.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.tts.AdventureApp.model.AdventureLocation;
import com.tts.AdventureApp.model.User;

public interface AdventureLocationRepository extends CrudRepository<AdventureLocation, Long> {
    List<AdventureLocation> findAllByOrderByCreatedAtDesc();
    List<AdventureLocation> findAllByUserOrderByCreatedAtDesc(User user);
    List<AdventureLocation> findAllByUsersInOrderByCreatedAtDesc(List<User> users);
}