package mp;

public interface Gorge {
	public void setLeftLine(Line left);
	public void setRightLine(Line right);
	public void setBridge(Rectangle bridge);
	public Line getRightLine();
	public Line getLeftLine();
	public Rectangle getBridge();
}
