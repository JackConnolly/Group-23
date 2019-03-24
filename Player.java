/** Player class holds player positions, names, tokens, and keeps track of moveAmount
* @author Anna Barrett
* last updated by: Jack Connolly
* @since 03-13-19
*/
import java.util.ArrayList;

public class Player {

	//Instance variables
	private String name;
	private ArrayList<Suspicion> suspected;
	private ArrayList<Accusation> accused;
	private int xPos;
	private int yPos;
	private String token;
	private int moveAmount;

	// Constructors
	public Player(String n) {

		name = n;
		this.suspected = new ArrayList<Suspicion>();
		this.accused = new ArrayList<Accusation>();
	}

	public Player(String name, int xpos, int ypos, String token) {

		this.name = name;
		this.xPos = xpos;
		this.yPos = ypos;
		this.token = token;
		this.suspected = new ArrayList<Suspicion>();
		this.accused = new ArrayList<Accusation>();

	}

	//Getter Methods

	public String getPlayerToken() {

		return token;

	}

	public int getMoveAmount() {

		return moveAmount;

	}
	//returns array of ints coresponding to player position [x, y]
	public int[] getPlayerPosition() {

		int[] a = new int[]{xPos, yPos};
		return a;

	}

	// Setter Methods

	/** Sets the Players position & calls the checkRoom method
	* @param xDistance distance player travelled horizontally
	* @param yDistance distance player travelled vertically
	*/
	public void setPlayerPosition(int xDistance, int yDistance) {

		// checks if not being moved moved variable is equal to false
		boolean moved = false;

		// checks if the xPosition plus the xDistance is between 0 and 4 and if moveAmount is greater than 0
		// Between 0 - 4 refers to the array index of the Board
		if (xPos + xDistance >= 0 && xPos + xDistance <= 4 && moveAmount > 0) {

			if (!moved) {

			moveAmount = moveAmount - 1;
			moved = true;

			}
		xPos += xDistance;
		}
		// checks if the yPosition plus the yDistance is between 0 and 4 and if moveAmount is greater than 0
		// Between 0 - 4 refers to the array index of the Board
		if(yPos + yDistance >= 0 && yPos + yDistance <= 4 && moveAmount > 0){
			if(!moved){
			moveAmount = moveAmount - 1;
			moved = true;
			}
		yPos += yDistance;
		}

		//Calls method to check if player is on room access space
		checkRoom();

	}

	public void setPlayerToken(String imageName) {

		token = imageName;

	}

	public void setMoveAmount(int move) {

		moveAmount = move;

	}

	/**
	* checks if Player has reached a room
	*/
	public void checkRoom() {
	// Room position for Library
		if (xPos == 0 && yPos == 0) {
			System.out.println("You've reached the Library, but there doesn't seem to be a murder here... ");

		// Room position for Kitchen
		} else if (xPos == 4 && yPos == 0 ) {
			System.out.println("You've reached the Kitchen, but there doesn't seem to be a murder here...");

		// Room position for Living Room
		}  else if (xPos == 0 && yPos == 2 ) {
			System.out.println("You've reached the Living Room, but there doesn't seem to be a murder here...");

		// Room position for Dining Room
		}  else if (xPos == 4 && yPos == 2 ) {
			System.out.println("You've reached the Dining Room, but there doesn't seem to be a murder here...");

		// Room position for Bedroom
		}  else if (xPos == 0 && yPos == 4 ) {
			System.out.println("You've reached the Bedroom, but there doesn't seem to be a murder here... ");

		// Room position for Office
		}  else if (xPos == 4 && yPos == 4 ) {
			System.out.println("You've reached Office, and you found the murder scene! You Win! ");
		}

	}


	/** adds players choice of suspected
	*
	*/
	public Suspicion addSuspected(Weapon weapon, Room room , Person person) {
		//Creates new suspicion
		Suspicion s = new Suspicion(weapon, room, person);
		// adds players choice of suspected to an arrayList of type suspicion
		suspected.add(s);
		return s;
	}

	public ArrayList<Suspicion> getSuspectedList() {
		return suspected;
	}
	
	/**
	*
	*/
	public Accusation addAccusation(Weapon weapon, Room room , Person person) {
		Accusation a = new Accusation(weapon, room, person);
		accused.add(a);
		return a;
	}



}
