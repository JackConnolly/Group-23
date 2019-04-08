/**
* @author Anna Barrett 
* @since 03-31-19
* Last Updated: Kylie Sicat 03-31-19
*/

import java.util.ArrayList;

public class Square{


/**Room that this square has access to
*/
private String roomAccess;

/**Constructor for square with room access
*/
public Square(String room){
	setRoomAccess(room);
}

/**default constructor
*/
public Square(){
	
}

// Setter
public void setRoomAccess(String room){
	roomAccess = room;
}

// Getter
public String getRoomAccess(){
	return roomAccess;
}


/** checks if Player is on a room access square
* 
*
*/
public boolean hasRoomAccess(){
	//if roomAccess exists on the square the player is on it will return true otherwise false
	if (roomAccess != null){
		return true;
	}
	else
		return false;
}

}