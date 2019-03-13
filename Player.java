import java.util.ArrayList;

public class Player{

String name;
int xpos;
int ypos;
String token;


public Player(String n){
	name = n;
}

public Player(String name, int xpos, int ypos, String token){
	this.name = name;
	this.xpos = xpos;
	this.ypos = ypos;
	this.token = token;
}

public int[] getPlayerPosition(){
	int[] a = new int[]{xpos, ypos};
	return a;
}

public void setPlayerToken(String imageName){
	token = imageName;
}

public String getPlayerToken(){
	return token;
}

}