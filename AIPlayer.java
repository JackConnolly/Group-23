/**
AI Player Class
@Author Anna Barrett
Last Updated 04-04-2019
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class AIPlayer extends Player{


ArrayList<String> allPossible; //list of possible guesses, decide what type(Cards vs String)
ArrayList<String> hand; //growing list of inncoent cards

//Should the AI have a list of weapons separate from people or rooms?


public AIPlayer(String name){
	super(name);
}

public AIPlayer(){
	super("Computer");
}
public AIPlayer(String name, int xPos, int yPos, String token){
	super(name, xPos, yPos, token);
}

public void getHand(Cards c){
	hand = c.getPlayerTwosHand(); //AI will always be player 2
}

public void startTurn(){
	 //call roll dice

	//decide direction to move
	
	//if in room suspect people, weapon that arent in hand

}

public void decideDirection(){
	//picks either up or down as direction
		Random rand = new Random();
		int direction = rand.nextInt(2);
		if(direction == 0){
			direction = -1;
		}
	while(getMoveAmount() > 0){
	if(getXPosition() == 0 || getXPosition() == 4){
		if (getYPosition() == 0){
			setPlayerPosition(0, 1);
			decideDirection();
		}
		else if (getYPosition() == 4){
			setPlayerPosition(0, -1);
			decideDirection();
		}
		else {
			setPlayerPosition(0, direction);
			decideDirection();
		}
	}
	else {
		setPlayerPosition(direction, 0);
		decideDirection();
	}
	}
}

public boolean isAI(){
	return true;
}

public void turnSequence(){
	BoardGUI f = new BoardGUI();
	f.rollDice();
	decideDirection();
}
	
	public static void main(String[] args){
		HumanPlayer player1 = new HumanPlayer("Anna", 0, 0, "$");
		AIPlayer player2 = new AIPlayer();
		
		
	}
}
	
			