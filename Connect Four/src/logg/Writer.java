package logg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Anna Palmqvist Sjövall
 *
 * A writer which saves text to file with timestamp.
 */
public class Writer {
	private static PrintWriter writer;
	
	public static void start(){
		String filename = "logged: " + Date.getSimpleDate();
		File file = new File(filename);

		try{
			FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			writer = out;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void stop(){
		writer.close();
	}
	
	public static void append(String data){
		appendText(Date.getDateWithTime() + " " + data);
	}
	
	private static void appendText(String data){
		writer.println(data);
	}
}
