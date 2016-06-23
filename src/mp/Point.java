package mp;

import util.models.PropertyListenerRegisterer;

public interface Point extends PropertyListenerRegisterer{
    public int getX(); 
    public int getY();  
    public double getAngle(); 
    public double getRadius();
    public void setAngle(double newAngle);
}