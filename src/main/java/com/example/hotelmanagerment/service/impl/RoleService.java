package com.example.hotelmanagerment.service.impl;

import com.example.hotelmanagerment.entity.ERole;
import com.example.hotelmanagerment.entity.Role;
import com.example.hotelmanagerment.repository.RoleRepository;
import com.example.hotelmanagerment.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleServiceImpl {

	@Autowired
	private RoleRepository RoleRepository;

	@Override
	public List<Role> getAllRole() {
		return RoleRepository.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		return RoleRepository.findById(id).get();
	}

	@Override
	public Role getRoleByName(ERole name) {
		return RoleRepository.findByName(name);
	}
	
	
	
}
