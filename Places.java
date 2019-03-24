/** CPSC Team 23
*Class Places extends Clue
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Places extends Cards2{

//introducing the instance variable of places
	private static ArrayList<String> places = new ArrayList<String>();
	private static String winPlace = new String();

/**
*Sets the default object Places
*@param no parameters
*/
	public Places(){
	}

/**
*Sets the object Places by setting the name
*@param name
*/

	public Places(String name){
		super(name);
	}

/**
Adds all 6 of the rooms which may
be accused to the array places
@param no parameters
@return nothing
*/
	public static void setPlaces(){

		places.add(" Library ");
		places.add(" Kitchen ");
		places.add(" Living Room ");
		places.add(" Dining Room ");
		places.add(" Office ");
		places.add(" Bedroom ");

	}

/**
*Gets the places cards
*@param no parameters
*@return the array list places
*/
	public ArrayList<String> getPlaces(){

		return places;

	}

/**
*Sets the instance variable winPlace
*as the randomly chosen string index  
*of the array places
*@param no parameters
*@return the winning place card
*/
	public String getWinningPlaces(){

		setPlaces();
		int rand = new Random().nextInt(6);

		winPlace = places.get(rand);
		places.remove(rand);

		return winPlace;
	}

}