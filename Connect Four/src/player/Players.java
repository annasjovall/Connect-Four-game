package player;

import java.util.ArrayList;

public class Players {
	private ArrayList<Player> list;
	private int activePlayer;
	
	public Players(){
		list = new ArrayList<>();
	}
	
	public boolean add(Player p){
		return list.add(p);
	}
	
	public Player getActivePlayer(){
		return list.get(activePlayer);
	}
	
	public void nextPlayer(){
		activePlayer = (activePlayer + 1) % list.size();
	}
	
}
