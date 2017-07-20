package com.everis.alicante.courses.becajava.garage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.GarageMain;
import com.everis.alicante.courses.becajava.garage.dao.impl.ReservaDAOFileImpl;
import com.everis.alicante.courses.becajava.garage.dao.interfaces.ReservaDAO;
import com.everis.alicante.courses.becajava.garage.domain.Camion;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Coche;
import com.everis.alicante.courses.becajava.garage.domain.Garage;
import com.everis.alicante.courses.becajava.garage.domain.Motocicleta;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.Aparcable;
import com.everis.alicante.courses.becajava.garage.interfaces.ControladorGarage;

public class ControladorGarageImpl implements ControladorGarage {

	@Override
	public void listarPlazasLibres() {

		List<Plaza> plazasLibres = new ArrayList<Plaza>();

		List<Plaza> plazas = GarageMain.getGarage().getPlazas();

		for (Plaza plaza : plazas) {

			if (plaza.getLibre()) {
				plazasLibres.add(plaza);
			}
		}

		for (Plaza plaza1 : plazasLibres) {
			System.out.println(plaza1);
		}
	}

	@Override
	public void listarPlazasOcupadas() {
		List<Plaza> plazasOcupadas = new ArrayList<Plaza>();

		List<Plaza> plazas = GarageMain.getGarage().getPlazas();

		for (Plaza plaza : plazas) {

			if (!plaza.getLibre()) {
				plazasOcupadas.add(plaza);
			}
		}

		for (Plaza plaza1 : plazasOcupadas) {
			System.out.println(plaza1);
		}

	}

	public boolean reserverPlaza() throws IOException {

		Vehiculo vehiculo = null;
		Cliente cliente = new Cliente();
		ReservaDAO dao = new ReservaDAOFileImpl();

		System.out.println("Ingrese Nif:");
		Scanner in = new Scanner(System.in);
		cliente.setNif(in.nextLine());
		System.out.println("Ingrese Nombre Completo:");
		cliente.setNombreCompleto(in.nextLine());

		System.out.println("Tipo de Vehiculo:\n" + "1.Coche\n" + "2.Moto\n" + "3.Camión");

		in = new Scanner(System.in);
		switch (in.nextInt()) {
		case 1:
			vehiculo = new Coche();
			System.out.println("Ingrese Matricula:");
			in = new Scanner(System.in);
			vehiculo.setPlate(in.nextLine());
			System.out.println("Ingrese Color:");
			// utilizar un metodo del hijo
			((Coche) (vehiculo)).setColor(in.nextLine());
			System.out.println("Ingrese Marca:");
			((Coche) (vehiculo)).setMarca(in.nextLine());
			System.out.println("Ingrese Modelo:");
			((Coche) (vehiculo)).setModelo(in.nextLine());
			((Coche) (vehiculo)).setNumWheels(4);
			break;
		case 2:
			vehiculo = new Motocicleta();
			System.out.println("Ingrese Matricula:");
			in = new Scanner(System.in);
			vehiculo.setPlate(in.nextLine());
			System.out.println("Ingrese Color:");
			// utilizar un metodo del hijo
			((Motocicleta) (vehiculo)).setColor(in.nextLine());
			System.out.println("Ingrese Marca:");
			((Motocicleta) (vehiculo)).setMarca(in.nextLine());
			System.out.println("Ingrese Modelo:");
			((Motocicleta) (vehiculo)).setModelo(in.nextLine());
			((Motocicleta) (vehiculo)).setNumWheels(2);
			break;
		case 3:
			vehiculo = new Camion();
			break;
		}

		cliente.setVehiculo(vehiculo);

		Garage garage = GarageMain.getGarage();
		List<Plaza> plazas = garage.getPlazas();
		boolean hayplaza = false;

		for (Plaza plaza : plazas) {

			if (plaza.getLibre() && vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza = true;
				Reserva reserva = new Reserva();
				reserva.setCliente(cliente);
				reserva.setPlaza(plaza);
				reserva.setFechaReserva(Calendar.getInstance().getTime());
				dao.saveReserva(reserva);

				return hayplaza;
			} else {
				hayplaza = false;
			}
		}
		return hayplaza;
	}

	@Override
	public void listaCliente() {
		Map<String, Cliente> clientes = GarageMain.getGarage().getClientes();

		Collection<Cliente> collection = clientes.values();

		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();

			System.out.println(cliente.getNombreCompleto());

		}
	}
}
