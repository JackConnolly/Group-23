/** CPSC Team 23
*Class Places extends Clue
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Room extends Cards{

//introducing the instance variable of places
	private static ArrayList<String> room = new ArrayList<String>();
	private static String winRoom = new String();

/**
*Sets the default object Places
*@param no parameters
*/
	public Room(){
	}

/**
*Sets the object Places by setting the name
*@param name
*/

	public Room(String name){
		super(name);
	}

/**
Adds all 6 of the rooms which may
be accused to the array places
@param no parameters
@return nothing
*/
	public static void setRoom(){

		room.add(" Library ");
		room.add(" Kitchen ");
		room.add(" Living Room ");
		room.add(" Dining Room ");
		room.add(" Office ");
		room.add(" Bedroom ");

	}

/**
*Gets the places cards
*@param no parameters
*@return the array list places
*/
	public ArrayList<String> getRoom(){

		return room;

	}

/**
*Sets the instance variable winPlace
*as the randomly chosen string index  
*of the array places
*@param no parameters
*@return the winning place card
*/
	public String getWinningRoom(){

		setRoom();
		int rand = new Random().nextInt(6);

		winRoom = room.get(rand);
		room.remove(rand);

		return winRoom;
	}

}