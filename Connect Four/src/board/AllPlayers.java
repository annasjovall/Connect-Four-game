package board;

import java.util.ArrayList;

import logg.Writer;

/**
 * 
 * @author Anna Palmqvist Sjövall
 * 
 * A list of the players in the Connect four game.
 */
public class AllPlayers {
	private ArrayList<Player> list; //The list of players
	private int activePlayer; //The placement of the current player
	
	/**
	 * Creates an empty list of players.
	 */
	public AllPlayers(){
		list = new ArrayList<>();
	}
	
	/**
	 * Adds a player to the list. 
	 * If a player of the same color is already added it is replaced.
	 * @param p The player to be added
	 * @return true if it was successful
	 */
	public boolean add(Player p){
		Writer.append("Added player " + p);
		if(list.contains(p)){
			list.remove(p);
		}
		return list.add(p);
	}
	
	/**
	 * Gets the current player
	 * @return The current player
	 */
	public Player getActivePlayer(){
		return list.get(activePlayer);
	}
	
	/**
	 * Sets the current player to the next one in the list.
	 */
	public void nextPlayer(){
		activePlayer = (activePlayer + 1) % list.size();
	}
	
	/**
	 * Clears the list and reset the current player.
	 */
	public void clear(){
		activePlayer = 0;
		list = new ArrayList<>();
	}
	
	/**
	 * Checks that both players have been added.
	 * @return True if both players have been added
	 */
	public boolean twoPlayersAdded(){		
		return list.size() == 2 && !list.get(0).equals(list.get(1));
	}
	
}
