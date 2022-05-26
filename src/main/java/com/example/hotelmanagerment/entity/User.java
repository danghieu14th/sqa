package com.example.hotelmanagerment.entity;


import com.example.hotelmanagerment.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	private String email;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public User(String username, String email, String password, Role role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public UserDTO toDTO () {
		return new UserDTO(id, username, email, password, role.toDTO());
	}
	
}
