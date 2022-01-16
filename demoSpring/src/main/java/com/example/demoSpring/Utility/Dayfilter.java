package com.example.demoSpring.Utility;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import org.json.simple.JSONObject;

import com.example.demo.Exception.DataException;
import com.example.demoSpring.Model.GenericTweet;
import com.example.demoSpring.Model.GeoTweet;
import com.example.demoSpring.Service.TweetServiceImpl;

public class Dayfilter implements Filter{
    LocalDate date; 
	
    public Dayfilter(LocalDate date) {
    	this.date = date; 
    	
    }
   
	
    
    
    //getFilter prende in input il generictweet di readJSON (che contiene i vari setter del model)   
    //filtra i tweet in base alla dat inserita
    // ad esempio far restituire quanti tweet vengono fatti in una data città
    
    
	@Override
	public JSONObject getFilter(GenericTweet generictweet) throws DataException {
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
