package main;

import mp.Avatar;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags("Animator")
public class AMoveAnimator implements MoveAnimator{
	Avatar avatar;
	int addX, addY, targetX, targetY;
	static final int MOVE_INCREMENT = 1;
	private static final int SLEEP_TIME_SHORT = 10;
	
	public AMoveAnimator(){
	}
		
	@Tags("animateAvatar")
	public synchronized void moveAvatar(Avatar anAvatar, int moveX, int moveY){
		
		avatar = anAvatar;
		addX = moveX;
		addY = moveY;
		
		targetX = avatar.getHead().getX() + addX;
		targetY = avatar.getHead().getY() + addY;
		
		while(avatar.getHead().getX() != targetX || avatar.getHead().getY() != targetY){
			
			ThreadSupport.sleep(SLEEP_TIME_SHORT);
			
			if(avatar.getHead().getX() < targetX){
				avatar.getHead().setX(avatar.getHead().getX() + MOVE_INCREMENT);
				avatar.getArms().setX(avatar.getArms().getX() + MOVE_INCREMENT);
				avatar.getLegs().setX(avatar.getLegs().getX() + MOVE_INCREMENT);
				avatar.getTorso().setX(avatar.getTorso().getX() + MOVE_INCREMENT);
				avatar.getText().setX(avatar.getText().getX() + MOVE_INCREMENT);
			}
			else if(avatar.getHead().getX() > targetX){
				avatar.getHead().setX(avatar.getHead().getX() - MOVE_INCREMENT);
				avatar.getArms().setX(avatar.getArms().getX() - MOVE_INCREMENT);
				avatar.getLegs().setX(avatar.getLegs().getX() - MOVE_INCREMENT);
				avatar.getTorso().setX(avatar.getTorso().getX() - MOVE_INCREMENT);
				avatar.getText().setX(avatar.getText().getX() - MOVE_INCREMENT);
			}
			
			if(avatar.getHead().getY() < targetY){
				avatar.getHead().setY(avatar.getHead().getY() + MOVE_INCREMENT);
				avatar.getArms().setY(avatar.getArms().getY() + MOVE_INCREMENT);
				avatar.getLegs().setY(avatar.getLegs().getY() + MOVE_INCREMENT);
				avatar.getTorso().setY(avatar.getTorso().getY() + MOVE_INCREMENT);
				avatar.getText().setY(avatar.getText().getY() + MOVE_INCREMENT);
			}
			else if(avatar.getHead().getY() > targetY){
				avatar.getHead().setY(avatar.getHead().getY() - MOVE_INCREMENT);
				avatar.getArms().setY(avatar.getArms().getY() - MOVE_INCREMENT);
				avatar.getLegs().setY(avatar.getLegs().getY() - MOVE_INCREMENT);
				avatar.getTorso().setY(avatar.getTorso().getY() - MOVE_INCREMENT);
				avatar.getText().setY(avatar.getText().getY() - MOVE_INCREMENT);	
			}
		}
	}	
}
