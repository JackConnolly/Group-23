/**
* Accusation Class
* @author Kylie Sicat
* @since 03-18-19
*/

public class Accusation extends Suspicion {


	// Constructor same as parent class suspicion
	public Accusation(Weapon weapon, Room room, Person person) {
		super(weapon, room, person);
	}

	public boolean checkWinner(Cards cards) {
		
		if ( cards != null && cards.getWinningRoom() != null
			&& cards.getWinningWeapon() != null && cards.getWinningPerson() != null) {
			if ( compare(this.getRoom().getName(), cards.getWinningRoom().getName())
				&&  compare(this.getWeapon().getName(), cards.getWinningWeapon().getName()) 
				&& compare(this.getPerson().getName(), cards.getWinningPerson().getName()) ) {
				//System.out.println("Congratualations! you have accused the rightful murderer!");
				return true;
			} else {
				//System.out.println("the winning cards are" + cards.getWinningRoom() + " " + cards.getWinningWeapon() + " " + cards.getWinningPerson());
				return false;

			}
			
		} else {
			return false;
		}
		
		
	}

	public boolean winningPrompt(Cards cards) {
		
		if (checkWinner(cards) == true) {
			System.out.println("Congratualations! you have accused the rightful murderer!");
			return true;
		} else {
			System.out.println("Boohoo! You have not accused the rightful murderer. The winning Cards were" + cards.getWinningRoom()+ " " + cards.getWinningWeapon() + " " + cards.getWinningPerson());
			return false;
			//System.out.println("the winning cards are" + cards.getWinningRoom() + " " + cards.getWinningWeapon() + " " + cards.getWinningPerson());
		}
	
		
	}

	
} // end of Class