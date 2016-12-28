package gui;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

//MÅSTE FIXA SIZE PÅ DOM

public class Alerts {
	
	/**
	 * Creates a pop-up confirmation with given title, header and info text. 
	 * When "OK" is pressed, the program is restarted. 
	 * Pressing cancel or [X] does nothing.
	 * @param title The title of the pop-up
	 * @param headerText The header text
	 * @param infoText The information text
	 */
	public static void confirmation(String title, String header, String content, Connect4 connect4){
		Alert alert = createAlert(title, header, content, AlertType.CONFIRMATION);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    connect4.clear();
		}
	}
	
	/**
	 * Creates a pop-up error with given title, header and info text.
	 * @param title The title of the pop-up
	 * @param headerText The header text
	 * @param infoText The information text
	 */
	public static void error(String title, String header, String content){
		createAlert(title, header, content, AlertType.WARNING)
		.showAndWait();
	}
	
	public static void information(String title, String header, String content){
		createAlert(title, header, content, AlertType.INFORMATION)
		.showAndWait();
	}
	
	private static Alert createAlert(String title, String header, String content, AlertType type){
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		return alert;
	}
}
