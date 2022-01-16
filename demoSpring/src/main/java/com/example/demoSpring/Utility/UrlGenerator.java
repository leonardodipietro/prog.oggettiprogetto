package com.example.demoSpring.Utility;

public class UrlGenerator  {

	private String url="https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?"; 
	
	
	public UrlGenerator(String url) {
		this.url=url;
	}
	
	public String craeteUrl (String city, int count , String lang) {
			
	
		
			url+= ("?q="+ city); 
			
			url+=("&count"+ count); 
			
			url+=("&lang"+lang); 
			
			return url;
		}
		
	}



