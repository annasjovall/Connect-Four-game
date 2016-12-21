package gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import player.Player;
import player.AllPlayers;

public class GUI extends Application{	
	public Parent test(){
		BorderPane root = new BorderPane();
		
		AllPlayers players = new AllPlayers();
		players.add(new Player("anna", Color.YELLOW));
		players.add(new Player("john", Color.RED));
		
		Connect4 drawGrid = new Connect4(players);
		root.setCenter(drawGrid.create());
		//root.setTop(createTop());
		
		return root;
	}
	
	private HBox createTop(){
		HBox hbox = new HBox();
		hbox.setPrefSize(200, 200);
		return hbox;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(test(), ScreenSize.getWidth() / 2, ScreenSize.getHeight() * 9 / 10));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
