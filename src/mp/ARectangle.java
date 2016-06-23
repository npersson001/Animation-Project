package mp;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@PropertyNames({"X","Y","Height","Width"})
@EditablePropertyNames({"X","Y","Height","Width"})
@StructurePattern(StructurePatternNames.RECTANGLE_PATTERN)

public class ARectangle extends AShape implements Rectangle{
	public ARectangle(int initX, int initY, int initHeight, int initWidth) {
		super(initX, initY, initHeight, initWidth);
	}
}