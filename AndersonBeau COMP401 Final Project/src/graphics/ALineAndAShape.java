package graphics;
import util.annotations.Visible;

public abstract class ALineAndAShape implements LineAndShape
{
	int shapeHeight;
	int shapeWidth;
	int lineLength;
	int xLocation;
	int yLocation;
	Shape bottomLine;
	Shape topShape;
	
	public ALineAndAShape (int initX, int initY, int bHeight, int bWidth, int pLength)
	{
		xLocation = initX;
		yLocation = initY;
		shapeHeight = bHeight;
		shapeWidth = bWidth;
		lineLength = pLength;
		bottomLine = new ALine(xLocation+(shapeWidth/2), yLocation+shapeHeight, 0, lineLength);
		topShape = createShape();
	}

	abstract Shape createShape();
	
	@Override
	public Shape getBottomLine()
	{
		return bottomLine;
	}

	@Override
	public Shape getTopShape()
	{
		return topShape;
	}

	@Visible(false)
	@Override
	public int getXLocation()
	{
		return xLocation;
	}

	@Visible(false)
	@Override
	public int getYLocation()
	{
		return yLocation;
	}
	@Visible(false)
	@Override
	public int getShapeHeight()
	{
		return shapeHeight;
	}

	@Visible(false)
	@Override
	public int getShapeWidth()
	{
		return shapeWidth;
	}
	@Visible(false)
	@Override
	public int getLineLength()
	{
		return lineLength;
	}
	
	@Override
	public void setXY(int newLocationX, int newLocationY)
	{
		xLocation = newLocationX;
		yLocation = newLocationY;
		bottomLine.setXY(xLocation+(shapeWidth/2), yLocation+shapeHeight);
		topShape.setXY(xLocation, yLocation);
	}
}
