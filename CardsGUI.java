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
import javafx.scene.layout.StackPane;

public class CardsGUI extends Application{
	
	public static void main(String[] args){

		launch(args);

	}

	public void start(Stage primaryStage) throws Exception{

		Cards c = new Cards();

		ArrayList<String> playerOne = new ArrayList<>(c.getPlayerOnesHand());
		ArrayList<String> playerTwo = new ArrayList<>(c.getPlayerTwosHand());

/** Beginning all of the hard-coded rectangles and
	the corresponding labels for all 12 cards;
	6 cards per each players hand
*/

	//Player One

//player one, card one
		Rectangle rectangle = new Rectangle(100, 100, 100, 100);
		Label player = new Label(playerOne.get(0));
		rectangle.setFill(Color.BLUE);
//player one, card two
		Rectangle rectangle3 = new Rectangle(100, 100, 100, 100);
		Label player3 = new Label(playerOne.get(1));
		rectangle3.setFill(Color.BLUE);
//player one, card three
		Rectangle rectangle5 = new Rectangle(100, 100, 100, 100);
		Label player5 = new Label(playerOne.get(2));
		rectangle5.setFill(Color.BLUE);
//player one, card four
		Rectangle rectangle7 = new Rectangle(100, 100, 100, 100);
		Label player7 = new Label(playerOne.get(3));
		rectangle7.setFill(Color.BLUE);
//player one, card five
		Rectangle rectangle9 = new Rectangle(100, 100, 100, 100);
		Label player9 = new Label(playerOne.get(4));
		rectangle9.setFill(Color.BLUE);
//player one, card six
		Rectangle rectangle11 = new Rectangle(100, 100, 100, 100);
		Label player11 = new Label(playerOne.get(5));
		rectangle11.setFill(Color.BLUE);

		//Player Two

//player two, card one
		Rectangle rectangle2 = new Rectangle(100, 100, 100, 100);
		Label player2 = new Label(playerTwo.get(0));
		rectangle2.setFill(Color.RED);
//player two, card two
		Rectangle rectangle4 = new Rectangle(100, 100, 100, 100);
		Label player4 = new Label(playerTwo.get(0));
		rectangle4.setFill(Color.RED);
//player two, card three
		Rectangle rectangle6 = new Rectangle(100, 100, 100, 100);
		Label player6 = new Label(playerTwo.get(2));
		rectangle6.setFill(Color.RED);
//player two, card four
		Rectangle rectangle8 = new Rectangle(100, 100, 100, 100);
		Label player8 = new Label(playerTwo.get(3));
		rectangle8.setFill(Color.RED);
//player two, card five
		Rectangle rectangle10 = new Rectangle(100, 100, 100, 100);
		Label player10 = new Label(playerTwo.get(4));
		rectangle10.setFill(Color.RED);
//player two, card six
		Rectangle rectangle12 = new Rectangle(100, 100, 100, 100);
		Label player12 = new Label(playerTwo.get(5));
		rectangle12.setFill(Color.RED);

//setting up HBox so they will all be beside one another
		StackPane stack = new StackPane();
		StackPane stack2 = new StackPane();

		HBox h = new HBox();

		FlowPane flow = new FlowPane();
		flow.setVgap(5);
		flow.setHgap(5);

		FlowPane flow2 = new FlowPane();
		flow2.setVgap(8);
		flow2.setHgap(8);

		FlowPane flow3 = new FlowPane();
		flow3.setVgap(5);
		flow3.setHgap(5);

		FlowPane flow4 = new FlowPane();
		flow4.setVgap(8);
		flow4.setHgap(8);

		flow.getChildren().addAll(rectangle, rectangle2, rectangle3, rectangle4, rectangle5, rectangle6);
		flow2.getChildren().addAll(player, player2, player3, player4, player5, player6);
		
		flow3.getChildren().addAll(rectangle7, rectangle8, rectangle9, rectangle10, rectangle11, rectangle12);
		flow4.getChildren().addAll(player7, player8, player9, player10, player11, player12);

		stack.getChildren().addAll(flow, flow2);
		stack2.getChildren().addAll(flow3, flow4);

		h.getChildren().addAll(stack, stack2);

		Scene scene = new Scene(h, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}