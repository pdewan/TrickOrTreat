package graphics;

public interface LineAndShape
{
	public Shape getBottomLine();
	public Shape getTopShape();
	public int getXLocation();
	public int getYLocation();
	public int getShapeHeight();
	public int getShapeWidth();
	public int getLineLength();
	public void setXY(int newLocationX, int newLocationY);
}