package main;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;	
import util.annotations.EditablePropertyNames;	
import util.annotations.PropertyNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"Input","Value"})	
@EditablePropertyNames({"Input"})	
@Tags({"Word"})

public class AWordToken extends AGeneralToken implements WordToken{
	String value;
	
	public AWordToken(String inputString){
		super(inputString);
		setInput(inputString);
	}
	
	public void setInput(String inputString){
		input = inputString;
		value = input.toLowerCase();
	}
	
	public String getValue(){
		return value;
	}
}
