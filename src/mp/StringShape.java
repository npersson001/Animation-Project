package mp;

import util.models.PropertyListenerRegisterer;

public interface StringShape extends Locatable, PropertyListenerRegisterer{
	public void setText(String initText);
	public String getText();
}
