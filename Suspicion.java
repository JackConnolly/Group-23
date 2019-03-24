/**
*
* @author Kylie Sicat
* @since 03-18-19
*/


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

	//Setter

	public void setWeapon(Weapon weapon) {

		this.weapon = weapon;

		

	}

	public void setRoom(Room room ) {

		this.room = room;


		

	}

	public void setPerson(Person person ) {

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

	// method which verifies whether suspected cards are correct according to the winning cards??

	}

	public String toString() {

		return "Weapon " + weapon.getName() + "; Room " + room.getName() + "; Person " + person.getName();
	}










































} // end of class 