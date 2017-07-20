package com.everis.alicante.courses.becajava.garage.dao.interfaces;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;

public interface ClienteDAO {

	 Map<String,Cliente> readClientes() throws IOException;
	 
	 void createCliente(Cliente cliente);
	
	 Cliente readCliente(String nif) throws IOException;
		
	 void deleteCliente(String nif);
}
