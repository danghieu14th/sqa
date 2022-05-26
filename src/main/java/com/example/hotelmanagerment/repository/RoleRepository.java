package com.example.hotelmanagerment.repository;

import com.example.hotelmanagerment.entity.ERole;
import com.example.hotelmanagerment.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName(ERole name);
	
}
