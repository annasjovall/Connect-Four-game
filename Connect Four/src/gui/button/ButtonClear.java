package gui.button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * 
 * @author Anna Palmqvist Sjövall
 *
 * A button that when pressed clears the board.
 */
public class ButtonClear {
	private Button buttonClear; //The button
	
	/**
	 * Creates a clear button. Clears the board when pressed.
	 */
	public ButtonClear(){
		buttonClear = new Button("Clear");
		
		buttonClear.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//händelse
		    }
		});
	}
	
	/**
	 * Gets the button.
	 * @return The button
	 */
	public Button getButton(){
		return buttonClear;
	}
}
