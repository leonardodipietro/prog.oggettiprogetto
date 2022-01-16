package com.example.demoSpring.Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.demoSpring.Model.GenericTweet;
import com.example.demoSpring.Model.GeoTweet;
import com.example.demoSpring.Utility.UrlGenerator; 

public interface TweetService {

//public abstract String createUrl(UrlGenerator url); 
	
public abstract GeoTweet readJSON(); 
public abstract JSONObject buildJSON(GenericTweet generictweet);

	
	
	
}
