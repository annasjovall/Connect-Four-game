import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CounterPane extends HBox {
	private Button button;
	private Label label;	
	
	public CounterPane(String s, Vote vote, Counters counters) {
		button = new Button(s);
		button.setOnAction(event -> {
				counters.incrementCounts(vote);
				label.setText(Integer.toString(counters.getCounts(vote)));	
			}
		);
		label = new Label("0");
		
		setPadding(new Insets(10, 10, 10, 10));
		setSpacing(20);  
		setAlignment(Pos.CENTER_LEFT); 
		getChildren().addAll(button, label);
	}
}
