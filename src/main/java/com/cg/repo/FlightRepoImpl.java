package com.cg.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entity.Flight;

@Repository
public class FlightRepoImpl implements FlightRepo {

	@PersistenceContext(name = "MyJPA")
	private EntityManager mgr;
	
	public int save(Flight flight) {
		mgr.persist(flight);
		return flight.getFlid();
	}

	public Flight fetch(int id) {
		Flight fl = (Flight) mgr.find(Flight.class, id);
		return fl;
	}

	public List<Flight> list() {
		return mgr.createQuery("from Flight").getResultList();
	}

	public List<Flight> findByCarrier(String carrier) {
		return mgr.createNamedQuery("bycarrier").
				setParameter("car", carrier).getResultList();
	}

}

