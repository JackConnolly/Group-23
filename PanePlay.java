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

  public class PanePlay extends Application{

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
	  Player player1 = new Player("Anna", 1, 1, "player1.png");
	  Player player2 = new Player("Jack", 1, 0, "player2.png");

      VBox notePad = new VBox(20);
      // setting preferred width for VBox notePad
      notePad.setPrefWidth(150);

      HBox statusBar = new HBox();
      statusBar.setPrefWidth(600);
      //Making insets for nodes
      Insets insetOne = new Insets(10,10,10,10);


      // Creating and Adding Buttons for VBox actionKeys
      Button rollDice = new Button("Roll Dice");
      Button suspectPlayer = new Button("Suspect Player");
      Button moveLeft = new Button("Move Left");
      Button moveRight = new Button("Move Right");
      Button moveUp = new Button("Move Up");
      Button moveDown = new Button("Move Down");
      actionKeys.getChildren().addAll(suspectPlayer,moveLeft,moveRight,moveUp,moveDown);


      //Creating and Adding buttons to Vbox notePad
      Button yesChar= new Button("Yes");
      Button noChar = new Button("No");
      Button yesWeapon = new Button("Yes");
      Button noWeapon = new Button("No");
      notePad.getChildren().addAll(yesChar,noChar,yesWeapon,noWeapon);

      actionKeys.getChildren().add(rollDice);


      int numRows = 5;
      int numColumns = 5;

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
          Button button = createButton(Integer.toString(i+1));
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


      //grid.setGridLinesVisible(true);




      Scene scene = new Scene(root, 800, 600);
      primaryStage.setTitle("PANE PLAY");
      primaryStage.setScene(scene);
      primaryStage.show();




    }//END OF START




  }//END OF APP