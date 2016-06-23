package main;

import grail.BridgeScene;
import util.annotations.Tags;

@Tags("PassCommand")
public class APassCommand implements PassCommand{
	BridgeScene scene;
	
	public APassCommand(BridgeScene aScene){
		scene = aScene;
	}
	
	public void run(){
		scene.passed();
	}
}
