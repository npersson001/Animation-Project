package main;

import java.util.ArrayList;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags("CommandList")
public class ACommandList implements CommandList{
	ArrayList<Runnable> commandList = new ArrayList<Runnable>();
	
	@Tags("add")
	public void add(Runnable aCommand){
		commandList.add(aCommand);
	}
	
	public void run(){
		for(int i = 0; i < commandList.size(); i++){
			commandList.get(i).run();
		}
	}
}
