/**
* Suspicion Class
* @author Kylie Sicat
* @since 03-18-19
* Last Updated : Kylie Sicat 03-31-19
*/

import java.util.ArrayList;

public class Suspicion {

	// Instance Variables
	private Weapon weapon;
	private Room room;
	private Person person;
	private boolean weaponFlag;
	private boolean roomFlag;
	private boolean personFlag;

	//Constructors

	public Suspicion(Weapon weapon, Room room, Person person) {
		this.weapon = weapon;
		this.room = room;
		this.person = person;
	}

	//Getter Methods

	public Weapon getWeapon() {
		return weapon;

	}

	public Room getRoom() {
		return room;

	}

	public Person getPerson() {
		return person;

	}

	// Setter Methods 

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;		

	}

	public void setRoom(Room room) {
		this.room = room;

	}

	public void setPerson(Person person) {
		this.person = person;

	}

	public void setPersonFlag(boolean pf) {
		this.personFlag = pf;

	}

	public void setRoomFlag(boolean rf) {
		this.roomFlag = rf;

	} 

	public void setWeaponFlag(boolean wf) {
		this.weaponFlag = wf;

	}

	//method where user can say yes or no for all 3
	public void setFlags(boolean pf, boolean rf, boolean wf) {
		this.setPersonFlag(pf);
		this.setRoomFlag(rf);
		this.setWeaponFlag(wf);

	}
 	
 	/** toString method
 	* @return the weapon, room, person
 	*/
	public String toString() {
		return "Weapon " + weapon.getName() + "; Room " + room.getName() + "; Person " + person.getName();

	}

	public ArrayList<String> checkContested(Cards cards, HumanPlayer contestingPlayer) {
		//contestingPlayer = 
		ArrayList<String> handsMatched = new ArrayList<String>();
		ArrayList<String> playersHand = cards.getPlayersHand(contestingPlayer.getName());

		for ( int i = 0 ; i < playersHand.size() ; i++ ) {
			if ( compare(this.person.getName(), playersHand.get(i))
				|| compare(this.room.getName(), playersHand.get(i))
				|| compare(this.weapon.getName(), playersHand.get(i))
				) {
				handsMatched.add(playersHand.get(i));
			} 
		}

		return handsMatched;
	
	}
	public ArrayList<String> checkContested(Cards cards, AIPlayer contestingPlayer) {
		//contestingPlayer = 
		ArrayList<String> handsMatched = new ArrayList<String>();
		ArrayList<String> playersHand = cards.getPlayersHand(contestingPlayer.getName());

		for ( int i = 0 ; i < playersHand.size() ; i++ ) {
			if ( compare(this.person.getName(), playersHand.get(i))
				|| compare(this.room.getName(), playersHand.get(i))
				|| compare(this.weapon.getName(), playersHand.get(i))
				) {
				handsMatched.add(playersHand.get(i));
			} 
		}

		return handsMatched;
	
	}

	protected boolean compare(String a, String b) {
		return 	( a.trim().toLowerCase().equals(b.trim().toLowerCase()) );
		
	}


} // end of class 