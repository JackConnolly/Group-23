import java.util.ArrayList;

public class Movement{
/*
* Setting variables for now, not sure if correct
*/
 public int yPos;
 public int xPos;
/* Setting increment to 1, but can be anything
* @amount would be wanted movement amount
* Not sure if there should be a seperate array in movement for position,
* or if it should just be in board
*/
  public void moveUp(int amount){
    yPos += 1;
  }
  public void moveDown(int amount){
    yPos -= 1;
  }
  public void moveLeft(int amount){
    xPos -= 1;
  }
  public void moveRight(int amount){
    xPos += 1;
  }
/*
* The dice roll for movement, will return random int within range
*/
  public int diceRoll(){
    int min = 1;
    int max = 6;
    int rollAmount = (int)(Math.random() * max) + 1;
    return rollAmount;


  }

}
