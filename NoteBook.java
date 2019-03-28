/** CPSC Team 23
*Class NoteBook
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;

public class NoteBook{

//setting the yes or no array
	public static ArrayList<Integer> arrayNo = new ArrayList<>();
//setting the array of all cards
	public static ArrayList<String> arrayCards = new ArrayList<>();

/**
Setting the default constructor
@param no parameters
*/

	public NoteBook(){
	}


/**
Sets the array arrayNo which
will show if a player knows if
each weapon, person, and room 
can be the winning one
@param no parameters
@return void
*/

	public static void setArrayNo(){

//adds 15 0s because there are 15 cards; all 0 for default
		for (int i = 0; i <= 14; i++){
			arrayNo.add(0);
		}

	}

/**
Sets the array arrayCards which
contains all the card names
(all weaons, rooms, and people)
@param no parameters
@return void
*/
	public static void setArrayCards(){

		RoomEnum room = new RoomEnum();
		WeaponEnum weapon = new WeaponEnum();
		PersonEnum person = new PersonEnum();

		room.initRoom();
		weapon.setWeapon();
		person.setPerson();
			
		arrayCards.addAll(room.getRoom());
		arrayCards.addAll(person.getPerson());
		arrayCards.addAll(weapon.getWeapon());

	}

//getter methods

	public static ArrayList<String> getArrayCards(){

		return arrayCards;
	}

	public static ArrayList<Integer> getArrayNo(){

		return arrayNo;
	}

}
