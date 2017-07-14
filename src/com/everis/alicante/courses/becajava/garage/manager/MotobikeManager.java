package com.everis.alicante.courses.becajava.garage.manager;

import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.domain.Motobike;


public class MotobikeManager {

	List<Motobike> elements = new ArrayList<>();

	public List<Motobike> list() {
		return elements;
	}

	public void carSave(final Motobike element) {
		elements.add(element);
	}

	public void delete(final Motobike element) {
		elements.remove(element);
	}
	
	public Motobike get(final int i) {
		return elements.get(i);
	}
	
}
