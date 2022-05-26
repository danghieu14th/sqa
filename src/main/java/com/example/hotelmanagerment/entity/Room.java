package com.example.hotelmanagerment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.hotelmanagerment.DTO.RoomDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_code")
	private String roomCode;
	
	private String picture;
	
	@Column(name = "adult_price")
	private Double adultPrice;
	
	@Column(name = "child_price")
	private Double childPrice;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	private Integer state;

	public Room(String roomCode, String picture, Double adultPrice, Double childPrice, Category category, Integer state) {
		super();
		this.roomCode = roomCode;
		this.picture = picture;
		this.adultPrice = adultPrice;
		this.childPrice = childPrice;
		this.category = category;
		this.state = state;
	}
	
	public RoomDTO toDTO () {
		return new RoomDTO(id, roomCode, picture, adultPrice, childPrice, category.toDTO(), state);
	}
}
