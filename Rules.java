/**
* Rules class that contains the rules for the board game clue
* @author Kylie Sicat
* @since 03-14-19
*/


public class Rules {
	
	public Rules(){}
	
	//println(  + )
	public void printRules() {

		System.out.println("Welcome To Clue!");
		System.out.println("Objectives: The objective of the game is to figure out who the murder is! In order to do this, You must find the correct weapon, room, and person.");
		System.out.println("To do so, you are each given 6 cards. Some cards are weapons, rooms, and people. The winning cards are not in either of the players hands.");
		System.out.println("To play: Roll the dice to give you the amount of squares you can move on the board. If you end up in a room you are given the option to 'suspect' or 'accuse'.");
		System.out.println("To suspect, you can choose who you think did it, and with what weapon, the other player is given the option to contest towards your suspicion if they have any of the cards you used to suspect with.");
		System.out.println("To accuse, it is similar to suspecting HOWEVER! Be sure your accusation is correct or ELSE IF one or more of your weapon, room or person is wrong you lose and the other player Wins the Game.");

	}
}