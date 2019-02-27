public class Player{
	
	//Player class organizes turns of the players but primarily returns tokens with different values (x and y position, cards, etc)
	//includes computer (AI) players.)
	
	public int initialMoveX = 0;
	public int initialMoveY = 0;
	
	//public void changeMove extends movement ()
		//public void getMove(){
			
			//int xPos = movementX;
			//int yPos = movementY;

	
	public class humanPlayer{
		
		System.out.println("Enter number of players: ");
		
		Scanner scanner = new Scanner(System.in);
		
		int numPlayers = scanner.nextLine();
		
		String[] currentPlayers = {numPlayers};
		
		public static void setToken (){
			
			for (int i = 0; i < numPlayers; i++){
				
				System.out.println("Type in the token you want to play as: ");
				System.out.println("% ! # &");
				
				Scanner scanner = new Scanner(System.in);
		
				String playerToken = scanner.nextLine();
				
				currentPlayers[i] = playerToken;
			}
			
		}
				
				//assign playerToken to arraylist
				
			
		}
			
		//token class for the GUI (gives position and card associated with each player)
}
