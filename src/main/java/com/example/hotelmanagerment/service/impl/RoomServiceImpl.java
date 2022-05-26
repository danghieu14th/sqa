package com.example.hotelmanagerment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagerment.entity.Category;
import com.example.hotelmanagerment.entity.Reservation;
import com.example.hotelmanagerment.entity.Room;
import com.example.hotelmanagerment.repository.CategoryRepository;
import com.example.hotelmanagerment.repository.RoomRepository;
import com.example.hotelmanagerment.service.ReservationService;
import com.example.hotelmanagerment.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ReservationService reservationService;

	@Override
	public List<Room> getAllRoom() {
		return roomRepository.findAll();
	}

	@Override
	public Room getRoomById(Long id) {
		return roomRepository.findById(id).get();
	}

	@Override
	public List<Room> getRoomByCategory(Category category) {
		return roomRepository.findByCategory(category);
	}

	@Override
	public Room createRoom(Room room) {
		room.setCategory(categoryRepository.findByName(room.getCategory().getName()));
		return roomRepository.save(room);
	}

	@Override
	public void deleteRoom(Room room) {
		Reservation reservation = reservationService.getReservationByRoom(room);
		if (reservation != null) reservationService.deleteReservation(reservation);
		roomRepository.delete(room);
	}

	@Override
	public Room editRoom(Room room, Long id) {
		Category category = categoryRepository.findByName(room.getCategory().getName());
		Room roomInDB = roomRepository.findById(id).get();
		
		roomInDB.setRoomCode(room.getRoomCode());
		roomInDB.setPicture(room.getPicture());
		roomInDB.setAdultPrice(room.getAdultPrice());
		roomInDB.setChildPrice(room.getChildPrice());
		roomInDB.setState(room.getState());
		roomInDB.setCategory(category);
		
		return roomRepository.save(roomInDB);
	}

	@Override
	public Room getRoomByRoomCode(String roomCode) {
		return roomRepository.findByRoomCode(roomCode);
	}

}
