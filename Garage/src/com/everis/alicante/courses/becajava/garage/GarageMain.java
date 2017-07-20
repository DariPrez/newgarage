package com.everis.alicante.courses.becajava.garage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.controller.ControladorGarageImpl;
import com.everis.alicante.courses.becajava.garage.dao.impl.ClienteDAOFileImpl;
import com.everis.alicante.courses.becajava.garage.dao.impl.PlazaDAOFileImpl;
import com.everis.alicante.courses.becajava.garage.dao.impl.ReservaDAOFileImpl;
import com.everis.alicante.courses.becajava.garage.dao.interfaces.ClienteDAO;
import com.everis.alicante.courses.becajava.garage.dao.interfaces.PlazaDAO;
import com.everis.alicante.courses.becajava.garage.dao.interfaces.ReservaDAO;
import com.everis.alicante.courses.becajava.garage.domain.Garage;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.interfaces.ControladorGarage;

public class GarageMain {

	static Garage garage;
	static ControladorGarage controlador;
	static String SEPARADOR = "*******************************************************************************";
	
	public static void main(String[] args) throws IOException {
		
		inicializarComponentes();
		//iniciar aplicacion o listar menu
		incializarAplicacion();
		
	}

	private static void incializarAplicacion() throws IOException {
		System.out.println(SEPARADOR);
		System.out.println("Bienvenido a el Garage SOLO MIO:\n¿Que desea Hacer?");
		System.out.println(SEPARADOR);
		System.out.println("1.Lista de Plazas Libres."
				+ "\n2.Lista de Plazas Ocupadas."
				+ "\n3.Calcular Ingresos."
				+ "\n4.Reservar una Plaza."
				+ "\n5.Consultar Reservas."
				+ "\n6.Listar Clientes."
				+ "\n7.Listar Vehículo");
		final Scanner in = new Scanner(System.in);
		final int option = in.nextInt();
		boolean resultado = true;
		if (option<=0&&option<=9) {
			System.out.println("Ingrese una opcion valida.");
		}
		System.out.println("La opción ingresada es: "+ option);
		
		switch(option){
		case 1:
			controlador.listarPlazasLibres();
			break;
		case 2:
			controlador.listarPlazasOcupadas();
			break;
		case 3:
			
			break;
		case 4:
			controlador.reserverPlaza();
			break;
		case 5:
			
			break;
		case 6:
			controlador.listaCliente();
			break;
		case 7:
			controlador.listarVehiculos();
			break;
		}
		if(option==4&&resultado) {
			System.out.println("Se ha reservado su plaza");
		} else if(option==4){
			System.out.println("No hay plazas disponibles");
		}
		
		
		incializarAplicacion();
		

	}

	private static void inicializarComponentes() throws IOException {
		
		PlazaDAO plazaDao = new PlazaDAOFileImpl();
		ReservaDAO reservaDao = new ReservaDAOFileImpl();
		ClienteDAO clienteDao = new ClienteDAOFileImpl();
		garage = new Garage();
		
		List<Plaza> plazasTemp = plazaDao.readPlazas();
		
		garage.setPlazas(plazasTemp);
		garage.setClientes(clienteDao.readClientes());
		controlador = new ControladorGarageImpl();
//		
//		for (int i = 0; i < plazas.length; i++) {
//			Plaza plazaTemp = new  Plaza();
//			plazaTemp.setNumeroPlaza(i+1);
//			if (i<10) {
//				plazaTemp.setPrecio(50.00);
//			} else if (i<20) {
//				plazaTemp.setPrecio(75.00);
//			} else {
//				plazaTemp.setPrecio(100.00);
//			}
//			plazas[i]=plazaTemp;
//		}
//		garage.setPlaza(plazas);
//		
//		for (int i = 0; i < plazas.length; i++) {
//			Plaza plazaTemp = new  Plaza();
//			plazaTemp.setNumeroPlaza(i+1);
//			if (i<10) {
//				plazaTemp.setPrecio(50.00);
//			} else if (i<20) {
//				plazaTemp.setPrecio(75.00);
//			} else {
//				plazaTemp.setPrecio(100.00);
//			}
//			plazas[i]=plazaTemp;
//		}
//		garage.setPlaza(plazas);
		
	}

	public static Garage getGarage() {
		return garage;
	}

}
