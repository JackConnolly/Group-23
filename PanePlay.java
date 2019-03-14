/**
* This is the GUI Board for the Game Clue
* @author Jack Connolly, Anna Barrett, Kylie Sicat, Hailey Allen, Jung Ho Kim
* last updated by: Kylie Sicat
* @since 03-13-19
*/
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

/**
* GUI class for Board Game Clue
*/
  public class PanePlay extends Application{

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

/** Creates private button to handle events
*/
    private Button createButton(String text){
    	Button createB = new Button(text);
    	createB.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);// Max val is a constant
    	createB.setOnAction(e -> System.out.println(text));// Setting up the action to print the text to console
      return createB;
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
		  }
		  else {
			  hBox1.getChildren().addAll(token1);
			  hBox2.getChildren().addAll(token2);
		  }	  
		  HBox[] boxes = new HBox[]{hBox1, hBox2};
		  return boxes;
	  }

    public void start(Stage primaryStage) throws Exception{
      //Setup the 2d array

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

      //Creating Labels for the places
      Label library = new Label("Library");
      Label kitchen = new Label("Kitchen");
      Label livingRoom = new Label("Living Room");
      Label diningRoom = new Label("Dining Room");
      Label office = new Label("Office");
      Label bedroom = new Label("Bedroom");
      notePad.getChildren().addAll(library, kitchen, livingRoom, diningRoom, office, bedroom);
     

      //Creating Labels for the people
      Label ppl1 = new Label("Miss Scarlet");
      Label ppl2 = new Label("Mr.Green");
      Label ppl3 = new Label("Mrs.White");
      Label ppl4 = new Label("Professor Plum");
      notePad.getChildren().addAll(ppl1, ppl2, ppl3, ppl4);
     
      //Creating Labels for the weapons
      Label candlestick = new Label("Candlestick");
      Label horseshoe = new Label("Horseshoe");
      Label waterBucket = new Label("Water Bucket");
      Label trophy = new Label("Trophy");
      Label revolver = new Label("Revolver");
      notePad.getChildren().addAll(candlestick, horseshoe, waterBucket, trophy, revolver);

	  
	  // Anon inner class
      rollDice.setOnAction(new EventHandler<ActionEvent>()
      {
        @Override
        public void handle(ActionEvent event)
        {
          PanePlay p = new PanePlay();
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


      root.setCenter(grid);
      root.setLeft(actionKeys);
      root.setRight(notePad);
      root.setTop(statusBar);
      root.setPadding(insetOne);




      Scene scene = new Scene(root, 800, 600);
      primaryStage.setTitle("PANE PLAY");
      primaryStage.setScene(scene);
      primaryStage.show();




    }//END OF START




  }//END OF APP