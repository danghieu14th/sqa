package com.example.hotelmanagerment.service;

import java.util.List;

import com.example.hotelmanagerment.entity.Reservation;
import com.example.hotelmanagerment.entity.Room;
import com.example.hotelmanagerment.entity.User;

public interface ReservationService {

	List<Reservation> getAllReservation ();
	
	Reservation getReservationById (Long id);
	
	List<Reservation> getReservationByUser (User user);
	
	Reservation getReservationByRoom (Room room);
	
	Reservation createReservation (Reservation reservation);
	
	Reservation editReservation (Reservation reservation, Long id);
	
	void deleteReservation (Reservation reservation);
	
}
