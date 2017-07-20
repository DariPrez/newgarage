package com.everis.alicante.courses.becajava.garage.domain;


import java.util.List;
import java.util.Map;

public class Garage {
	
	private List<Plaza> plazas;
	
	private Map<String, Reserva> reservas;
	
	private Map<String, Cliente> clientes;
	
	private Map<String, Vehiculo> vehiculos;
	
	public List<Plaza> getPlazas() {
		return plazas;
	}



	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}



	public Map<String, Reserva> getReservas() {
		return reservas;
	}



	public void setReservas(Map<String, Reserva> reservas) {
		this.reservas = reservas;
	}



	public Map<String, Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(Map<String, Cliente> clientes) {
		this.clientes = clientes;
	}



	public Map<String, Vehiculo> getVehiculos() {
		return vehiculos;
	}



	public void setVehiculos(Map<String, Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
		
}
