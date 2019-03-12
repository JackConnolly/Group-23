import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;

public class CardsGUI extends Application{
	
	public static void main(String[] args){

		launch(args);

	}

	public void start(Stage primaryStage) throws Exception{

		Cards c = new Cards();

		ArrayList<String> playerOne = new ArrayList<>(c.getPlayerOnesHand());
		ArrayList<String> playerTwo = new ArrayList<>(c.getPlayerTwosHand());

		

//creating the labels for all of player ones hand
		/**Label p10 = new Label (playerOne.get(0));
		Label p11 = new Label(playerOne.get(1));
		Label p12 = new Label(playerOne.get(2));
		Label p13 = new Label(playerOne.get(3));
		Label p14 = new Label(playerOne.get(4));
		Label p15 = new Label(playerOne.get(5));

//creating the labels for all of player twos hand
		Label p20 = new Label(playerTwo.get(0));
		Label p21 = new Label(playerTwo.get(1));
		Label p22 = new Label(playerTwo.get(2));
		Label p23 = new Label(playerTwo.get(3));
		Label p24 = new Label(playerTwo.get(4));
		Label p25 = new Label(playerTwo.get(5));
		*/

/*
		for(int i=0; i<=1; i++){
			grid.add(rectangle+i, i, i+5);
			grid.add(new Label(playerOne.get(i)), i, i+5);
		}		

		for(int i=0; i<=12; i++){
			grid.add(rectangle1, i+5, i);
			//grid.add(new Label(playerTwo.get(i)), i+5, i);
		}

		GridPane gridpane = new GridPane();
		int rowNum=4;
		int colNum=4;
		for(int row=0; row<rowNum; row++)
		{
			for (int col=0; col<colNum; col++)
			{
				Rectangle rectangle = new Rectangle();
				rectangle.setWidth(2);
				rectangle.setHeight(2);
				rectangle.setFill(Color.BLUE);
				Label play = new Label(playerOne.get(i))
				GridPane.setRowIndex(rectangle, row);
				GridPane.setColumnIndex(rectangle, col);
				gridpane.getChildren().addAll(rectangle, play);
			}
		}

*/

		BorderPane pane = new BorderPane();
		HBox h = new HBox();
		VBox v1 = new VBox();
		VBox v2 = new VBox();

		Rectangle rectangle = new Rectangle(10, 10, 10, 10);
		rectangle.setFill(Color.BLUE);

		v1.getChildren().add(rectangle);
		pane.setLeft(v1);
		
		Scene scene = new Scene(pane, 100, 100);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}