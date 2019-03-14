/** Implements Cards class logic to create Cards GUI
* @author Hailey Allen
* @since 03-13-19
*/




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
import javafx.scene.text.*;

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
		Rectangle rectangle = new Rectangle(100, 100, 100, 50);
		Label player = new Label(playerOne.get(0));
		player.setTextFill(Color.BLACK);
		rectangle.setStroke(Color.WHITE);
		rectangle.setFill(Color.BLUE);
//player one, card two
		Rectangle rectangle2 = new Rectangle(100, 100, 100, 50);
		Label player2 = new Label(playerOne.get(1));
		player2.setTextFill(Color.BLACK);
		rectangle2.setStroke(Color.WHITE);
		rectangle2.setFill(Color.BLUE);
//player one, card three
		Rectangle rectangle3 = new Rectangle(100, 100, 100, 50);
		Label player3 = new Label(playerOne.get(2));
		player3.setTextFill(Color.BLACK);
		rectangle3.setStroke(Color.WHITE);
		rectangle3.setFill(Color.BLUE);
//player one, card four
		Rectangle rectangle4 = new Rectangle(100, 100, 100, 50);
		Label player4 = new Label(playerOne.get(3));
		player4.setTextFill(Color.BLACK);
		rectangle4.setStroke(Color.WHITE);
		rectangle4.setFill(Color.BLUE);
//player one, card five
		Rectangle rectangle5 = new Rectangle(100, 100, 100, 50);
		Label player5 = new Label(playerOne.get(4));
		player5.setTextFill(Color.BLACK);
		rectangle5.setStroke(Color.WHITE);
		rectangle5.setFill(Color.BLUE);
//player one, card six
		Rectangle rectangle6 = new Rectangle(100, 100, 100, 50);
		Label player6 = new Label(playerOne.get(5));
		player6.setTextFill(Color.BLACK);
		rectangle6.setStroke(Color.WHITE);
		rectangle6.setFill(Color.BLUE);

		//Player Two

//player two, card one
		Rectangle rectangle7 = new Rectangle(10, 10, 100, 50);
		Label player7 = new Label(playerTwo.get(0));
		player7.setTextFill(Color.BLACK);
		rectangle7.setStroke(Color.WHITE);
		rectangle7.setFill(Color.PURPLE);
//player two, card two
		Rectangle rectangle8 = new Rectangle(10, 10, 100, 50);
		Label player8 = new Label(playerTwo.get(1));
		player8.setTextFill(Color.BLACK);
		rectangle8.setStroke(Color.WHITE);
		rectangle8.setFill(Color.PURPLE);
//player two, card three
		Rectangle rectangle9 = new Rectangle(10, 10, 100, 50);
		Label player9 = new Label(playerTwo.get(2));
		player9.setTextFill(Color.BLACK);
		rectangle9.setStroke(Color.WHITE);
		rectangle9.setFill(Color.PURPLE);
//player two, card four
		Rectangle rectangle10 = new Rectangle(10, 10, 100, 50);
		Label player10 = new Label(playerTwo.get(3));
		player10.setTextFill(Color.BLACK);
		rectangle10.setStroke(Color.WHITE);
		rectangle10.setFill(Color.PURPLE);
//player two, card five
		Rectangle rectangle11 = new Rectangle(10, 10, 100, 50);
		Label player11 = new Label(playerTwo.get(4));
		player11.setTextFill(Color.BLACK);
		rectangle11.setStroke(Color.WHITE);
		rectangle11.setFill(Color.PURPLE);
//player two, card six
		Rectangle rectangle12 = new Rectangle(10, 10, 100, 50);
		Label player12 = new Label(playerTwo.get(5));
		player12.setTextFill(Color.BLACK);
		rectangle12.setStroke(Color.WHITE);
		rectangle12.setFill(Color.PURPLE);

//setting up HBox so they will all be beside one another
		StackPane stack = new StackPane();
		StackPane stack2 = new StackPane();
		StackPane stack3 = new StackPane();
		StackPane stack4 = new StackPane();
		StackPane stack5 = new StackPane();
		StackPane stack6 = new StackPane();
		StackPane stack7 = new StackPane();
		StackPane stack8 = new StackPane();
		StackPane stack9 = new StackPane();
		StackPane stack10 = new StackPane();
		StackPane stack11 = new StackPane();
		StackPane stack12 = new StackPane();

		HBox h = new HBox();
		HBox h2 = new HBox();
		VBox v = new VBox();

		FlowPane flow = new FlowPane();
		FlowPane flow2 = new FlowPane();
		FlowPane flow3 = new FlowPane();
		FlowPane flow4 = new FlowPane();
		FlowPane flow5 = new FlowPane();
		FlowPane flow6 = new FlowPane();
		FlowPane flow7 = new FlowPane();
		FlowPane flow8 = new FlowPane();
		FlowPane flow9 = new FlowPane();
		FlowPane flow10 = new FlowPane();
		FlowPane flow11 = new FlowPane();
		FlowPane flow12 = new FlowPane();

		FlowPane play = new FlowPane();
		FlowPane play2 = new FlowPane();
		FlowPane play3 = new FlowPane();
		FlowPane play4 = new FlowPane();
		FlowPane play5 = new FlowPane();
		FlowPane play6 = new FlowPane();
		FlowPane play7 = new FlowPane();
		FlowPane play8 = new FlowPane();
		FlowPane play9 = new FlowPane();
		FlowPane play10 = new FlowPane();
		FlowPane play11 = new FlowPane();
		FlowPane play12 = new FlowPane();
		
		flow.getChildren().add(rectangle);
		flow2.getChildren().add(rectangle2);
		flow3.getChildren().add(rectangle3);
		flow4.getChildren().add(rectangle4);
		flow5.getChildren().add(rectangle5);
		flow6.getChildren().add(rectangle6);
		flow7.getChildren().add(rectangle7);
		flow8.getChildren().add(rectangle8);
		flow9.getChildren().add(rectangle9);
		flow10.getChildren().add(rectangle10);
		flow11.getChildren().add(rectangle11);
		flow12.getChildren().add(rectangle12);

		play.getChildren().add(player);
		play2.getChildren().add(player2);
		play3.getChildren().add(player3);
		play4.getChildren().add(player4);
		play5.getChildren().add(player5);
		play6.getChildren().add(player6);
		play7.getChildren().add(player7);
		play8.getChildren().add(player8);
		play9.getChildren().add(player9);
		play10.getChildren().add(player10);
		play11.getChildren().add(player11);
		play12.getChildren().add(player12);

		stack.getChildren().addAll(flow, play);
		stack2.getChildren().addAll(flow2, play2);
		stack3.getChildren().addAll(flow3, play3);
		stack4.getChildren().addAll(flow4, play4);
		stack5.getChildren().addAll(flow5, play5);
		stack6.getChildren().addAll(flow6, play6);
		stack7.getChildren().addAll(flow7, play7);
		stack8.getChildren().addAll(flow8, play8);
		stack9.getChildren().addAll(flow9, play9);
		stack10.getChildren().addAll(flow10, play10);
		stack11.getChildren().addAll(flow11, play11);
		stack12.getChildren().addAll(flow12, play12);

		h.getChildren().addAll(stack, stack2, stack3, stack4, stack5, stack6);
		h2.getChildren().addAll(stack7, stack8, stack9, stack10, stack11, stack12);

		v.getChildren().addAll(h, h2);

		Scene scene = new Scene(v, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}