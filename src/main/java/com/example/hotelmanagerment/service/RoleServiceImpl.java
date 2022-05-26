package com.example.hotelmanagerment.service;



import com.example.hotelmanagerment.entity.ERole;
import com.example.hotelmanagerment.entity.Role;

import java.util.List;

public interface RoleServiceImpl {

	List<Role> getAllRole();

	Role getRoleById(Long id);
	
	Role getRoleByName (ERole name);

}
