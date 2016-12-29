package board;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Anna Palmqvist Sjövall
 * 
 * A class that keeps track of the amount of wins and who won.
 */
public class HighScore {
	private static Map<String, Integer> map = new HashMap<>(); //A map with players name and wins
	
	/**
	 * Adds a winner to the highscore.
	 * If the player already exists, the wins is incremented by one.
	 * @param name The name of the winner
	 * @return The amounts of wins as an Integer
	 */
	public static Integer addWinner(String name){
		Integer value = map.get(name);
		if (value == null)
			return map.put(name, 1);
		
		return map.put(name, value + 1);
	}
	
	/**
	 * If the specified name is not already associated with a win
	 * associates it with the given win and returns null, else returns the current value.
	 * @param name The name of the player
	 * @param i The amount of wins
	 */
	public static void putWinner(String name, Integer i){
		map.putIfAbsent(name, i);
	}
	
	/**
	 * A string representation of the highscore with keys and values separated by given separator.
	 * Sorts the list in decending order of amounts of wins(values).
	 * @param separator The separator between key and value.
	 * @return The string representation
	 */
	public static String print(String separator){
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> mapp = Sorter.sortByValue(map);
		
		for(Entry<String,Integer> e : mapp.entrySet()){
			sb.append(e.getKey() + separator + e.getValue());
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
