package graphics;

import util.annotations.Position;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class AWheelbarrow implements Wheelbarrow
{
	int wheelbarrowX;
	int wheelbarrowY;
	Shape wheelbarrowHandlebar;
	Shape wheelbarrowBack;
	Shape wheelbarrowBottom;
	Shape wheelbarrowHandle;
	PictureLabel wheelbarrowWheel;
	Shape wheelbarrowHub;
	Shape wheelbarrowAxle;
	
	public AWheelbarrow (int initX, int initY)
	{
		wheelbarrowX = initX;
		wheelbarrowY = initY;
		wheelbarrowHandlebar = new ALine(wheelbarrowX+10, wheelbarrowY+25, 10, 0);
		wheelbarrowBack = new ARectangle (wheelbarrowX+20, wheelbarrowY, 10, 40, true);
		wheelbarrowBottom = new ARectangle (wheelbarrowX+20, wheelbarrowY+40, 120, 10, true);
		wheelbarrowHandle = new AOval (wheelbarrowX, wheelbarrowY+20, 10, 10, true);
		wheelbarrowWheel = new ATire (wheelbarrowX+40, wheelbarrowY+50, 0);
		wheelbarrowHub = new AOval (wheelbarrowX+60, wheelbarrowY+70, 9, 9, false);
		wheelbarrowAxle = new ARectangle (wheelbarrowX+64, wheelbarrowY+50, 2, 20, false);
	}

	@Override
	public Shape getWheelbarrowHandlebar()
	{
		return wheelbarrowHandlebar;
	}

	@Override
	public Shape getWheelbarrowBack()
	{
		return wheelbarrowBack;
	}

	@Override
	public Shape getWheelbarrowBottom()
	{
		return wheelbarrowBottom;
	}

	@Override
	public Shape getWheelbarrowHandle()
	{
		return wheelbarrowHandle;
	}

	@Position (0)
	@Override
	public PictureLabel getWheelbarrowWheel()
	{
		return wheelbarrowWheel;
	}

	@Override
	public Shape getWheelbarrowHub()
	{
		return wheelbarrowHub;
	}

	@Override
	public Shape getWheelbarrowAxle()
	{
		return wheelbarrowAxle;
	}

	@Visible(false)
	@Override
	public int getWheelbarrowX()
	{
		return wheelbarrowX;
	}

	@Visible(false)
	@Override
	public int getWheelbarrowY()
	{
		return wheelbarrowY;
	}

	@Override
	public void setWheelbarrowXY(int xLocation, int yLocation)
	{
		wheelbarrowX = xLocation;
		wheelbarrowY = yLocation;
		wheelbarrowHandlebar.setXY(wheelbarrowX+10, wheelbarrowY+25);
		wheelbarrowBack.setXY(wheelbarrowX+20, wheelbarrowY);
		wheelbarrowBottom.setXY(wheelbarrowX+20, wheelbarrowY+40);
		wheelbarrowHandle.setXY(wheelbarrowX, wheelbarrowY+20);
		wheelbarrowWheel.setXY(wheelbarrowX+40, wheelbarrowY+50);
		wheelbarrowHub.setXY(wheelbarrowX+60, wheelbarrowY+70);
		wheelbarrowAxle.setXY(wheelbarrowX+64, wheelbarrowY+50);
	}
}
