/** CPSC Team 23
*Class Cards extends Clue
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;

public class Cards2{

/**
This portion of code introduces all 
private instance variables which will 
be used throughout the class
*/

//Making the 'winning' array of winning cards
	private static ArrayList<String> selectedCards = new ArrayList<>();

//Making the array which will hold the rest of the cards
	private static ArrayList<String> remainderCards = new ArrayList<>();

//Making the arrays for the two players hands
	private static ArrayList<String> playerOne = new ArrayList<>();
	private static ArrayList<String> playerTwo = new ArrayList<>();

	private String name;

	public static Places places = new Places();
	public static People people = new People();
	public static Weapons weapons = new Weapons();

/**
Constructor with no parameters; 
sets the default variable used
@param no parameters
*/

	public Cards2(){
	}

/**
Constructor which sets the name of the 
weapon, place, or person beign accsued
in clue
@param name 
*/

	public Cards2(String name){
		this.name = name;
	}

/**
Sets the winning cards from the arrays
weapons, places, and people and adds
them to the array selectedCards
@param weapons of object type Weapons (to access weapons array)
@param people of object type People (to access people array)
@param places of object type Places (to access places array)
*/

	public static void addSelectedCards(){

//adding the winning cards to the array selectedCards
		selectedCards.add(places.getWinningPlaces());
		selectedCards.add(people.getWinningPeople());
		selectedCards.add(weapons.getWinningWeapon());

	}

/**
Adds the remaining cards from the arrays
weapons, places, and people and adds
them to the array selectedCards
@param weapons of object type Weapons (to access weapons array)
@param people of object type People (to access people array)
@param places of object type Places (to access places array)
*/

	public static void addRemainingCards(){

		Places places = new Places();
		People people = new People();
		Weapons weapons = new Weapons();

//adding the remaining cards (not winning) to remainderCards
		remainderCards.addAll(places.getPlaces());
		remainderCards.addAll(people.getPeople());
		remainderCards.addAll(weapons.getWeapons());

	}

	public static void playerOnesHand(){

//using a for loop to repeat this process 6 times

		for (int i=5; i>=0; i--){
			if(i == 5){
				int random = new Random().nextInt(12);
				playerOne.add(remainderCards.get(random));
				remainderCards.remove(random);
			}
			if(i == 4){
				int random = new Random().nextInt(11);
				playerOne.add(remainderCards.get(random));
				remainderCards.remove(random);
			}
			if(i == 3){
				int random = new Random().nextInt(10);
				playerOne.add(remainderCards.get(random));
				remainderCards.remove(random);
			}
			if(i == 2){
				int random = new Random().nextInt(9);
				playerOne.add(remainderCards.get(random));
				remainderCards.remove(random);
			}
			if(i == 1){
				int random = new Random().nextInt(8);
				playerOne.add(remainderCards.get(random));
				remainderCards.remove(random);
			}
			if(i == 0){
				int random = new Random().nextInt(7);
				playerOne.add(remainderCards.get(random));
				remainderCards.remove(random);
			}
		}

	}

	public static void playerTwosHand(){

//using a for loop to repeat this process 6 times

		for (int i=5; i>=0; i--){

			playerTwo.add(remainderCards.get(i));
			remainderCards.remove(i);

		}
	}

	public void setName(String name){
		this.name = name;
	}

//getter methods

	public ArrayList<String> getSelectedCards(){

		return selectedCards;
	}

	public ArrayList<String> getRemainingCards(){

		return remainderCards;
	}

	public ArrayList<String> getPlayerOnesHand(){

		return playerOne;
	}

	public ArrayList<String> getPlayerTwosHand(){

		return playerTwo;
	}

	public String getName(){
		return name;
	}

/**
The main method of the class which
prints off player one and twos cards,
as well as the winning cards which
have been randomly chosen
*/

	public static void main(String[] args){

		Cards2 c = new Cards2();
		addSelectedCards();
		addRemainingCards();
		playerOnesHand();
		playerTwosHand();

		System.out.println("The Winning Cards are " + c.getSelectedCards());
		System.out.println("Player Ones Cards are " + c.getPlayerOnesHand());
		System.out.println("Player Twos Cards are " + c.getPlayerTwosHand());

	}

}