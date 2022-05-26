package com.example.hotelmanagerment.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotelmanagerment.DTO.ReservationDTO;
import com.example.hotelmanagerment.DTO.RoomDTO;
import com.example.hotelmanagerment.DTO.UserDTO;
import com.example.hotelmanagerment.service.ReservationService;
import com.example.hotelmanagerment.service.RoomService;
import com.example.hotelmanagerment.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin/reservations")
public class AdminReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;

	@GetMapping("")
	public String getAllReservation (Model model) {
		
		List<ReservationDTO> reservationDTOs = reservationService.getAllReservation()
				.stream().map(e -> e.toDTO()).collect(Collectors.toList());
		
		model.addAttribute("reservationDTOs", reservationDTOs);
		
		return "/admin/reservation/reservations";
	}
	
	@GetMapping("/add-reservation")
	public String addNewReservationGet (Model model) {
		
		List<UserDTO> userDTOs = userService.getAllUser().stream()
				.map(e -> e.toDTO()).collect(Collectors.toList());
		
		List<RoomDTO> roomDTOs = roomService.getAllRoom().stream()
				.map(e -> e.toDTO()).collect(Collectors.toList()).stream()
				.filter(e -> e.getState() == 0).collect(Collectors.toList());
		
		model.addAttribute("userDTOs", userDTOs);
		model.addAttribute("roomDTOs", roomDTOs);
		model.addAttribute("reservationDTO", new ReservationDTO());
		
		return "/admin/reservation/add-reservation";
	}
	
	@PostMapping("/add-reservation")
	public String addNewReservationPost (Model model, 
			@ModelAttribute("reservationDTO") ReservationDTO reservationDTO) {
		
		reservationDTO.setUserDTO(userService.getUserByUsername(reservationDTO.getUserDTO()
				.getUsername()).toDTO());
		reservationDTO.setRoomDTO(roomService.getRoomByRoomCode(reservationDTO.getRoomDTO()
				.getRoomCode()).toDTO());
		reservationService.createReservation(reservationDTO.toEntity());
		
		return "redirect:/admin/reservations";
	}
	
}
