package com.example.demoSpring.Filter;

import org.json.simple.JSONObject;

import com.example.demoSpring.Exception.DataException;
import com.example.demoSpring.Exception.PlaceException;
import com.example.demoSpring.Model.GenericTweet;
import com.example.demoSpring.Model.GeoTweet;

public interface Filter{
/*	
protected GenericTweet generictweet;

public Filter(GenericTweet generictweet) {
	this.generictweet=generictweet;
}
*/
	
public JSONObject getFilter() throws DataException, PlaceException; 


	
}
