package com.example.demoSpring.Model;

public class Place {
	
	//dati geo di twitter relativi ad un luog: 
	// nome del luogo es: Roma
	//country es: italia
	//place_type es: citta,quartiere...

	private String name; 
	
	private String place_type; 
	
	private String country;

	public Place (String name,String place_type,String country){
		this.name=name;
		this.place_type=place_type;
		this.country=country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace_type() {
		return place_type;
	}

	public void setPlace_type(String place_type) {
		this.place_type = place_type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	} 
	
	
	
}
