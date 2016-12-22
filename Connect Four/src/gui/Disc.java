package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Disc extends Circle{
	public Disc(Color colorPlayer, int radius){
		super(radius, radius, radius, colorPlayer);
	}
}
