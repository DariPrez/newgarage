package com.everis.alicante.courses.becajava.garage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.GarageMain;
import com.everis.alicante.courses.becajava.garage.domain.Camion;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Coche;
import com.everis.alicante.courses.becajava.garage.domain.Garage;
import com.everis.alicante.courses.becajava.garage.domain.Motocicleta;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.Aparcable;
import com.everis.alicante.courses.becajava.garage.interfaces.ControladorGarage;

public class ControladorGarageConArrays implements ControladorGarage{

	@Override
	public void listarPlazasLibres() {
		
		List<Plaza> plazasLibres = new ArrayList<Plaza>();
		
		Plaza[] plazas = GarageMain.getGarage().getPlaza();
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];
			if(plaza.getLibre()) {
				plazasLibres.add(plaza);
			}
		}
		for (Plaza plaza : plazasLibres) {
			System.out.println(plaza);
		}
		
	}

	@Override
	public void listarPlazasOcupadas() {
		List<Plaza> plazasOcupadas = new ArrayList<Plaza>();
		
		Plaza[] plazas = GarageMain.getGarage().getPlaza();
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];
			if(!plaza.getLibre()) {
				plazasOcupadas.add(plaza);
			}
		}
		for (Plaza plaza : plazasOcupadas) {
			System.out.println(plaza);
		}
	}

	public boolean reserverPlaza() {
		Vehiculo vehiculo = null;
		Cliente cliente = new Cliente();
		System.out.println("Ingrese Nif:");
		Scanner in = new Scanner(System.in);
		cliente.setNif(in.nextLine());
		System.out.println("Ingrese Nombre Completo:");
		cliente.setNombreCompleto(in.nextLine());
		System.out.println("Tipo de Vehiculo:\n"
				+ "1.Coche\n"
				+ "2.Moto\n"
				+ "3.Camión");
		final int num = in.nextInt();
		switch (num) {
		case 1:
			vehiculo = new Coche();
			System.out.println("Ingrese Matricula:");
			Scanner in2 = new Scanner(System.in);
			vehiculo.setPlate(in2.nextLine());
			System.out.println("Ingrese Color:");
			//utilizar un metodo del hijo 
			((Coche)(vehiculo)).setColor(in2.nextLine());
			System.out.println("Ingrese Marca:");
			((Coche)(vehiculo)).setMarca(in2.nextLine());
			System.out.println("Ingrese Modelo:");
			((Coche)(vehiculo)).setModelo(in2.nextLine());
			((Coche)(vehiculo)).setNumWheels(4);
			break;
		case 2:
			vehiculo = new Motocicleta();
			System.out.println("Ingrese Matricula:");
			Scanner in3 = new Scanner(System.in);
			vehiculo.setPlate(in3.nextLine());
			System.out.println("Ingrese Color:");
			//utilizar un metodo del hijo 
			((Motocicleta)(vehiculo)).setColor(in3.nextLine());
			System.out.println("Ingrese Marca:");
			((Motocicleta)(vehiculo)).setMarca(in3.nextLine());
			System.out.println("Ingrese Modelo:");
			((Motocicleta)(vehiculo)).setModelo(in3.nextLine());
			((Motocicleta)(vehiculo)).setNumWheels(2);
			break;
		case 3:
			vehiculo = new Camion();
			break;
		}
		
		
		Garage garage = GarageMain.getGarage();
		Plaza[] plazas = garage.getPlaza();
		boolean hayplaza = false;
		
		for (int i = 0; i < plazas.length; i++) {
			
			Plaza plaza = plazas[i];
			
			if(plaza.getLibre()&&vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza= true;
				return hayplaza;
			} else {
			hayplaza = false;
			}
		}
		return hayplaza;
	}

	@Override
	public void listaCliente() {
//		Cliente cliente = ControladorGarageConArrays;
		
		
	}


}
