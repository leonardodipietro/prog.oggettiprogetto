package com.example.demoSpring.Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.demoSpring.Exception.DataException;
import com.example.demoSpring.Exception.PlaceException;
import com.example.demoSpring.Model.GenericTweet;
import com.example.demoSpring.Model.GeoTweet;
import com.example.demoSpring.Model.Place;

public class Placefilter implements Filter{

	GenericTweet generictweet;
	String place;
	
	public Placefilter(GenericTweet generictweet,String place) {
		
		this.generictweet= generictweet;
		this.place=place;
	}

	
	//getFilter prende in input il geotweet di readJSON    
    //filtra i tweet in base ad un luogo specifico
    

	public JSONObject getFilter() throws PlaceException {
	
		JSONObject obj = new JSONObject (); 
		
		JSONArray list= (JSONArray) obj.get("place");  
		
		for(Place pp : generictweet.getLocation()) {
			
		JSONObject place= new JSONObject();
		
		if(pp.getName()==null) throw new PlaceException("Luogo non presente nel tweet"); 
		
		if(pp.getName().equals(this.place)) { 
			
			obj.put("name", pp.getName()); 
			obj.put("Country",pp.getCountry() ); 
			obj.put("place_type", pp.getPlace_type());
			
			list.add(place);
		}
		}
		
		
		return obj;
	}
	
	
	
	
	
}
