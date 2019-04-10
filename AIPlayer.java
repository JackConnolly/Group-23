/**
AI Player Class
@Author Anna Barrett
Last Updated 04-04-2019
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class AIPlayer extends Player{


private ArrayList<String> allPossibleWeapons = new ArrayList<String>(); //list of possible weapons
private ArrayList<String> allPossibleRooms = new ArrayList<String>(); //list of possible rooms
private ArrayList<String> allPossiblePeople = new ArrayList<String>(); //list of possible people
private ArrayList<String> hand; //growing list of innocent cards

private Cards cards;
private Player otherPlayer;



public AIPlayer(String name){
	super(name);
}

public AIPlayer(Cards aCards, Player player1){
	super("Computer");
	cards = aCards;
	otherPlayer = player1;
}
public AIPlayer(String name, int xPos, int yPos, String token, Cards aCards, Player other){
	super(name, xPos, yPos, token);
	cards = aCards;
	otherPlayer = other;
}

public void initializeAI(){
	allPossiblePeople.add(" Miss Scarlet ");
		allPossiblePeople.add(" Mr.Green ");
		allPossiblePeople.add(" Mrs.White ");
		allPossiblePeople.add(" Professor Plum ");
		allPossibleRooms.add(" Library ");
		allPossibleRooms.add(" Kitchen ");
		allPossibleRooms.add(" Lounge ");
		allPossibleRooms.add(" Dining_Room ");
		allPossibleRooms.add(" Study ");
		allPossibleRooms.add(" Billiard_Room ");
		allPossibleWeapons.add(" Candlestick ");
		allPossibleWeapons.add(" Horseshoe ");
		allPossibleWeapons.add(" Water Bucket ");
		allPossibleWeapons.add(" Trophy ");
		allPossibleWeapons.add(" Revolver ");
}

public void getHands(ArrayList<String> cards){
	hand = cards;
	checkingPossible();
}
	
	/**
	* checks if Player has reached a room
	*/
	public String checkingRoom() {
	// Room position for Library
		if (getXPosition() == 0 && getYPosition() == 0) {
			//System.out.println("You've reached the Library");
			return " Library ";
		// Room position for Kitchen
		} else if (getXPosition() == 4 && getYPosition() == 0 ) {
			//System.out.println("You've reached the Kitchen");
			return " Kitchen ";
		// Room position for Lounge
		}  else if (getXPosition() == 0 && getYPosition() == 2 ) {
			//System.out.println("You've reached the Lounge");
			return " Lounge ";
		// Room position for Dining Room
		}  else if (getXPosition() == 4 && getYPosition() == 2 ) {
			//System.out.println("You've reached the Dining Room");
			return " Dining_Room ";
		// Room position for Study
		}  else if (getXPosition() == 0 && getYPosition() == 4 ) {
			//System.out.println("You've reached the Bedroom");
		return " Study ";
		// Room position for Billiard Room
		}  else if (getXPosition() == 4 && getYPosition() == 4 ) {
			//System.out.println("You've reached the Billiard Room");
		return " Billiard_Room ";
		}
	return null;
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
			System.out.println("moved down");
			if(checkingRoom() != null){
				suspect(checkingRoom());
				setMoveAmount(0);
				//enter a method to suspect automatically
			}
			decideDirection();
		}
		else if (getYPosition() == 4){
			setPlayerPosition(0, -1);
			System.out.println("moved up");
			if(checkingRoom() != null){
				suspect(checkingRoom());
				setMoveAmount(0);
				//enter a method to suspect automatically
			}
			decideDirection();
		}
		else {
			setPlayerPosition(0, direction);
			System.out.println("moved random up/down");
			if(checkingRoom() != null){
				suspect(checkingRoom());
				setMoveAmount(0);
				//enter a method to suspect automatically
			}
			decideDirection();
		}
	}
	else {
		setPlayerPosition(direction, 0);
		System.out.println("moved random left/right");
		decideDirection();
	}
	}
}

public boolean isAI(){
	return true;
}

public void checkingPossible(){
	initializeAI();
	for (int i = 0; i < hand.size(); i++){
		if(allPossibleWeapons.contains(hand.get(i))){
			for (int j = 0; j < allPossibleWeapons.size(); j++){
				if(allPossibleWeapons.get(j) == hand.get(i))
				allPossibleWeapons.remove(j);
			}
		}
		else if(allPossibleRooms.contains(hand.get(i))){
			for (int j = 0; j < allPossibleRooms.size(); j++){
				if(allPossibleRooms.get(j) == hand.get(i))
				allPossibleRooms.remove(j);
			}
		}
		else if(allPossiblePeople.contains(hand.get(i))){
			for (int j = 0; j < allPossiblePeople.size(); j++){
				if(allPossiblePeople.get(j) == hand.get(i))
				allPossiblePeople.remove(j);
			}
		}	
	}
		System.out.println(allPossiblePeople);
		System.out.println(allPossibleRooms);
		System.out.println(allPossibleWeapons);
}

public void suspect(String room){
Room suspectedRoom = new Room(room);
Person suspectedPerson = new Person(allPossiblePeople.get(0));
Weapon suspectedWeapon = new Weapon(allPossibleWeapons.get(0));

Suspicion s;
s = addSuspected(suspectedWeapon, suspectedRoom, suspectedPerson);

System.out.println("Suspected: " + s.toString());
ArrayList<String> contested;
contested = s.checkContested(cards, otherPlayer);
System.out.println("Contested cards: " + contested);
//contested = s.checkContested(c, otherplayer);//how do I access the cards and instance of other player?????
//method to remove innocent things
	
}



public void turnSequence(){
	BoardGUI f = new BoardGUI();
	setMoveAmount(f.diceRoll());
	System.out.println("move amount is " + getMoveAmount());
	decideDirection();
}
	
	
}
	
			