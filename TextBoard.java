/**
*Text based Board
*@author Anna Barrett
*@last updated: Kylie Sicat 03-24-19
*/
import java.util.*;

public class TextBoard{

	private Player player1;
	private Player player2;
	private Player turn;
	private ArrayList<String> rooms;
	private int length; //length of longest room name
	private static Scanner scan = new Scanner(System.in);
	private Square[][] board;
	
	//Constructor
		TextBoard(Player player1, Player player2, ArrayList<String> rooms){
		this.player1 = player1;
		this.player2 = player2;
		turn = player1;
		this.rooms = rooms;
	}
	
	//adds space to the front of room names to make them line up
	public String formatNames(){
	String holder = "";
	for(String i:rooms){
		if(i.length() > holder.length())
			holder = i;
	}
	length = holder.length();
	for(int j = 0; j < rooms.size(); j++){
		if(rooms.get(j) != holder){
			for(int i = 0; i < holder.length() - rooms.get(j).length() + 3; i++){
				if(j < rooms.size()/2)
				rooms.set(j, "*" + rooms.get(j));
				 
			}
		}
	}
	return holder;
}

//prints square and checks for players
	public void printSquare( int row, int column){
		System.out.print("|_");
		if(player1.getXPosition() == column && player1.getYPosition() == row){
			System.out.print(player1.getToken());
		}
			else
				System.out.print("_");
		if(player2.getXPosition() == column && player2.getYPosition() == row){
			System.out.print(player2.getToken());
		}
			else
				System.out.print("_");		
		System.out.print("_|");
	}
	
	//Prints Board
	public void printBoard(int columns, int rows){

	board = new Square[rows][columns];
	length = formatNames().length();
	

//putting spaces in front of squares that do not have a room
	for (int i = 0; i < rows; i++){
		System.out.println("");
		if(i % 2 != 0){
			for(int x = 0; x < length  ; x++){ 
			System.out.print(" ");
			}
		}
		//begins printing board
		for (int j = 0; j < columns; j++){
			board[i][j] = new Square();
			
			//setting rooms on left side of board j == 0 
			if(i == 0 && j == 0){
				board[i][j].setRoomAccess(rooms.get(0));
				System.out.print(rooms.get(0));
				printSquare(i, j);
			}
			else if(i == 2 && j == 0){
				board[i][j].setRoomAccess(rooms.get(1));
				System.out.print(rooms.get(1));
				printSquare(i, j);
			}
			else if(i == 4 && j == 0){
				board[i][j].setRoomAccess(rooms.get(2));
				System.out.print(rooms.get(2));
				printSquare(i, j);
			}
			//setting rooms on right side of board j == 4
			else if(i == 0 && j == 4){
				board[i][j].setRoomAccess(rooms.get(3));
				printSquare(i, j);
				System.out.print(rooms.get(3));
			}
			else if(i == 2 && j == 4){
				board[i][j].setRoomAccess(rooms.get(4));
				printSquare(i, j);
				System.out.print(rooms.get(4));
			}
			else if(i == 4 && j == 4){
				board[i][j].setRoomAccess(rooms.get(5));
				printSquare(i, j);
				System.out.print(rooms.get(5));
			}
				else{	
			printSquare(i, j);
			}
		}
		System.out.println("");	
	}
	}
	
