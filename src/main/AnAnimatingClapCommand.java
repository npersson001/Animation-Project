package main;

import mp.Avatar;
import util.annotations.Tags;

@Tags("AnimatingCommand")
public class AnAnimatingClapCommand implements AnimatingClapCommand{
	Avatar avatar;
	ClapAnimator animator;
	
	public AnAnimatingClapCommand(ClapAnimator anAnimator, Avatar anAvatar){
		animator = anAnimator;
		avatar = anAvatar;
	}
	
	public void run(){
		animator.clapAvatar(avatar);
	}
}