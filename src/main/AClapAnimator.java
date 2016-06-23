package main;

import mp.Avatar;
import util.misc.ThreadSupport;

public class AClapAnimator implements ClapAnimator {
	Avatar avatar;
	private static final int ROTATION_UNITS = 1, SHORT_SLEEP = 10, THIRTY_THREE = 33, FOURTY = 40;
	
	public AClapAnimator(){
	}
	
	public synchronized void clapAvatar(Avatar anAvatar){
		avatar = anAvatar;
		
		avatar.getArms().rotateLine(THIRTY_THREE);
		
		while(true){
			for(int i = 0; i < FOURTY; i++){
				ThreadSupport.sleep(SHORT_SLEEP);
				avatar.getArms().rotateLine(ROTATION_UNITS);
			}
			for(int i = 0; i < FOURTY; i++){
				ThreadSupport.sleep(SHORT_SLEEP);
				avatar.getArms().rotateLine(-ROTATION_UNITS);
			}
		}
	}
}
