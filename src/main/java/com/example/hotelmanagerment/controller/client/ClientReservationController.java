package com.example.hotelmanagerment.controller.client;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotelmanagerment.DTO.ReservationDTO;
import com.example.hotelmanagerment.DTO.RoomDTO;
import com.example.hotelmanagerment.entity.Reservation;
import com.example.hotelmanagerment.entity.Room;
import com.example.hotelmanagerment.entity.User;
import com.example.hotelmanagerment.service.ReservationService;
import com.example.hotelmanagerment.service.RoomService;
import com.example.hotelmanagerment.service.UserService;

@Controller
@RequestMapping("")
public class ClientReservationController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/new-reservation")
	public String newReservationGet (Model model, HttpSession session) {
		
		List<RoomDTO> roomDTOs = roomService.getAllRoom().stream()
				.map(e -> e.toDTO()).collect(Collectors.toList()).stream()
				.filter(e -> e.getState() == 0).collect(Collectors.toList());
		
		ReservationDTO reservationDTO = new ReservationDTO();
		
		model.addAttribute("roomDTOs", roomDTOs);
		model.addAttribute("reservationDTO", reservationDTO);
		
		return "client/reservation-page";
	}
	
	@PostMapping("/new-reservation")
	public String newReservationPost (Model model, HttpSession session, 
				@ModelAttribute("reservationDTO") ReservationDTO reservationDTO) {
		
		User user = userService.getUserByUsername((String)session.getAttribute("username"));
		Room room = roomService.getRoomByRoomCode(reservationDTO.getRoomDTO().getRoomCode());
		
		reservationDTO.setUserDTO(user.toDTO());
		reservationDTO.setRoomDTO(room.toDTO());
		
		reservationService.createReservation(reservationDTO.toEntity());
		
		return "redirect:/your-reservations";
	}
	
	@GetMapping("/your-reservations")
	public String getReservationGet (Model model, HttpSession session) {
		
		User user = userService.getUserByUsername((String) session.getAttribute("username"));
		
		List<ReservationDTO> reservationDTOs = reservationService.getReservationByUser(user)
				.stream().map(e -> e.toDTO()).collect(Collectors.toList());
		
		model.addAttribute("reservationDTOs", reservationDTOs);
		
		return "client/your-reservations";
	}
	
	@GetMapping("/delete-reservation/{id}")
	public String deleteReservation (Model model, HttpSession session, 
				@PathVariable("id") Long id) {
		
		reservationService.deleteReservation(reservationService.getReservationById(id));
		
		return "redirect:/your-reservations";
	}
	
}
