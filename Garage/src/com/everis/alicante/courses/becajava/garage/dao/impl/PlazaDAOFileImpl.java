package com.everis.alicante.courses.becajava.garage.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.dao.interfaces.PlazaDAO;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;

public class PlazaDAOFileImpl implements PlazaDAO{

	@Override
	public Plaza[] readPlazas() throws IOException {
		
		List<String> data = new ArrayList<String>();
		String linea;
		//buscar fichero
		
		File file = new File("src/resources/Plazas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		while ((linea=buffer.readLine())!=null) {
			data.add(linea);
			System.out.println(linea);
		}
		return null;
	}

	@Override
	public void write(Plaza[] plazas) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws IOException {
		PlazaDAO dao = new PlazaDAOFileImpl();
		dao.readPlazas();
	}

}
