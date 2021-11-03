package com.cookbook.recipeapi.util;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 

/**
 * @author heman
 *
 *This class has methods that local date time
 */

public class DateTimeUtility {
	
	/**
	 * Returns Local date and time in this method
	 * 
	 * @return - local date and time will be returned in the format of dd-MM-yyyy
	 *         HH:mm
	 * 
	 */
	 DateTimeUtility() {
	}
	
	/**
	 * This method is use to get local date time in 'dd-MM-yyyy HH:mm' format.
	 * 
	 * @return String
	 */
	
	public static String getLocalDateTime() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		   LocalDateTime datetimenow = LocalDateTime.now();
		  
		return datetimenow.format(dtf);
		  }  
	
	
	
}

