package gui;

import java.util.ArrayList;
import java.util.List;

import board.AllPlayers;
import board.Board;
import board.BoardSize;
import board.WinOrTie;
import board.HighScore;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 * 
 * @author Anna Palmqvist Sjövall
 *
 * The game Connect 4. Two players face off, red vs yellow. 
 * Before starting the game, name the two players.
 * The game ends when one player gets four discs in a row or when there are no more moves.
 * 
 */
public class Connect4 {
	private static final int ROWS = BoardSize.ROWS; // Amount of rows
	private static final int COLS = BoardSize.COLUMNS; // Amount of cols
	private static final int TILE_SIZE = ScreenSize.calculateTileSize(); // Size of the tiles
	private static final int RADIUS = TILE_SIZE / 2; // The radius of a circle/disc

	private Board board; // The play board
	private AllPlayers players; // The players in the game
	private WinOrTie end; // The rules in the game
	private Pane discPane; //Pane to add disc in
	
	/**
	 * Creates a Connect4 game with the players in list.
	 * @param list The list of players
	 */
	public Connect4(AllPlayers list) {
		players = list;
		board = new Board(ROWS, COLS);
		end = new WinOrTie(board);
		discPane = new Pane();
	}

	/**
	 * Creates the parent and adds the children; pane with discs, grid of tiles and the highlighted columns.
	 * @return The parent with added children
	 */
	public Parent create() {
		Pane root = new Pane();
		Shape grid = createGrid();

		root.getChildren().add(discPane);
		root.getChildren().add(grid);
		root.getChildren().addAll(dropDiscsColumns());

		return root;
	}

	/**
	 * Create the grid containing the shape rectangle with white circles.
	 * The circles are created as holes for containing incoming discs.
	 * @return The rectangle with white holes.
	 */
	private Shape createGrid() {
		Shape shape = new Rectangle(TILE_SIZE * COLS, TILE_SIZE * ROWS);

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				//adjusts the circle placement so it is placed in the center
				Shape circle = new Circle(col * TILE_SIZE + RADIUS, row * TILE_SIZE + RADIUS, RADIUS); 
				shape = Shape.subtract(shape, circle);
			}
		}
		shape.setFill(Color.BLUE);
		return shape;
	}

	/**
	 * Adds highlighted columns following the mouse pointer.
	 * When pressing a column a disc dropps.
	 * @return
	 */
	private List<Rectangle> dropDiscsColumns() {
		ArrayList<Rectangle> list = new ArrayList<>();

		for (int col = 0; col < COLS; col++) {
			Rectangle rectangle = new Rectangle(TILE_SIZE, TILE_SIZE * ROWS);
		
			rectangle.setTranslateX(col * TILE_SIZE);
			rectangle.setFill(Color.TRANSPARENT);
			
			//highlights column when mouse entered
			rectangle.setOnMouseEntered(e -> rectangle.setFill(Color.rgb(0, 149, 192, 0.2)));
			rectangle.setOnMouseExited(e -> rectangle.setFill(Color.TRANSPARENT));
			
			//drops disc if allowed
			int column = col;
			rectangle.setOnMouseClicked(e -> allowedToDropDisc(column));
			list.add(rectangle);
		}
		return list;
	}

	/**
	 * Makes sure the players names are entered before dropping discs.
	 * Also checks so that the column is not full before dropping a disc.
	 * @param column The column to drop the disc in
	 */
	private void allowedToDropDisc(int column) {
		boolean dropSuccess = board.discCanDrop(column);

		try {
			if (players.twoPlayersAdded() && dropSuccess) {
				dropDisc(new Disc(players.getActivePlayer().getColor(), RADIUS), column);
				View.updateActivePlayer(players.getActivePlayer().getColor());
			} else
				Alerts.error("Warning", "Name players first", "Submit each players name respectivly");

		} catch (IndexOutOfBoundsException e) {}
	}

	/**
	 * Drops a disc in the visuals with animation to look like it is falling.
	 * Also calls to change game status, that is to switch active player.
	 * @param disc The disc to be dropped
	 * @param column The column to drop the disc in
	 */
	private void dropDisc(Disc disc, int column) {
		int row = board.getRow(column);

		discPane.getChildren().add(disc);
		disc.setTranslateX(column * TILE_SIZE);
		TranslateTransition animation = new TranslateTransition(Duration.seconds(0.5), disc);
		animation.setToY(row * TILE_SIZE);
		animation.play();
		
		changeGameStatus(column, row);
	}

	/**
	 * Clears the board and the visuals of discs and players. 
	 * Creates the board again.
	 */
	public void clear() {
		board.clear();
		players.clear();
		View.clearGUI();
	}

	/**
	 * Switches the active player.
	 * If a player has won or it is a tie it calls on a pop-up window and calls on clear.
	 * @param column
	 * @param row
	 */
	private void changeGameStatus(int column, int row) {
		board.dropDisc(column, players.getActivePlayer());
		
		if (end.win(row, column)){ 
			popUpHS();
			popUpConf("Congratulations on the win " + players.getActivePlayer());
		}
		else if (end.filledBoard()){ 
			popUpConf("No more moves possible, tie");
		}
		else 
			next();
	}
	
	/**
	 * Calls to change active player to next in line.
	 */
	public void next(){
		players.nextPlayer();
	}
	
	/**
	 * Creates a Pop-up confirmation window with the given header. 
	 * @param header The text going in the header
	 */
	private void popUpConf(String header){
		Alerts.restart("Finished Game", header, "Would you like to play again?", this);
	}
	
	/**
	 * Creates a Pop-up information window for the highscore.
	 */
	private void popUpHS(){
		Alerts.information("HighScore", "Name and amount of wins", HighScore.print(" \t "));
	}
}
