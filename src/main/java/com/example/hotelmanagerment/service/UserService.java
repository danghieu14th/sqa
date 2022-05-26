package com.example.hotelmanagerment.service;


import com.example.hotelmanagerment.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{

	//User save(UserRegistrationDTO registrationDTO);
	
	User createUser(User user);
	
	User getUserById (Long id);
	
	List<User> getAllUser ();
	
	User editUser (Long id, User user);
	
	void deleteUser (User user);

	User getUserByEmail (String email);

	User getUserByUsername (String username);
	
}
