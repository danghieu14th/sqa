package com.example.hotelmanagerment.service.impl;


import com.example.hotelmanagerment.entity.ERole;
import com.example.hotelmanagerment.entity.Role;
import com.example.hotelmanagerment.entity.User;
import com.example.hotelmanagerment.repository.UserRepository;
import com.example.hotelmanagerment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		
		if (user == null)
			throw new UsernameNotFoundException("Invalid Username or Password");
		
		return new org.springframework.security.core.userdetails.User(
					user.getEmail(), user.getPassword(), 
					mapRolesToAuthorities(new HashSet<Role>(Arrays.asList(user.getRole())))
				);
		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		
		return roles.stream().map(role -> 
			new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());
		
	}

	
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	
	@Override
	public User editUser(Long id, User user) {
		User userInDB = userRepository.findById(id).get();
		Role role = roleService.getRoleByName(user.getRole().getName());
		
		userInDB.setEmail(user.getEmail());
		userInDB.setUsername(user.getUsername());
		userInDB.setRole(role);
		return userRepository.save(userInDB);
	}

	
	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}


	@Override
	public User createUser(User user) {
		Role role = roleService.getRoleByName(user.getRole().getName());
		user.setRole(role);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

	
}
