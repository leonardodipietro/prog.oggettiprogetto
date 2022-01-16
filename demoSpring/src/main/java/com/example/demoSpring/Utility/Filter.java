package com.example.demoSpring.Utility;

import org.json.simple.JSONObject;

import com.example.demo.Exception.DataException;
import com.example.demo.Exception.PlaceException;
import com.example.demoSpring.Model.GenericTweet;
import com.example.demoSpring.Model.GeoTweet;

public interface Filter{
	
	public abstract JSONObject getFilter(GenericTweet generictweet) throws DataException, PlaceException; 
    
	
}
