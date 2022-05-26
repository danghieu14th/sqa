package com.example.hotelmanagerment.service;

import java.util.List;

import com.example.hotelmanagerment.entity.Category;

public interface CategoryService {

	List<Category> getAllCategory ();
	
	Category getCategoryById (Long id);
	
	Category getCategoryByName (String name);
	
	Category createNewCategory (Category category);
	
	void deleteCategory (Category category);
	
	Category editCategory (Category category, Long id);
	
}
