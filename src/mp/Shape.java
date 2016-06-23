package mp;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags("BoundedShape")
public interface Shape extends Locatable, PropertyListenerRegisterer{
    public int getWidth();
    public int getHeight();
    public void setWidth(int initWidth);
    public void setHeight(int initHeight);
}
