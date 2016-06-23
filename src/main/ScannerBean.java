package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "tokens"})
@EditablePropertyNames({"ScannedString"})

public class ScannerBean implements ScannerBeanInterface{
	String scannedString;
	GeneralToken tokens[];
	static int indexToken = 0;
	
	public ScannerBean(String tempString){
		this.setScannedString(tempString);
	}
	
	//this will set the instance variable as well as starting the sorting process to print the string
	public void setScannedString(String tempString){
		scannedString = tempString;
		tokens = ScannerBean.checkFirstChar(scannedString);
		tokens = ScannerBean.removeNull(tokens);
	}
	
	public String getScannedString(){
		return scannedString;
	}
	
	public void setTokens(GeneralToken tempInput, int index){
		tokens[index] = tempInput;
	}
	
	public GeneralToken[] getTokens(){
		return tokens;
	}
	
	static GeneralToken[] checkFirstChar(String tempString){
		tempString += " ";
		GeneralToken tokensLong[] = new GeneralToken[tempString.length()];
		for(int i = 0; i < tempString.length(); i++){
			char startChar = tempString.charAt(i);
			
			//if statement sorts the string by the first character to determine which method will be called
			if (startChar == ' '){
				tempString = tempString.substring(1,tempString.length());
			}
			else if(startChar == '"'){
				int tempIndex = ScannerBean.checkQuote(tempString, i);
				GeneralToken quoteToken = new AQuoteToken(tempString.substring(1,tempIndex));
				tokensLong[indexToken] = quoteToken;
				indexToken++;
				tempString = tempString.substring(tempIndex+1,tempString.length());
			}
			else if(ScannerBean.isALetter(startChar)){ 
				int tempIndex = ScannerBean.checkWord(tempString, i);
				
				if(tempString.substring(0,tempIndex).equalsIgnoreCase("move")){
					WordToken moveToken = new AMoveToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)moveToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("say")){
					WordToken sayToken = new ASayToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)sayToken;					
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("approach")){
					WordToken approachToken = new AnApproachToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)approachToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("rotateleftarm")){
					WordToken rotateLeftArmToken = new ARotateLeftArmToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)rotateLeftArmToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("rotaterightarm")){
					WordToken rotateRightArmToken = new ARotateRightArmToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)rotateRightArmToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("repeat")){
					WordToken repeatToken = new ARepeatToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)repeatToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("define")){
					WordToken defineToken = new ADefineToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)defineToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("call")){
					WordToken callToken = new ACallToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)callToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("thread")){
					WordToken threadToken = new AThreadToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)threadToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("wait")){
					WordToken waitToken = new AWaitToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)waitToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("proceedall")){
					WordToken proceedAllToken = new AProceedAllToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)proceedAllToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("sleep")){
					WordToken sleepToken = new ASleepToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)sleepToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("undo")){
					WordToken undoToken = new AnUndoToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)undoToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("redo")){
					WordToken redoToken = new ARedoToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)redoToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("pass")){
					WordToken passToken = new APassToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)passToken;
				}
				else if(tempString.substring(0,tempIndex).equalsIgnoreCase("fail")){
					WordToken failToken = new AFailToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)failToken;
				}
				else{
					WordToken wordToken = new AWordToken(tempString.substring(0,tempIndex));
					tokensLong[indexToken] = (GeneralToken)wordToken;
				}
				indexToken++;
				tempString = tempString.substring(tempIndex,tempString.length());
			}
			else if(ScannerBean.isNumber(startChar)){
				int tempIndex = ScannerBean.checkNumber(tempString, i);
				NumberToken numberToken = new ANumberToken(tempString.substring(0,tempIndex));
				tokensLong[indexToken] = (GeneralToken)numberToken;
				indexToken++;
				tempString = tempString.substring(tempIndex, tempString.length());
			}
			else if(startChar == '{'){
				GeneralToken startToken = new AStartToken(tempString.substring(0,1));
				tokensLong[indexToken] = startToken;
				indexToken++;
				tempString = tempString.substring(1,tempString.length());
			}
			else if(startChar == '}'){
				GeneralToken endToken = new AnEndToken(tempString.substring(0,1));
				tokensLong[indexToken] = endToken;
				indexToken++;
				tempString = tempString.substring(1,tempString.length());
			}
			else if(startChar == '+'){
				GeneralToken plusToken = new APlusToken(tempString.substring(0,1));
				tokensLong[indexToken] = plusToken;
				indexToken++;
				tempString = tempString.substring(1,tempString.length());
			}
			else if(startChar == '-'){
				GeneralToken minusToken = new AMinusToken(tempString.substring(0,1));
				tokensLong[indexToken] = minusToken;
				indexToken++;
				tempString = tempString.substring(1,tempString.length());
			}
			i = -1;
		}
		indexToken = 0;
		return tokensLong;
	}
	
	static int checkWord(String tempString, int index){
		boolean confirmLength = true;
	
		while(confirmLength){
			index++;
			if(tempString.charAt(index) == ' ' || tempString.charAt(index) == '}'){
				confirmLength = false;
			}
		}
		return index;
	}
	
	static int checkNumber(String tempString, int index){
		boolean confirmLength = true;
		
		while(confirmLength){
			index++;
			if(tempString.charAt(index) == ' ' || tempString.charAt(index) == '}'){
				confirmLength = false;
			}
		}
		return index;
	}

	static int checkQuote(String tempString, int index){
		boolean confirmLength = true;
		
		while(confirmLength){
			index++;
			if(tempString.charAt(index) == '"'){
				confirmLength = false;
			}
		}
		return index;
	}
	
	static boolean isNumber(char tempChar){
		return (tempChar >= '0' && tempChar <= '9');
	}
	
	static boolean isALetter(char tempChar){
		return (tempChar >= 'a' && tempChar <= 'z' || tempChar >= 'A' && tempChar <= 'Z');
	}
	
	static GeneralToken[] removeNull(GeneralToken[] tempTokens){
		int counter = 0;
		for(int i = 0; i < tempTokens.length; i++){
			if(tempTokens[i] != null){
				counter++;
			}
		}
		GeneralToken[] newTokens = new GeneralToken[counter];
		System.arraycopy(tempTokens, 0, newTokens, 0, counter);
		return newTokens;
	}
}

