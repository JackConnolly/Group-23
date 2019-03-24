/** Player class holds player positions, names, tokens, and keeps track of moveAmount
@Author Anna Barrett
*/
import java.util.ArrayList;

public class Player{

//instance variables
private String name;
private int xpos;
private int ypos;
private String token;
private int moveAmount;
private ArrayList<String> cards;


public Player(String n){
	name = n;
}

public Player(String name, int xpos, int ypos, String token){
	this.name = name;
	this.xpos = xpos;
	this.ypos = ypos;
	this.token = token;
}

//returns xpos
public int getXPosition(){
	return xpos;
}

//returns ypos
public int getYPosition(){
	return ypos;
}


//Setter for player position
public void setPlayerPosition(int xDistance, int yDistance){
	boolean moved = false;
	if(xpos + xDistance >= 0 && xpos + xDistance <= 4 && moveAmount > 0 && xDistance != 0 ){
		if(!moved){
		moveAmount = moveAmount - 1;
		moved = true;
		}
		xpos += xDistance;
		
	}
	if(ypos + yDistance >= 0 && ypos + yDistance <= 4 && moveAmount > 0){
		if(!moved){
		moveAmount = moveAmount - 1;
		moved = true;
		}
		ypos += yDistance;
	}
}


public ArrayList<String> getCards(){
	return cards;
}

public void setCards(ArrayList<String> cards){
	this.cards = cards;
}
	
	

public void setToken(String imageName){
	token = imageName;
}

public String getToken(){
	return token;
}

public int getMoveAmount(){
	return moveAmount;
}

public void setMoveAmount(int move){
	moveAmount = move;
}

}