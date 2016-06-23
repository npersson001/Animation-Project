package mp;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@PropertyNames({"LeftLine","RightLine","Bridge"})
@EditablePropertyNames({"LeftLine","RightLine","Bridge"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class AGorge implements Gorge{
	Line leftLine, rightLine;
	Rectangle bridge;
	private final static int LINE_LENGTH = 800, LINE_Y = 0, LINE_ANGLE = 0, DISTANCE_BETWEEN_LINES = 100, BRIDGE_Y = 400, BRIDGE_HEIGHT = 70, BRIDGE_WIDTH = 100;
	
	public AGorge(int initX){
		leftLine = new ALine(initX, LINE_Y, LINE_LENGTH, LINE_ANGLE);
		rightLine = new ALine(initX+DISTANCE_BETWEEN_LINES, LINE_Y, LINE_LENGTH, LINE_ANGLE);
		bridge = new ARectangle(initX, BRIDGE_Y, BRIDGE_HEIGHT, BRIDGE_WIDTH);
	}
	
	public void setLeftLine(Line aLeftLine){
		leftLine = aLeftLine;
	}
	
	public Line getLeftLine(){
		return leftLine;
	}
	
	public void setRightLine(Line aRightLine){
		rightLine = aRightLine;
	}
	
	public Line getRightLine(){
		return rightLine;
	}
	
	public void setBridge(Rectangle aBridge){
		bridge = aBridge;
	}
	
	public Rectangle getBridge(){
		return bridge;
	}
}
