package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonClear {
	private Button buttonClear; //The button
	
	/**
	 * Creates a new ButtonSubmit with given dimensions. 
	 * The text from the given TextField is used to create a new player.
	 * The label over the TextField will change to contain the submitted text.
	 * @param textField The TextField containing the submitted text
	 * @param dimensions The size of the button
	 * @param players The list of players
	 * @param label The label over the TextField
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
	
	public Button getButton(){
		return buttonClear;
	}
}
