package mp;

public interface AngleShape {
	public void setX(int initX);
	public void setY(int initY);
	public void setRadius(double initRadius);
	public void setAngle(double initAngle);
	public int getX();
	public int getY();
	public double getRadius();
	public double getAngle();
	public void moveLine(int moveX, int moveY);
	public Line getLeftLine();
	public Line getRightLine();
	public void rotateLine(int units);
}