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


/**Constructor for square with room access
*/
public Square(String room){
	setRoomAccess(room);
}


/**default constructor
*/
public Square(){
	
}



}