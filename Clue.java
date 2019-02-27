public class Clue {
	
	public static void main(String[] args){

	Rules r = new Rules();
	r.printRules();
	
	Board b = new Board();
	Cards c = new Cards();
	/**hard coding size of board because I hard coded placement of rooms
	*/
	c.setPlaces();
	/** trying to add all players to all players array */
	b.initializeBoard(4, 5, c.getPlaces());
}
}