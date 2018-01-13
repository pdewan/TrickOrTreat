package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class AnAvatar extends ALineAndAShape implements Avatar
{
	public AnAvatar(int initX, int initY, int bHeight, int bWidth, int bLength)
	{
		super(initX, initY, bHeight, bWidth, bLength);
	}

	@Override
	public Shape createShape()
	{
		Shape newShape = new AOval (xLocation, yLocation, shapeWidth, shapeHeight, true);
		return newShape;
	}
}
