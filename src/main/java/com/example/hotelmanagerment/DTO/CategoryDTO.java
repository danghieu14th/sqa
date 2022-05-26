package com.example.hotelmanagerment.DTO;

import com.example.hotelmanagerment.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

	private Long id;
	private String name;
	private String description;
	private String picture;
	
	public Category toEntity () {
		return new Category(name, description, picture);
	}
	
}
