package com.everis.alicante.courses.becajava.garage.domain;

public class Cliente {
	private String nif;
	private String nombreCompleto;
	private Vehiculo vehiculo;
	
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String toTxtFile() {
		String str ="";
		str=str.concat(nif);
		str=str.concat(";");
		str=str.concat(nombreCompleto);
		str=str.concat(";");
		str=str.concat(vehiculo.getPlate());
		return str;
	}
}
