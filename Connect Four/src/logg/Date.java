package logg;

import java.time.LocalDateTime;

public class Date {
	/**
	 * Gets a string representing the date.
	 * @return A string representing the date in the format hour:min:sec CET month/day-year 
	 */
	public static String getDateWithTime(){
		LocalDateTime date = java.time.LocalDateTime.now();
		int year = date.getYear();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		int hour = date.getHour();
		int min = date.getMinute();
		int sec = date.getSecond();
		return hour + ":" + min + ":" + sec + " CET " 
				+ month + "/" + day + "-" + year;
		}
	
	public static String getSimpleDate(){
		LocalDateTime date = java.time.LocalDateTime.now();
		int year = date.getYear();
		int month = date.getMonthValue();
		int hour = date.getHour();
		int min = date.getMinute();
		int day = date.getDayOfMonth();
		return hour + ":" + min + " " + year + "-" + month + "-" + day; 
	}
}
