package main;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;	
import util.annotations.EditablePropertyNames;	
import util.annotations.PropertyNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"Input"})	
@EditablePropertyNames({"Input"})	
@Tags({"Start"})

public class AStartToken extends AGeneralToken implements GeneralToken{
	public AStartToken(String inputString){
		super(inputString);
	}
}
