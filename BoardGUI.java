import java.util.ArrayList;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.control.CheckBoxTreeItem;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.util.*;
import javafx.util.converter.DefaultStringConverter;

/**
* This is the GUI Board for the Game Clue, as per feedback from Demo 2 we re trying to
* remove logic from the GUI
* @author Jack Connolly, Anna Barrett, Kylie Sicat, Hailey Allen, Jung Ho Kim
* last updated by: Hailey Allen
* @since 04-07-19
*/

  public class BoardGUI extends Application{

	//Game Instance Variables
	private Player player1;
	private Player player2;
	private Player turn;

  // Variables for the dynamic buttons
  private int numRows = 5;
  private int numColumns = 5;

	//Dice roll class is here for my own sake of debugging the board
 	public int diceRoll() {
 		int min = 1;
 		int max = 6;
 		int rollAmount = (int)(Math.random() * max) + 1;
 		System.out.println(rollAmount);
 		return rollAmount;
 	}


  public static void main(String[] args) {
    	Rules r = new Rules();
    	r.printRules();
    	launch(args);
    }
	//Function to check player position and display image onto button
  public HBox[] displayPlayers(Player player1, Player player2){
	   HBox hBox1 = new HBox();
	   HBox hBox2 = new HBox();
	   Label label = new Label(" ");
	   int player1Position[] = player1.getPlayerPosition();
	   int player2Position[] = player2.getPlayerPosition();
	   ImageView token1 = new ImageView( getClass().getResource(player1.getPlayerToken()).toExternalForm());
     ImageView token2 = new ImageView( getClass().getResource(player2.getPlayerToken()).toExternalForm());
		 if (player1Position == player2Position){
			  hBox1.getChildren().addAll( token1, label, token2);
		  } else {
			  hBox1.getChildren().addAll(token1);
			  hBox2.getChildren().addAll(token2);
		  }
		  HBox[] boxes = new HBox[]{hBox1, hBox2};
		  return boxes;
	  }

  public void start(Stage primaryStage) throws Exception{


      // Setup the panes
      BorderPane root = new BorderPane();
      GridPane grid = new GridPane();
      grid.setGridLinesVisible(true);
      VBox actionKeys = new VBox(20);
      // setting preferred width for VBox actionKeys
      actionKeys.setPrefWidth(150);

      //SCENE 1 --> titleScene
    BorderPane titlePage = new BorderPane();
    StackPane st = new StackPane();

    Button start = new Button(" START HERE ");
    start.setTextFill(Color.BLACK);

    ImageView titlePicture = new ImageView(getClass().getResource("Clue-Poster.jpg").toExternalForm());
    //titlePicture.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

    st.getChildren().addAll(titlePicture, start);
    titlePage.setCenter(st);

//SCENE 2 --> playerScene

    VBox vert1 = new VBox(20);
    VBox vert2 = new VBox(20);
    VBox vert3 = new VBox(20);
    HBox hor = new HBox(20);
    HBox hor2 = new HBox(20);
    HBox hor3 = new HBox(20);

//setting all labels fro two player game
    Label playerChoice = new Label("Enter your names: ");
    playerChoice.setTextFill(Color.BLACK);
    playerChoice.setFont(Font.font("Arial Rounded MT Bold", 20));

    TextField txt = new TextField("");
    hor.getChildren().add(playerChoice);
    Label name2 = new Label("Player One: ");
    name2.setTextFill(Color.RED);
    hor2.getChildren().add(name2);
    hor2.getChildren().add(txt);

    TextField txt2 = new TextField("");
    
    Label name3 = new Label("Player Two: ");
    name3.setTextFill(Color.BLUE);
    hor3.getChildren().add(name3);
    hor3.getChildren().add(txt2);

    vert2.getChildren().addAll(hor, hor2, hor3);

    Button ready = new Button(" Our names are entered! ");
    Button aiReady = new Button(" I have no friends :( ");

    vert1.getChildren().add(aiReady);
    vert1.getChildren().add(ready);

    vert3.getChildren().addAll(vert2, vert1);

//setting the 'cushioning' around the buttons
    Insets insetScene2 = new Insets(200,200,200,300);
    vert3.setPadding(insetScene2);


//SCENE 3 --> ruleScene
    VBox vb = new VBox(20);
    Insets insetScene3 = new Insets(75,200,200,250);
    vb.setPadding(insetScene3);

    BorderPane border = new BorderPane();

    Label rules = new Label("Rules For Clue: ");
    rules.setTextFill(Color.BLACK);
    rules.setFont(Font.font("Arial Rounded MT Bold", 30));

    Rules r = new Rules();

//print statements for all of the rules
    Label rules2 = new Label("Objectives: The objective of the game is to figure out who the murder is!");
    Label rules3 = new Label("In order to do this, You must find the correct weapon, room, and person.");
    Label rules4 = new Label("To do so, you are each given 6 cards. Some cards are weapons, rooms,");
    Label rules5 = new Label("and people. The winning cards are not in either of the players hands.");
    Label rules6 = new Label("To play: Roll the dice to give you the amount of squares you can");
    Label rules7 = new Label(" move on the board. If you end up in a room you are given the ");
    Label rules8 = new Label("option to 'suspect' or 'accuse'. To suspect, you can choose who ");
    Label rules9 = new Label("you think did it, and with what weapon, the other player is given ");
    Label rules10 = new Label("the option to contest towards your suspicion if they have any of ");
    Label rules11 = new Label("the cards you used to suspect with. To accuse, it is similar to ");
    Label rules12 = new Label("suspecting HOWEVER! Be sure your accusation is correct or ELSE IF ");
    Label rules13 = new Label("one or more of your weapon, room or person is wrong you lose and ");
    Label rules14 = new Label(" the other player wins the game!");

//changing size and font of rules
    rules2.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules3.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules4.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules5.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules6.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules7.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules8.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules9.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules10.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules11.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules12.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules13.setFont(Font.font("Arial Rounded MT Bold", 10));
    rules14.setFont(Font.font("Arial Rounded MT Bold", 10));


    Button change = new Button(" I accept these rules ");

    vb.getChildren().addAll(rules, rules2, rules3, rules4, rules5, rules6, rules7, rules8, rules9, rules10, rules11, rules12, rules13, rules14, change);

    //border.setCenter(vb);

//SCENE 4 --> aiScene

    VBox vert4 = new VBox(20);
    VBox vert5= new VBox(20);
    HBox hor4 = new HBox(20);
    HBox hor5 = new HBox(20);

//setting all buttons for human vs ai
    Label playerChoice2 = new Label("Enter your name: ");
    playerChoice2.setTextFill(Color.BLACK);
    playerChoice2.setFont(Font.font("Arial Rounded MT Bold", 20));

    TextField txt3 = new TextField("");
    hor4.getChildren().add(playerChoice2);
    Label name1 = new Label("Player One: ");
    name1.setTextFill(Color.RED);
    hor5.getChildren().add(name1);
    hor5.getChildren().add(txt3);

    Button ready2 = new Button(" My name is entered! ");

    vert5.getChildren().addAll(hor4, hor5, ready2);
    Insets insetScene4 = new Insets(200,200,200,300);
    vert5.setPadding(insetScene4);


//Cretaing all different scenes and how to toggle between   

    Scene ruleScene = new Scene(vb, 800, 600);

    Scene playerScene = new Scene(vert3, 800, 600);

    Scene rootScene = new Scene(root, 800, 600);

    Scene titleScene = new Scene(titlePage, 800, 600);

    Scene aiScene = new Scene(vert5, 800, 600);

    start.setOnAction( e -> primaryStage.setScene(ruleScene));
    change.setOnAction( e -> primaryStage.setScene(playerScene));
    aiReady.setOnAction( e -> primaryStage.setScene(aiScene));

    ready.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event)
      {

        String playerOneName = txt.getText();
        player1.setName(playerOneName);


        String playerTwoName = txt2.getText();
        player2.setName(playerTwoName);

        ready.setOnAction( e -> primaryStage.setScene(rootScene));
      }
     }
    );

    ready2.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event)
      {

      String playerOneName = txt3.getText();
      player1.setName(playerOneName);

      ready2.setOnAction( e -> primaryStage.setScene(rootScene));

      }
     }
    );

	    // setting player names and initial positions
	    player1 = new Player("", 1, 1, "player1.png");
	    player2 = new Player("", 1, 0, "player2.png");
	    turn = player1;

      VBox notePad = new VBox(20);
      // setting preferred width for VBox notePad
      notePad.setPrefWidth(150);

      HBox statusBar = new HBox();
      statusBar.setPrefWidth(600);
      //Making insets for nodes
      Insets insetOne = new Insets(10,10,10,10);


      // Creating and Adding Buttons for VBox actionKeys
      Button rollDice = new Button("Roll Dice");
	    Button endTurn = new Button("End Turn");
      Button suspectPlayer = new Button("Suspect Player");
      Button accusePlayer = new Button("Accuse Player");
	    Label moveAmount = new Label("Movement Allowed: ");

	    Button moveLeft = new Button("Move Left");
	    moveLeft.setOnAction(new EventHandler<ActionEvent>()
	    {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{

	   	turn.setPlayerPosition(-1, 0);
			grid.getChildren().clear(); //clears Board
      // Redrawing Board
      for (int i = 0 ; i < 25  ; i++){

          Button button = new Button();
		      HBox[] boxes = displayPlayers(player1, player2);
		      if(player1.getPlayerPosition()[0] == i % 5 && player1.getPlayerPosition()[1] == i / 5)
			       button.setGraphic(boxes[0]);
		      if(player2.getPlayerPosition()[0] == i % 5 && player2.getPlayerPosition()[1] == i / 5)
			       button.setGraphic(boxes[1]);
             button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		         moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
		         grid.add(button, i % 5, i / 5);

        }
          grid.setGridLinesVisible(true);
	   	}
	   }
	  );

      Button moveRight = new Button("Move Right");
	  	moveRight.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   	turn.setPlayerPosition(1, 0);
			grid.getChildren().clear(); //clears Board
      // Redrawing Board
      for (int i = 0 ; i < 25  ; i++){
          Button button =  new Button();
          grid.setGridLinesVisible(true);
		      HBox[] boxes = displayPlayers(player1, player2);
		  if(player1.getPlayerPosition()[0] == i % 5 && player1.getPlayerPosition()[1] == i / 5)
			    button.setGraphic(boxes[0]);
		  if(player2.getPlayerPosition()[0] == i % 5 && player2.getPlayerPosition()[1] == i / 5)
			    button.setGraphic(boxes[1]);
		      button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		      moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
          grid.add(button, i % 5, i / 5);
        }
          grid.setGridLinesVisible(true);
	   	}
	   }
	  );

	  Button moveUp = new Button("Move Up");
	  	moveUp.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		turn.setPlayerPosition(0, -1);
			grid.getChildren().clear(); //clears Board
