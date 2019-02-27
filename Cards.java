import java.util.ArrayList;
import java.util.Random;

public class Cards {

//introducing the cards array
	ArrayList<String> places = new ArrayList<>();
	ArrayList<String> people = new ArrayList<>();
	ArrayList<String> weapons = new ArrayList<>();

//making the array list which will have the randomized weapon, place, and person 
	ArrayList<String> selectedCards = new ArrayList<>();

//making the array which will hold the rest of the cards
	ArrayList<String> remainderCards = new ArrayList<>();

//making the arrays for the two players hands
	ArrayList<String> playerOne = new ArrayList<>();
	ArrayList<String> playerTwo = new ArrayList<>();

	public Cards(){

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

	public void printCards(){

		Cards c = new Cards();

		c.setPlaces();
		c.setPeople();
		c.setWeapons();
		c.winningCards();
		c.setPlayerOnesHand();
		c.setPlayerTwosHand();

		System.out.println("Player Ones Cards are " + c.getPlayerOnesHand());
		System.out.println("Player Twos Cards are " + c.getPlayerTwosHand());
		System.out.println("The Winning Cards are " + c.getSelectedCards());

	}

}