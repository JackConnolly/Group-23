import java.util.ArrayList;

public class Square{


/**Room that this square has access to
*/
String roomAccess;



/**setters for roomAccess
*/
public void setRoomAccess(String room){
	roomAccess = room;
}

public String getRoomAccess(){
	return roomAccess;
}


/**Constructor for square with room access
*/
public Square(String room){
	setRoomAccess(room);
}


/**default constructor
*/
public Square(){
	
}

public boolean hasRoomAccess(){
	if (roomAccess != null){
		return true;
	}
	else
		return false;
}


}