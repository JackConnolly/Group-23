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
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.control.CheckBoxTreeItem;

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
		      HBox[] boxes = displayPlayers(player1, player2);
		  if(player1.getPlayerPosition()[0] == i % 5 && player1.getPlayerPosition()[1] == i / 5)
			    button.setGraphic(boxes[0]);
		  if(player2.getPlayerPosition()[0] == i % 5 && player2.getPlayerPosition()[1] == i / 5)
			    button.setGraphic(boxes[1]);
		      button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		      moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
          grid.add(button, i % 5, i / 5);
        }
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
		  HBox[] boxes = displayPlayers(player1, player2);
		  if(player1.getPlayerPosition()[0] == i % 5 && player1.getPlayerPosition()[1] == i / 5)
			  button.setGraphic(boxes[0]);
		  if(player2.getPlayerPosition()[0] == i % 5 && player2.getPlayerPosition()[1] == i / 5)
			  button.setGraphic(boxes[1]);
		  button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		  moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
          grid.add(button, i % 5, i / 5);
        }
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
		  if(player2.getPlayerPosition()[0] == i % 5 && player2.getPlayerPosition()[1] == i / 5)
			    button.setGraphic(boxes[1]);
		      button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		      moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
          grid.add(button, i % 5, i / 5);
        }
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
      actionKeys.getChildren().addAll(suspectPlayer,moveLeft,moveRight,moveUp,moveDown, endTurn);




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
/*  THe following is the GUI for the notepad, I had to do the
 long way for a couple of things, because for some reason addAll wasnt working
 for some nodes. This is my first time working with th UI nodes so im sure
 ill get more proficient
*/


        VBox rootRight = new VBox();

        // Root item is master branch of tree
        CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem<String> ("Player One");
        CheckBoxTreeItem<String> rootItem2 = new CheckBoxTreeItem<String> ("Player Two");



        //Secondary branches

        //PLayer 1
        CheckBoxTreeItem<String> people = new CheckBoxTreeItem<String> ("People");
        CheckBoxTreeItem<String> places = new CheckBoxTreeItem<String> ("Rooms");
        CheckBoxTreeItem<String> items = new CheckBoxTreeItem<String> ("Items");

        //PLayer 2
        CheckBoxTreeItem<String> people2 = new CheckBoxTreeItem<String> ("People");
        CheckBoxTreeItem<String> places2 = new CheckBoxTreeItem<String> ("Rooms");
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
        CheckBoxTreeItem<String> place3 = new CheckBoxTreeItem<String> ("Living Room");
        CheckBoxTreeItem<String> place4 = new CheckBoxTreeItem<String> ("Dining Room");
        CheckBoxTreeItem<String> place5 = new CheckBoxTreeItem<String> ("Office");
        CheckBoxTreeItem<String> place6 = new CheckBoxTreeItem<String> ("Bedroom");

        //Player 2 places
        CheckBoxTreeItem<String> place12 = new CheckBoxTreeItem<String> ("Kitchen");
        CheckBoxTreeItem<String> place22 = new CheckBoxTreeItem<String> ("Library");
        CheckBoxTreeItem<String> place32 = new CheckBoxTreeItem<String> ("Living Room");
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


      root.setCenter(grid);
      root.setLeft(actionKeys);
      root.setRight(rootRight);
      root.setTop(statusBar);
      root.setPadding(insetOne);




      Scene scene = new Scene(root, 800, 600);
      primaryStage.setTitle("Group 23 CLUE");
      primaryStage.setScene(scene);
      primaryStage.show();




    }//END OF START




  }//END OF APP
