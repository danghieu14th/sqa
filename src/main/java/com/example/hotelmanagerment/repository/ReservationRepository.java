package com.example.hotelmanagerment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelmanagerment.entity.Reservation;
import com.example.hotelmanagerment.entity.Room;
import com.example.hotelmanagerment.entity.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> findByUser(User user);
	
	Reservation findByRoom(Room room);
	
}
