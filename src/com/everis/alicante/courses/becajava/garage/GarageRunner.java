package com.everis.alicante.courses.becajava.garage;

import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.domain.Bicycle;
import com.everis.alicante.courses.becajava.garage.domain.Car;
import com.everis.alicante.courses.becajava.garage.domain.Motobike;
import com.everis.alicante.courses.becajava.garage.manager.BicycleManager;
import com.everis.alicante.courses.becajava.garage.manager.CarManager;
import com.everis.alicante.courses.becajava.garage.manager.MotobikeManager;
import com.everis.alicante.courses.becajava.garage.ui.GarageMenu;

public class GarageRunner {

	static final Scanner in = new Scanner(System.in);
	static final CarManager carManager = new CarManager();
	static final MotobikeManager motobikeManager = new MotobikeManager();
	static final BicycleManager bicycleManager = new BicycleManager();
	
	public static void main(String[] args) {
		String option;

		do {
			option = GarageMenu.getInstance().play();
			switch (option) {
			case "1.1":
				System.out.println(carManager.list());
				break;
			case "1.2":
				carManager.save(carBuilder());
				break;
			case "1.3":
				carManager.delete(selectCar());
				break;
			case "1.4":
				//carManager.get(selectCar());
			}
		} while (!option.equals("0"));
	}

	private static Car carBuilder() {
		System.out.println("Ingresar Nuevo Coche:" + "\nIngresar la Matrícula:");
		final Scanner in = new Scanner(System.in);
		final String plate = in.nextLine();
		System.out.println("Ingresar el Color:");
		final String color = in.nextLine();
		System.out.println("Ingresar el Modelo:");
		final String model = in.nextLine();
		return new Car(plate, color, model);
	}

	private static Motobike motoBikeBuilder() {
		System.out.println("Ingresar Nueva Moto:" + "\nIngresar la Matrícula:");
		final Scanner in = new Scanner(System.in);
		final String plate = in.nextLine();
		System.out.println("Ingresar el Color:");
		final String color = in.nextLine();
		System.out.println("Ingresar el Modelo:");
		final String model = in.nextLine();
		return new Motobike(plate, color, model);
	}

	private static Bicycle bicycleBuilder() {
		System.out.println("Ingresar Nueva Bicicleta:\n");
		
		System.out.println("Ingresar el Color:");
		final String color = in.nextLine();
		System.out.println("Ingresar el Modelo:");
		final String model = in.nextLine();
		return new Bicycle(color, model);
	}

	
	private static Integer selectCar() {
		System.out.println(carManager.list());
		System.out.println("Selecciona un elemento de la lista");
		int element = in.nextInt();
		return carManager.get(element-1);
	}
}
