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
 * A writer which saves text to file with added timestamp.
 */
public class Writer {
	private static PrintWriter writer; //The writer used to append text
	
	/**
	 * Starts the writer so that more text can be added.
	 */
	public static void start(){
		String filename = "logged: " + Date.getSimpleDate();
		File file = new File(filename); //creates the file

		try{
			FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			writer = out;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Stops the writing and adds the text to the file.
	 */
	public static void stop(){
		writer.close();
	}
	
	/**
	 * Appends the given String data to the textfile. Adds a timestamp.
	 * @param data The data to append
	 */
	public static void append(String data){
		appendText(Date.getDateWithTime() + " " + data);
	}
	
	/**
	 * Appends a string to the file.
	 * @param data The string to be added
	 */
	private static void appendText(String data){
		writer.println(data);
	}
}
