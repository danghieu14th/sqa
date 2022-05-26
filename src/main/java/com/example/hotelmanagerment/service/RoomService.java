package com.example.hotelmanagerment.service;

import java.util.List;

import com.example.hotelmanagerment.entity.Category;
import com.example.hotelmanagerment.entity.Room;

public interface RoomService {

	List<Room> getAllRoom ();
	
	Room getRoomById (Long id);
	
	Room getRoomByRoomCode (String roomCode);
	
	List<Room> getRoomByCategory (Category category);
	
	Room createRoom (Room room);
	
	Room editRoom (Room room, Long id);
	
	void deleteRoom (Room room);
	
}
