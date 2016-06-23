package mp;
import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;


@PropertyNames({"X","Y","Height","Width"})
@EditablePropertyNames({"X","Y","Height","Width"})
@Tags("BoundedShape")
public abstract class AShape extends ALocatable implements Shape{
    int width, height;
    
    public AShape (int initX, int initY, int initHeight, int initWidth) {
    	super(initX, initY);
    	height = initHeight;
    	width = initWidth;
    }
    
    public int getWidth(){
    	return width;
    }
    
    public int getHeight(){
    	return height;
    }
    
    public void setHeight(int initHeight){
    	int oldVal = height;
    	int newVal = initHeight;
    	height = initHeight;
    	listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldVal, newVal));
    }
    
    public void setWidth(int initWidth){
    	int oldVal = width;
    	int newVal = initWidth;
    	width = initWidth;
    	listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldVal, newVal));
    }
}