package com.example.demoSpring.Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.demoSpring.Model.GenericTweet;
import com.example.demoSpring.Model.GeoTweet;
import com.example.demoSpring.Utility.Distance;
import com.example.demoSpring.Utility.GetCoordinates;

public class DistanceFilter implements Filter{
 
	GetCoordinates coord= new GetCoordinates();
	Distance distance= new Distance();
	GenericTweet generictweet;
	String input;
	
	public DistanceFilter(GenericTweet generictweet) {
		this.generictweet=generictweet;
		this.input=input;
		// TODO Auto-generated constructor stub
	}

	
	//il metodo findDistance prende in input : le coordinate di geo.getCoord salvate nel model come vettore di double 
	// e di coord.getCoordinates metodo che restituisce le coordinate di una citta italiana in input
	
	// vedere come implementarle meglio
	
	@Override
	public JSONObject getFilter() {
	JSONObject obj = new JSONObject(); 
	
	JSONArray list = (JSONArray) obj.get("coordinates");
	
	for(GeoTweet geo: generictweet.getGeolocal() ) {
		JSONObject coordinates = new JSONObject();
		
		if(distance.findDistance(coord.getCoordinates(input), geo.getCoord() ));
		
	}
		
	}
	
}
