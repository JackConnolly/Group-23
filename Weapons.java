/** CPSC Team 23
*Class Weapons extends Clue
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;

public class Weapons extends Cards2{

//introducing the instance variable of weapons
	private static ArrayList<String> weapons = new ArrayList<>();
	private static String winWeapon = new String();

/**
*Sets the default object Weapons
*@param parameters not used
*/
	public Weapons(){
	}

/**
*Sets the object Weapons by setting the name
*@param name
*/

	public Weapons(String name){
		super(name);
	}

/**
Adds all 5 of the weapons which may
be accused to the array weapons
@param no parameters
@return nothing
*/

	public void setWeapons(){

		weapons.add(" Candlestick ");
		weapons.add(" Horseshoe ");
		weapons.add(" Water Bucket ");
		weapons.add(" Trophy ");
		weapons.add(" Revolver ");
	}

/**
*Gets the weapons cards
*@param no parameters
*@return the array list of weapons
*/
	public ArrayList<String> getWeapons(){

		return weapons;

	}

/**
*Sets the instance variable winWeapon
*as the randomly chosen string index  
*of the array weapons
*@param no parameters
*@return the winning weapon card
*/
	public String getWinningWeapon(){

		setWeapons();
		int rand = new Random().nextInt(5);

		winWeapon = weapons.get(rand);
		weapons.remove(rand);

		return winWeapon;
	}

}