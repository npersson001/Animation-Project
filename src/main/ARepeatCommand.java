package main;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags("Repeat")
public class ARepeatCommand implements RepeatCommand{
	int numRuns;
	Runnable command;
	
	public ARepeatCommand(int repeatableTimes, Runnable aCommand){
		numRuns = repeatableTimes;
		command = aCommand;
	}
	
	public void run(){
		for(int i = 0; i < numRuns; i++){
			command.run();
		}
	}
}