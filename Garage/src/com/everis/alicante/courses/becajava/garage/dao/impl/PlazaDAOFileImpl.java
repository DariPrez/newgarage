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
	public List<Plaza> readPlazas() throws IOException {
		
		//List<String> data = new ArrayList<String>();
		List<Plaza> plazas = new ArrayList<Plaza>();
		String linea;
		//buscar fichero
		
		File file = new File("src/resources/Plazas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		while ((linea=buffer.readLine())!=null) {
			//data.add(linea);
			
			if(!linea.contains("NUMERO_PLAZA")) {
			Plaza plazaTemp = new Plaza();
			
			String[] temp = linea.split(";");
			plazaTemp.setNumeroPlaza(Integer.parseInt(temp[0]));
			plazaTemp.setPrecio(Double.parseDouble(temp[1]));
			//plazaTemp.setNumeroPlaza(Integer.parseInt(linea.substring(0,linea.indexOf(";"))));
//			String tmp= linea.substring(linea.indexOf(";")+1);
//			plazaTemp.setPrecio(Double.parseDouble(tmp.substring(0,linea.indexOf(";")+1)));
//			String precio = linea.substring(linea.indexOf(";",1)+1,linea.indexOf(";"));
//			plazaTemp.setPrecio(Double.parseDouble(precio));
			
			plazas.add(plazaTemp);
			//System.out.println(linea);
			}}
		reader.close();
		return plazas;
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
