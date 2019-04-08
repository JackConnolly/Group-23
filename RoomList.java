/** CPSC Team 23
*Class Places extends Clue
*@author Hailey Allen/ group 23
*@since 04-07-19
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class RoomList {

//introducing the instance variable of places
	private static ArrayList<String> room = new ArrayList<String>();
	private static ArrayList<String> printRoom = new ArrayList<String>();
	private static String winRoom = new String();

/**
*Sets the default object Places
*@param no parameters
*/
	public RoomList(){
	}

/**
Adds all 6 of the rooms which may
be accused to the array places
@param no parameters
@return nothing
*/
	public void initRoom(){

		room.add(" Library ");
		room.add(" Kitchen ");
		room.add(" Lounge ");
		room.add(" Dining_Room ");
		room.add(" Study ");
		room.add(" Billiard_Room ");

	}

	public void setPrintRoom(){

		printRoom.add(" Library ");
		printRoom.add(" Kitchen ");
		printRoom.add(" Lounge ");
		printRoom.add(" Dining_Room ");
		printRoom.add(" Study ");
		printRoom.add(" Billiard_Room ");

	}

/**
*Gets the places cards
*@param no parameters
*@return the array list places
*/
	public ArrayList<String> getRoom(){

		return room;

	}

	public ArrayList<String> getPrintRoom(){

		return printRoom;

	}

/**
*Sets the instance variable winPlace
*as the randomly chosen string index  
*of the array places
*@param no parameters
*@return the winning place card
*/
	public String getWinningRoom(){

		initRoom();
		int rand = new Random().nextInt(6);

		winRoom = room.get(rand);
		room.remove(rand);

		System.out.println("winroom " + winRoom);

		return winRoom;
	}

}