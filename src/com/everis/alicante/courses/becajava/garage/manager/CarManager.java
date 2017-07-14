package com.everis.alicante.courses.becajava.garage.manager;

import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.domain.Car;

public class CarManager{

	private List<Car> elements = new ArrayList<>();
	
	public List<Car> list() {
		return elements;
	}

	public void save(final Car element) {
		elements.add(element);
	}

	public void delete(final Car i) {
		elements.remove(i);
	}
	
	public Car get(final int i) {
		return elements.get(i);
	}
	
	
}
