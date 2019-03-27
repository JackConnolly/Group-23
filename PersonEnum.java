/** CPSC Team 23
*Class Person extends Clue
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;

public class PersonEnum {

//introducing the instance variable of person
	private static ArrayList<String> person = new ArrayList<>();
	private static String winPerson = new String();

/**
*Sets the default object Person
*@param parameters not used
*/
	public PersonEnum(){
	}


/**
Adds all 4 of the people which may
be accused to the array people
@param no parameters
@return nothing
*/

	public void setPerson(){

		person.add(" Miss Scarlet ");
		person.add(" Mr.Green ");
		person.add(" Mrs.White ");
		person.add(" Professor Plum ");

	}

/**
*Gets the people cards
*@param no parameters
*@return the array list people
*/
	public ArrayList<String> getPerson(){

		return person;

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

		winPerson = person.get(rand);
		person.remove(rand);

		System.out.println("winperson " + winPerson);

		return winPerson;
	}

}