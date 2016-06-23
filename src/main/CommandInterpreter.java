package main;

import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;

public interface CommandInterpreter extends PropertyListenerRegisterer{
	public void setCommand(String aString);
	public String getCommand();
	public void asynchronousArthur();
	public void asynchronousGalahad();
	public void asynchronousRobin();
	public void asynchronousLancelot();
	public void asynchronousGuard();
	public void addPropertyChangeListener(PropertyChangeListener listener);
	public void waitingArthur();
	public void waitingRobin();
	public void waitingGalahad();
	public void waitingLancelot();
	public void startAnimation();
}
