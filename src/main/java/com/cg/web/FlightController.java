package com.cg.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.entity.Flight;
import com.cg.exception.InvalidFlightException;
import com.cg.service.FlightService;

@Controller
public class FlightController {
	private List<String> carriers;
	private List<String> cities;

	public FlightController() {
		carriers = Arrays.asList("Indigo", "SpiceJet", "AirIndia", "GoAir");
		cities = Arrays.asList("Mumbai", "Pune", "Bengaluru", "Kolkata", "Delhi");
	}

	@Autowired
	private FlightService service;

	@RequestMapping(value = "/addFlight.do", method = RequestMethod.GET)
	public String addFlight(Model model) {
		model.addAttribute("carriers", carriers);
		model.addAttribute("cities", cities);
		model.addAttribute("flight", new Flight());
		return "add";
	}

	@RequestMapping(value = "/checkFlight.do", method = RequestMethod.POST)
	public String checkFlight(@ModelAttribute("flight") @Valid Flight flight, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("carriers", carriers);
			model.addAttribute("cities", cities);
			model.addAttribute("message", "Adding flight failed");
			return "add";
		} else {
			model.addAttribute("carriers", carriers);
			model.addAttribute("cities", cities);
			model.addAttribute("flight", flight);
			int id = service.addFlight(flight);
			model.addAttribute("message", "Flight added with Id: " + id);
			return "add";
		}
	}

	@RequestMapping("/find.do")
	public String findFlight(int id, Map model) throws InvalidFlightException {
		Flight flight = service.getFlight(id);
		model.put("flight", flight);
		return "find";
	}
}
