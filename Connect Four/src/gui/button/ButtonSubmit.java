package gui.button;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import player.AllPlayers;
import player.Player;

/**
 * 
 * @author Anna Palmqvist Sjövall
 *
 * A button that submits the text from a TextField to create a new player
 */
public class ButtonSubmit {
	private Button buttonSubmit; //The button
	private String submittedText; //The text submitted through the TextField
	
	/**
	 * Creates a new ButtonSubmit with given dimensions. 
	 * The text from the given TextField is used to create a new player.
	 * The label over the TextField will change to contain the submitted text.
	 * @param textField The TextField containing the submitted text
	 * @param dimensions The size of the button
	 * @param players The list of players
	 * @param label The label over the TextField
	 */
	public ButtonSubmit(TextField textField, double dimensions, AllPlayers players, Label label) {
		buttonSubmit = new Button("Submit");
		buttonSubmit.setPrefWidth(dimensions);
		
		buttonSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				submittedText = textField.getText();
				if(allowed(submittedText)){
					Color color = label.getText().contains("red") ? Color.RED : Color.YELLOW;
					players.add(new Player(submittedText, color));
					label.setText("Name: " + submittedText);
				}
			}
		});
	}
	
	/**
	 * Checks that the submitted string is not empty.
	 * @param text The text to be checked
	 * @return true if the String is not empty
	 */
	private boolean allowed(String text){
		return !text.isEmpty();
	}
	
	/**
	 * Gets the button.
	 * @return The button
	 */
	public Button getButton() {
		return buttonSubmit;
	}
}
