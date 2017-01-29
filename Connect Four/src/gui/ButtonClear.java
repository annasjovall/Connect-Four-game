package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonClear {
	private Button buttonClear; //The button
	
	/**
	 * Creates a new ButtonClear with given dimensions named "Restart".
	 * @param dimensions The size of the button
	 * @param connect4 The current connect4 game
	 */
	public ButtonClear(double dimensions, Connect4 connect4) {
		buttonClear = new Button("Restart");
		buttonClear.setPrefWidth(dimensions);
		
		buttonClear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				connect4.clear();
			}
		});
	}
	
	/**
	 * Gets the Button.
	 * @return the Button
	 */
	public Button getButton(){
		return buttonClear;
	}
}
