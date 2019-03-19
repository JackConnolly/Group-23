/*
* This is a tester program for javafx, as well as
* a tester for javadoc
* @author Jack Connolly
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

  public class PanePlay extends Application{

	//game variables
	private Player player1;
	private Player player2;
	private Player turn;
	
    // Variables for the dynamic buttons
    private int numRows = 5;
    private int numColumns = 5;
	
	    //Dice roll class is here for my own sake of debugging the board
  public int diceRoll(){
   int min = 1;
   int max = 6;
   int rollAmount = (int)(Math.random() * max) + 1;
   System.out.println(rollAmount);
   return rollAmount;
 }

    public static void main(String[] args){
      launch(args);
    }

/* Creates private button to handle events
*/
    private Button createButton(String text){
      Button createB = new Button(text);
      createB.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);// Max val is a constant
      createB.setOnAction(e -> System.out.println(text));// Setting up the action to print the text to console
      return createB;
      }
	  
	  	  /* Function to check player position and display image onto button
	  */
	  public HBox[] displayPlayers(Player player1, Player player2){
		  HBox hBox1 = new HBox();
		  HBox hBox2 = new HBox();
		  Label label = new Label(" ");
		  ImageView token1 = new ImageView( getClass().getResource(player1.getPlayerToken()).toExternalForm());
          ImageView token2 = new ImageView( getClass().getResource(player2.getPlayerToken()).toExternalForm());
			  hBox1.getChildren().addAll(token1);
			  hBox2.getChildren().addAll(token2);
		   
		  HBox[] boxes = new HBox[]{hBox1, hBox2};
		  return boxes;
	  }
	  
	  //Function to clear and redraw the board
	  //needs the players, label of moveAmount, and the pane as inputs
	  public void drawBoard(Player player1, Player player2, GridPane grid){
		  grid.getChildren().clear(); //clears Board
				
      for (int i = 0 ; i < 25  ; i++){ // Redrawing Board
          Button button =  new Button();
		  HBox[] boxes = displayPlayers(player1, player2);
		  if(player1.getXPosition() == i % 5 && player1.getYPosition() == i / 5)
			  button.setGraphic(boxes[0]);
		  if(player2.getXPosition() == i % 5 && player2.getYPosition() == i / 5)
			  button.setGraphic(boxes[1]);
		  button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
          grid.add(button, i % 5, i / 5);
        }
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
			drawBoard(player1, player2, grid);
			moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
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
			drawBoard(player1, player2, grid);
			moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
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
			drawBoard(player1, player2, grid);
			moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
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
			drawBoard(player1, player2, grid);
			moveAmount.setText("Movements Allowed: " + Integer.toString(turn.getMoveAmount()));
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
      actionKeys.getChildren().addAll(suspectPlayer,moveLeft,moveRight,moveUp,moveDown,endTurn);




      //Creating and Adding buttons to Vbox notePad
      Button yesChar= new Button("Yes");
      Button noChar = new Button("No");
      Button yesWeapon = new Button("Yes");
      Button noWeapon = new Button("No");
      notePad.getChildren().addAll(yesChar,noChar,yesWeapon,noWeapon);
	  
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
		drawBoard(player1, player2, grid);


      root.setCenter(grid);
      root.setLeft(actionKeys);
      root.setRight(notePad);
      root.setTop(statusBar);
      root.setPadding(insetOne);


      //grid.setGridLinesVisible(true);




      Scene scene = new Scene(root, 800, 600);
      primaryStage.setTitle("PANE PLAY");
      primaryStage.setScene(scene);
      primaryStage.show();




    }//END OF START




  }//END OF APP