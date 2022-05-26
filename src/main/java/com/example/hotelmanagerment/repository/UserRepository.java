package com.example.hotelmanagerment.repository;


import com.example.hotelmanagerment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	User findByEmail(String email);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
