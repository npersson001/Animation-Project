package mp;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import main.AListenerSupport;
import main.ListenerSupport;
import util.annotations.PropertyNames;

@PropertyNames({"X","Y","Angle","Radius"})
@StructurePattern(StructurePatternNames.POINT_PATTERN)
public class APolarPoint implements Point {
	ListenerSupport listenerSupport = new AListenerSupport();
    double radius, angle;
    
    public APolarPoint(double theRadius, double theAngle) {
        radius = theRadius;
        angle = theAngle;
    }
    
    public int getX() { return (int) (radius*Math.sin(angle)); }
    public int getY() { return (int) (radius*Math.cos(angle)); }
    public double getAngle() { return angle; } 
    public double getRadius() { return radius;}
    
    public void setAngle(double newAngle){
    	double oldVal = angle;
    	double newVal = newAngle;
    	angle = newAngle;
    	listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Angle", oldVal, newVal));
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
		listenerSupport.add(listener);
	} 
}  