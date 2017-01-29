package board;

import javafx.scene.paint.Color;

/**
 * @author Anna Palmqvist Sjövall
 * 
 * A Connect four player
 */
public class Player {
	private final String name; //Name of player
	private final Color color; //Color of players disc
	
	/**
	 * Creates a player with the given name and color.
	 * @param name First name of player
	 * @param color Color of the players disc in the game
	 */
	public Player(String name, Color color){
		this.name = name;
		this.color = color;
	}
	
	/**
	 * Get the name of the player.
	 * @return The players name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Get the players disc color.
	 * @return The color of the players disc
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * Returns a string representation of a player.
	 */
	public String toString(){
		return name;
	}
	
	/**
	 * Indicates whether some other object is "equal to" this one. Based on name.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Player){
			return ((Player) obj).color.equals(color);
		}
		return false;
	}
}
