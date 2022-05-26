package com.example.hotelmanagerment.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.hotelmanagerment.DTO.ReservationDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "reservations")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	private Integer adultNumber;
	private Integer childNumber;
	private Integer periodOfStay;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrivalDate;
	
	public Reservation(User user, Room room, Integer adultNumber, Integer childNumber, Integer periodOfStay, Date arrivalDate) {
		super();
		this.user = user;
		this.room = room;
		this.adultNumber = adultNumber;
		this.childNumber = childNumber;
		this.periodOfStay = periodOfStay;
		this.arrivalDate = arrivalDate;
	}
	
	public ReservationDTO toDTO () {
		Double totalPrice = adultNumber * room.getAdultPrice() + childNumber * room.getChildPrice();
		return new ReservationDTO(id, user.toDTO(), room.toDTO(), adultNumber, childNumber, periodOfStay, totalPrice*periodOfStay, arrivalDate);
	}
	
}
