package mp;

public interface Avatar {
	public void setText(StringShape initText);
	public StringShape getText();
	public AngleShape getArms();
	public AngleShape getLegs();
	public ImageShape getHead();
	public Line getTorso();
	public void moveAvatar(int x, int y); 
	public void scaleAvatar(int scale);
	public void teleportAvatar(int x, int y);
}
