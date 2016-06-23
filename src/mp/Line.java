package mp;
import util.models.PropertyListenerRegisterer;

public interface Line extends Locatable, PropertyListenerRegisterer{
    public void setRadius(double initialRadius);
    public void setAngle(double initialAngle);
    public double getRadius();
    public double getAngle();
    public int getHeight();
    public int getWidth();
    public void rotateLine(int units);
}
