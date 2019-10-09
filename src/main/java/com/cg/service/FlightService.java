package com.cg.service;

import java.util.List;

import com.cg.entity.Flight;
import com.cg.exception.InvalidFlightException;

public interface FlightService {
	
	int addFlight(Flight flight);
	
	Flight getFlight(int id) throws InvalidFlightException;
	
	List<Flight> getList();
	
	List<Flight> getByCarrier(String carrier) throws InvalidFlightException;
}
