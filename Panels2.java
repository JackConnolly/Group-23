import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Vbox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Panels2 extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage primaryStage) {

		GridPane root = new GridPane();
		//GraphicsContext gc = getGraphicsContext2D();
		Rectangle r = new Rectangle(50, 50, 150, 250);
		Rectangle r2 = new Rectangle(70, 60, 160, 260);
		Button yesChar= new Button("Yes");
		Button noChar = new Button("No");
		Button yesWeapon = new Button("Yes");
		Button noWeapon = new Button("No");
		r.setFill(Color.WHITE);
		root.add(r2, 1, 1);
		root.add(r, 1,1);

		//GridPane root2 = new GridPane();
		root.add(yesChar, 1, 1);
		root.add(noChar, 2, 1);
		root.add(yesWeapon, 1, 2);
		root.add(noWeapon, 2, 2);
		//root.add(moveUp, 2, 20);
		//Button moveUp = new Button("Move Up");
		//Button moveDown = new Button("Move Down");
		//gc.fillText("<Character>", 10, 20);
		//r.setFill(Color.WHITE);
		//root.add(r2, 2, 1);
		//root.add(r, 2,1);
	

	Scene scene = new Scene(root, 300, 300);
	//Scene scene2 = new Scene(root2, 300, 300);
	  primaryStage.setTitle("panels");
	  primaryStage.setScene(scene);
	  primaryStage.show();
	
}

}