package com.everis.alicante.courses.becajava.garage.dao.interfaces;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;

public interface VehiculoDAO {
	
	Map<String,Vehiculo> readVehiculos() throws IOException;
	
	void createVehiculo();
	
	Vehiculo readVehiculo(String plate) throws IOException;
	
	void deleteVehiculo(String plate);

}
