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
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.input.KeyCode;
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

/**
* This is the GUI Board for the Game Clue, as per feedback from Demo 2 we re trying to
* remove logic from the GUI
* @author Jack Connolly, Anna Barrett, Kylie Sicat, Hailey Allen, Jung Ho Kim
* last updated by: Jack Connolly
* @since 03-13-19
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

	    // setting player names and initial positions
	    player1 = new Player("Anna", 1, 1, "player1.png");
	    player2 = new Player("Jack", 1, 0, "player2.png");
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
             if (i == 0){
               //button.setText("Library");
               Image i2 = new Image("book2.jpg");
               ImageView iv2 = new ImageView();
               iv2.setImage(i2);
               iv2.setFitWidth(50);
               iv2.setFitHeight(50);
               //iv2.setPreserveRatio(true);
               //iv2.setSmooth(true);
               //iv2.setCache(true);
               button.setGraphic(iv2);
             }
             if (i == 4){
               //button.setText("Kitchen");
               //button.setGraphic(ImageView iv2 = new ImageView("library.png"));
               Image i2 = new Image("dining.jpg");
               ImageView iv2 = new ImageView();
               iv2.setImage(i2);
               iv2.setFitWidth(50);
               iv2.setFitHeight(50);
               //iv2.setPreserveRatio(true);
               //iv2.setSmooth(true);
               //iv2.setCache(true);
               button.setGraphic(iv2);

             }
             if (i == 10){
              // button.setText("Living Room");
              Image i2 = new Image("kitchen.png");
              ImageView iv2 = new ImageView();
              iv2.setImage(i2);
              iv2.setFitWidth(50);
              iv2.setFitHeight(50);
              //iv2.setPreserveRatio(true);
              //iv2.setSmooth(true);
              //iv2.setCache(true);
              button.setGraphic(iv2);
             }
             if (i == 14){
               //button.setText("Dining Room");
               Image i2 = new Image("study.png");
               ImageView iv2 = new ImageView();
               iv2.setImage(i2);
               iv2.setFitWidth(50);
               iv2.setFitHeight(50);
               //iv2.setPreserveRatio(true);
               //iv2.setSmooth(true);
               //iv2.setCache(true);
               button.setGraphic(iv2);
             }
             if (i == 20){
               //button.setText("Bedroom");
               Image i2 = new Image("lounge.png");
               ImageView iv2 = new ImageView();
               iv2.setImage(i2);
               iv2.setFitWidth(60);
               iv2.setFitHeight(50);
               //iv2.setPreserveRatio(true);
               //iv2.setSmooth(true);
               //iv2.setCache(true);
               button.setGraphic(iv2);
             }
             if (i == 24){
              //button.setText("Office");
              Image i2 = new Image("billiards.png");
              ImageView iv2 = new ImageView();
              iv2.setImage(i2);
              iv2.setFitWidth(60);
              iv2.setFitHeight(50);
              //iv2.setPreserveRatio(true);
              //iv2.setSmooth(true);
              //iv2.setCache(true);
              button.setGraphic(iv2);
             }

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
          if (i == 0){
            //button.setText("Library");
            Image i2 = new Image("book2.jpg");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(50);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);
          }
          if (i == 4){
            //button.setText("Kitchen");
            //button.setGraphic(ImageView iv2 = new ImageView("library.png"));
            Image i2 = new Image("dining.jpg");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(50);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);

          }
          if (i == 10){
           // button.setText("Living Room");
           Image i2 = new Image("kitchen.png");
           ImageView iv2 = new ImageView();
           iv2.setImage(i2);
           iv2.setFitWidth(50);
           iv2.setFitHeight(50);
           //iv2.setPreserveRatio(true);
           //iv2.setSmooth(true);
           //iv2.setCache(true);
           button.setGraphic(iv2);
          }
          if (i == 14){
            //button.setText("Dining Room");
            Image i2 = new Image("study.png");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(50);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);
          }
          if (i == 20){
            //button.setText("Bedroom");
            Image i2 = new Image("lounge.png");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(60);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);
          }
          if (i == 24){
           //button.setText("Office");
           Image i2 = new Image("billiards.png");
           ImageView iv2 = new ImageView();
           iv2.setImage(i2);
           iv2.setFitWidth(60);
           iv2.setFitHeight(50);
           //iv2.setPreserveRatio(true);
           //iv2.setSmooth(true);
           //iv2.setCache(true);
           button.setGraphic(iv2);
          }
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
          if (i == 0){
            //button.setText("Library");
            Image i2 = new Image("book2.jpg");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(50);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);
          }
          if (i == 4){
            //button.setText("Kitchen");
            //button.setGraphic(ImageView iv2 = new ImageView("library.png"));
            Image i2 = new Image("dining.jpg");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(50);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);

          }
          if (i == 10){
           // button.setText("Living Room");
           Image i2 = new Image("kitchen.png");
           ImageView iv2 = new ImageView();
           iv2.setImage(i2);
           iv2.setFitWidth(50);
           iv2.setFitHeight(50);
           //iv2.setPreserveRatio(true);
           //iv2.setSmooth(true);
           //iv2.setCache(true);
           button.setGraphic(iv2);
          }
          if (i == 14){
            //button.setText("Dining Room");
            Image i2 = new Image("study.png");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(50);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);
          }
          if (i == 20){
            //button.setText("Bedroom");
            Image i2 = new Image("lounge.png");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(60);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);
          }
          if (i == 24){
           //button.setText("Office");
           Image i2 = new Image("billiards.png");
           ImageView iv2 = new ImageView();
           iv2.setImage(i2);
           iv2.setFitWidth(60);
           iv2.setFitHeight(50);
           //iv2.setPreserveRatio(true);
           //iv2.setSmooth(true);
           //iv2.setCache(true);
           button.setGraphic(iv2);
          }
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
          if (i == 0){
            //button.setText("Library");
            Image i2 = new Image("book2.jpg");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(50);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);
          }
          if (i == 4){
            //button.setText("Kitchen");
            //button.setGraphic(ImageView iv2 = new ImageView("library.png"));
            Image i2 = new Image("dining.jpg");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(50);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);

          }
          if (i == 10){
           // button.setText("Living Room");
           Image i2 = new Image("kitchen.png");
           ImageView iv2 = new ImageView();
           iv2.setImage(i2);
           iv2.setFitWidth(50);
           iv2.setFitHeight(50);
           //iv2.setPreserveRatio(true);
           //iv2.setSmooth(true);
           //iv2.setCache(true);
           button.setGraphic(iv2);
          }
          if (i == 14){
            //button.setText("Dining Room");
            Image i2 = new Image("study.png");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(50);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);
          }
          if (i == 20){
            //button.setText("Bedroom");
            Image i2 = new Image("lounge.png");
            ImageView iv2 = new ImageView();
            iv2.setImage(i2);
            iv2.setFitWidth(60);
            iv2.setFitHeight(50);
            //iv2.setPreserveRatio(true);
            //iv2.setSmooth(true);
            //iv2.setCache(true);
            button.setGraphic(iv2);
          }
          if (i == 24){
           //button.setText("Office");
           Image i2 = new Image("billiards.png");
           ImageView iv2 = new ImageView();
           iv2.setImage(i2);
           iv2.setFitWidth(60);
           iv2.setFitHeight(50);
           //iv2.setPreserveRatio(true);
           //iv2.setSmooth(true);
           //iv2.setCache(true);
           button.setGraphic(iv2);
          }

        }
        grid.setGridLinesVisible(true);

	  }
	   }
	  );

	  endTurn.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		if (turn == player1)
					turn = player2;
				else
					turn = player1;
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
          Label l1 = new Label("Test 1");
          Label l2 = new Label("Test2");
		      button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		      HBox[] boxes = displayPlayers(player1, player2);
		      if(player1.getPlayerPosition()[0] == i % 5 && player1.getPlayerPosition()[1] == i / 5)
			       button.setGraphic(boxes[0]);
		      if(player2.getPlayerPosition()[0] == i % 5 && player2.getPlayerPosition()[1] == i / 5)
			       button.setGraphic(boxes[1]);
             grid.add(button, i % 5, i / 5);
             if (i == 0){
               //button.setText("Library");
               Image i2 = new Image("book2.jpg");
               ImageView iv2 = new ImageView();
               iv2.setImage(i2);
               iv2.setFitWidth(50);
               iv2.setFitHeight(50);
               //iv2.setPreserveRatio(true);
               //iv2.setSmooth(true);
               //iv2.setCache(true);
               button.setGraphic(iv2);
             }
             if (i == 4){
               //button.setText("Kitchen");
               //button.setGraphic(ImageView iv2 = new ImageView("library.png"));
               Image i2 = new Image("dining.jpg");
               ImageView iv2 = new ImageView();
               iv2.setImage(i2);
               iv2.setFitWidth(50);
               iv2.setFitHeight(50);
               //iv2.setPreserveRatio(true);
               //iv2.setSmooth(true);
               //iv2.setCache(true);
               button.setGraphic(iv2);

             }
             if (i == 10){
              // button.setText("Living Room");
              Image i2 = new Image("kitchen.png");
              ImageView iv2 = new ImageView();
              iv2.setImage(i2);
              iv2.setFitWidth(50);
              iv2.setFitHeight(50);
              //iv2.setPreserveRatio(true);
              //iv2.setSmooth(true);
              //iv2.setCache(true);
              button.setGraphic(iv2);
             }
             if (i == 14){
               //button.setText("Dining Room");
               Image i2 = new Image("study.png");
               ImageView iv2 = new ImageView();
               iv2.setImage(i2);
               iv2.setFitWidth(50);
               iv2.setFitHeight(50);
               //iv2.setPreserveRatio(true);
               //iv2.setSmooth(true);
               //iv2.setCache(true);
               button.setGraphic(iv2);
             }
             if (i == 20){
               //button.setText("Bedroom");
               Image i2 = new Image("lounge.png");
               ImageView iv2 = new ImageView();
               iv2.setImage(i2);
               iv2.setFitWidth(60);
               iv2.setFitHeight(50);
               //iv2.setPreserveRatio(true);
               //iv2.setSmooth(true);
               //iv2.setCache(true);
               button.setGraphic(iv2);
             }
             if (i == 24){
              //button.setText("Office");
              Image i2 = new Image("billiards.png");
              ImageView iv2 = new ImageView();
              iv2.setImage(i2);
              iv2.setFitWidth(60);
              iv2.setFitHeight(50);
              //iv2.setPreserveRatio(true);
              //iv2.setSmooth(true);
              //iv2.setCache(true);
              button.setGraphic(iv2);
             }




        }
/*  THe following is the GUI for the notepad, I had to do the
 long way for a couple of things, because for some reason addAll wasnt working
 for some nodes. This is my first time working with th UI nodes so im sure
 ill get more proficient
*/


        VBox rootRight = new VBox();

        // Root item is master branch of tree
        CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem<String> ("Player One");
        CheckBoxTreeItem<String> rootItem2 = new CheckBoxTreeItem<String> ("Player Two");
        rootItem.setExpanded(true);
        rootItem2.setExpanded(true);



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
        CheckBoxTreeItem<String> place3 = new CheckBoxTreeItem<String> ("Kitchen");
        CheckBoxTreeItem<String> place4 = new CheckBoxTreeItem<String> ("Dining Room");
        CheckBoxTreeItem<String> place5 = new CheckBoxTreeItem<String> ("Office");
        CheckBoxTreeItem<String> place6 = new CheckBoxTreeItem<String> ("Bedroom");

        //Player 2 places
        CheckBoxTreeItem<String> place12 = new CheckBoxTreeItem<String> ("Kitchen");
        CheckBoxTreeItem<String> place22 = new CheckBoxTreeItem<String> ("Library");
        CheckBoxTreeItem<String> place32 = new CheckBoxTreeItem<String> ("Kitchen");
        CheckBoxTreeItem<String> place42 = new CheckBoxTreeItem<String> ("Dining Room");
        CheckBoxTreeItem<String> place52 = new CheckBoxTreeItem<String> ("Office");
        CheckBoxTreeItem<String> place62 = new CheckBoxTreeItem<String> ("Bedroom");

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
    HBox h = new HBox();
    HBox h2 = new HBox();
    HBox h3 = new HBox();
    HBox h4 = new HBox();
    HBox cardGUI = new HBox();

    VBox v = new VBox();
    VBox v2 = new VBox();

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

    cardGUI.getChildren().addAll(v, v2);

    // Starting on the css down here

    // background image settings
    Image image = new Image("clue-image-real.png");
    ImageView imageV = new ImageView();
    imageV.setImage(image);
    imageV.setFitWidth(400);
    imageV.setPreserveRatio(true);
    imageV.setSmooth(true);
    imageV.setCache(true);

    StackPane stackMid = new StackPane();
    stackMid.getChildren().addAll(imageV,grid);
    stackMid.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));

      root.setCenter(stackMid);
      root.setLeft(actionKeys);
      root.setRight(rootRight);
      root.setTop(cardGUI);
      root.setPadding(insetOne);


      Scene scene = new Scene(root, 800, 600);
      grid.getStylesheets().add(getClass().getResource("cluecss.css").toExternalForm());
      primaryStage.setTitle("BoardGUI");
      primaryStage.setScene(scene);
      primaryStage.setMaximized(true);
      primaryStage.show();




    }//END OF START




  }//END OF APP
