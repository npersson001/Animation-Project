package main;

public interface BroadcastingClearanceManager {
    public void proceed();
    public void waitForProceed(); 
    public void proceedAll();
}
