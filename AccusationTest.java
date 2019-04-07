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

} // end of test file