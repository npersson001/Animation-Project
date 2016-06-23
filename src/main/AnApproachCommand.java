package main;

import grail.BridgeScene;
import mp.Avatar;
import util.annotations.Tags;

@Tags("ApproachCommand")
public class AnApproachCommand implements ApproachCommand{
	Avatar avatar;
	BridgeScene scene;
	
	public AnApproachCommand(BridgeScene aScene, Avatar anAvatar){
		scene = aScene;
		avatar = anAvatar;
	}
	
	public void run(){
		scene.approachAvatar(avatar);
	}
}
