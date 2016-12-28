package gui;

import board.AllPlayers;
import gui.button.ButtonSubmit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	private static Circle redCircle;
	private static Circle yellowCircle;
	private static Stage stage;	
	
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
	 * @param redPlayersCircle TODO
	 * @return A VBox with a label, textfield, tile and submitbutton
	 */
	private VBox createSides(String colorName, boolean redPlayersCircle){
		VBox vbox = new VBox();
		double vboxSize = ScreenSize.size() / 5;
		double textFieldSize = ScreenSize.size() * 3 / 20;
		
		Label label = new Label("Name: " + colorName);
		label.setFont(new Font(ScreenSize.calculateTileSize() / 5));
		
		TextField textField = new TextField ();
		textField.setPrefWidth(textFieldSize);
		textField.setMaxWidth(textFieldSize);
		
		ButtonSubmit submitButton = new ButtonSubmit(textField, textFieldSize, players, label);
		
		vbox.getChildren().addAll(label, textField, submitButton.getButton(), createCircle(colorName, redPlayersCircle));
		
		vbox.setSpacing(vboxSize / 20);
		vbox.setPrefWidth(vboxSize);
		return vbox;
	}
	
	private Shape createCircle(String color, boolean redPlayersCircle){
		Circle c = new Circle(0, 0, ScreenSize.calculateTileSize() / 2);
		c.setStroke(Color.BLACK);
		c.setFill(null);
		c.setStrokeWidth(0.5);
		
		if(redPlayersCircle) {
			redCircle = c; 
			redCircle.setFill(Color.RED); //Red starts
		}
		else yellowCircle = c; 
		
		return c;
	}
	
	/**
	 * Creates the VBox corresponding to the yellow player.
	 * @return The VBox
	 */
	private VBox yellowPlayer(){
		return createSides(colorNameYellow, false);
	}
	
	/**
	 * Creates the VBox corresponding to the yellow player.
	 * @return The VBox
	 */
	private VBox redPlayer(){
		return createSides(colorNameRed, true);
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

	public static void updateActivePlayer(Color color) {
		if(color.equals(Color.RED)){
			redCircle.setFill(color);
			yellowCircle.setFill(Color.TRANSPARENT);
		}
		else if(color.equals(Color.YELLOW)){
			yellowCircle.setFill(color);
			redCircle.setFill(Color.TRANSPARENT);
		}
	}
}
