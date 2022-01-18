package com.example.demoSpring.Filter;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import org.json.simple.JSONObject;

import com.example.demoSpring.Exception.DataException;
import com.example.demoSpring.Model.GenericTweet;
import com.example.demoSpring.Model.GeoTweet;
import com.example.demoSpring.Service.TweetServiceImpl;

public class Dayfilter implements Filter{
    
    GenericTweet generictweet;
	LocalDate date; 
	
	public Dayfilter(GenericTweet generictweet,LocalDate date) {
		this.generictweet=generictweet;
		this.date=date;
	}

    
    //getFilter prende in input il generictweet di readJSON   
    //filtra i tweet in base alla dat inserita
    // ad esempio far restituire quanti tweet vengono fatti in una data città
    
    
	@Override
	public JSONObject getFilter() throws DataException {
		// TODO Auto-generated method stub
		JSONObject obj= new JSONObject(); 
		
		
		if(generictweet.getCreatedAt()==null) throw new DataException("Data non presente nel tweet");
		
		
	if ( generictweet.getCreatedAt().compareTo(date)==0) {
		
	   obj.put("created_at", generictweet.getCreatedAt()); 
	   obj.put("id", generictweet.getId()); 
	   obj.put("text", generictweet.getText()); 

	}
	    
	return  obj; 
		
	}
	
	
}
