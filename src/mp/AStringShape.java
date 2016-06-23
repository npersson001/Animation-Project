package mp;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@PropertyNames({"Text","X","Y"})
@EditablePropertyNames({"Text","X","Y"})
@StructurePattern(StructurePatternNames.STRING_PATTERN)

public class AStringShape extends ALocatable implements StringShape{
	String text;
	
	public AStringShape(String initText, int initX, int initY){
		super(initX, initY);
		text = initText;
	}
	
	public void setText(String initText){
		String oldVal = text;
		String newVal = initText;
		text = initText;
		listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Text", oldVal, newVal));
	}
	
	public String getText(){
		return text;
	}
}