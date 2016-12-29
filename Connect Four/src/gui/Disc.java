package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * 
 * @author Anna Palmqvist Sjövall
 * 
 * A subclass of the shape circle that represents a disc in a connect4 game.
 */
public class Disc extends Circle{
	
	/**
	 * Creates a disc.
	 * @param colorPlayer The color of the disc
	 * @param radius The radius of the disc
	 */
	public Disc(Color colorPlayer, int radius){
		super(radius, radius, radius, colorPlayer);
	}
}
