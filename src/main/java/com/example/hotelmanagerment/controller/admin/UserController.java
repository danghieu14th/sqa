package com.example.hotelmanagerment.controller.admin;


import com.example.hotelmanagerment.DTO.UserDTO;
import com.example.hotelmanagerment.entity.User;
import com.example.hotelmanagerment.service.UserService;
import com.example.hotelmanagerment.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@GetMapping("")
	public String listUser(Model model) {

		List<User> users = userService.getAllUser();

		List<UserDTO> userDTOs = users.stream().map(e -> e.toDTO()).collect(Collectors.toList());

		model.addAttribute("userDTOs", userDTOs);

		return "admin/user/users";
	}

	@GetMapping("/add-user")
	public String addNewUserGet(Model model) {

		UserDTO userDTO = new UserDTO();
		model.addAttribute("userDTO", userDTO);

		return "admin/user/add-user";
	}

	@PostMapping("/add-user")
	public String addNewUserPost(Model model, @ModelAttribute(name = "userDTO") UserDTO userDTO) {

		userService.createUser(userDTO.toModel());
		
		return "redirect:/admin/users";
	}

	@GetMapping("/edit-user/{id}")
	public String editUserGet(Model model, @PathVariable(name = "id") Long id) {

		UserDTO userDTO = userService.getUserById(id).toDTO();
		
		model.addAttribute("userDTO", userDTO);

		return "admin/user/edit-user";
	}

	@PostMapping("/edit-user/{id}")
	public String editUserPost(Model model, @ModelAttribute(name = "userDTO") UserDTO userDTO,
			@PathVariable(name = "id") Long id) {
		
		userDTO.setPassword(userService.getUserById(id).getPassword());
		
		userService.editUser(id, userDTO.toModel());

		return "redirect:/admin/users";
	}

	@GetMapping("/delete-user/{id}")
	public String deleteUser(Model model, @PathVariable(name = "id") Long id) {

		userService.deleteUser(userService.getUserById(id));

		return "redirect:/admin/users";
	}
}
