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
import javafx.scene.shape.Rectangle;

public class Panels extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage primaryStage) {

		GridPane root = new GridPane();

		Button rollDice = new Button("Roll Dice");
		Button suspectPlayer = new Button("Suspect Player");
		Button moveLeft = new Button("Move Left");
		Button moveRight = new Button("Move Right");
		Button moveUp = new Button("Move Up");
		Button moveDown = new Button("Move Down");
		root.add(rollDice, 2, 3);
		root.add(suspectPlayer, 2, 9);
		root.add(moveLeft, 2, 12);
		root.add(moveRight, 2, 16);
		root.add(moveUp, 2, 20);
		root.add(moveDown, 2, 24);

		GridPane root2 = new GridPane();
		Rectangle rectangle1 = new Rectangle(1,1,9,15);
		Rectangle rectangle2 = new Rectangle(2,2,8,14);
		root.add(rectangle1, 1,2);
	

	Scene scene = new Scene(root, 150, 300);
	  primaryStage.setTitle("panels");
	  primaryStage.setScene(scene);
	  primaryStage.show();
	
}

}