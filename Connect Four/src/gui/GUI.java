package gui;

import gui.button.ButtonClear;
import gui.button.ButtonSubmit;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import player.Player;
import player.AllPlayers;
import player.Board;
import player.EndGame;

public class GUI extends Application{	
	private AllPlayers players = new AllPlayers();
	private Scene scene;
	
	public void endGame(){
		
	}
	
	public Parent test(){
		BorderPane root = new BorderPane();

//		players.add(new Player("anna", Color.YELLOW));
//		players.add(new Player("john", Color.RED));
		
		Connect4 drawGrid = new Connect4(players);
		root.setCenter(drawGrid.create());
		root.setLeft(redPlayer());
		root.setRight(yellowPlayer());
		root.setBottom(createBottom());
		root.setTop(createTop());
		
		return root;
	}

	
	private VBox createSides(String colorName){
		VBox vbox = new VBox();
		double vboxSize = ScreenSize.size() / 5;
		double textFieldSize = ScreenSize.size() * 3 / 20;
		
		Label label = new Label("Name: " + colorName + "Player");
		
		TextField textField = new TextField ();
		textField.setPrefWidth(textFieldSize);
		textField.setMaxWidth(textFieldSize);
		
		ButtonSubmit submitButton = new ButtonSubmit(textField, textFieldSize, players, label);
		
		Shape tile = Tile.createTile((int)Math.round(vboxSize), ScreenSize.calculateTileSize() / 2);
		
		vbox.getChildren().addAll(label, textField, tile, submitButton.getButton());
		
		vbox.setSpacing(vboxSize / 20);
		vbox.setPrefWidth(vboxSize);
		return vbox;
	}
	
	private VBox yellowPlayer(){
		return createSides("yellow");
	}
	
	private HBox createTop(){
		HBox top = new HBox();
		return top;
	}
	
	private VBox redPlayer(){
		return createSides("red");
	}
	
	public static void displayActivePlayer(Color activePlayer, int radius){
		Disc disc = new Disc(activePlayer, radius);
	}
	
	public static void alert(String title, String headerText, String infoText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(infoText);
		alert.showAndWait();
	}
	
	
	private HBox createBottom(){
		HBox hbox = new HBox();
		Button buttonClear = new ButtonClear().getButton();
		Label label = new Label("hola");
		
		
		//hbox.setSpacing(30); //byt till skalenligt
	    hbox.getChildren().addAll(buttonClear, label);
		return hbox;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		scene = new Scene(test(), ScreenSize.size(), ScreenSize.size());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
