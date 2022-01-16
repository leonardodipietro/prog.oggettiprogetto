package com.example.demoSpring.Model;

import java.util.Vector;

public class GeoTweet {

// dati relativi al geo di twitter: 
	// coord indica la latitudine e la longitudine
	//type come viene geolocalizzata la posizione
	  //ad es. può essere: -Point segnata da un un unica coordinata(coppia di lat e long) 
	 //- Polygon una quaterna di coordinate ( quattro coppie di coordinate)
	
	
     Vector<Double> coord= new Vector<Double>(); 
      private String type;
     
    /*Sistema Sessagesimale ( 41° 52' 24'' N ; 12° 30' E (ROMA))
    * private short gradi; 
     * private short primi; 
     * private short secondi;
     * private char pcard; 
     /*
     
     /* Sistema decimale (41,89 N ; 12,57 E)
     * private double dec; 
     * private char pcard;  
    */
    	
	
	public Vector<Double> getCoord() {
		return coord;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setCoord(Vector<Double> coord) {
		this.coord = coord;
	}


	
	
	
}
