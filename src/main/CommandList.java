package main;

public interface CommandList extends Runnable {
	public void add(Runnable aCommand);
}
