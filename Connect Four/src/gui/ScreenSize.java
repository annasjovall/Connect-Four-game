package gui;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class ScreenSize {
	private static Rectangle2D rectangle = Screen.getPrimary().getVisualBounds();
	
	public static Rectangle2D getRectangular(){
		return rectangle;
	}
	
	public static double getHeight(){
		return rectangle.getHeight();
	}
	
	public static double getWidth(){
		return rectangle.getWidth();
	}
}
