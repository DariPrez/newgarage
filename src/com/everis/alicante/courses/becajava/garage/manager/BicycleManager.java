package com.everis.alicante.courses.becajava.garage.manager;

import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.domain.Bicycle;

public class BicycleManager {

	List<Bicycle> elements = new ArrayList<>();

	public List<Bicycle> list() {
		return elements;
	}

	public void carSave(final Bicycle element) {
		elements.add(element);
	}

	public void delete(final Bicycle element) {
		elements.remove(element);
	}
	
	public Bicycle get(final int i) {
		return elements.get(i);
	}
}
