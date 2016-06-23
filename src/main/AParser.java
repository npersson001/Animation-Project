package main;

import grail.BridgeScene;
import mp.Avatar;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)	
@PropertyNames({"CommandText", "CommandObject"})	
@EditablePropertyNames({"CommandText"})	
@Tags("Parser")
public class AParser implements Parser{
	Table aTable;
	String commandText;
	int indexCommand;
	BridgeScene scene;
	GeneralToken[] array;
	final static int POSITIVE = 1, NEGATIVE = -1, ZERO = 0, ONE = 1, TWO = 2, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6;
	
	public AParser(BridgeScene aScene){
		scene = aScene;
		aTable = new ATable();
		aTable.put("arthur", scene.getArthur());
		aTable.put("robin", scene.getRobin());
		aTable.put("guard", scene.getGuard());
		aTable.put("galahad", scene.getGalahad());
		aTable.put("lancelot", scene.getLancelot());
	}
	
	public void setCommandText(String aCommandText){
		indexCommand = 0;
		commandText = aCommandText;
		ScannerBeanInterface scanner = new ScannerBean(commandText);
		array = scanner.getTokens();
	}
	
	public String getCommandText(){
		return commandText;
	}
	
	public Runnable getCommandObject(){
		return parseCommand();
	}
	
	@Tags("parseCommand")
	public Runnable parseCommand(){
		if(array[indexCommand] instanceof ASayToken){
			return parseSay();
		}
		else if(array[indexCommand] instanceof AMoveToken){
			return parseMove();
		}
		else if(array[indexCommand] instanceof APassToken){
			return parsePass();
		}
		else if(array[indexCommand] instanceof AFailToken){
			return parseFail();
		}
		else if(array[indexCommand] instanceof AnApproachToken){
			return parseApproach();
		}
		else if(array[indexCommand] instanceof ARepeatToken){
			return parseRepeat();
		}
		else if(array[indexCommand] instanceof AStartToken){
			return parseCommandList();
		}
		return null;
	}
	
	@Tags("numberParser")
	public int parseNumber(){
		if(array[indexCommand] instanceof APlusToken){
			indexCommand += TWO;
			return POSITIVE*((NumberToken)array[indexCommand - ONE]).getValue();
		}
		else if(array[indexCommand] instanceof AMinusToken){
			indexCommand += TWO;
			return NEGATIVE*((NumberToken)array[indexCommand - ONE]).getValue();
		}
		else if(array[indexCommand] instanceof ANumberToken){
			indexCommand ++;
			return ((NumberToken)array[indexCommand - ONE]).getValue();
		}
		return ZERO;
	}
	
	@Tags("parseRepeat")
	public RepeatCommand parseRepeat(){
		if(array[indexCommand + ONE] instanceof ANumberToken){
			NumberToken numTimes = (NumberToken)array[indexCommand + ONE];
			indexCommand += TWO;
			return new ARepeatCommand(numTimes.getValue(), parseCommand());
		}
		return null;
	}
	
	@Tags("parseCommandList")
	public CommandList parseCommandList(){
		indexCommand ++;
		CommandList commandList = new ACommandList();
		while(true){
			if(array[indexCommand] instanceof AnEndToken)
				break;
			commandList.add(parseCommand());
		}
		return commandList;
	}
	
	@Tags("parseApproach")
	public ApproachCommand parseApproach(){
		if(aTable.get(array[indexCommand + ONE].getInput().toLowerCase()) != null){
			Avatar movingAvatar = (Avatar) aTable.get(array[indexCommand + ONE].getInput().toLowerCase());
			indexCommand += TWO;
			return new AnApproachCommand(scene, movingAvatar);
		}
		return null;
	}
	
	@Tags("parsePass")
	public PassCommand parsePass(){
		indexCommand += ONE;
		return new APassCommand(scene);
	}
	
	@Tags("parseFail")
	public FailCommand parseFail(){
		indexCommand += ONE;
		return new AFailCommand(scene);
	}
	
	@Tags("parseSay")
	public SayCommand parseSay(){
		if(array[indexCommand + ONE] instanceof AQuoteToken){
			indexCommand += TWO;
			return new ASayCommand(scene, array[indexCommand - ONE].getInput());
		}
		return null;
	}
	