// Redrawing Board
      for (int i = 0 ; i < 25  ; i++){
          Button button =  new Button();
          grid.setGridLinesVisible(true);
		  HBox[] boxes = displayPlayers(player1, player2);
		  if(player1.getPlayerPosition()[0] == i % 5 && player1.getPlayerPosition()[1] == i / 5)
			  button.setGraphic(boxes[0]);
		  if(player2.getPlayerPosition()[0] == i % 5 && player2.getPlayerPosition()[1] == i / 5)
			  button.setGraphic(boxes[1]);
		  button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		  moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
          grid.add(button, i % 5, i / 5);
        }
          grid.setGridLinesVisible(true);
	   	}
	   }
	  );

      Button moveDown = new Button("Move Down");
	  	moveDown.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   	turn.setPlayerPosition(0, 1);
			grid.getChildren().clear(); //clears Board
      // Redrawing Board

      for (int i = 0 ; i < 25  ; i++){
          Button button = new Button();
		      HBox[] boxes = displayPlayers(player1, player2);
		  if(player1.getPlayerPosition()[0] == i % 5 && player1.getPlayerPosition()[1] == i / 5)
			    button.setGraphic(boxes[0]);
          grid.setGridLinesVisible(true);
		  if(player2.getPlayerPosition()[0] == i % 5 && player2.getPlayerPosition()[1] == i / 5)
			    button.setGraphic(boxes[1]);
		      button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		      moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
          grid.add(button, i % 5, i / 5);

        }
        grid.setGridLinesVisible(true);

	  }
	   }
	  );

      Cards c = new Cards();
    c.setAllCards();

    ArrayList<String> playerOne = new ArrayList<>(c.getPlayerOnesHand());
    ArrayList<String> playerTwo = new ArrayList<>(c.getPlayerTwosHand());

