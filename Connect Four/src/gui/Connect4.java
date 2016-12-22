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
import player.BoardSize;
import player.EndGame;
import player.AllPlayers;

public class Connect4 {
	private static final int ROWS = BoardSize.ROWS;
	private static final int COLS = BoardSize.COLUMNS;
	private static final int TILE_SIZE = ScreenSize.calculateTileSize();
	private static final int RADIUS = TILE_SIZE / 2;

	private Board board;
	private AllPlayers players;
	private EndGame end;
	private Pane discPane;

	public Connect4(AllPlayers list) {
		players = list;
		board = new Board(ROWS, COLS);
		end = new EndGame(board);
		discPane = new Pane();
	}

	public Parent create() {
		Pane root = new Pane();
		Shape grid = createGrid();

		root.getChildren().add(discPane);
		root.getChildren().add(grid);
		root.getChildren().addAll(dropDiscsColumns());

		return root;
	}

	private Shape createGrid() {
		Shape shape = new Rectangle(TILE_SIZE * COLS, TILE_SIZE * ROWS);

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				Shape circle = new Circle(col * TILE_SIZE + RADIUS, row * TILE_SIZE + RADIUS, RADIUS);
				shape = Shape.subtract(shape, circle);
			}
		}
		shape.setFill(Color.BLUE);
		return shape;
	}

	private List<Rectangle> dropDiscsColumns() {
		ArrayList<Rectangle> list = new ArrayList<>();

		for (int col = 0; col < COLS; col++) {
			Rectangle rectangle = new Rectangle(TILE_SIZE, TILE_SIZE * ROWS);
			rectangle.setTranslateX(col * TILE_SIZE);
			rectangle.setFill(Color.TRANSPARENT);
			rectangle.setOnMouseEntered(e -> rectangle.setFill(Color.rgb(0, 149, 192, 0.2)));
			rectangle.setOnMouseExited(e -> rectangle.setFill(Color.TRANSPARENT));
			int column = col;
			rectangle.setOnMouseClicked(e -> allowedToDropDisc(column)); // Byt
																			// till
																			// activePlayerist
			list.add(rectangle);
		}
		return list;
	}

	private void allowedToDropDisc(int column) {
		try {
			boolean dropSuccess = board.discCanDrop(column); 
			if (dropSuccess)
				dropDisc(new Disc(players.getActivePlayer().getColor(), RADIUS), column);
			else
				System.out.println("Ditt drag är ogilltigt");
		} catch (IndexOutOfBoundsException e) {
			GUI.alert("Warning", "Name players first", "Submit each players name respectivly");
		}
	}

	private void dropDisc(Disc disc, int column) {
		int row = board.getRow(column);

		try {
			changeGameStatus(column, row);
		} catch (IndexOutOfBoundsException e) {
			GUI.alert("anna", "anna", "anna");
		}

		discPane.getChildren().add(disc);
		disc.setTranslateX(column * TILE_SIZE);
		TranslateTransition animation = new TranslateTransition(Duration.seconds(0.5), disc);
		animation.setToY(row * TILE_SIZE);
		animation.play();

	}

	private void clear() {
		board.clear();
		create();
	}

	private void changeGameStatus(int column, int row) {
		board.dropDisc(column, players.getActivePlayer());
		if (end.win(row, column)) {
			System.out.println("vinnare! " + players.getActivePlayer());
			GUI.alert("du vann", "anna panna", "ananananan");
			clear();
		}
		if (end.filledBoard()) {
			System.out.println("Oavgjort!");
			System.exit(0);
		}
		players.nextPlayer();
		// board.print();
	}

}
