package main;

import grail.BridgeScene;
import util.annotations.Tags;

@Tags("SayCommands")
public class ASayCommand implements SayCommand{
	String string;
	BridgeScene scene;
	
	public ASayCommand(BridgeScene aBridgeScene, String aString){
		string = aString;
		scene = aBridgeScene;
	}
	
	
	public void run(){
		scene.say(string);
	}
}
