import javafx.application.*;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CountersView extends Application {

	@Override
	public void start(Stage stage) {
		Counters counters = new Counters();
		VBox root = new VBox();
		root.getChildren().add(new CounterPane("Yes", Vote.YES, counters));
		root.getChildren().add(new CounterPane("No",  Vote.NO, counters));
		root.getChildren().add(new CounterPane("Neutral", Vote.NEUTRAL, counters));
		root.setPrefSize(150, 100);
				
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		stage.setTitle("Counters");
		stage.setScene(scene);
	    stage.show();
	}
	
	public static void main(String[] args) {
		CountersView.launch(args);
	}

}
