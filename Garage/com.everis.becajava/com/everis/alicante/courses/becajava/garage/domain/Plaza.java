package com.everis.alicante.courses.becajava.garage.domain;

public class Plaza {
	private Cliente cliente;
	private Double precio;
	private int numeroPlaza;
	private Boolean libre = false;	

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getNumeroPlaza() {
		return numeroPlaza;
	}
	public void setNumeroPlaza(int numeroPlaza) {
		this.numeroPlaza = numeroPlaza;
	}
	
	public boolean getLibre() {
		if(cliente == null) {
			return true;
		} else {
			return libre;
		}
	}
	
	@Override
	public String toString() {
		return "Cliente= " + cliente + ", Precio = " + precio + ", NúmeroPlaza = " + numeroPlaza + "\n";
	}
	
}
