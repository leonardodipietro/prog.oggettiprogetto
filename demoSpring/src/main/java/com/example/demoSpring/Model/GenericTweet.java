package com.example.demoSpring.Model;


import java.time.LocalDate;
import java.util.Vector;

public class GenericTweet{
	
  // private String created_at; 
	private LocalDate localdate; 
	private long id ; 
	private String text; 
	
	private Vector<Place> location= new Vector<Place>(); 
	private Vector<GeoTweet> geolocal = new Vector<GeoTweet>();
	
/*
	public GenericTweet(String createdAt, long id , String text)
	{
		this.createdAt= createdAt; 
		this.id=id; 
		this.text=text; 
		
	}
*/
	

	
	

	public LocalDate getCreatedAt() {
		return localdate;
	}

	

	public Vector<Place> getLocation() {
		return location;
	}



	public void setLocation(Vector<Place> location) {
		this.location = location;
	}



	public Vector<GeoTweet> getGeolocal() {
		return geolocal;
	}



	public void setGeolocal(Vector<GeoTweet> geolocal) {
		this.geolocal = geolocal;
	}



	public void setCreatedAt(LocalDate localdate) {
		this.localdate = localdate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	

}
