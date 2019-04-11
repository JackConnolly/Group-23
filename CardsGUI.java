/** Implements Cards class logic to create Cards GUI
* @author Hailey Allen
* @since 03-26-19
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
		c.setAllCards();

		ArrayList<String> playerOne = new ArrayList<>(c.getPlayerOnesHand());
		ArrayList<String> playerTwo = new ArrayList<>(c.getPlayerTwosHand());

/** 
Beginning all of the hard-coded rectangles and
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
		HBox h3 = new HBox();
		HBox h4 = new HBox();
		HBox h5 = new HBox();

		VBox v = new VBox();
		VBox v2 = new VBox();

		stack.getChildren().addAll(rectangle, player);
		stack2.getChildren().addAll(rectangle2, player2);
		stack3.getChildren().addAll(rectangle3, player3);
		stack4.getChildren().addAll(rectangle4, player4);
		stack5.getChildren().addAll(rectangle5, player5);
		stack6.getChildren().addAll(rectangle6, player6);
		stack7.getChildren().addAll(rectangle7, player7);
		stack8.getChildren().addAll(rectangle8, player8);
		stack9.getChildren().addAll(rectangle9, player9);
		stack10.getChildren().addAll(rectangle10, player10);
		stack11.getChildren().addAll(rectangle11, player11);
		stack12.getChildren().addAll(rectangle12, player12);

		h.getChildren().addAll(stack, stack2, stack3);
		h2.getChildren().addAll(stack4, stack5, stack6);
		h3.getChildren().addAll(stack7, stack8, stack9);
		h4.getChildren().addAll(stack10, stack11, stack12);

		v.getChildren().addAll(h, h2);
		v2.getChildren().addAll(h3, h4);

		h5.getChildren().addAll(v, v2);

		Scene scene = new Scene(h5, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}