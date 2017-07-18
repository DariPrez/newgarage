package com.everis.alicante.courses.becajava.garage.domain;

import java.util.Arrays;

public class Garage {
	private Plaza[] plaza;

	public Plaza[] getPlaza() {
		return plaza;
	}

	public void setPlaza(Plaza[] plaza) {
		this.plaza = plaza;
	}

	@Override
	public String toString() {
		return "Garage [plaza=" + Arrays.toString(plaza) + "]";
	}
	
	
}
