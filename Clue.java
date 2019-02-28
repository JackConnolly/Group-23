import java.util.Scanner;

public class Clue {

	public void promptKey(){
   System.out.println();
   Scanner scanner = new Scanner(System.in);
   scanner.nextLine();
}

	public static void main(String[] args){

	Rules r = new Rules();
	r.printRules();

	Clue d = new Clue();
	d.promptKey();
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
	d.promptKey();
	c.printCards();

	System.out.println();
	System.out.println();

	Movement m = new Movement();
	d.promptKey();
	System.out.println("You rolled a... " + m.diceRoll());
}
}
