package gui;

import java.util.HashMap;
import java.util.Map;

import gui.button.ButtonSubmit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import player.AllPlayers;

/**
 * 
 * @author Anna Palmqvist Sjövall
 *
 * A visual of the surrounding elements of the connect 4, also creates it.
 */
public class GUI extends Application{	
	private AllPlayers players = new AllPlayers(); //Creates an empty list of players
	private String colorNameRed = "red"; //Headline name for player red
	private String colorNameYellow = "yellow"; //Headline name for player yellow
	private static Stage stage;
	private Map<String, Shape> mapCircles = new HashMap<>();
	
	
	/**
	 * Creates a border pane and places all the elements in it.
	 * @return Parent containing the parts
	 */
	public Parent setAllPartOfPanes(){
		BorderPane root = new BorderPane();
		Connect4 drawGrid = new Connect4(players);
		
		root.setCenter(drawGrid.create());
		root.setLeft(redPlayer());
		root.setRight(yellowPlayer());
		root.setTop(createTop());
		
		return root;
	}

	/**
	 * Creates the vboxes in the left and right part of the border pane.
	 * @param colorName The name of the color corresponding to the player
	 * @return A VBox with a label, textfield, tile and submitbutton
	 */
	private VBox createSides(String colorName){
		VBox vbox = new VBox();
		double vboxSize = ScreenSize.size() / 5;
		double textFieldSize = ScreenSize.size() * 3 / 20;
		
		Label label = new Label("Name: " + colorName);
		label.setFont(new Font(ScreenSize.calculateTileSize() / 5));
		
		TextField textField = new TextField ();
		textField.setPrefWidth(textFieldSize);
		textField.setMaxWidth(textFieldSize);
		
		ButtonSubmit submitButton = new ButtonSubmit(textField, textFieldSize, players, label);
		
		//Shape tile = Tile.createTile((int)Math.round(vboxSize), ScreenSize.calculateTileSize() / 2);
		
		//vbox.getChildren().addAll(label, textField, tile, submitButton.getButton());
		vbox.getChildren().addAll(label, textField, submitButton.getButton(), createCircle(colorName));
		
		vbox.setSpacing(vboxSize / 20);
		vbox.setPrefWidth(vboxSize);
		return vbox;
	}
	
	private Shape createCircle(String color){
		Circle c = new Circle(0, 0, ScreenSize.calculateTileSize() / 2);
		c.setStroke(Color.BLACK);
		c.setFill(null);
		c.setStrokeWidth(0.5);
//		mapCircles.put(color, c);
		return c;
	}
	
//	public static Map<String, Shape> emptyCircles(){
//		return mapCircles;
//	}
	
	/**
	 * Creates the VBox corresponding to the yellow player.
	 * @return The VBox
	 */
	private VBox yellowPlayer(){
		return createSides(colorNameYellow);
	}
	
	/**
	 * Creates the VBox corresponding to the yellow player.
	 * @return The VBox
	 */
	private VBox redPlayer(){
		return createSides(colorNameRed);
	}	
	
	/**
	 * Creates the top HBox. Adds text at the top of the game.
	 * @return The top HBox
	 */
	private HBox createTop(){
		HBox top = new HBox();
		Label labelHead = new Label("Connect 4 game. Enter name before beginning to play.");
		labelHead.setFont(new Font(ScreenSize.size() / 40));
		
		top.getChildren().addAll(labelHead);
		top.setAlignment(Pos.CENTER);
		top.setPadding(new Insets(ScreenSize.size() / 20));
		return top;
	}

	/**
	 * The main entry point for all JavaFX applications. 
	 * The start method is called after the init method has returned, 
	 * and after the system is ready for the application to begin running.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Scene scene = new Scene(setAllPartOfPanes(), ScreenSize.size(), ScreenSize.size());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void clearGUI(){
		stage.close();
		Platform.runLater( () -> {
			try {
				new GUI().start( new Stage() );
			} catch (Exception e) {
				// TODO Auto-generated catch block//måste jag ha denna
				e.printStackTrace();
			}
		} );
	}
	
	/**
	 * Starts the program
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
