package com.example.hotelmanagerment.DTO;


import com.example.hotelmanagerment.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Long id;
	private String username;
	private String email;
	private String password;
	private RoleDTO roleDTO;
	
	public User toModel () {
		return new User(id, username, email, password, roleDTO.toModel());
	}
	
}
