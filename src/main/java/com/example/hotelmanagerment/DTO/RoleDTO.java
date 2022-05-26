package com.example.hotelmanagerment.DTO;

import com.example.hotelmanagerment.entity.ERole;
import com.example.hotelmanagerment.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

	private Long id;
	private String name;
	
	public Role toModel () {
		return new Role(id, ERole.valueOf(name));
	}
}
