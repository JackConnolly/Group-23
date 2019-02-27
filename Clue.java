public class Clue {
	
	public static void main(String[] args){

	Rules r = new Rules();
	r.printRules();

	System.out.println();
	System.out.println();
	
	Board b = new Board();
	Cards c = new Cards();
	/**hard coding size of board because I hard coded placement of rooms
	*/
	c.setPlaces();
	/** trying to add all players to all players array */
	b.initializeBoard(4, 5, c.getPlaces());
	
	System.out.println();
	System.out.println();
	
	c.printCards();

	System.out.println();
	System.out.println();

	Movement m = new Movement();

	System.out.println("You rolled a... " + m.diceRoll());
}
}