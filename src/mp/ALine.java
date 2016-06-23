package mp;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@PropertyNames({"X","Y","Radius","Angle","Width","Height"})
@EditablePropertyNames({"X","Y","Radius","Angle"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)

public class ALine extends ALocatable implements Line{
    double radius, angle;
    Point aPolarPoint = new APolarPoint(radius, angle);
    private final int THIRTY_TWO = 32;
    
    public ALine (int initX, int initY, double initialRadius, double initialAngle) {
    	super(initX, initY);
        radius = initialRadius;
        angle = initialAngle;
    }
    
    public int getWidth(){
    	return (int)(radius*Math.sin(angle));
    }
    
    public int getHeight(){
    	return (int)(radius*Math.cos(angle));
    }
    
    public void setX(int tempX){
    	int oldVal = x;
    	int newVal = tempX;
    	x = tempX;
    	listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal, newVal));
    }
    
    public void setY(int tempY){
    	int oldVal = y;
    	int newVal = tempY;
    	y = tempY;
    	listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal, newVal));
    }
    
    public void setRadius(double newRadius){
    	double oldVal = radius;
    	double newVal = newRadius;
    	radius = newRadius;
        listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Radius", oldVal, newVal));
    }
    
    public void setAngle(double newAngle){
    	int oldHeight = this.getHeight(), oldWidth = this.getWidth();
        angle = newAngle;
        int newHeight = this.getHeight(), newWidth = this.getWidth();
        listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, newHeight));
        listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, newWidth));
    }
    
    public double getRadius(){
    	return radius;
    }
    
    public double getAngle(){
    	return angle;
    }
    
	public void rotateLine(int units){
		int oldWidth = this.getWidth(), oldHeight = this.getHeight();
    	angle += (double)(units*Math.PI/THIRTY_TWO);
    	int newWidth = this.getWidth(), newHeight = this.getHeight();
    	aPolarPoint.setAngle(angle);
    	listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, newWidth));
    	listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, newHeight));

    }
}