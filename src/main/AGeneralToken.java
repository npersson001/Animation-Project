package main;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;	
import util.annotations.EditablePropertyNames;	
import util.annotations.PropertyNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"Input"})	
@EditablePropertyNames({"Input"})

public abstract class AGeneralToken implements GeneralToken{
	String input;
	
	public AGeneralToken(String inputString){
		input = inputString;
	}
	
	public void setInput(String inputString){
		input = inputString;
	}
	
	public String getInput(){
		return input;
	}
}