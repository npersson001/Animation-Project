package main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import grail.BridgeScene;
import util.annotations.Tags;

@Tags("ConsoleSceneView")
public class AConsoleSceneView implements ConsoleSceneView, PropertyChangeListener{
	BridgeScene model;
	CommandInterpreter command;
	public AConsoleSceneView(BridgeScene aBridgeScene){
		model = aBridgeScene;
		registerWithModel();
	}
	
	public AConsoleSceneView(BridgeScene aBridgeScene, CommandInterpreter aCommand){
		command = aCommand;
		model = aBridgeScene;
		registerWithModel();
	}
	
	void registerWithModel() {
		
		command.addPropertyChangeListener(this);
		
		model.addPropertyChangeListener(this);
		
		model.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
		model.getArthur().getHead().addPropertyChangeListener(this);
		model.getArthur().getTorso().addPropertyChangeListener(this);
		model.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getArthur().getText().addPropertyChangeListener(this);
		
		model.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getLancelot().getArms().getRightLine().addPropertyChangeListener(this);
		model.getLancelot().getHead().addPropertyChangeListener(this);
		model.getLancelot().getTorso().addPropertyChangeListener(this);
		model.getLancelot().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getLancelot().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getLancelot().getText().addPropertyChangeListener(this);
		
		model.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getRobin().getArms().getRightLine().addPropertyChangeListener(this);
		model.getRobin().getHead().addPropertyChangeListener(this);
		model.getRobin().getTorso().addPropertyChangeListener(this);
		model.getRobin().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getRobin().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getRobin().getText().addPropertyChangeListener(this);
		
		model.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getGalahad().getArms().getRightLine().addPropertyChangeListener(this);
		model.getGalahad().getHead().addPropertyChangeListener(this);
		model.getGalahad().getTorso().addPropertyChangeListener(this);
		model.getGalahad().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getGalahad().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getGalahad().getText().addPropertyChangeListener(this);
		
		model.getGuard().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getGuard().getArms().getRightLine().addPropertyChangeListener(this);
		model.getGuard().getHead().addPropertyChangeListener(this);
		model.getGuard().getTorso().addPropertyChangeListener(this);
		model.getGuard().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getGuard().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getGuard().getText().addPropertyChangeListener(this);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println ("Property change event: " + evt);
	}
}
