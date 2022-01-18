package com.example.demoSpring.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class GetCoordinates {
	
	private Vector<String> city;
	private Vector<String> coord;
	/*
	
	public GetCoordinates(Vector<String> city, Vector<String> coord) {
		super();
		this.city = city;
		this.coord = coord;
	}
	
	*/
	
	// Legge un fil riga per riga contenente alcune città italiane con le loro coordinate 
	// e le assegna a due vettori paralleli , dopodiche restituisce le coordinate della citta inserita
	
	public String getCoordinates(String input) {
		
		try {
		Scanner file_input = new Scanner(new BufferedReader(new FileReader("city.txt"))); 
		
		while(file_input.hasNext()) {
			city.add(file_input.next()); 
			coord.add(file_input.next()); 
			}
		file_input.close();
		
	}catch(IOException e) {
		System.out.println("Errore di IO"); 
		System.out.println(e); 
		
	}
	
		for(int i=0 ; i<city.size(); i++) {
			
			if(city.get(i)==input)
				return coord.get(i);
		}
		
		return null;
	
	
	}
	
	
	
	

}

