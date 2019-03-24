/** CPSC Team 23
*Class People extends Clue
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;

public class People extends Cards2{

//introducing the instance variable of people
	private static ArrayList<String> people = new ArrayList<>();
	private static String winPeople = new String();

/**
*Sets the default object People by setting the people
*@param parameters not used
*/
	public People(){
	}

/**
Adds all 4 of the people which may
be accused to the array people
@param no parameters
@return nothing
*/

	public void setPeople(){

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
	public ArrayList<String> getPeople(){

		return people;

	}

/**
*Sets the instance variable winPeople
*as the randomly chosen string index  
*of the array people
*@param no parameters
*@return the winning people card
*/
	public String getWinningPeople(){

		setPeople();
		int rand = new Random().nextInt(4);

		winPeople = people.get(rand);
		people.remove(rand);

		return winPeople;
	}

}