/**
Beginning all of the hard-coded rectangles and
the corresponding labels for all 12 cards;
6 cards per each players hand
*/


//setting up HBox so they will all be beside one another
    HBox h = new HBox();
    HBox h2 = new HBox();
    HBox h3 = new HBox();
    HBox h4 = new HBox();
    HBox h5 = new HBox();
    HBox h6 = new HBox();
    HBox h7 = new HBox();
    HBox h8 = new HBox();
    HBox cardGUI = new HBox();

    VBox v = new VBox();
    VBox v2 = new VBox();
    VBox v3 = new VBox();
    VBox v4 = new VBox();

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
    StackPane stack13 = new StackPane();
    StackPane stack14 = new StackPane();
    StackPane stack15 = new StackPane();
    StackPane stack16 = new StackPane();
    StackPane stack17 = new StackPane();
    StackPane stack18 = new StackPane();
    StackPane stack19 = new StackPane();
    StackPane stack20 = new StackPane();
    StackPane stack21 = new StackPane();
    StackPane stack22 = new StackPane();
    StackPane stack23 = new StackPane();
    StackPane stack24 = new StackPane();

    StackPane stack25 = new StackPane();
    StackPane stack26 = new StackPane();

     ImageView cardBack1 = new ImageView(getClass().getResource("PlayingCard.jpg").toExternalForm());
          cardBack1.setFitHeight(50);
          cardBack1.setFitWidth(100);

          ImageView cardBack2 = new ImageView(getClass().getResource("PlayingCard.jpg").toExternalForm());
          cardBack2.setFitHeight(50);
          cardBack2.setFitWidth(100);

          ImageView cardBack3 = new ImageView(getClass().getResource("PlayingCard.jpg").toExternalForm());
          cardBack3.setFitHeight(50);
          cardBack3.setFitWidth(100);

          ImageView cardBack4 = new ImageView(getClass().getResource("PlayingCard.jpg").toExternalForm());
          cardBack4.setFitHeight(50);
          cardBack4.setFitWidth(100);

          ImageView cardBack5 = new ImageView(getClass().getResource("PlayingCard.jpg").toExternalForm());
          cardBack5.setFitHeight(50);
          cardBack5.setFitWidth(100);

          ImageView cardBack6 = new ImageView(getClass().getResource("PlayingCard.jpg").toExternalForm());
          cardBack6.setFitHeight(50);
          cardBack6.setFitWidth(100);

          ImageView cardBack7 = new ImageView(getClass().getResource("PlayingCard2.jpg").toExternalForm());
          cardBack7.setFitHeight(50);
          cardBack7.setFitWidth(100);

          ImageView cardBack8 = new ImageView(getClass().getResource("PlayingCard2.jpg").toExternalForm());
          cardBack8.setFitHeight(50);
          cardBack8.setFitWidth(100);

          ImageView cardBack9 = new ImageView(getClass().getResource("PlayingCard2.jpg").toExternalForm());
          cardBack9.setFitHeight(50);
          cardBack9.setFitWidth(100);

          ImageView cardBack10 = new ImageView(getClass().getResource("PlayingCard2.jpg").toExternalForm());
          cardBack10.setFitHeight(50);
          cardBack10.setFitWidth(100);

          ImageView cardBack11 = new ImageView(getClass().getResource("PlayingCard2.jpg").toExternalForm());
          cardBack11.setFitHeight(50);
          cardBack11.setFitWidth(100);

          ImageView cardBack12 = new ImageView(getClass().getResource("PlayingCard2.jpg").toExternalForm());
          cardBack12.setFitHeight(50);
          cardBack12.setFitWidth(100);

          ImageView titlePicture1 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player = new Label(playerOne.get(0));
          player.setTextFill(Color.RED);
          titlePicture1.setFitHeight(50);
          titlePicture1.setFitWidth(100);
      //player one, card two
          ImageView titlePicture2 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label playertwo = new Label(playerOne.get(1));
          playertwo.setTextFill(Color.RED);
          titlePicture2.setFitHeight(50);
          titlePicture2.setFitWidth(100);
      //player one, card three
          ImageView titlePicture3 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player3 = new Label(playerOne.get(2));
          player3.setTextFill(Color.RED);
          titlePicture3.setFitHeight(50);
          titlePicture3.setFitWidth(100);
      //player one, card four
          ImageView titlePicture4 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player4 = new Label(playerOne.get(3));
          player4.setTextFill(Color.RED);
          titlePicture4.setFitHeight(50);
          titlePicture4.setFitWidth(100);
      //player one, card five
          ImageView titlePicture5 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player5 = new Label(playerOne.get(4));
          player5.setTextFill(Color.RED);
          titlePicture5.setFitHeight(50);
          titlePicture5.setFitWidth(100);
      //player one, card six
          ImageView titlePicture6 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player6 = new Label(playerOne.get(5));
          player6.setTextFill(Color.RED);
          titlePicture6.setFitHeight(50);
          titlePicture6.setFitWidth(100);

          //player two, card one
          ImageView titlePicture7 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player7 = new Label(playerTwo.get(0));
          player7.setTextFill(Color.BLUE);
          titlePicture7.setFitHeight(50);
          titlePicture7.setFitWidth(100);
      //player two, card two
          ImageView titlePicture8 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player8 = new Label(playerTwo.get(1));
          player8.setTextFill(Color.BLUE);
          titlePicture8.setFitHeight(50);
          titlePicture8.setFitWidth(100);
      //player two, card three
          ImageView titlePicture9 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player9 = new Label(playerTwo.get(2));
          player9.setTextFill(Color.BLUE);
          titlePicture9.setFitHeight(50);
          titlePicture9.setFitWidth(100);
      //player two, card four
          ImageView titlePicture10 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player10 = new Label(playerTwo.get(3));
          player10.setTextFill(Color.BLUE);
          titlePicture10.setFitHeight(50);
          titlePicture10.setFitWidth(100);
      //player two, card five
          ImageView titlePicture11 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player11 = new Label(playerTwo.get(4));
          player11.setTextFill(Color.BLUE);
          titlePicture11.setFitHeight(50);
          titlePicture11.setFitWidth(100);
      //player two, card six
          ImageView titlePicture12 = new ImageView(getClass().getResource("PlayingCardFront.jpg").toExternalForm());
          Label player12 = new Label(playerTwo.get(5));
          player12.setTextFill(Color.BLUE);
          titlePicture12.setFitHeight(50);
          titlePicture12.setFitWidth(100);


          stack.getChildren().addAll(titlePicture1, player);
          stack2.getChildren().addAll(titlePicture2, playertwo);
          stack3.getChildren().addAll(titlePicture3, player3);
          stack4.getChildren().addAll(titlePicture4, player4);
          stack5.getChildren().addAll(titlePicture5, player5);
          stack6.getChildren().addAll(titlePicture6, player6);
          stack7.getChildren().addAll(titlePicture7, player7);
          stack8.getChildren().addAll(titlePicture8, player8);
          stack9.getChildren().addAll(titlePicture9, player9);
          stack10.getChildren().addAll(titlePicture10, player10);
          stack11.getChildren().addAll(titlePicture11, player11);
          stack12.getChildren().addAll(titlePicture12, player12);

          stack13.getChildren().addAll(cardBack1);
          stack14.getChildren().addAll(cardBack2);
          stack15.getChildren().addAll(cardBack3);
          stack16.getChildren().addAll(cardBack4);
          stack17.getChildren().addAll(cardBack5);
          stack18.getChildren().addAll(cardBack6);
          stack19.getChildren().addAll(cardBack7);
          stack20.getChildren().addAll(cardBack8);
          stack21.getChildren().addAll(cardBack9);
          stack22.getChildren().addAll(cardBack10);
          stack23.getChildren().addAll(cardBack11);
          stack24.getChildren().addAll(cardBack12);

          h.getChildren().addAll(stack, stack2, stack3);
          h2.getChildren().addAll(stack4, stack5, stack6);
          h3.getChildren().addAll(stack7, stack8, stack9);
          h4.getChildren().addAll(stack10, stack11, stack12);

          h5.getChildren().addAll(stack13, stack14, stack15);
          h6.getChildren().addAll(stack16, stack17, stack18);
          h7.getChildren().addAll(stack19, stack20, stack21);
          h8.getChildren().addAll(stack22, stack23, stack24);

          v.getChildren().addAll(h, h2);
          v2.getChildren().addAll(h3, h4);

          v3.getChildren().addAll(h5, h6);
          v4.getChildren().addAll(h7, h8);

          stack25.getChildren().addAll(v, v3);
          stack26.getChildren().addAll(v2, v4);

          v3.setVisible(false);

          cardGUI.getChildren().addAll(stack25, stack26);

   
	  endTurn.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		if (turn == player1){
					turn = player2;

          v3.setVisible(true);
          v4.setVisible(false);
         
        }
				else{
					turn = player1;

          v3.setVisible(false);
          v4.setVisible(true);


        }
    }
	   }
	  );

  


	      // Creates ComboBox of type string, adds suspects to it
    ComboBox<String> peopleBox = new ComboBox<String>();
    peopleBox.getItems().addAll(
    "Miss Scarlet",
    "Mr. Green",
    "Mrs. White",
    "Prof Plum");
    peopleBox.setPromptText("People");
    //Creates ComboBox type string, adds weapons
    ComboBox<String> weaponBox = new ComboBox<String>();
    weaponBox.getItems().addAll(
    "Revolver",
    "Bucket",
    "Candlestick",
    "Trophy",
    "Horse Shoe");
    weaponBox.setPromptText("Weapons");

    //event handlers for suspect and accuse buttons

    accusePlayer.setOnAction(new EventHandler<ActionEvent>()
     {
      @Override
      public void handle(ActionEvent event)
      {
        System.out.println("Who would you like to accuse?");
    }
     }
    );

    suspectPlayer.setOnAction(new EventHandler<ActionEvent>()
     {
      @Override
      public void handle(ActionEvent event)
      {
        System.out.println("Who would you like to suspect?");
    }
     }
    );


  // Event handler for ComboBox, first time trying this
    peopleBox.setOnAction(new EventHandler<ActionEvent>()
     {
      @Override
      public void handle(ActionEvent event)
      {
        String selected = peopleBox.getValue();
        System.out.println(selected);
    }
     }
    );

    weaponBox.setOnAction(new EventHandler<ActionEvent>()
     {
      @Override
      public void handle(ActionEvent event)
      {
        String selected = weaponBox.getValue();
        System.out.println(selected);
    }
     }
    );

      actionKeys.getChildren().addAll(suspectPlayer,accusePlayer,peopleBox,weaponBox,moveLeft,moveRight,moveUp,moveDown, endTurn);





	  // Anon inner class
      rollDice.setOnAction(new EventHandler<ActionEvent>()
      {
        @Override
        public void handle(ActionEvent event)
        {
          BoardGUI p = new BoardGUI();
		      int move = p.diceRoll();
          moveAmount.setText("Movements Allowed: " + Integer.toString(move));
			    turn.setMoveAmount(move);

        }
      });

        actionKeys.getChildren().add(rollDice);
	      actionKeys.getChildren().add(moveAmount);



      // Makes the rows and columns a dynamic size
      for (int row = 0 ; row < numRows ; row++ ){
          RowConstraints rc = new RowConstraints();
          rc.setFillHeight(true);
          rc.setVgrow(Priority.ALWAYS);
          grid.getRowConstraints().add(rc);
        }

      for (int col = 0 ; col < numColumns; col++ ){
          ColumnConstraints cc = new ColumnConstraints();
          cc.setFillWidth(true);
          cc.setHgrow(Priority.ALWAYS);
          grid.getColumnConstraints().add(cc);
        }


      // Makes the buttons in a 5 x 5
      for (int i = 0 ; i < 25  ; i++){
          Button button = new Button();
		      button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		      HBox[] boxes = displayPlayers(player1, player2);
		      if(player1.getPlayerPosition()[0] == i % 5 && player1.getPlayerPosition()[1] == i / 5)
			       button.setGraphic(boxes[0]);
		      if(player2.getPlayerPosition()[0] == i % 5 && player2.getPlayerPosition()[1] == i / 5)
			       button.setGraphic(boxes[1]);
             grid.add(button, i % 5, i / 5);
        }


      CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem<String> ("Player One");
      CheckBoxTreeItem<String> rootItem2 = new CheckBoxTreeItem<String> ("Player Two");

      rootItem.setExpanded(true);
      rootItem2.setExpanded(true);


