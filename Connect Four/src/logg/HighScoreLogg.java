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

public class HighScoreLogg {
	private static String filename = "HighScore.txt";
	private static String separator = ",";
	//private File file = new File(fileName);
	
	public static void read(){
		List<String> list = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
			list = br.lines().collect(Collectors.toList());
			for (String s : list) {
				String[] split = s.split(separator);
				HighScore.putWinner(split[0], Integer.valueOf(split[1]));
			}
		} catch (NoSuchFileException f) {
			// There is no file to read from
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//overwrite
	public static void save(){
		try {
			Files.write(Paths.get(filename), HighScore.print(separator).getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
