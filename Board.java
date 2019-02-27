import java.util.ArrayList;

public class Board{
	
	public Board(){
		
	}
	

/**prints the inputted number of columns and rows on board
*/
public void initializeBoard(int columns, int rows, ArrayList<String> rooms){

	Square[][] board = new Square[rows][columns];
	
	/** finding which room name is longest and adding spaces to other room names to make the layout look nice */
	String holder = "";
	for(String i:rooms){
		if(i.length() > holder.length())
			holder = i;
	}
	for(int j = 0; j < rooms.size(); j++){
		if(rooms.get(j) != holder){
			for(int i = 0; i < holder.length() - rooms.get(j).length() + 3; i++){
				if(j < rooms.size()/2)
				rooms.set(j, " " + rooms.get(j));
				 
			}
		}
	}
	
	
	/**setting room access and printing board */
	for (int i = 0; i < rows; i++){
		System.out.println("");
		if(i % 2 != 0){
			for(int x = 0; x < holder.length()  ; x++){
			System.out.print(" ");
			}
		}
		for (int j = 0; j < columns; j++){
			board[i][j] = new Square();
			
			/**setting rooms on left side of board j == 0 */
			if(i == 0 && j == 0){
				board[i][j].setRoomAccess(rooms.get(0));
				System.out.print(rooms.get(0));
				printSquare();
			}
			else if(i == 2 && j == 0){
				board[i][j].setRoomAccess(rooms.get(1));
				System.out.print(rooms.get(1));
				printSquare();
			}
			else if(i == 4 && j == 0){
				board[i][j].setRoomAccess(rooms.get(2));
				System.out.print(rooms.get(2));
				printSquare();
			}
			/**setting rooms on right side of board j == 3 */
			else if(i == 0 && j == 3){
				board[i][j].setRoomAccess(rooms.get(3));
				printSquare();
				System.out.print(rooms.get(3));
			}
			else if(i == 2 && j == 3){
				board[i][j].setRoomAccess(rooms.get(4));
				printSquare();
				System.out.print(rooms.get(4));
			}
			else if(i == 4 && j == 3){
				board[i][j].setRoomAccess(rooms.get(5));
				printSquare();
				System.out.print(rooms.get(5));
			}
				else{	
			printSquare();
			}
		}
				
	}
	
	
}
	
	/**prints empty square */
	public void printSquare(){
		System.out.print("|____|");
	}
	




}