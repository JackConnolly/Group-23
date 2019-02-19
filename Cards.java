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
		for (int i=places.size(); i>=0; i--){



		}

		return "";

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

}