package com.everis.alicante.courses.becajava.garage.dao.interfaces;


import java.io.IOException;

import com.everis.alicante.courses.becajava.garage.domain.Plaza;

public interface PlazaDAO {

	Plaza[] readPlazas() throws IOException ;
	
	void write(Plaza[] plazas);
	
}
