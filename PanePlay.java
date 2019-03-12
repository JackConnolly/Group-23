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
      VBox actionKeys = new VBox();

      Button move = new Button("Move");

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

      actionKeys.getChildren().add(move);
      root.setCenter(grid);
      root.setLeft(actionKeys);

      grid.setGridLinesVisible(true);







      Scene scene = new Scene(root, 800, 600);
      primaryStage.setTitle("PANE PLAY");
      primaryStage.setScene(scene);
      primaryStage.show();




    }//END OF START




  }//END OF APP
