package graphics;

public class APoint implements Point
{
	private int xCoordinate;
	private int yCoordinate;
	
	public APoint(int x, int y)
	{
		xCoordinate = x;
		yCoordinate = y;
	}
	
	@Override
	public int getX()
	{
		return xCoordinate;
	}

	@Override
	public int getY()
	{
		return yCoordinate;
	}
}
