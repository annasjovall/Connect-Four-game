package logging;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;

import java.io.IOException;

import java.time.LocalDateTime;

/**
 * 
 * @author Anna Palmqvist Sjövall
 *
 * A writer which saves text to file with timestamp.
 */
public class Writer {
	
	/**
	 * Gets a string representing the date.
	 * @return A string representing the date in the format hour:min:sec CET month/day-year 
	 */
	private static String getDate(){
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
	
	/**
	 * Saves the specified string with the given filename
	 * @param filename The name the saved file
	 * @param data The string to be saved
	 */
	public static void save(String filename, String data) {
		try {
			Files.write(Paths.get(filename), data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test that the Writer functions.
	 * @param args
	 */
	public static void main(String[] args){
		String data = getDate() +  "test sträng, utskrift";
		save("AuditLog.txt", data);
	}
}
