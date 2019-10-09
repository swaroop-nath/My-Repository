package com.cg.repo;

import java.util.List;

import com.cg.entity.Flight;

public interface FlightRepo {

	int save(Flight flight);
	
	Flight fetch(int id);
	
	List<Flight> list();
	
	List<Flight> findByCarrier(String carrier);
}
