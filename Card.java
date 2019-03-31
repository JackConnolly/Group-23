/**
* Card Object Class
@author Kylie Sicat
@since 03-31-19
*
*/

public class Card {
	// Instance Variables
	private String name;
	private String type;

	// Constructors
	public Card(String name) {

		this.name = name;

	}

	// Getter for name
	public String getName() {
		return name;
	}

	/** toString method
	* returns String of name
	*/
	public String toString() {
		return "Name: " + name;
	}
}