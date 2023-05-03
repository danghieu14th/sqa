package com.example.hotelmanagerment.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotelmanagerment.DTO.CategoryDTO;
import com.example.hotelmanagerment.DTO.RoomDTO;
import com.example.hotelmanagerment.entity.Category;
import com.example.hotelmanagerment.entity.Room;
import com.example.hotelmanagerment.service.CategoryService;
import com.example.hotelmanagerment.service.RoomService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin/rooms")
public class AdminRoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public String getAllRoom (Model model) {
		List<RoomDTO> roomDTOs = roomService.getAllRoom().stream()
				.map(e -> e.toDTO()).collect(Collectors.toList());
		
		model.addAttribute("roomDTOs", roomDTOs);
		return "admin/room/rooms";
	}
	
	@GetMapping("/add-room")
	public String addNewRoomGet (Model model) {
		
		List<CategoryDTO> categoryDTOs = categoryService.getAllCategory().stream()
				.map(e -> e.toDTO()).collect(Collectors.toList());
		
		model.addAttribute("roomDTO", new RoomDTO());
		model.addAttribute("categoryDTOs", categoryDTOs);
		
		return "admin/room/add-room";
	}
	
	@PostMapping("/add-room")
	public String addNewRoomPost (Model model, 
			@ModelAttribute("roomDTO") RoomDTO roomDTO) {
		
		roomService.createRoom(roomDTO.toEntity());
		
		return "redirect:/admin/rooms";
	}
	
	@GetMapping("/edit-room/{id}")
	public String editRoomGet (Model model, 
			@PathVariable("id") Long id) {
		
		List<CategoryDTO> categoryDTOs = categoryService.getAllCategory().stream()
				.map(e -> e.toDTO()).collect(Collectors.toList());
		
		model.addAttribute("roomDTO", roomService.getRoomById(id).toDTO());
		model.addAttribute("categoryDTOs", categoryDTOs);
		
		return "admin/room/edit-room";
	}
	
	@PostMapping("/edit-room/{id}")
	public String editRoomPost (Model model, 
			@PathVariable("id") Long id,
			@ModelAttribute("roomDTO") RoomDTO roomDTO) {
		
		roomService.editRoom(roomDTO.toEntity(), id);
		
		return "redirect:/admin/rooms";
	}
	
	@GetMapping("/delete-room/{id}")
	public String deleteRoom (Model model, 
			@PathVariable("id") Long id) {
		
		roomService.deleteRoom(roomService.getRoomById(id));
		
		return "redirect:/admin/rooms";
	}
	
}
