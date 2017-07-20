package com.everis.alicante.courses.becajava.garage.dao.interfaces;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Cliente;

public interface ClienteDAO {

	 Map<String,Cliente> readClientes() throws IOException;
	 
	 void createCliente(Cliente cliente);
	
	
}
