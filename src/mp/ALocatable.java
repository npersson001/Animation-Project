package mp;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import main.AListenerSupport;
import main.ListenerSupport;


@PropertyNames({"X","Y"})
@EditablePropertyNames({"X","Y"})
@Tags("Locatable")
public abstract class ALocatable implements Locatable{
		int x, y;
		ListenerSupport listenerSupport = new AListenerSupport();
	
		public ALocatable(int initX, int initY){
			x = initX;
			y = initY;
		}
	
	 	public void setX(int tempX){
	 		int oldVal = x;
	 		int newVal = tempX;
	    	x = tempX;
	    	listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal, newVal));
	    }
	    
	    public int getX(){
	    	return x;
	    }
	    
	    public void setY(int tempY){
	    	int oldVal = y;
	 		int newVal = tempY;
	    	y = tempY;
	    	listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal, newVal));
	    }
	    
	    public int getY(){
	    	return y;
	    }
	    
	    public void addPropertyChangeListener(PropertyChangeListener listener) {
			listenerSupport.add(listener);
		}  
}
