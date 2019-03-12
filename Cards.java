/** CPSC Team 23
*Class Cards extends Clue
*@author Hailey Allen/ group 23
*/

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Cards{

//Introducing the various card type arrays
	private ArrayList<String> places = new ArrayList<>();
	private ArrayList<String> people = new ArrayList<>();
	private ArrayList<String> weapons = new ArrayList<>();

//Making the 'winning' array of winning cards
	private ArrayList<String> selectedCards = new ArrayList<>();

//Making the array which will hold the rest of the cards
	private ArrayList<String> remainderCards = new ArrayList<>();

//Making the arrays for the two players hands
	private ArrayList<String> playerOne = new ArrayList<>();
	private ArrayList<String> playerTwo = new ArrayList<>();

//Constructor with no parameters; sets the default 
	public Cards(){
		this.setPlaces();
		this.setPeople();
		this.setWeapons();
		this.winningCards();
		this.setPlayerOnesHand();
		this.setPlayerTwosHand();
	}

	public void setPlaces(){

//adding cards to places array
		places.add("Library");
		places.add("Kitchen");
		places.add("Living Room");
		places.add("Dining Room");
		places.add("Office");
		places.add("Bedroom");

	}

	public void setPeople(){

//adding cards to people array
		people.add("Miss Scarlet");
		people.add("Mr.Green");
		people.add("Mrs.White");
		people.add("Professor Plum");

	}

	public void setWeapons(){

//adding cards to weapons array
		weapons.add("Candlestick");
		weapons.add("Horseshoe");
		weapons.add("Water Bucket");
		weapons.add("Trophy");
		weapons.add("Revolver");
	}

	public String winningCards(){

//choosing the random cards to be the chosen ones
		int random = new Random().nextInt(places.size());
		int random2 = new Random().nextInt(people.size());
		int random3 = new Random().nextInt(weapons.size());

//adding chosen cards to the chosen cards array (winning cards)
		selectedCards.add(places.get(random));
		selectedCards.add(people.get(random2));
		selectedCards.add(weapons.get(random3));

//removing said chosen cards from their original array so they are not handed out
		places.remove(random);
		people.remove(random2);
		weapons.remove(random3);

//adding the remainder cards to one arraylist
		remainderCards.addAll(places);
		remainderCards.addAll(people);
		remainderCards.addAll(weapons);

		return "";

	}

//handing out the remaining cards to the players
	public void setPlayerOnesHand(){

		for (int i=5; i>=0; i--){

			int random = new Random().nextInt(remainderCards.size());
			playerOne.add(remainderCards.get(random));
			remainderCards.remove(random);

		}

	}

	public void setPlayerTwosHand(){

		for (int i=5; i>=0; i--){

			playerTwo.add(remainderCards.get(i));
			remainderCards.remove(i);

		}

	}

//getter methods
	public ArrayList<String> getPlaces(){

		return places;

	}

	public ArrayList<String> getPeople(){

		return people;

	}

	public ArrayList<String> getWeapons(){

		return weapons;

	}

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

	public static void main(String[] args){

		Cards c = new Cards();

		System.out.println("Player Ones Cards are " + c.getPlayerOnesHand());
		System.out.println("Player Twos Cards are " + c.getPlayerTwosHand());
		System.out.println("The Winning Cards are " + c.getSelectedCards());


	}


}