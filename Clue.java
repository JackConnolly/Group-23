import java.util.Scanner;
import java.util.ArrayList;

public class Clue {

	public void promptKey(){
	   System.out.println();
	   Scanner scanner = new Scanner(System.in);
	   scanner.nextLine();
	} // end of promptKey

	public static void main(String[] args) {
		Player player1 = new Player("Anna", 1, 1, "player1.png");
		Player player2 = new Player("Jack", 1, 0, "player2.png");
		
		Clue clue = new Clue();
		clue.runGame(player1, player2);

	} // end of main

	public void chooseAction() {
//@todo move to its own method
		Room room = new Room("living Room"); //temp for now - need to figure out which room the player entered
		System.out.println("Do you want to suspect or accuse (s/a) ?");
		Scanner keyboard = new Scanner(System.in);
		String choice = keyboard.nextLine();
		String choiceDesc = "";
		if (choice.equals("s")) {
			choiceDesc = "suspect";
		} else if (choice.equals("a")) {
			choiceDesc = "accuse";
		} else {
			System.out.println("invalid choice");
		} // end of if (choice.equals("s"))


	}

	public void runGame(Player player1, Player player2) {  

		Rules r = new Rules();
		r.printRules();

		Clue d = new Clue();
		d.promptKey();
		System.out.println();
		System.out.println();


		Board b = new Board();
		Cards c = new Cards();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("1"));
		players.add(new Player("2"));
		
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
		boolean gameOn = true;
		int tempI = 0;
		
		Player currPlayer = player1;
		Player otherPlayer = player2;
		Suspicion s;
		Accusation a;

		while (gameOn) {
			//Suspicion s;
			//Accusation a;
			Movement m = new Movement();
			d.promptKey();
			System.out.println("You rolled a... " + m.diceRoll());

			if (true) {  //@todo in a room?  // in board gui

				//@todo move to its own method
				Room room = new Room("living Room"); //temp for now - need to figure out which room the player entered
				System.out.println("currPlayer = " + currPlayer);
				System.out.println("Do you want to suspect or accuse (s/a) ?");
				Scanner keyboard = new Scanner(System.in);
				String choice = keyboard.nextLine();
				String choiceDesc = "";
				if (choice.equals("s")) {
					choiceDesc = "suspect";
				} else if (choice.equals("a")) {
					choiceDesc = "accuse";
				} else {
					System.out.println("invalid choice");
					break;
					//continue
				} // end of if (choice.equals("s"))

				//Suspicion s;
				//Accusation a;

				System.out.println("What person would you like to "+choiceDesc+"?");
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
				System.out.println("What weapon would you like to "+choiceDesc+"?");
				Scanner keyboard2 = new Scanner(System.in);
				String weaponName = keyboard2.nextLine();
				Weapon weapon = new Weapon(weaponName);
				// if statements for each weapon // else invalid

				if (choice.equals("s")) {
					s = currPlayer.addSuspected(weapon, room, person);
					System.out.println("suspected: " + s);
				} else if (choice.equals("a")) {
					a = currPlayer.addAccusation(weapon, room, person);
					System.out.println("accused: " + a);
				} // end pf (choice.equals("s"))

				//@todo move to its own method
				if (choice.equals("s")) {
					//Suspicion s;
					//Accusation a;
					System.out.println("otherPlaye =" + otherPlayer);
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
						//s.setPersonFlag(pf);
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

						//@todo room and weapon
					}
				} else if (choice.equals("a")) {
					System.out.println("Do you wish to contest against your opponent's Accusation? Type 'Y' or 'N'.");
					Scanner keyboard3 = new Scanner(System.in);
					String otherPlayerChoice = keyboard3.nextLine();

					//@toDo
					//a.setPersonFlag(pf);


					//if (a.checkAccusation()) {
					//	gameOn = false;
					//}
				}

			} //end of if inside room

			tempI++;
			if ( tempI == 2 ) {
				gameOn = false;
			}

			if (currPlayer == player1) {
				currPlayer = player2;
				otherPlayer = player1;
			} else {
				currPlayer = player1;
				otherPlayer = player2;
			}

		} // end of while

		//System.out.println();

	}
} // end of class
