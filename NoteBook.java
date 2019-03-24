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

	public Cards c = new Cards();
	public Places place = new Places();
	public Weapons weapon = new Weapons();
	public People people = new People();

	public static void setArrayNo(){

		for (int i = 0; i <= 14; i++){
			arrayNo.add(0);
		}

	}

	public static ArrayList<Integer> getArrayNo(){

		return arrayNo;
	}

	public static void setArrayCards(){

		Places place = new Places();
		Weapons weapon = new Weapons();
		People people = new People();

		place.setPlaces();
		weapon.setWeapons();
		people.setPeople();
			
		arrayCards.addAll(place.getPlaces());
		arrayCards.addAll(people.getPeople());
		arrayCards.addAll(weapon.getWeapons());

	}

	public static ArrayList<String> getArrayCards(){

		return arrayCards;
	}

	public static void main(String[] args){

		setArrayNo();
		setArrayCards();

		System.out.println(getArrayCards());
		System.out.println(getArrayNo());

	}

}