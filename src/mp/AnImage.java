package mp;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@PropertyNames({"ImageFileName","X","Y","Height","Width"})
@EditablePropertyNames({"ImageFileName","X","Y","Height","Width"})
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class AnImage extends AShape implements ImageShape{
	String imageFileName;
	
	public AnImage(String image, int initX, int initY, int initHeight, int initWidth){
		super(initX, initY, initHeight, initWidth);
		imageFileName = image;
	}
	
	public void setImageFileName(String image){
		String oldVal = imageFileName;
		String newVal = image;
		imageFileName = image;
		listenerSupport.notifyAllListeners(new PropertyChangeEvent(this, "Image", oldVal, newVal));
	}
	
	public String getImageFileName(){
		return imageFileName;
	}
}