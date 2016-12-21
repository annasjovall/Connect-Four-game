package player;

import java.util.ArrayList;

public class AllPlayers {
	private ArrayList<Player> list;
	private int activePlayer;
	
	public AllPlayers(){
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
