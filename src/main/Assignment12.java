package main;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.ABridgeScene;
import grail.ABridgeSceneController;
import grail.ABridgeSceneView;
import grail.BridgeScene;
import grail.BridgeSceneView;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.misc.ThreadSupport;

public class Assignment12 {
	final static int SLEEP_TIME_SHORT = 10, FRAME_X = 1000, FRAME_Y = 800, SLEEP_TIME_LONG = 3000, SMALL_FRAME_X = 300, SMALL_FRAME_Y = 300;
	final static int EIGHTY = 80, NINETY = 90, HUNDRED = 100;
	final static int APPROACH_X = 635, ARTHUR_X = 250;
	
	
	public static void main(String[] args){
		BridgeScene bridgeScene = new ABridgeScene();
		ScannerBeanInterface scannedString = new ScannerBean("");
		BroadcastingClearanceManager manager = new ABroadcastingClearanceManager();
		CommandInterpreter command = new ACommandInterpreter(bridgeScene, scannedString, manager);
		BridgeSceneView view = new ABridgeSceneView(bridgeScene, command);
		new AConsoleSceneView(bridgeScene, command);
		ObjectEditor.edit(command);
		ObjectEditor.edit(manager);
		JFrame frame = new JFrame("A BridgeScene View");
		frame.add((Component) view);
		frame.setSize(FRAME_X,FRAME_Y);
		frame.setVisible(true);
		
		command.waitingArthur();
		command.waitingGalahad();
		command.waitingLancelot();
		command.waitingRobin();
	}
}