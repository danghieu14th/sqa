package com.example.hotelmanagerment.DTO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.hotelmanagerment.entity.Reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
	
	private Long id;
	private UserDTO userDTO;
	private RoomDTO roomDTO;
	private Integer adultNumber;
	private Integer childNumber;
	private Integer periodOfStay;
	private Double totalPrice;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrivalDate;
	
	public Reservation toEntity () {
		return new Reservation(userDTO.toModel(), roomDTO.toEntity(), adultNumber, childNumber, periodOfStay, arrivalDate);
	}
}
