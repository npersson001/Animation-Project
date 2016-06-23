package grail;

import mp.AnAvatar;
import mp.AnImage;
import mp.Avatar;
import mp.ImageShape;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import main.AListenerSupport;
import main.ListenerSupport;
import mp.AGorge;
import mp.Gorge;
import mp.ARectangle;
import mp.Rectangle;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.misc.ThreadSupport;
import util.annotations.PropertyNames;

@PropertyNames({"Guard","Arthur","Lancelot","Robin","Galahad","Gorge","GuardArea","KnightArea","Occupied","KnightTurn"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BridgeScene"})
public class ABridgeScene implements BridgeScene{
	Avatar arthur, lancelot, robin, galahad, guard, questionedKnight;
	Gorge gorge;
	Rectangle guardArea, knightArea;
	boolean occupied = false, knightTurn = false;
	private final static int RIGHT_X = 250, LEFT_X = 100, UPPER_Y = 100, LOWER_Y = 300, AVATAR_HEIGHT = 64, AVATAR_WIDTH = 40, GUARD_X = 725, GUARD_Y = 250;
	private final static int GORGE_X = 800, GUARD_AREA_X = 710, GUARD_AREA_Y = 400, SQUARE_SIDE = 70, KNIGHT_AREA_X = 620, KNIGHT_AREA_Y = 400;
	private final static int FALL_X = 825, FALL_Y = 500, PASS_X = 1050, PASS_Y = 250, APPROACH_X = 635, APPROACH_Y = 250;
	private final static int ZERO = 0, FIVE = 5, ONE = 1, SLEEP_TIME_SHORT = 10, SLEEP_TIME_LONG = 1000;
	ListenerSupport listenerSupport = new AListenerSupport();
	
	public ABridgeScene(){
		ImageShape arthurImage = new AnImage("arthur.jpg", RIGHT_X, LOWER_Y, AVATAR_HEIGHT, AVATAR_WIDTH);
		ImageShape lancelotImage = new AnImage("lancelot.jpg", RIGHT_X, UPPER_Y, AVATAR_HEIGHT, AVATAR_WIDTH);
		ImageShape robinImage = new AnImage("robin.jpg", LEFT_X, UPPER_Y, AVATAR_HEIGHT, AVATAR_WIDTH);
		ImageShape galahadImage = new AnImage("galahad.jpg", LEFT_X, LOWER_Y, AVATAR_HEIGHT, AVATAR_WIDTH);
		ImageShape guardImage = new AnImage("guard.jpg", GUARD_X, GUARD_Y, AVATAR_HEIGHT, AVATAR_WIDTH);
	
		arthur = new AnAvatar(arthurImage);
		lancelot = new AnAvatar(lancelotImage);
		robin = new AnAvatar(robinImage);
		galahad = new AnAvatar(galahadImage);
		guard = new AnAvatar(guardImage);
		gorge = new AGorge(GORGE_X);
		guardArea = new ARectangle(GUARD_AREA_X, GUARD_AREA_Y, SQUARE_SIDE, SQUARE_SIDE);
		knightArea = new ARectangle(KNIGHT_AREA_X, KNIGHT_AREA_Y, SQUARE_SIDE, SQUARE_SIDE);	
	}
	
	public Avatar getGuard(){
		return guard;
	}
	
	public Avatar getArthur(){
		return arthur;
	}
	
	public Avatar getLancelot(){
		return lancelot;
	}
	
	public Avatar getRobin(){
		return robin;
	}
	
	public Avatar getGalahad(){
		return galahad;
	}
	
	public Gorge getGorge(){
		return gorge;
	}
	
	public Rectangle getGuardArea(){
		return guardArea;
	}
	
	public Rectangle getKnightArea(){
		return knightArea;
	}
	
	@Tags("approach")
	public void approachAvatar(Avatar anAvatar){
		
		assert preApproachAvatar();
		
		anAvatar.moveAvatar(APPROACH_X - anAvatar.getHead().getX(), APPROACH_Y - anAvatar.getHead().getY());
		
		if(anAvatar.getHead().getX() == APPROACH_X && anAvatar.getHead().getY() == APPROACH_Y){
			occupied = true;
			listenerSupport.notifyAllListeners(new PropertyChangeEvent (this, "occupied", false, true));
			questionedKnight = anAvatar;
		}
	}
	
	public boolean preApproachAvatar(){
		return !occupied;
	}

	public boolean getOccupied(){
		return occupied;
	}
	
	public boolean getKnightTurn(){
		return knightTurn;
	}
	
	@Tags("say")
	public void say(String aString){
		
		assert preSay();
		
		ThreadSupport.sleep(SLEEP_TIME_LONG);
		
		if(knightTurn){
			questionedKnight.getText().setText(aString);
			knightTurn = false;
			listenerSupport.notifyAllListeners(new PropertyChangeEvent (this, "knightTurn", true, false));
		}
		else{
			guard.getText().setText(aString);
			knightTurn = true;
			listenerSupport.notifyAllListeners(new PropertyChangeEvent (this, "knightTurn", false, true));
		}
		
		ThreadSupport.sleep(SLEEP_TIME_LONG);

	}
	
	public boolean preSay(){
		return occupied;
	}
	
	@Tags("passed")
	public void passed(){
		
		assert prePassed();
		
		guard.getText().setText("Correct!");
		questionedKnight.getText().setText("Yes!");
		
		ThreadSupport.sleep(SLEEP_TIME_LONG);
		
		questionedKnight.moveAvatar(PASS_X - questionedKnight.getHead().getX(), PASS_Y - questionedKnight.getHead().getY());
	
		if(questionedKnight.getHead().getX() == PASS_X && questionedKnight.getHead().getY() == PASS_Y){
			occupied = false;
			listenerSupport.notifyAllListeners(new PropertyChangeEvent (this, "occupied", true, false));
			questionedKnight.getText().setText("");
			guard.getText().setText("");
		}
	}
	
	public boolean prePassed(){
		return !knightTurn;
	}
	
	@Tags("failed")
	public void failed(){
		
		assert preFailed();
		
		if(!knightTurn){
			guard.getText().setText("Never!");
			questionedKnight.getText().setText("AHHHHH");

			ThreadSupport.sleep(SLEEP_TIME_LONG);
			
			questionedKnight.moveAvatar(FALL_X - questionedKnight.getHead().getX(), FALL_Y - questionedKnight.getHead().getY());
		}
		else{
			guard.getText().setText("NOOOOOO!");
			questionedKnight.getText().setText("Gotcha!");
			
			ThreadSupport.sleep(SLEEP_TIME_LONG);
			
			guard.moveAvatar(FALL_X - guard.getHead().getX(), FALL_Y - guard.getHead().getY());
		}
		
		if(questionedKnight.getHead().getX() == FALL_X && questionedKnight.getHead().getY() == FALL_Y){
			occupied = false;
			listenerSupport.notifyAllListeners(new PropertyChangeEvent (this, "occupied", true, false));
			questionedKnight.getText().setText("");
			guard.getText().setText("");
		}
		else if(guard.getHead().getX() == FALL_X && guard.getHead().getY() == FALL_Y){
			occupied = false;
			listenerSupport.notifyAllListeners(new PropertyChangeEvent (this, "occupied", true, false));
			questionedKnight.getText().setText("");
			guard.getText().setText("");
		}
	}
	
	public boolean preFailed(){
		return occupied;
	}
	
	public void moveTo(Avatar anAvatar, int initX, int initY){
		int x = anAvatar.getHead().getX();
		int y = anAvatar.getHead().getY();
		int targetX = initX;
		int targetY = initY;
		
		if(y < targetY){
			anAvatar.moveAvatar(ZERO, ONE);
		}			
		else if(y > targetY){
				anAvatar.moveAvatar(ZERO, -ONE);
		}
	
		if(x < targetX){				
			anAvatar.moveAvatar(ONE, ZERO);
		}
		else if(x > targetX){
			anAvatar.moveAvatar(-ONE, ZERO);
		}
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listenerSupport.add(listener);
	}  
}
