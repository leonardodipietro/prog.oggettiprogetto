package com.example.demoSpring.Utility;

public class Distance {

	convertStringinLong pointone;
	convertStringinLong pointtwo;

	public double findDistance(convertStringinLong pointone, convertStringinLong pointtwo)    {
		final double R=6371;
		final double pigreco=3.1415927;
		double lat_one, lat_two;
		double lon_one, lon_two;
		double fi;
		double p;
		double distance;
		lat_one=pigreco*pointone.getLati()/180;
		lat_two=pigreco*pointtwo.getLati()/180;
		lon_one=pigreco*pointone.getLongi()/180;
		lon_two=pigreco*pointtwo.getLongi()/180;
		fi=Math.abs(lon_one-lon_two) ;  //calcola l'angolo compreso fi
		p=Math.cos(Math.sin(lat_two)*Math.sin(lat_one)+Math.cos(lat_two)*Math.cos(lat_one)*Math.cos(fi));//calcolo il terzo lato del triangolo sferico
		distance=p*R;
		return distance;
	}

}

	


