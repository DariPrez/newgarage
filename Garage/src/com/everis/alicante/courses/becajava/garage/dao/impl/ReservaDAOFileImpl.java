package com.everis.alicante.courses.becajava.garage.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.everis.alicante.courses.becajava.garage.GarageMain;
import com.everis.alicante.courses.becajava.garage.dao.interfaces.PlazaDAO;
import com.everis.alicante.courses.becajava.garage.dao.interfaces.ReservaDAO;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;

public class ReservaDAOFileImpl implements ReservaDAO {

	@Override
	public void saveReserva(Reserva reserva) throws IOException {

		File file = new File("src/resources/Reservas.txt");
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter buffer = new BufferedWriter(writer);

		buffer.newLine();
		buffer.write(reserva.toTxtFile());//
		buffer.close();

	}

	@Override
	public Map<String, Reserva> readReservas() throws IOException {
		
		Map<String,Reserva> reservas = new TreeMap<String, Reserva>();
		
		PlazaDAO daoPlaza = new PlazaDAOFileImpl();
		
		String linea;
		
		File file = new File("src/resources/Reservas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		while ((linea = buffer.readLine()) != null) {
			if(!linea.contains("CODIGO_RESERVA") || linea.isEmpty()) {
				
				Reserva reserva = new Reserva();
				
				String[] temp = linea.split(";");
				
				reserva.setCodigoReserva(temp[0]);
				
				Plaza plaza = GarageMain.getGarage().getPlazas().get(Integer.parseInt(temp[1]));
				
				reserva.setPlaza(plaza);
				
				reserva.setCliente(GarageMain.getGarage().getClientes().get(temp[2]));
				
				reserva.getCliente().setVehiculo(GarageMain.getGarage().getVehiculos().get(temp[3]));
				
				reservas.put(reserva.getCodigoReserva(),reserva);
				
				System.out.println(reservas);
				
			}
		}
		
		return reservas;
	}

}
