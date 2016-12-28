package gui;

import board.BoardSize;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * 
 * @author Anna Palmqvist Sjövall
 *
 * A class describing the size of the screen the program is run on. 
 * And the size of the window for the GUI.
 */
public class ScreenSize {
	
	/**
	 * Returns the size of the window. 
	 * It is the smallest of the height and width of the screen. 
	 * For marginal the window is a bit smaller than that.
	 * @return size of the window
	 */
	public static double size(){
		Rectangle2D rectangleSize = Screen.getPrimary().getVisualBounds();
		return Math.min(rectangleSize.getHeight(), rectangleSize.getWidth()) * 9 / 10;
	}
	
	/**
	 * The tile size of the Connect 4 board based on screen size.
	 * @return the tile size of the connect 4 board
	 */
	public static int calculateTileSize(){
		double partOfScreen = size() * 3 / 5;
		int mostTiles = Math.max(BoardSize.ROWS, BoardSize.COLUMNS);
		double tileSize = partOfScreen / mostTiles;
		return (int)Math.round(tileSize);
	}
}
