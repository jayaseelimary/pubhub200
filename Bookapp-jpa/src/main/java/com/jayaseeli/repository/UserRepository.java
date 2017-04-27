package com.jayaseeli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayaseeli.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmailIdAndPassword(String emailId, String password);

}
