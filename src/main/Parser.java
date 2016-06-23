package main;

public interface Parser {
	public void setCommandText(String aCommandText);
	public String getCommandText();
	public Runnable getCommandObject();
	public Runnable parseCommand();
	public RepeatCommand parseRepeat();
	public CommandList parseCommandList();
	public ApproachCommand parseApproach();
	public PassCommand parsePass();
	public FailCommand parseFail();
	public SayCommand parseSay();
	public MoveCommand parseMove();
	public int checkSignToken(GeneralToken tempToken);
	public int parseNumber();
}
