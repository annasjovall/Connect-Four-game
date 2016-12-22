package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * 
 * @author Anna Palmqvist Sjövall
 *
 * A tile consisting of a blue square and an inscripted white circle.
 */
public class Tile {
	
	/**
	 * Creates a tile at given placement with the inscripted circle of size radius.
	 * @param placement The placement of the Rectangle. Given by the upper left corner.
	 * @param radius The radius of the inscripted circle. The tile itself is given the size radius*2.
	 * @return The tile which is a shape
	 */
	public static Shape createTile(int placement, int radius){
		Shape tile = new Rectangle(placement, placement, radius * 2, radius * 2);
		Shape circle = new Circle(placement + radius, placement + radius, radius);
		tile = Shape.subtract(tile, circle);
		tile.setFill(Color.BLUE);
		return tile;
	}
	
}