/*  THe following is the GUI for the notepad, I had to do the
 long way for a couple of things, because for some reason addAll wasnt working
 for some nodes. This is my first time working with th UI nodes so im sure
 ill get more proficient
*/


        VBox rootRight = new VBox();

        //Secondary branches

        //PLayer 1
        CheckBoxTreeItem<String> people = new CheckBoxTreeItem<String> ("People");
        CheckBoxTreeItem<String> places = new CheckBoxTreeItem<String> ("Places");
        CheckBoxTreeItem<String> items = new CheckBoxTreeItem<String> ("Items");

        //PLayer 2
        CheckBoxTreeItem<String> people2 = new CheckBoxTreeItem<String> ("People");
        CheckBoxTreeItem<String> places2 = new CheckBoxTreeItem<String> ("Places");
        CheckBoxTreeItem<String> items2 = new CheckBoxTreeItem<String> ("Items");
        // Tertiary branches

        //Player 1 People
        CheckBoxTreeItem<String> person1 = new CheckBoxTreeItem<String> ("Miss Scarlet");
        CheckBoxTreeItem<String> person2 = new CheckBoxTreeItem<String> ("Mr. Green");
        CheckBoxTreeItem<String> person3 = new CheckBoxTreeItem<String> ("Mrs.White");
        CheckBoxTreeItem<String> person4 = new CheckBoxTreeItem<String> ("Prof. Plum");

        //Player 2 people
        CheckBoxTreeItem<String> person12 = new CheckBoxTreeItem<String> ("Miss Scarlet");
        CheckBoxTreeItem<String> person22 = new CheckBoxTreeItem<String> ("Mr. Green");
        CheckBoxTreeItem<String> person32 = new CheckBoxTreeItem<String> ("Mrs.White");
        CheckBoxTreeItem<String> person42 = new CheckBoxTreeItem<String> ("Prof. Plum");

        //Player 1 places
        CheckBoxTreeItem<String> place1 = new CheckBoxTreeItem<String> ("Kitchen");
        CheckBoxTreeItem<String> place2 = new CheckBoxTreeItem<String> ("Library");
        CheckBoxTreeItem<String> place3 = new CheckBoxTreeItem<String> ("Lounge");
        CheckBoxTreeItem<String> place4 = new CheckBoxTreeItem<String> ("Dining Room");
        CheckBoxTreeItem<String> place5 = new CheckBoxTreeItem<String> ("Study");
        CheckBoxTreeItem<String> place6 = new CheckBoxTreeItem<String> ("Billiard Room");

        //Player 2 places
        CheckBoxTreeItem<String> place12 = new CheckBoxTreeItem<String> ("Kitchen");
        CheckBoxTreeItem<String> place22 = new CheckBoxTreeItem<String> ("Library");
        CheckBoxTreeItem<String> place32 = new CheckBoxTreeItem<String> ("Lounge");
        CheckBoxTreeItem<String> place42 = new CheckBoxTreeItem<String> ("Dining Room");
        CheckBoxTreeItem<String> place52 = new CheckBoxTreeItem<String> ("Study");
        CheckBoxTreeItem<String> place62 = new CheckBoxTreeItem<String> ("Billiard Room");

        //Player 1 items
        CheckBoxTreeItem<String> item1 = new CheckBoxTreeItem<String> ("Trophy");
        CheckBoxTreeItem<String> item2 = new CheckBoxTreeItem<String> ("Revolver");
        CheckBoxTreeItem<String> item3 = new CheckBoxTreeItem<String> ("Candlestick");
        CheckBoxTreeItem<String> item4 = new CheckBoxTreeItem<String> ("Bucket");
        CheckBoxTreeItem<String> item5 = new CheckBoxTreeItem<String> ("Horse Shoe");

        //Player 2 items2
        CheckBoxTreeItem<String> item12 = new CheckBoxTreeItem<String> ("Trophy");
        CheckBoxTreeItem<String> item22 = new CheckBoxTreeItem<String> ("Revolver");
        CheckBoxTreeItem<String> item32 = new CheckBoxTreeItem<String> ("Candlestick");
        CheckBoxTreeItem<String> item42 = new CheckBoxTreeItem<String> ("Bucket");
        CheckBoxTreeItem<String> item52 = new CheckBoxTreeItem<String> ("Horse Shoe");

  /* Not sure why this doesnt work ??
        people.getChildren().addAll(person1,person2,person3,person4);
        places.getChildren().addAll(place1,place2,place3,place4,place5,place6);
        items.getChildren().addAll(item1,item2,item3,item4,item5);
      So I have to do it the long way
  */
        people.getChildren().add(person1);
        people.getChildren().add(person2);
        people.getChildren().add(person3);
        people.getChildren().add(person4);

        places.getChildren().add(place1);
        places.getChildren().add(place2);
        places.getChildren().add(place3);
        places.getChildren().add(place4);
        places.getChildren().add(place5);
        places.getChildren().add(place6);

        items.getChildren().add(item1);
        items.getChildren().add(item2);
        items.getChildren().add(item3);
        items.getChildren().add(item4);
        items.getChildren().add(item5);

        //Player 2
        people2.getChildren().add(person12);
        people2.getChildren().add(person22);
        people2.getChildren().add(person32);
        people2.getChildren().add(person42);

        places2.getChildren().add(place12);
        places2.getChildren().add(place22);
        places2.getChildren().add(place32);
        places2.getChildren().add(place42);
        places2.getChildren().add(place52);
        places2.getChildren().add(place62);

        items2.getChildren().add(item12);
        items2.getChildren().add(item22);
        items2.getChildren().add(item32);
        items2.getChildren().add(item42);
        items2.getChildren().add(item52);

        rootItem.getChildren().add(people);
        rootItem.getChildren().add(places);
        rootItem.getChildren().add(items);

        rootItem2.getChildren().add(people2);
        rootItem2.getChildren().add(places2);
        rootItem2.getChildren().add(items2);


        //Player 1 notebook
         TreeView<String> checkTree = new TreeView<String>();
        checkTree.setRoot(rootItem);
        checkTree.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

        //Plaer 2 notebook
         TreeView<String> checkTree2 = new TreeView<String>();
        checkTree2.setRoot(rootItem2);
        checkTree2.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

        //Not sure if there is a method for setting all leaves setIndependent
        //So I did it the long way
        people.setIndependent(true);
        rootItem.setIndependent(true);
        items.setIndependent(true);
        places.setIndependent(true);

        people2.setIndependent(true);
        rootItem2.setIndependent(true);
        items2.setIndependent(true);
        places2.setIndependent(true);


        rootRight.getChildren().addAll(checkTree,checkTree2);


    Image image = new Image("clue-image.png");
    ImageView imageV = new ImageView();
    imageV.setImage(image);

    StackPane stackMid = new StackPane();
    stackMid.getChildren().addAll(imageV,grid);

      root.setCenter(stackMid);
      root.setLeft(actionKeys);
      root.setRight(rootRight);
      root.setTop(cardGUI);
      root.setPadding(insetOne);

      Music m = new Music();
      m.playMusic("C:\\Users\\Hailey\\Downloads\\j\\Final\\pinkpanther.wav");

      grid.getStylesheets().add(getClass().getResource("cluecss.css").toExternalForm());
      primaryStage.setTitle("BoardGUI");
      primaryStage.setScene(titleScene);
      primaryStage.show();


    }//END OF START




  }//END OF APP
