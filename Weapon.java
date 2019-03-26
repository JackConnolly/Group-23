/** CPSC Team 23
*Class Weapon extends Clue
*@author Hailey Allen/ group 23
*@since March 23, 2019
*/

import java.util.ArrayList;
import java.util.Random;

public class Weapon extends Cards{

//introducing the instance variable of weapons
	private static ArrayList<String> weapon = new ArrayList<>();
	private static String winWeapon = new String();

/**
*Sets the default object Weapons
*@param parameters not used
*/
	public Weapon(){
	}

/**
*Sets the object Weapons by setting the name
*@param name
*/

	public Weapon(String name){
		super(name);
	}

/**
Adds all 5 of the weapons which may
be accused to the array weapons
@param no parameters
@return nothing
*/

	public void setWeapon(){

		weapon.add(" Candlestick ");
		weapon.add(" Horseshoe ");
		weapon.add(" Water Bucket ");
		weapon.add(" Trophy ");
		weapon.add(" Revolver ");
	}

/**
*Gets the weapons cards
*@param no parameters
*@return the array list of weapons
*/
	public ArrayList<String> getWeapon(){

		return weapon;

	}

/**
*Sets the instance variable winWeapon
*as the randomly chosen string index  
*of the array weapons
*@param no parameters
*@return the winning weapon card
*/
	public String getWinningWeapon(){

		setWeapon();
		int rand = new Random().nextInt(5);

		winWeapon = weapon.get(rand);
		weapon.remove(rand);

		return winWeapon;
	}

}