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
import javafx.scene.layout.Region;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
import javafx.scene.control.Label;

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

      HBox statusBar = new HBox(8);
      //HBox hbox = new HBox(8); // spacing = 8
      //statusBar.getChildren().addAll(new Label("Name:"), new TextField());
      GridPane y = new GridPane();

      statusBar.setPrefWidth(500);
      //statusBar.setHgrow(Priority.ALWAYS);
      statusBar.setPrefHeight(300);


      // Creating and Adding Buttons for VBox actionKeys
      Button rollDice = new Button("Roll Dice");
      Button suspectPlayer = new Button("Suspect Player");
      Button moveLeft = new Button("Move Left");
      Button moveRight = new Button("Move Right");
      Button moveUp = new Button("Move Up");
      Button moveDown = new Button("Move Down");
      actionKeys.getChildren().addAll(rollDice, suspectPlayer, moveLeft, moveRight, moveUp, moveDown);

      //Creating and Adding buttons to Vbox notePad
      Button yesChar= new Button("Yes");
      Button noChar = new Button("No");
      Button yesWeapon = new Button("Yes");
      Button noWeapon = new Button("No");

      y.getChildren().addAll(yesChar, noChar, yesWeapon, noWeapon);
      notePad.getChildren().add(y);
  

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


      Label rules = new Label("Welcome To Clue!\n");
      Label rules2 = new Label("Equipment: There is 2 colored tokens representing");
      rules.setAlignment(Pos.CENTER);
      rules2.setAlignment(Pos.CENTER);
      statusBar.getChildren().add(rules);
      statusBar.getChildren().add(rules2);


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

     // grid.setGridLinesVisible(true);


      Scene scene = new Scene(root, 800, 600);
      primaryStage.setTitle("PANE PLAY");
      primaryStage.setScene(scene);
      primaryStage.show();




    }//END OF START




  }//END OF APP
