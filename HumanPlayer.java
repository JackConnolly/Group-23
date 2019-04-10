import java.util.ArrayList;
import java.util.Scanner;


public class HumanPlayer extends Player{

public HumanPlayer(String name){
	super(name);
}
public HumanPlayer(String name, int xPos, int yPos, String token){
	super(name, xPos, yPos, token);
}

public boolean isAI(){
	return false;
}

public void promptForName(){
	System.out.println("What is your name? ");
	Scanner input = new Scanner(System.in);
	String name = input.nextLine();
	HumanPlayer player = new HumanPlayer(name);
}


}