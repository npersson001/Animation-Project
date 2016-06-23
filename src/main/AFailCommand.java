package main;

import grail.BridgeScene;
import util.annotations.Tags;

@Tags("FailCommand")
public class AFailCommand implements FailCommand{
	BridgeScene scene;
	
	public AFailCommand(BridgeScene aScene){
		scene = aScene;
	}
	
	public void run(){
		scene.failed();
	}
}
