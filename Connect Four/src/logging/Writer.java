package logging;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class Writer {
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
	
	public static void save(String filename, String data) {
		try {
			Files.write(Paths.get(filename), data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		String data = getDate() +  "test sträng, utskrift";
		save("AuditLog.txt", data);
	}
}
