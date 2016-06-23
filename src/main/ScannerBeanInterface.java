package main;

public interface ScannerBeanInterface {
	public void setScannedString(String inputString);
	public String getScannedString();
	public void setTokens(GeneralToken inputString, int index);
	public GeneralToken[] getTokens();
	
}
