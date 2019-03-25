/** CPSC Team 23
*Class Person extends Clue
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;

public class Person extends Cards{

//introducing the instance variable of person
	private static ArrayList<String> people = new ArrayList<>();
	private static String winPeople = new String();

/**
*Sets the default object Person
*@param parameters not used
*/
	public Person(){
	}

/**
*Sets the object Person by setting the name
*@param name
*/

	public Person(String name){
		super(name);
	}

/**
Adds all 4 of the people which may
be accused to the array people
@param no parameters
@return nothing
*/

	public void setPerson(){

		people.add(" Miss Scarlet ");
		people.add(" Mr.Green ");
		people.add(" Mrs.White ");
		people.add(" Professor Plum ");

	}

/**
*Gets the people cards
*@param no parameters
*@return the array list people
*/
	public ArrayList<String> getPerson(){

		return people;

	}

/**
*Sets the instance variable winPeople
*as the randomly chosen string index  
*of the array people
*@param no parameters
*@return the winning people card
*/
	public String getWinningPerson(){

		setPerson();
		int rand = new Random().nextInt(4);

		winPeople = people.get(rand);
		people.remove(rand);

		return winPeople;
	}

}