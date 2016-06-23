package main;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;	
import util.annotations.EditablePropertyNames;	
import util.annotations.PropertyNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"Input","Value"})	
@EditablePropertyNames({"Input"})	
@Tags({"repeat"})

public class ARepeatToken extends AWordToken implements WordToken{
	public ARepeatToken(String inputString){
		super(inputString);
	}
}