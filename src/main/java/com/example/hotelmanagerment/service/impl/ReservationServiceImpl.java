package com.example.hotelmanagerment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagerment.entity.Reservation;
import com.example.hotelmanagerment.entity.Room;
import com.example.hotelmanagerment.entity.User;
import com.example.hotelmanagerment.repository.ReservationRepository;
import com.example.hotelmanagerment.repository.RoomRepository;
import com.example.hotelmanagerment.repository.UserRepository;
import com.example.hotelmanagerment.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getReservationById(Long id) {
		return reservationRepository.findById(id).get();
	}

	@Override
	public List<Reservation> getReservationByUser(User user) {
		return reservationRepository.findByUser(user);
	}

	@Override
	public Reservation createReservation(Reservation reservation) {
		User user = userRepository.findByUsername(reservation.getUser().getUsername());
		Room room = roomRepository.findByRoomCode(reservation.getRoom().getRoomCode());
		
		reservation.setUser(user);
		reservation.setRoom(room);
		
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation editReservation(Reservation reservation, Long id) {
		Reservation reservationInDB = getReservationById(id);
		User user = userRepository.findByUsername(reservation.getUser().getUsername());
		Room room = roomRepository.findByRoomCode(reservation.getRoom().getRoomCode());
		
		reservationInDB.setUser(user);
		reservationInDB.setRoom(room);
		reservationInDB.setAdultNumber(reservation.getAdultNumber());
		reservationInDB.setChildNumber(reservation.getChildNumber());
		reservationInDB.setPeriodOfStay(reservation.getPeriodOfStay());
		
		return reservationRepository.save(reservationInDB);
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		reservationRepository.delete(reservation);
	}

	@Override
	public Reservation getReservationByRoom(Room room) {
		return reservationRepository.findByRoom(room);
	}

}
