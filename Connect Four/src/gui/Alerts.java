package gui;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Alerts {
	
	/**
	 * Creates an Alert of type confirmation with given title, header and info text. 
	 * When "OK" is pressed, the program is restarted. 
	 * Pressing cancel or [X] keeps the game going.
	 * @param title The title of the pop-up
	 * @param header The header text
	 * @param content The information text
	 * @param connect4 The connect4 game the pop-up should appear in
	 */
	public static void confirmation(String title, String header, String content, Connect4 connect4){
		Alert alert = createAlert(title, header, content, AlertType.CONFIRMATION);
		
		Optional<ButtonType> result = alert.showAndWait();
		
		//Either clears or keeps the game going
		if (result.get() == ButtonType.OK){
		    connect4.clear();
		}
		else if(result.get() == ButtonType.CANCEL){
			connect4.next();
		}
	}
	
	/**
	 * Creates an Alert of type error.
	 * @param title The title of the pop-up
	 * @param header The header text
	 * @param content The information text
	 */
	public static void error(String title, String header, String content){
		createAlert(title, header, content, AlertType.WARNING)
		.showAndWait();
	}
	
	/**
	 * Creates an Alert of type information.
	 * @param title The title of the pop-up
	 * @param header The header text
	 * @param content The information text
	 */
	public static void information(String title, String header, String content){
		createAlert(title, header, content, AlertType.INFORMATION)
		.showAndWait();
	}
	
	/**
	 * Creates the pop-up of given type, title, header and info text.
	 * @param title The title of the pop-up
	 * @param header The header text
	 * @param info The information text
	 * @param type The type of alert to be created
	 * @return The Alert that was created
	 */
	private static Alert createAlert(String title, String header, String content, AlertType type){
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		return alert;
	}
}
