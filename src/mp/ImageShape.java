package mp;

import util.models.PropertyListenerRegisterer;

public interface ImageShape extends Shape, PropertyListenerRegisterer{
	public void setImageFileName(String image);
	public String getImageFileName();
}
