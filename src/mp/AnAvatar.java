package mp;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;
import util.annotations.EditablePropertyNames;	
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@PropertyNames({"Text","Head","Arms","Legs","Torso"})	
@EditablePropertyNames({"Text"})	
@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AnAvatar implements Avatar {
	StringShape text;
	ImageShape head;
	AngleShape arms, legs;
	Line torso;
	private final static int DISTANCE_FROM_HEAD_X = 5, DISTANCE_FROM_HEAD_Y = 2, RADIANS_DENOMINATOR_FOR_THIRTY_DEGREES = 6, MOVE_INCREMENT = 1;
	private static final long SLEEP_TIME_SHORT = 10;
	
	@Tags("connect")
	public AnAvatar(ImageShape characterHead){
		
		head = characterHead;
		torso = new ALine(head.getX()+(head.getWidth()/2), head.getY()+head.getHeight(), (double)head.getHeight(), (double)0);
		arms = new AnAngleShape(head.getX()+(head.getWidth()/2), head.getY()+head.getHeight(), (double)head.getHeight(), (double)(Math.PI/RADIANS_DENOMINATOR_FOR_THIRTY_DEGREES));
		legs = new AnAngleShape(head.getX()+(head.getWidth()/2), head.getY()+(2*head.getHeight()), (double)head.getHeight(), (double)(Math.PI/RADIANS_DENOMINATOR_FOR_THIRTY_DEGREES));
		text = new AStringShape("", head.getX()+head.getWidth()+DISTANCE_FROM_HEAD_X, head.getY()-DISTANCE_FROM_HEAD_Y);
	}
	
	public void setText(StringShape initText){
		text = initText;
	}
	
	public StringShape getText(){
		return text;
	}
	
	public ImageShape getHead(){
		return head;
	}
	
	public AngleShape getArms(){
		return arms;
	}
	
	public AngleShape getLegs(){
		return legs;
	}
	
	public Line getTorso(){
		return torso;
	}
	
	@Tags({"move"})
	public void moveAvatar(int addX, int addY){
		
		int targetX = head.getX() + addX;
		int targetY = head.getY() + addY;
		
		while(head.getX() != targetX || head.getY() != targetY){
			ThreadSupport.sleep(SLEEP_TIME_SHORT);
			if(head.getX() < targetX){
				head.setX(head.getX() + MOVE_INCREMENT);
				arms.setX(arms.getX() + MOVE_INCREMENT);
				legs.setX(legs.getX() + MOVE_INCREMENT);
				torso.setX(torso.getX() + MOVE_INCREMENT);
				text.setX(text.getX() + MOVE_INCREMENT);
			}
			else if(head.getX() > targetX){
				head.setX(head.getX() - MOVE_INCREMENT);
				arms.setX(arms.getX() - MOVE_INCREMENT);
				legs.setX(legs.getX() - MOVE_INCREMENT);
				torso.setX(torso.getX() - MOVE_INCREMENT);
				text.setX(text.getX() - MOVE_INCREMENT);
			}
			
			if(head.getY() < targetY){
				head.setY(head.getY() + MOVE_INCREMENT);
				arms.setY(arms.getY() + MOVE_INCREMENT);
				legs.setY(legs.getY() + MOVE_INCREMENT);
				torso.setY(torso.getY() + MOVE_INCREMENT);
				text.setY(text.getY() + MOVE_INCREMENT);
			}
			else if(head.getY() > targetY){
				head.setY(head.getY() - MOVE_INCREMENT);
				arms.setY(arms.getY() - MOVE_INCREMENT);
				legs.setY(legs.getY() - MOVE_INCREMENT);
				torso.setY(torso.getY() - MOVE_INCREMENT);
				text.setY(text.getY() - MOVE_INCREMENT);
			}
		}
	}
	
	public void teleportAvatar(int initX, int initY){
		head.setX(initX);
		head.setY(initY);
	}
	
	public void scaleAvatar(int scale){
		head.setHeight(head.getHeight()+scale);
		head.setWidth(head.getWidth()+scale);
		torso.setX(head.getX()+(head.getWidth()/2));
		torso.setY(head.getY()+head.getHeight());
		torso.setRadius((double)head.getHeight());
		arms.setX(head.getX()+(head.getWidth()/2));
		arms.setY(head.getY()+head.getHeight());
		arms.setRadius((double)head.getHeight());
		legs.setX(head.getX()+(head.getWidth()/2));
		legs.setY(head.getY()+(2*head.getHeight()));
		legs.setRadius((double)head.getHeight());
		text.setX(head.getX()+head.getWidth()+DISTANCE_FROM_HEAD_X);
		text.setY(head.getY()-2);
	}
	
}
