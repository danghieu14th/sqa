package com.example.hotelmanagerment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagerment.entity.Category;
import com.example.hotelmanagerment.entity.Room;
import com.example.hotelmanagerment.repository.CategoryRepository;
import com.example.hotelmanagerment.service.CategoryService;
import com.example.hotelmanagerment.service.RoomService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private RoomService roomService;
	
	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category createNewCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		List<Room> rooms = roomService.getRoomByCategory(category);
		for (Room i : rooms)
			roomService.deleteRoom(i);
		categoryRepository.delete(category);
	}

	@Override
	public Category editCategory(Category category, Long id) {
		Category categoryInDB = getCategoryById(id);
		categoryInDB.setName(category.getName());
		categoryInDB.setDescription(category.getDescription());
		return categoryRepository.save(categoryInDB);
	}

	@Override
	public Category getCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}

}
