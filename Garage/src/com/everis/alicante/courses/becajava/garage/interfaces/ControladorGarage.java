package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.IOException;

public interface ControladorGarage {

	void listarPlazasLibres();
	void listarPlazasOcupadas();
	boolean reserverPlaza() throws IOException;
	void listaCliente();
}
