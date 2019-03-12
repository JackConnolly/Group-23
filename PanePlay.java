/*
* This is a tester program for javafx, as well as
* a tester for javadoc
* @author Jack Connolly
*/
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
    private Button createButton(String text) {
      Button button = new Button(text);
      button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      button.setOnAction(e -> System.out.println(text));
      return button ;
      }

    public void start(Stage primaryStage) throws Exception{
      // Setup the panes
      BorderPane root = new BorderPane();
      GridPane grid = new GridPane();

      VBox actionKeys = new VBox(20);
      // setting preferred width for VBox actionKeys
      actionKeys.setPrefWidth(150);

      VBox notePad = new VBox(20);
      // setting preferred width for VBox notePad
      notePad.setPrefWidth(150);

      HBox statusBar = new HBox();
      statusBar.setPrefWidth(600);


      // Creating and Adding Buttons for VBox actionKeys
      Button rollDice = new Button("Roll Dice");
      Button suspectPlayer = new Button("Suspect Player");
      Button moveLeft = new Button("Move Left");
      Button moveRight = new Button("Move Right");
      Button moveUp = new Button("Move Up");
      Button moveDown = new Button("Move Down");
      actionKeys.getChildren().add(suspectPlayer);
      actionKeys.getChildren().add(moveLeft);
      actionKeys.getChildren().add(moveRight);
      actionKeys.getChildren().add(moveUp);
      actionKeys.getChildren().add(moveDown);

      //Creating and Adding buttons to Vbox notePad
      Button yesChar= new Button("Yes");
      Button noChar = new Button("No");
      Button yesWeapon = new Button("Yes");
      Button noWeapon = new Button("No");
      notePad.getChildren().add(yesChar);
      notePad.getChildren().add(noChar);
      notePad.getChildren().add(yesWeapon);
      notePad.getChildren().add(noWeapon);


      statusBar.getChildren().add(rollDice);


      int numRows = 5 ;
      int numColumns = 5 ;

      for (int row = 0 ; row < numRows ; row++ ){
          RowConstraints rc = new RowConstraints();
          rc.setFillHeight(true);
          rc.setVgrow(Priority.ALWAYS);
          grid.getRowConstraints().add(rc);
        }

      for (int col = 0 ; col < numColumns; col++ ) {
          ColumnConstraints cc = new ColumnConstraints();
          cc.setFillWidth(true);
          cc.setHgrow(Priority.ALWAYS);
          grid.getColumnConstraints().add(cc);
        }



      for (int i = 0 ; i < 25  ; i++) {
          Button button = createButton(Integer.toString(i+1));
          grid.add(button, i % 5, i / 5);
        }

      
      root.setCenter(grid);
      root.setLeft(actionKeys);
      root.setRight(notePad);
      root.setBottom(statusBar);

      grid.setGridLinesVisible(true);


      Scene scene = new Scene(root, 900, 700);
      primaryStage.setTitle("PANE PLAY");
      primaryStage.setScene(scene);
      primaryStage.show();




    }//END OF START




  }//END OF APP