	//Reprints Board
	public void reprintBoard(int columns, int rows){

	board = new Square[rows][columns];
	

//putting spaces in front of squares that do not have a room
	for (int i = 0; i < rows; i++){
		System.out.println("");
		if(i % 2 != 0){
			for(int x = 0; x < length  ; x++){ 
			System.out.print(" ");
			}
		}
		//begins printing board
		for (int j = 0; j < columns; j++){
			board[j][i] = new Square();
			
			//setting rooms on left side of board j == 0 
			if(i == 0 && j == 0){
				board[j][i].setRoomAccess(rooms.get(0));
				System.out.print(rooms.get(0));
				printSquare(i, j);
			}
			else if(i == 2 && j == 0){
				board[j][i].setRoomAccess(rooms.get(1));
				System.out.print(rooms.get(1));
				printSquare(i, j);
			}
			else if(i == 4 && j == 0){
				board[j][i].setRoomAccess(rooms.get(2));
				System.out.print(rooms.get(2));
				printSquare(i, j);
			}
			//setting rooms on right side of board j == 4
			else if(i == 0 && j == 4){
				board[j][i].setRoomAccess(rooms.get(3));
				printSquare(i, j);
				System.out.print(rooms.get(3));
				
			}
			else if(i == 2 && j == 4){
				board[j][i].setRoomAccess(rooms.get(4));
				printSquare(i, j);
				System.out.print(rooms.get(4));
			}
			else if(i == 4 && j == 4){
				board[j][i].setRoomAccess(rooms.get(5));
				printSquare(i, j);
				System.out.print(rooms.get(5));
			}
				else{	
			printSquare(i, j);
			}
		}
		System.out.println("");	
	}

	}
	
public static void main(String[] args){
	
	Cards c = new Cards();
	c.setPlaces();
	Player player1 = new Player("Anna", 0, 0, "#");
	Player player2 = new Player("Jack", 4, 4, "$");
	TextBoard b = new TextBoard(player1, player2, c.getPlaces());
	b.printBoard( 5, 5);
	b.displayPrompt();


}

public void checkForRoom(){
	if(board[turn.getXPosition()][turn.getYPosition()].hasRoomAccess()){
				System.out.println("You are in the " + board[turn.getXPosition()][turn.getYPosition()].getRoomAccess());
				/**
				* @toDo - if in room, not sure how you store the Room but with Cards it is supposed to be a separate class/ Object or if it
				* is easier to store it as a string? 
				*/
				if (true) { 

					chooseAction(player1, player2);


				}

			}
}

/** From Clue class I created - Kylie
*/
public void chooseAction(Player currPlayer, Player otherPlayer) {
//@todo move to its own method
		
		System.out.println("Do you want to suspect or accuse (s/a) ?");
		Scanner keyboard = new Scanner(System.in);
		String choice = keyboard.nextLine();
		//String choiceDesc = "";
		if (choice.equals("s")) {
			suspect(currPlayer, otherPlayer);
			
		} else if (choice.equals("a")) {
			accuse(currPlayer);

		} else {
			System.out.println("invalid choice");
		} // end of if (choice.equals("s"))

}

public void suspect(Player currPlayer, Player otherPlayer) {
		Suspicion s;
		Room room = new Room("living Room"); //temp for now - need to figure out which room the player entered
		System.out.println("What person would you like to suspect?");
		Scanner keyboard1 = new Scanner(System.in);
		String personName = keyboard1.nextLine();
		Person person = new Person(personName.toLowerCase());
	
			if (personName.equals("professor plum")){
				person = new Person(personName);
				
			} else if (personName.equals("miss scarlet")) {
				person = new Person(personName);

			} else if (personName.equals("mr. green")) {
				person = new Person(personName);

			} else if (personName.equals("mrs. white")) {
				person = new Person(personName);

			} else {
				System.out.println("invalid person options for persons are professor plum, miss scarlet, mr. green & mrs. white");
			} // end of if (personName.toLowerCase() == "professor plum")
	
		System.out.println("What weapon would you like to suspect?"); 
		Scanner keyboard2 = new Scanner(System.in);
		String weaponName = keyboard2.nextLine();
		Weapon weapon = new Weapon(weaponName.toLowerCase());
		if (weaponName.equals("candlestick")) {
				weapon = new Weapon(weaponName);
				
			} else if (weaponName.equals("horseshoe")) {
				weapon = new Weapon(weaponName);

			} else if (weaponName.equals("water bucket")) {
				weapon = new Weapon(weaponName);

			} else if (weaponName.equals("trophy")) {
				weapon = new Weapon(weaponName);

			} else if (weaponName.equals("revolver")) {
				weapon = new Weapon(weaponName);

			} else {
				System.out.println("invalid person options for persons are professor plum, miss scarlet, mr. green & mrs. white");
			}
		

		s = currPlayer.addSuspected(weapon, room, person);
		System.out.println("suspected: " + s); 

		System.out.println("otherPlayer =" + otherPlayer);
		System.out.println("Do you wish to contest against your opponent's Suspicion? Type 'Y' or 'N'.");
		Scanner keyboard3 = new Scanner(System.in);
		String otherPlayerChoice = keyboard3.nextLine();

		if (otherPlayerChoice.equals("y")) {
			System.out.println("Do you contest the person?");
			boolean pf = true;
			Scanner keyboard4 = new Scanner(System.in);
			String personFlag = keyboard4.nextLine();
			if (personFlag.toLowerCase() == "y") { 
				pf = true;

			} else if (personFlag.toLowerCase() == "n") {
				pf = false;
			}
			//.setPersonFlag(pf);

			System.out.println("person flag" + pf);

			System.out.println("Do you contest the weapon?");
			boolean wf = true;
			Scanner keyboard5 = new Scanner(System.in);
			String weaponFlag = keyboard5.nextLine();
			if (weaponFlag.toLowerCase() == "y") { 
				wf = true;

			} else if (weaponFlag.toLowerCase() == "n") {
				wf = false;
			}

			//s.setWeaponFlag(wf);
			System.out.println("weapon flag" + wf);
		}


	}

