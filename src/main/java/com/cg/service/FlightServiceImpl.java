package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Flight;
import com.cg.exception.InvalidFlightException;
import com.cg.repo.FlightRepo;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepo repo;
	
	public int addFlight(Flight flight) {
		return repo.save(flight);
	}

	public Flight getFlight(int id) throws InvalidFlightException {
		Flight f = repo.fetch(id);
		if(f == null)
			throw new InvalidFlightException("Flight not found for Id:"+id);
		return f;
	}

	public List<Flight> getList() {
		return repo.list();
	}

	public List<Flight> getByCarrier(String carrier) throws InvalidFlightException {
		List<Flight> flights = repo.findByCarrier(carrier);
		if(flights == null || flights.size() == 0)
			throw new InvalidFlightException("No flight found for:"+carrier);
		return flights;
	}
}
