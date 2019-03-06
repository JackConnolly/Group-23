import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Panels extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		GridPane root = new GridPane();

		Button rollDice = new Button("Roll Dice");
		Button suspectPlayer = new Button("Suspect Player");
		root.add(rollDice, 0, 3);
		root.add(suspectPlayer, 1, 3);


	

	Scene scene = new Scene(root, 300, 150);
	  primaryStage.setTitle("panels yeehaw");
	  primaryStage.setScene(scene);
	  primaryStage.show();
	
}

}