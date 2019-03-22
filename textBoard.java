/**
Text based Board
@Author Anna Barrett

*/
import java.util.*;

public class textBoard{

	private Player player1;
	private Player player2;
	private Player turn;
	private ArrayList<String> rooms;
	private int length; //length of longest room name
	private static Scanner scan = new Scanner(System.in);
	private Square[][] board;
	
	//Constructor
		textBoard(Player player1, Player player2, ArrayList<String> rooms){
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
	textBoard b = new textBoard(player1, player2, c.getPlaces());
	b.printBoard( 5, 5);
	b.displayPrompt();


}

public void checkForRoom(){
	if(board[turn.getXPosition()][turn.getYPosition()].hasRoomAccess()){
				System.out.println("You are in the " + board[turn.getXPosition()][turn.getYPosition()].getRoomAccess());
			}
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