	public void accuse(Player currPlayer) {

		Accusation a;
		Room room = new Room("living Room"); //temp for now - need to figure out which room the player entered
		System.out.println("What person would you like to suspect?");
		Scanner keyboard1 = new Scanner(System.in);
		String personName = keyboard1.nextLine();
		Person person = new Person(personName);
		boolean invalid = true ;
		//while (invalid) {
			if (personName.toLowerCase() == "professor plum") {
				invalid = false;
				person = new Person(personName);
				

			} else if (personName.toLowerCase() == "miss scarlet") {
				invalid = false;
				person = new Person(personName);

			} else if (personName.toLowerCase() == "mr. green") {
				invalid = false;
				person = new Person(personName);

			} else if (personName.toLowerCase() == "mrs. white") {
				invalid = false;
				person = new Person(personName);

			} else {
				System.out.println("invalid person options for persons are professor plum, miss scarlet, mr. green & mrs. white");
			} // end of if (personName.toLowerCase() == "professor plum")
		//}
		// if statements for each name of person // else invalid
		System.out.println("What weapon would you like to suspect ?");
		Scanner keyboard2 = new Scanner(System.in);
		String weaponName = keyboard2.nextLine();
		Weapon weapon = new Weapon(weaponName);
		a = currPlayer.addAccusation(weapon, room, person);
		System.out.println("accused: " + a);
		// if statements for each weapon // else invalid


	}

//funtion controls and deals with user input and appropriate response
public void displayPrompt(){
	while (true){
	
	String action;
	System.out.println("Press [R] to roll the dice");
	scan = new Scanner(System.in);
	action = scan.nextLine().toLowerCase();
	if(action.charAt(0) == 'r'){
	int move = diceRoll();
	System.out.println("You rolled a " + move);
	turn.setMoveAmount(move);
	}
	else {
	System.out.println("Invalid Input");
	}
	
	while(turn.getMoveAmount() > 0){
	System.out.println("Use [W], [A], [S], and [D] to move your Player. When your turn is finished press [F]");
	action = scan.nextLine();
	char input = action.charAt(0);
	switch(input){
		case 'w':
			turn.setPlayerPosition(0, -1);
			reprintBoard(5, 5);
			System.out.println("You moved up. You have " + turn.getMoveAmount() + " moves left.");
			checkForRoom();
			break;
		case 's':
			turn.setPlayerPosition(0, 1);
			reprintBoard(5, 5);
			System.out.println("You moved down. You have " + turn.getMoveAmount() + " moves left.");
			checkForRoom();
			break;
		case 'a':
			turn.setPlayerPosition(-1, 0);
			reprintBoard(5, 5);
			System.out.println("You moved left. You have " + turn.getMoveAmount() + " moves left.");
			checkForRoom();
			break;
		case 'd':
			turn.setPlayerPosition(1, 0);
			reprintBoard(5, 5 );
			System.out.println("You moved right. You have " + turn.getMoveAmount() + " moves left.");
			checkForRoom();
			break;
		case 'f':
			turn.setMoveAmount(0);
			System.out.println("You have ended your turn. You have " + turn.getMoveAmount() + " moves left.");
			break;
		default:
			System.out.println("Invalid Input");
	}
			
	}
	
	}

		
}



	    //Dice roll class is here for my own sake of debugging the board
  public int diceRoll(){
   int min = 1;
   int max = 6;
   int rollAmount = (int)(Math.random() * max) + 1;
   return rollAmount;
 }
 }
