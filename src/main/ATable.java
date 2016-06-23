package main;

import java.util.ArrayList;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.MAP_PATTERN)
@Tags("Table")
//S is going to be Strings and O is going to be Objects
public class ATable<S,O> implements Table<S,O>{
	ArrayList<S> arrayKey = new ArrayList<S>();
	ArrayList<O> arrayValue = new ArrayList<O>();
	
	public ATable(){
	}
	
	public void put(S key, O val){
		
		if(arrayKey.contains(key)){
			arrayValue.set(arrayKey.indexOf(key), val);
		}
		else{
			arrayKey.add(key);
			arrayValue.add(arrayKey.indexOf(key), val);
		}
	}
	
	public O get(String key){
		return arrayValue.get(arrayKey.indexOf(key));
	}
}
