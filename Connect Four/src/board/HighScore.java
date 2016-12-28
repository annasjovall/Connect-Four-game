package board;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HighScore {
	private static Map<Player, Integer> map = new HashMap<>();
	
	public static Integer addWinner(Player player){
		Integer value = map.get(player);
		if (value == null)
			return map.put(player, 1);
		
		return map.put(player, value + 1);
	}
	
	//prints sorted list, decending order of amounts of wins
	public static String print(){
		StringBuilder sb = new StringBuilder();
		
		Map<Player, Integer> mapp = Sorter.sortByValue(map);
		
		for(Entry<Player,Integer> e : mapp.entrySet()){
			sb.append(e.getKey() + " has won: " + e.getValue() + " times.");
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
