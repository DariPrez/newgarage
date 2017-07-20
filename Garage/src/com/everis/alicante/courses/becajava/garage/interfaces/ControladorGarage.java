package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.domain.Plaza;

public interface ControladorGarage {

	void listarPlazasLibres();
	void listarPlazasOcupadas();
	boolean reserverPlaza() throws IOException;
	void listaCliente() throws IOException;
	void listarVehiculos() throws IOException;
}
