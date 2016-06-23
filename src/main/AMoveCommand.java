package main;

import mp.Avatar;
import util.annotations.Tags;

@Tags("MoveCommand")
public class AMoveCommand implements MoveCommand{
	static final int MOVE_INCREMENT = 1;
	Avatar avatar;
	int addX, addY;;
	
	public AMoveCommand(Avatar anAvatar, int initX, int initY){
		avatar = anAvatar;
		addX = initX;
		addY = initY;
	}
	
	public void run(){
		avatar.moveAvatar(addX, addY);
	}
}
