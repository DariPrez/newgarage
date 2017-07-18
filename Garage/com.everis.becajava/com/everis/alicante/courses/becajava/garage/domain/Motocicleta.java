package com.everis.alicante.courses.becajava.garage.domain;

import com.everis.alicante.courses.becajava.garage.interfaces.Aparcable;

public class Motocicleta extends Vehiculo implements Aparcable {

	private String color;
	private String marca;
	private String modelo;
	private Integer numWheels;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public void aparcar() {
		System.out.println("Puede Aparcar");
	}

	public Integer getNumWheels() {
		return numWheels;
	}

	public void setNumWheels(Integer numWheels) {
		this.numWheels = numWheels;
	}
}
