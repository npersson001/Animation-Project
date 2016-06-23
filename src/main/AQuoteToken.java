package main;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;	
import util.annotations.EditablePropertyNames;	
import util.annotations.PropertyNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"Input"})	
@EditablePropertyNames({"Input"})	
@Tags({"Quote"})

public class AQuoteToken extends AGeneralToken implements GeneralToken{
	public AQuoteToken(String inputString){
		super(inputString);
	}
}
