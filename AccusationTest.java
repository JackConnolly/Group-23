/**
*/

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class AccusationTest {

	public class MockCards extends Cards { 
		public MockCards(){};
		public MockCards(Weapon w, Room r, Person p) {
			super();
			this.setWinningWeapon(w);
			this.setWinningRoom(r);
			this.setWinningPerson(p);
			HumanPlayer p1 = new HumanPlayer("Anna");
			HumanPlayer p2 = new HumanPlayer("Jack");
			this.setPlayerOneObject(p1);
			this.setPlayerTwoObject(p2);
				
		}
		public MockCards(Weapon w, Room r, Person p, ArrayList<String> p2Cards) {
			super();
			this.setWinningWeapon(w);
			this.setWinningRoom(r);
			this.setWinningPerson(p);
			HumanPlayer p1 = new HumanPlayer("Anna");
			HumanPlayer p2 = new HumanPlayer("Jack");
			this.setPlayerOneObject(p1);
			this.setPlayerTwoObject(p2);
			this.setPlayerTwoHand(p2Cards);
		}		
		
    }

	@Test
	public void test_checkWinner_allCorrect() {
		Weapon w = new Weapon("revolver");
		Person p = new Person("miss scarlet");
		Room r = new Room("kitchen");
		MockCards c = new MockCards(w, r, p);
		Accusation a = new Accusation(w, r, p);
		boolean result = a.checkWinner(c);
		assertTrue("Result should be a winner", result);

	}

	@Test
	public void test_checkWinner_notCorrect() {
		Weapon w = new Weapon("revolver");
		Person p= new Person("miss scarlet");
		Room r = new Room("kitchen");
		Room r2 = new Room("Living_Room");
		MockCards c = new MockCards(w, r, p);
		Accusation a = new Accusation(w, r2, p);
		boolean result = a.checkWinner(c);
		assertTrue("Result should not be a winner", !result);

	} 

	@Test
	public void test_checkWinner_withMixedCase() {
		Weapon w = new Weapon("revolver");
		Person p= new Person("miss scArLET");
		Room r = new Room("kitchen");
		
		MockCards c = new MockCards(w, r, p);
		Accusation a = new Accusation(w, r, p);
		boolean result = a.checkWinner(c);
		assertTrue("Result should be a winner", result);

	}

	@Test
	public void test_checkContested_() {
		Weapon w = new Weapon("revolver");
		Person p= new Person("miss scArLET");
		Room r = new Room("kitchen");
		HumanPlayer cp = new HumanPlayer("Jack");
		ArrayList<String> p2Cards = new ArrayList<String>();
		p2Cards.add("revolver");
		p2Cards.add("Library");
		p2Cards.add("miss scarlet");

		MockCards c = new MockCards(w, r, p, p2Cards);
		Suspicion a = new Suspicion(w, r, p);
		//boolean result = a.checkWinner(c);
		ArrayList<String> matchCards = a.checkContested(c, cp);
		assertTrue("Result should have a specified list", matchCards != null && matchCards.size() == 2);
		assertEquals("First Match", "revolver", matchCards.get(0));
		assertEquals("second match", "miss scarlet", matchCards.get(1));
		//todo assert returnlist


	}

} // end of test file