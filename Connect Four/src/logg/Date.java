package logg;

import java.time.LocalDateTime;

public class Date {
	/**
	 * Gets a string representing the date.
	 * @return A string representing the date in the format hour:min:sec CET month/day-year 
	 */
	public static String getDateWithTime(){
		LocalDateTime date = java.time.LocalDateTime.now();

		return date.getHour() + ":" + date.getMinute() + ":" + date.getSecond() + " CET " 
				+ date.getMonthValue() + "/" + date.getDayOfMonth() + "-" + date.getYear();
		}
	
	/**
	 * Gets a string representing a more casual date form.
	 * @return A string representing the date in the format hour:min year-month-day
	 */
	public static String getSimpleDate(){
		LocalDateTime date = java.time.LocalDateTime.now();
		
		return date.getHour() + ":" + date.getMinute() + " " 
				+ date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth(); 
	}
}
