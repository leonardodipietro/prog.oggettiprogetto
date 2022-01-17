package com.example.demoSpring.Utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.demo.Exception.PlaceException;
import com.example.demoSpring.Model.GenericTweet;
import com.example.demoSpring.Model.GeoTweet;
import com.example.demoSpring.Model.Place;

public class Placefilter implements Filter {

	String place; 
	private GenericTweet generictweet;
	
	public Placefilter(String place,GenericTweet generictweet) {
		this.place =place;
		this.generictweet= generictweet;
	}

	
	
	//getFilter prende in input il geotweet di readJSON (che contiene i vari setter del model)   
    //filtra i tweet in base ad un luogo specifico
    
	
	@Override
	public JSONObject getFilter() throws PlaceException {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject (); 
		
		JSONArray list= (JSONArray) obj.get("place");  
		
		for(Place pp : generictweet.getLocation()) {
			
		JSONObject place= new JSONObject();
		
		if(pp.getName()==null) throw new PlaceException("Luogo non presente nel tweet"); 
		
		if(pp.getName().equals(this.place)) { 
			
			obj.put("name", pp.getName()); 
			obj.put("Country",pp.getCountry() ); 
			obj.put("place_type", pp.getPlace_type());
		}
		}
		
		
		return obj;
	}
	
	
	
	
	
}
