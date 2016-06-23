package main;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;	
import util.annotations.EditablePropertyNames;	
import util.annotations.PropertyNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"Input"})	
@EditablePropertyNames({"Input"})	
@Tags({"End"})

public class AnEndToken extends AGeneralToken implements GeneralToken{
	public AnEndToken(String inputString){
		super(inputString);
	}
}
