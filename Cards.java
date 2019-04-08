/** CPSC Team 23
*Class Cards extends Clue
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;

public class Cards{

/**
This portion of code introduces all 
private instance variables which will 
be used throughout the class
*/

//Making the 'winning' array of winning cards
	private ArrayList<String> selectedCards = new ArrayList<>();

//Making the array which will hold the rest of the cards
	private ArrayList<String> remainderCards = new ArrayList<>();

//Making the arrays for the two players hands
	private ArrayList<String> playerOne = new ArrayList<>();
	private ArrayList<String> playerTwo = new ArrayList<>();

	private Player playerOneObject;
	private Player playerTwoObject;

	private String name;

	//public Room room = new Room();
	//public Person person = new Person();
	//public Weapon weapon = new Weapon();

	private Room winningRoom;
	private Weapon winningWeapon;
	private Person winningPerson;

/**
Constructor with no parameters; 
sets the default variable used
@param no parameters
*/

	public Cards(){
	}

/**
Constructor which sets the name of the 
weapon, place, or person beign accsued
in clue
@param name 
*/

	public Cards(String name){
		this.name = name;
	}

	public void setPlayerOneObject(Player p1) {
		this.playerOneObject = p1;

	}

	public void setPlayerTwoObject(Player p2) {
		this.playerTwoObject = p2;

	}

	public Player getPlayerOneObject() {
		return playerOneObject;

	}

	public Player getPlayerTwoObject() {
		return playerTwoObject;

	}
/**
Sets the winning cards from the arrays
weapons, places, and people and adds
them to the array selectedCards
@param weapons of object type Weapon (to access weapons array)
@param people of object type Person (to access people array)
@param places of object type Room (to access places array)
*/
	
	public Room getWinningRoom() {
		return winningRoom;

	}
	public Weapon getWinningWeapon() {
		return winningWeapon;

	}
	public Person getWinningPerson() {
		return winningPerson;

	}

	public void setWinningRoom(Room room) {
		this.winningRoom = room;

	}
	public void setWinningWeapon(Weapon weapon) {
		this.winningWeapon = weapon;

	}
	public void setWinningPerson(Person person) {
		this.winningPerson = person;


	}
	public void setPlayerOnesHand(ArrayList<String> p1Cards) {
		this.playerOne = p1Cards;
	}

	public void setPlayerTwoHand(ArrayList<String> p2Cards) {
		this.playerTwo = p2Cards;

	}

	public void addSelectedCards(){

		RoomList roomList = new RoomList();
		PersonList personList = new PersonList();
		WeaponList weaponList = new WeaponList();

		this.setWinningRoom(new Room(roomList.getWinningRoom()));
		this.setWinningWeapon(new Weapon(weaponList.getWinningWeapon()));
		this.setWinningPerson(new Person(personList.getWinningPerson()));
	

//adding the winning cards to the array selectedCards
		//selectedCards.add(roomEnum.getWinningRoom());
		//selectedCards.add(personEnum.getWinningPerson());
		//selectedCards.add(weaponEnum.getWinningWeapon());

	}

/**
Adds the remaining cards from the arrays
weapons, places, and people and adds
them to the array selectedCards
@param weapons of object type Weapons (to access weapons array)
@param people of object type People (to access people array)
@param places of object type Places (to access places array)
*/

	public void addRemainingCards(){

		RoomList room = new RoomList();
		PersonList person = new PersonList();
		WeaponList weapon = new WeaponList();

//adding the remaining cards (not winning) to remainderCards
		remainderCards.addAll(room.getRoom());
		remainderCards.addAll(person.getPerson());
		remainderCards.addAll(weapon.getWeapon());

	}

	public void playerOnesHand(){

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

	public void playerTwosHand(){

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

	public ArrayList<String> getPlayersHand(String playerName){
		if ( playerName.equals(this.playerOneObject.getName()) )
			return playerOne;
		else if ( playerName.equals(this.playerTwoObject.getName()) )
			return playerTwo;
		else
			return null;
	}

/**
The main method of the class which
prints off player one and twos cards,
as well as the winning cards which
have been randomly chosen- only used 
for trouble shooting
*/

	public final void setAllCards(){
		addSelectedCards();
		addRemainingCards();
		playerOnesHand();
		playerTwosHand();
	}
	

}