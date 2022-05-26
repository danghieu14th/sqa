package com.example.hotelmanagerment.controller.admin;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotelmanagerment.DTO.CategoryDTO;
import com.example.hotelmanagerment.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public String getAllCategory(Model model) {
		
		List<CategoryDTO> categoryDTOs = categoryService.getAllCategory().stream()
				.map(e -> e.toDTO()).collect(Collectors.toList());
		
		model.addAttribute("categoryDTOs", categoryDTOs);
		return "/admin/category/categories";
	}
	
	@GetMapping("/add-category")
	public String addNewCategoryGet (Model model) {
		model.addAttribute("categoryDTO", new CategoryDTO());
		return "/admin/category/add-category";
	}
	
	@PostMapping("/add-category")
	public String addNewCategoryPost (Model model, 
			@ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
		
		categoryService.createNewCategory(categoryDTO.toEntity());
		
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/edit-category/{id}")
	public String editCategoryGet (Model model, 
			@PathVariable("id") Long id) {
		
		CategoryDTO categoryDTO = categoryService.getCategoryById(id).toDTO();
		model.addAttribute("categoryDTO", categoryDTO);
		return "/admin/category/edit-category";
	}
	
	@PostMapping("/edit-category/{id}")
	public String editCategoryPost (Model model, 
			@PathVariable("id") Long id,
			@ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
		
		categoryService.editCategory(categoryDTO.toEntity(), id);
		
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/delete-category/{id}")
	public String deleteCategory (Model model, 
			@PathVariable("id") Long id) {
		
		categoryService.deleteCategory(categoryService.getCategoryById(id));
		return "redirect:/admin/categories";
	}
	
}
