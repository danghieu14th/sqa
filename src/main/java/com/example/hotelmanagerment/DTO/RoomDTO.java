package com.example.hotelmanagerment.DTO;

import com.example.hotelmanagerment.entity.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

	private Long id;
	private String roomCode;
	private String picture;
	private Double adultPrice;
	private Double childPrice;
	private CategoryDTO categoryDTO;
	private Integer state;
	
	public Room toEntity () {
		return new Room(roomCode, picture, adultPrice, childPrice, categoryDTO.toEntity(), state);
	}
	
}
