package board;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HighScore {
	private static Map<String, Integer> map = new HashMap<>();
	
	public static Integer addWinner(String name){
		Integer value = map.get(name);
		if (value == null)
			return map.put(name, 1);
		
		return map.put(name, value + 1);
	}
	
	//put if the player does not already exist
	public static void putWinner(String name, Integer i){
		map.putIfAbsent(name, i);
	}
	
	//prints sorted list, decending order of amounts of wins
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
