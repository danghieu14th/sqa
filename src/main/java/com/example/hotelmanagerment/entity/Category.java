package com.example.hotelmanagerment.entity;

import javax.persistence.*;

import com.example.hotelmanagerment.DTO.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private String picture;
	
	public Category(String name, String description, String picture) {
		super();
		this.name = name;
		this.description = description;
		this.picture = picture;
	}
	
	public CategoryDTO toDTO () {
		return new CategoryDTO(id, name, description, picture);
	}



}
