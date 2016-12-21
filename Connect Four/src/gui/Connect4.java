package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import player.Board;
import player.EndGame;
import player.AllPlayers;

public class Connect4{
	
	private static final int ROWS = 6;
	private static final int COLS = 7;	
	private static final int TILE_SIZE = 60; //(int)Math.round((double)SCREEN_HEIGHT/(ROWS + 1) - 40);
	private static final int RADIUS = TILE_SIZE / 2;
	
	private Board board;
	private AllPlayers players;
	private EndGame end;
	private Pane discPane;
	
	public Connect4(AllPlayers list){
		players = list;
		board = new Board(ROWS, COLS);
		end = new EndGame(board);
		discPane = new Pane();
	}
	
	public Parent create(){
		Pane root = new Pane();
		Shape grid = createGrid();
		
		root.getChildren().add(discPane);
		root.getChildren().add(grid);
		root.getChildren().addAll(dropDiscsColumns());
		
		return root;
	}
	
	private Shape createGrid(){
		Shape shape = new Rectangle(TILE_SIZE * COLS, TILE_SIZE * ROWS);
		
		for(int row = 0; row < ROWS; row++){
			for(int col = 0; col < COLS; col++){
				double radius = TILE_SIZE / 2;
				Shape circle = new Circle(col*TILE_SIZE + radius , row*TILE_SIZE + radius, radius);
				shape = Shape.subtract(shape, circle);
			}
		}
		shape.setFill(Color.BLUE);
		return shape;
	}
	
	private List<Rectangle> dropDiscsColumns(){
		ArrayList<Rectangle> list = new ArrayList<>();
		
		for(int col = 0; col < COLS; col++){
			Rectangle rectangle = new Rectangle(TILE_SIZE, TILE_SIZE * ROWS);
			rectangle.setTranslateX(col*TILE_SIZE);
			rectangle.setFill(Color.TRANSPARENT);
			rectangle.setOnMouseEntered(e -> rectangle.setFill(Color.rgb(0, 149, 192, 0.2)));
			rectangle.setOnMouseExited(e -> rectangle.setFill(Color.TRANSPARENT));
			int column = col;
			rectangle.setOnMouseClicked(e -> allowedToDropDisc(column)); //Byt till activePlayerist
			list.add(rectangle);
		}
		return list;
	}
	
	private void allowedToDropDisc(int column){
		boolean dropSuccess = board.discCanDrop(column); //ska den kunna kasta exception?
		if(dropSuccess) dropDisc(new Disc(players.getActivePlayer().getColor()), column);
		else System.out.println("Ditt drag är ogilltigt");
	}
	
	private void dropDisc(Disc disc, int column){
		int row = board.getRow(column);
		
		changeGameStatus(column, row);
		
		discPane.getChildren().add(disc);
		disc.setTranslateX(column*TILE_SIZE);
		TranslateTransition animation = new TranslateTransition(Duration.seconds(0.5), disc);
		animation.setToY(row * TILE_SIZE);
		animation.play();
		}
	
	private void changeGameStatus(int column, int row){
		board.dropDisc(column, players.getActivePlayer());
		if(end.win(row, column)) {
			System.out.println("vinnare! " + players.getActivePlayer());
			System.exit(0);
		}
		if(end.filledBoard()){
			System.out.println("Oavgjort!");
			System.exit(0);
		}
		players.nextPlayer();
		//board.print();
	}
	
	private static class Disc extends Circle{
		public Disc(Color colorPlayer){
			super(RADIUS , RADIUS, RADIUS, colorPlayer);
		}
	}

}
