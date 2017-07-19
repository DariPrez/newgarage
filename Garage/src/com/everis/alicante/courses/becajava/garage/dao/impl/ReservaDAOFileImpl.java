package com.everis.alicante.courses.becajava.garage.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import com.everis.alicante.courses.becajava.garage.dao.interfaces.ReservaDAO;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;

public class ReservaDAOFileImpl implements ReservaDAO {

	@Override
	public void saveReserva(Reserva reserva) throws IOException {
		
		File file = new File("src/resources/Reservas.txt");
		FileWriter writer = new FileWriter(file,true);
		BufferedWriter buffer = new BufferedWriter(writer);
		
		buffer.newLine();
		buffer.write(reserva.toTxtFile());//
		buffer.close();
		
	}

	public static void main(String args[]) throws IOException{
		Reserva reserva= new Reserva();
		Cliente cliente= new Cliente();
		cliente.setNif("5533555555");
		Plaza plaza= new Plaza();
		
		
		reserva.setCliente(cliente);
		reserva.setPlaza(plaza);

		Vehiculo vehiculo= new Vehiculo();
		vehiculo.setPlate("2345 asd");
		
		cliente.setVehiculo(vehiculo);
		reserva.setCliente(cliente);
		reserva.setPlaza(plaza);
		reserva.setFechaReserva(Calendar.getInstance().getTime());
		
		
		ReservaDAO dao= new ReservaDAOFileImpl();
		
		dao.saveReserva(reserva);
	}
}
