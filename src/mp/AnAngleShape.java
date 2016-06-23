package mp;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@PropertyNames({"X","Y","Radius","Angle","LeftLine","RightLine"})
@EditablePropertyNames({"X","Y","Radius","Angle"})
@Tags({"Angle"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AnAngleShape implements AngleShape{
	int x, y;
	double radius, angle;
	Line leftLine, rightLine;
	private final static int INCREMENT_NUMERATOR = 64;
	
	public AnAngleShape(){
	}
	
	public AnAngleShape(int initX, int initY, double initRadius, double initAngle){
		x = initX;
		y = initY;
		radius = initRadius;
		angle = initAngle;
		leftLine = new ALine(x, y, radius, -angle);
		rightLine = new ALine(x, y, radius, angle);
	}
	
	public void setX(int initX){
		x = initX;
		leftLine.setX(x);
		rightLine.setX(x);
	}
	
	public int getX(){
		return x;
	}
	
	public void setY(int initY){
		y = initY;
		leftLine.setY(y);
		rightLine.setY(y);
	}
	
	public int getY(){
		return y;
	}
	
	public void setRadius(double initRadius){
		radius = initRadius;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setAngle(double initAngle){
		angle = initAngle;
	}
	
	public double getAngle(){
		return angle;
	}
	
	public Line getLeftLine(){
		return leftLine;
	}
	
	public Line getRightLine(){
		return rightLine;
	}
	
	 @Tags({"move"})
	public void moveLine(int numX, int numY){
	    x += numX;
	    y += numY;
	    leftLine.setY(y);
		rightLine.setY(y);
		leftLine.setX(x);
		rightLine.setX(x);
	}
	 
	public void rotateLine(int units){
	    int increment = INCREMENT_NUMERATOR/units;
	    rightLine.setAngle(angle+= Math.PI/increment);
	}
}
