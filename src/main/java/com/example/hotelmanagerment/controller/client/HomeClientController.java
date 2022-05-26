package com.example.hotelmanagerment.controller.client;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotelmanagerment.DTO.CategoryDTO;
import com.example.hotelmanagerment.DTO.UserDTO;
import com.example.hotelmanagerment.entity.ERole;
import com.example.hotelmanagerment.entity.Role;
import com.example.hotelmanagerment.entity.User;
import com.example.hotelmanagerment.service.CategoryService;
import com.example.hotelmanagerment.service.UserService;


@Controller
@RequestMapping("")
public class HomeClientController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public String homeClient (Model model) {
		
		List<CategoryDTO> categoryDTOs = categoryService.getAllCategory()
				.stream().map(e -> e.toDTO()).collect(Collectors.toList());
		
		model.addAttribute("categoryDTOs", categoryDTOs);
		
		return "/client/home-page";	
	}
	
	@GetMapping("/login")
	public String loginGet (Model model) {

		UserDTO userDTO = new UserDTO();

		model.addAttribute("userDTO", userDTO);

		return "/client/login.html";
	}
	
	@PostMapping("/login")
	public String loginPost (Model model, HttpSession session,
							 @ModelAttribute(name = "userDTO") UserDTO userDTO) {

		User user = userService.getUserByEmail(userDTO.getEmail());

		if (user == null){
			model.addAttribute("error", "Username or password is invalid");
			return "/client/login";
		}

		if (user.getRole().getName().equals(ERole.ROLE_USER) && new BCryptPasswordEncoder().matches(userDTO.getPassword(), user.getPassword())){
			session.setAttribute("username", user.getUsername());
			return "redirect:/";
		}

		model.addAttribute("error", "Username or password is invalid");
		return "/client/login";

	}

	@GetMapping("/register")
	public String registerGet (Model model) {

		UserDTO userDTO = new UserDTO();

		model.addAttribute("userDTO", userDTO);

		return "/client/register";
	}

	@PostMapping("/register")
	public String registerPost (Model model, @ModelAttribute(name = "userDTO") UserDTO userDTO) {

		userDTO.setRoleDTO((new Role(ERole.ROLE_USER)).toDTO());
		userService.createUser(userDTO.toModel());

		return "redirect:/login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session){

		session.removeAttribute("username");

		return "redirect:/";
	}
	
}
