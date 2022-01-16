package com.example.demoSpring.Utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParse {
     
	/*public DateParse() {
	} 
	*/
	public LocalDate dateParse(String created_at) {
		LocalDate date;
		
		DateTimeFormatter formatt= DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss Z yyyy"); 
		LocalDateTime datetime= LocalDateTime.parse(created_at,formatt);
		
		date= datetime.toLocalDate(); 
		
		return date; 
	}
	
}

