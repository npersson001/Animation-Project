package main;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;	
import util.annotations.EditablePropertyNames;	
import util.annotations.PropertyNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"Input"})	
@EditablePropertyNames({"Input"})	
@Tags({"Plus"})

public class APlusToken extends AGeneralToken implements GeneralToken{
	public APlusToken(String inputString){
		super(inputString);
	}
}
