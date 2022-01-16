package com.example.demoSpring.Service;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.example.demoSpring.Model.GenericTweet;
import com.example.demoSpring.Model.GeoTweet;
import com.example.demoSpring.Model.Place;
import com.example.demoSpring.Utility.DateParse;
import com.example.demoSpring.Utility.UrlGenerator;

public class TweetServiceImpl implements TweetService {

	private  String url= "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?"; 
	Vector<GeoTweet> geolocal = new Vector<GeoTweet>();
	Vector<Place> location= new Vector <Place>();
	//questo metodo legge il riga per riga il jsonobject in questione, dopodichè prende le informazioni rilevanti al suo interno e le salva nei campi del generictweet.



	@SuppressWarnings("unused")
	@Override
	public GeoTweet readJSON() {
		JSONObject obj= new JSONObject();

		try {

			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			//stato = connection.getResponseCode(); // salvo in una variabile il response code

			InputStream inputstream = connection.getInputStream(); 
			String body=" ";
			String textline=" "; 
			//Crea un Buffer che ci permette di leggere il testo da InputStream che otteniamo da connection.

			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(inputstream));

				/*StringBuilder body= new StringBuilder(); 
	     while((textline= in.readLine()) != null)
		 body.append(textline); 
				 */

				while((textline=in.readLine()) != null) 
					body+= textline; 
			}finally {
				inputstream.close(); 

			}
			obj = (JSONObject) JSONValue.parse(body);

		}catch(MalformedURLException mue) {
			mue.printStackTrace();

		} catch (IOException ioe) {

			//System.out.println(" STATO: " + stato);

			ioe.printStackTrace();
		}


		//assegno ai vari campi del generictweet le informazioni del json

		JSONArray list= (JSONArray) obj.get("statuses");


		DateParse dp= new DateParse(); 

		GenericTweet generictweet= new GenericTweet(); 


		JSONObject statuses = new JSONObject(); 

		generictweet.setCreatedAt(dp.dateParse((String)statuses.get("created_at")));
		generictweet.setId((long)statuses.get("id") );
		generictweet.setText((String)statuses.get("text"));



		//for(int i=0; i<list.size(); i++) {
		//JSONObject listelement= (JSONObject) list.get(i); 

		JSONArray listelement= (JSONArray) obj.get("place");  
		JSONObject place=new JSONObject(); 

		//Profile avatar = new Profile(); 
		Place pp= new Place ();  

		pp.setName((String)place.get("name"));
		pp.setCountry((String)place.get("country"));
		pp.setPlace_type((String)place.get("place_type"));
		location.add(pp); //aggiungo gli elementi al vettore di profile 

		//salvo il vettore  con il setter di generictweet assegnando i singoli attributi
		generictweet.setLocation(location); 


		JSONObject geo = new JSONObject(); 
		GeoTweet geotweet= new GeoTweet(); 
		Vector<Double> coord = (Vector<Double>) geo.get("coordinates");
		geotweet.setCoord(coord);  
		geotweet.setType((String)geo.get("type"));

		geolocal.add(geotweet);  

		return geotweet;

	}



	//questo metodo riceve come parametro il geotweet "aggiornato" e mi restituisce il json rilevante.



	@SuppressWarnings("unchecked")
	@Override
	public JSONObject buildJSON(GenericTweet generictweet) {


		JSONObject obj= new JSONObject(); 


		// generictweeet
		JSONArray tweet = (JSONArray) obj.get("statuses"); 

		JSONObject statuses = new JSONObject();  

		statuses.put("created_at", generictweet.getCreatedAt()); 
		statuses.put("id", generictweet.getId()); 
		statuses.put("text", generictweet.getText()); 



		/* oppure : 
		 * JSONArray tweet =(JSONArray) obj.get("statuses"); 
		 * for(int i=0 ; i<tweet.size(); i++){
		 * JSONObject statuses = (JSONObject) tweet.get(i); 

		statuses.put("created_at", generictweet.getCreatedAt()); 
		statuses.put("id", generictweet.getId()); 
		statuses.put("text", generictweet.getText()); 
		 * 
		 * 
		 * 
		 */




		// Credo che non serva il jsonarray qui

		JSONArray list= (JSONArray) obj.get("place");  

		for(Place pp : generictweet.getLocation()) {

			JSONObject place= new JSONObject();

			place.put("name", pp.getName());
			place.put("country", pp.getCountry()); 
			place.put("place_type",pp.getPlace_type());

			list.add(place);

		}




		JSONObject geo = new JSONObject(); 
		GeoTweet geotweet = new GeoTweet();

		geo.put("coordinates", geotweet.getCoord()); 
		geo.put("type", geotweet.getType()); 

		return obj; 


	}























}





	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	


	