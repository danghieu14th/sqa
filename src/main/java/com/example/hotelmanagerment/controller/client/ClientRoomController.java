package com.example.hotelmanagerment.controller.client;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotelmanagerment.DTO.RoomDTO;
import com.example.hotelmanagerment.entity.Category;
import com.example.hotelmanagerment.service.CategoryService;
import com.example.hotelmanagerment.service.RoomService;

@Controller
@RequestMapping("")
public class ClientRoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/room-category/{id}")
	public String getRoomOfCategory (Model model, 
			@PathVariable("id") Long id) {
		
		Category category = categoryService.getCategoryById(id);
		
		List<RoomDTO> roomDTOs = roomService.getRoomByCategory(category).stream()
				.map(e -> e.toDTO()).collect(Collectors.toList()).stream()
				.filter(e -> e.getState() == 0).collect(Collectors.toList());
		
		model.addAttribute("roomDTOs", roomDTOs);
		model.addAttribute("categoryDTO", category.toDTO());
		
		return "client/room.html";
	}
	
	
}
