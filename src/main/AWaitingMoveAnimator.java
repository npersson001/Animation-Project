package main;

public class AWaitingMoveAnimator extends AMoveAnimator implements WaitingMoveAnimator{
	BroadcastingClearanceManager manager;
	
	public AWaitingMoveAnimator(BroadcastingClearanceManager aManager){
		manager = aManager;
	}
	
	
}
