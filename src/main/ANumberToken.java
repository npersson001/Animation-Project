package main;

import util.annotations.StructurePattern;	
import util.annotations.StructurePatternNames;	
import util.annotations.EditablePropertyNames;	
import util.annotations.PropertyNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"Input","Value"})	
@EditablePropertyNames({"Input"})	
@Tags({"Number"})

public class ANumberToken extends AGeneralToken implements NumberToken{
	int value;
	
	public ANumberToken(String inputString){
		super(inputString);
		setInput(inputString);
	}
	
	public void setInput(String inputString){
		input = inputString;
		value = Integer.parseInt(input);
	}
	
	public int getValue(){
		return value;
	}
}
