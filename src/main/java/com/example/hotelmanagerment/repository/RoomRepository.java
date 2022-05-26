package com.example.hotelmanagerment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelmanagerment.entity.Category;
import com.example.hotelmanagerment.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

	List<Room> findByCategory(Category category);
	
	Room findByRoomCode (String roomCode);
	
}