	@Tags("parseMove")
	public MoveCommand parseMove(){
		
		indexCommand ++;
		if(array[indexCommand] instanceof AWordToken){
			Avatar movingAvatar = (Avatar) aTable.get(array[indexCommand].getInput().toLowerCase());
			indexCommand ++;
			int xValue = parseNumber();
			int yValue = parseNumber();
			
			return new AMoveCommand(movingAvatar, xValue, yValue);
		}
			
		/*
		if(aTable.get(array[indexCommand + ONE].getInput().toLowerCase()) != null && array[indexCommand + TWO] instanceof ANumberToken && array[indexCommand + THREE] instanceof ANumberToken){
			Avatar movingAvatar = (Avatar) aTable.get(array[indexCommand + ONE].getInput().toLowerCase());
			NumberToken xValue = (NumberToken)array[indexCommand + TWO];
			NumberToken yValue = (NumberToken)array[indexCommand + THREE];
			
			indexCommand += FOUR;
			return new AMoveCommand(movingAvatar, xValue.getValue(), yValue.getValue());
		}
		else if(aTable.get(array[indexCommand + ONE].getInput().toLowerCase()) != null && (array[indexCommand + TWO] instanceof APlusToken || array[indexCommand + TWO] instanceof AMinusToken) 
				&& array[indexCommand + THREE] instanceof ANumberToken && (array[indexCommand + FOUR] instanceof APlusToken || array[indexCommand + FOUR] instanceof AMinusToken)
				&& array[indexCommand + FIVE] instanceof ANumberToken){
					
			Avatar movingAvatar = (Avatar) aTable.get(array[indexCommand + ONE].getInput().toLowerCase());
			NumberToken xValue = (NumberToken)array[indexCommand + THREE];
			NumberToken yValue = (NumberToken)array[indexCommand + FIVE];
					
			indexCommand += SIX;
			return new AMoveCommand(movingAvatar, this.checkSignToken(array[indexCommand - FOUR])*xValue.getValue(), this.checkSignToken(array[indexCommand - TWO])*yValue.getValue());
		}	
		else if(aTable.get(array[indexCommand + ONE].getInput().toLowerCase()) != null && (array[indexCommand + TWO] instanceof APlusToken || array[indexCommand + TWO] instanceof AMinusToken) 
				&& array[indexCommand + THREE] instanceof ANumberToken && array[indexCommand + FOUR] instanceof ANumberToken){
					
			Avatar movingAvatar = (Avatar) aTable.get(array[indexCommand + ONE].getInput().toLowerCase());
			NumberToken xValue = (NumberToken)array[indexCommand + THREE];
			NumberToken yValue = (NumberToken)array[indexCommand + FOUR];
				
			indexCommand += FIVE;
			return new AMoveCommand(movingAvatar, this.checkSignToken(array[indexCommand - THREE])*xValue.getValue(), yValue.getValue());
		}	
		else if(aTable.get(array[indexCommand + ONE].getInput().toLowerCase()) != null
				&& array[indexCommand + TWO] instanceof ANumberToken && (array[indexCommand + THREE] instanceof APlusToken || array[indexCommand + THREE] instanceof AMinusToken) 
				&& array[indexCommand + FOUR] instanceof ANumberToken){
					
			Avatar movingAvatar = (Avatar) aTable.get(array[indexCommand + ONE].getInput().toLowerCase());
			NumberToken xValue = (NumberToken)array[indexCommand + TWO];
			NumberToken yValue = (NumberToken)array[indexCommand + FOUR];
				
			indexCommand += FIVE;
			return new AMoveCommand(movingAvatar, xValue.getValue(), this.checkSignToken(array[indexCommand - TWO])*yValue.getValue());
		}
		*/
		return null;
	}
	
	public int checkSignToken(GeneralToken tempToken){
		if(tempToken.getInput().equals("+")){
			return POSITIVE;
		}
		else if(tempToken.getInput().equals("-")){
			return NEGATIVE;
		}
		else{
			return 0;
		}
	}
}
