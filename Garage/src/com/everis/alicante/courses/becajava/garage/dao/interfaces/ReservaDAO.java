package com.everis.alicante.courses.becajava.garage.dao.interfaces;

import java.io.IOException;

import com.everis.alicante.courses.becajava.garage.domain.Reserva;

public interface ReservaDAO {

	void saveReserva(Reserva reserva) throws IOException; 
}
