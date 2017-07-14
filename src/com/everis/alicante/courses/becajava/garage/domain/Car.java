package com.everis.alicante.courses.becajava.garage.domain;

public class Car {

	private String plate, color, model;
	private Integer numWheels;
	public Car(String plate, String color, String model) {
		this.plate = plate;
		this.color = color;
		this.model = model;
		this.numWheels = 4;
	}
	@Override
	public String toString() {
		System.out.println("Coches:\n");
		return "Matricula: " + plate + " Color: " + color + " Modelo: " + model + " Ruedas: " + numWheels + "\n";
	}

}