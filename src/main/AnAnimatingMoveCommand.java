package main;

import mp.Avatar;
import util.annotations.Tags;

@Tags("AnimatingCommand")
public class AnAnimatingMoveCommand implements AnimatingMoveCommand{
	Avatar avatar;
	int addX, addY;
	MoveAnimator animator;
	BroadcastingClearanceManager manager;
	boolean checker = false;
	
	public AnAnimatingMoveCommand(MoveAnimator anAnimator, Avatar anAvatar, int initX, int initY, BroadcastingClearanceManager aManager, boolean aBoolean){
		animator = anAnimator;
		avatar = anAvatar;
		addX = initX;
		addY = initY;
		checker = aBoolean;
		manager = aManager;
	}
	
	public void run(){
		if(checker){
			manager.waitForProceed();
		}
		animator.moveAvatar(avatar, addX, addY);
	}
}
