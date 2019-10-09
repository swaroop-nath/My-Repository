package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SequenceGenerator(name = "flseq", sequenceName = "fl_seq")
@NamedQuery(name = "bycarrier", query = "SELECT f FROM Flight f WHERE f.carrier=:car")
public class Flight {
	@Id
	@GeneratedValue(generator = "flseq")
	private int flid;
	@Column(length = 20)
	private String carrier;
	@Column(name = "kahase", length = 20)
	private String source;
	@Column(name = "kahatak", length = 20)
	private String destination;
//	@NotEmpty(message="Distance is mandatory")
//	@Size(min=2, message="Distance should be minimum 2 digits")
//	@Pattern(regexp = "[0-9] {2,}", message = "Input valid distance")
	@NotBlank(message = "Can't be blank")
	@Digits(integer = 3,fraction = 0, message = "Invalid distance")
	@Column(name = "fasla")
	private int distance;
	
	public int getFlid() {
		return flid;
	}
	public void setFlid(int flid) {
		this.flid = flid;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
