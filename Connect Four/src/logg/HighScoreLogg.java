package logg;

import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import board.HighScore;

/**
 * 
 * @author Anna Palmqvist Sjövall
 *
 * A logger of highscore. Both writes and reads from file and adds to the Highscore list.
 */
public class HighScoreLogg {
	private static String filename = "HighScore.txt"; //The filname to save and read from
	private static String separator = ","; //The separator between name and wins.
	
	/**
	 * Reads from file and if it exits, it adds the highscore to HighScore.
	 */
	public static void read(){
		List<String> list = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
			list = br.lines().collect(Collectors.toList());
			for (String s : list) {
				String[] split = s.split(separator);
				HighScore.putWinner(split[0], Integer.valueOf(split[1])); //Add the winner to HighScore
			}
		} catch (NoSuchFileException f) {
			// There is no file to read from, then do nothing
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Saves the highscore in a textfile. Overwrites previous file of same name.
	 */
	public static void save(){
		try {
			Files.write(Paths.get(filename), HighScore.print(separator).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
