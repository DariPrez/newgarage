package com.everis.alicante.courses.becajava.garage.domain;

public class Motobike {

	private String plate;
	private String color;
	private String model;
	private Integer numWheels;

	public Motobike(String plate, String color, String model) {
		this.plate = plate;
		this.color = color;
		this.model = model;
		this.numWheels = 2;
	}

}
