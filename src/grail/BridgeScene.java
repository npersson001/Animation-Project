package grail;

import java.beans.PropertyChangeListener;

import mp.Avatar;
import mp.Gorge;
import mp.Rectangle;
import util.models.PropertyListenerRegisterer;

public interface BridgeScene extends PropertyListenerRegisterer{
	public Avatar getArthur();
	public Avatar getGalahad();
	public Avatar getLancelot();
	public Avatar getRobin();
	public Avatar getGuard();
	public Gorge getGorge();
	public Rectangle getGuardArea();
	public Rectangle getKnightArea();
	public boolean getOccupied();
	public void approachAvatar(Avatar anAvatar);
	public boolean getKnightTurn();
	public void say(String aString);
	public void passed();
	public void failed();
	public void moveTo(Avatar anAvatar, int initX, int initY);
	public boolean preSay();
	public boolean preFailed();
	public boolean prePassed();
	public boolean preApproachAvatar();
}
