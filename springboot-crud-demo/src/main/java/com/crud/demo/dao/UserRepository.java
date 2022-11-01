package com.crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	
}
