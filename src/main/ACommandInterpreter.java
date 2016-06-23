package main;

import java.beans.PropertyChangeListener;

import grail.BridgeScene;
import mp.Avatar;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"Command","Table","BridgeScene","ScannerBean"})	
@EditablePropertyNames({"Command"})	
@Tags("CommandInterpreter")
public class ACommandInterpreter implements CommandInterpreter{
	final static int POSITIVE = 1, NEGATIVE = -1, MOVE_DISTANCE = 50;
	BridgeScene aBridgeScene;
	ScannerBeanInterface aScannerBean;
	Table<String,Object> aTable;
	String aCommand;
	ListenerSupport listenerSupport = new AListenerSupport();
	MoveAnimator arthurMove = new AMoveAnimator();;
	MoveAnimator galahadMove = new AMoveAnimator();;
	MoveAnimator robinMove = new AMoveAnimator();;
	MoveAnimator lancelotMove = new AMoveAnimator();;
	ClapAnimator guardClap = new AClapAnimator();
	BroadcastingClearanceManager manager;
	
	public ACommandInterpreter(BridgeScene initBridgeScene, ScannerBeanInterface initScannerBean, BroadcastingClearanceManager aManager){
		aCommand = "";
		manager = aManager;
		aBridgeScene = initBridgeScene;
		aScannerBean = initScannerBean;
		aTable = new ATable<String, Object>();
		aTable.put("arthur", aBridgeScene.getArthur());
		aTable.put("robin", aBridgeScene.getRobin());
		aTable.put("guard", aBridgeScene.getGuard());
		aTable.put("galahad", aBridgeScene.getGalahad());
		aTable.put("lancelot", aBridgeScene.getLancelot());
	}
	
	@Visible(false)
	public BridgeScene getBridgeScene(){
		return aBridgeScene;
	}
	
	@Visible(false)
	public ScannerBeanInterface getScannerBean(){
		return aScannerBean;
	}
	
	@Visible(false)
	public Table<String, Object> getTable(){
		return aTable;
	}
	
	public void setCommand(String aString){
		aCommand = aString;
		AParser parser = new AParser(aBridgeScene);
		parser.setCommandText(aCommand);
		parser.getCommandObject().run();
	}
	
	public String getCommand(){
		return aCommand;
	}
	
	@Tags("asynchronousArthur")
	public void asynchronousArthur(){
		Thread thread1 = new Thread(new AnAnimatingMoveCommand(arthurMove, aBridgeScene.getArthur(), MOVE_DISTANCE, MOVE_DISTANCE, manager, false));
		thread1.start();
		}
	
	@Tags("asynchronousGalahad")
	public void asynchronousGalahad(){
		Thread thread2 = new Thread(new AnAnimatingMoveCommand(galahadMove, aBridgeScene.getGalahad(), MOVE_DISTANCE, MOVE_DISTANCE, manager, false));
		thread2.start();
	}
	
	@Tags("asynchronousLancelot")
	public void asynchronousLancelot(){
		Thread thread3 = new Thread(new AnAnimatingMoveCommand(lancelotMove, aBridgeScene.getLancelot(), MOVE_DISTANCE, MOVE_DISTANCE, manager, false));
		thread3.start();
	}
	
	@Tags("asynchronousRobin")
	public void asynchronousRobin(){
		Thread thread4 = new Thread(new AnAnimatingMoveCommand(robinMove, aBridgeScene.getRobin(), MOVE_DISTANCE, MOVE_DISTANCE, manager, false));
		thread4.start();
	}
	
	@Tags("AsynchronousGuard")
	public void asynchronousGuard(){
		Thread thread5 = new Thread(new AnAnimatingClapCommand(guardClap, aBridgeScene.getGuard()));
		thread5.start();
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listenerSupport.add(listener);
	} 
	
	@Tags("waitingArthur")
	public void waitingArthur(){
		Thread thread1 = new Thread(new AnAnimatingMoveCommand(arthurMove, aBridgeScene.getArthur(), MOVE_DISTANCE, MOVE_DISTANCE, manager, true));
		thread1.start();
	}
	
	@Tags("waitingLancelot")
	public void waitingLancelot(){
		Thread thread2 = new Thread(new AnAnimatingMoveCommand(lancelotMove, aBridgeScene.getLancelot(), MOVE_DISTANCE, MOVE_DISTANCE, manager, true));
		thread2.start();
	}
	
	@Tags("waitingRobin")
	public void waitingRobin(){
		Thread thread3 = new Thread(new AnAnimatingMoveCommand(robinMove, aBridgeScene.getRobin(), MOVE_DISTANCE, MOVE_DISTANCE, manager, true));
		thread3.start();
	}
	
	@Tags("waitingGalahad")
	public void waitingGalahad(){
		Thread thread4 = new Thread(new AnAnimatingMoveCommand(galahadMove, aBridgeScene.getGalahad(), MOVE_DISTANCE, MOVE_DISTANCE, manager, true));
		thread4.start();
	}
	
	@Tags("startAnimation")
	public void startAnimation(){
		 manager.proceedAll();
	}
}
