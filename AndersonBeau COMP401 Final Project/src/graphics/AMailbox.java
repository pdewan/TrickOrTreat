package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class AMailbox extends ALineAndAShape implements Mailbox
{
	public AMailbox(int initX, int initY, int bHeight, int bWidth, int pLength)
	{
		super(initX, initY, bHeight, bWidth, pLength);
	}

	@Override
	public Shape createShape()
	{
		Shape newShape = new ARectangle (xLocation, yLocation, shapeWidth, shapeHeight, true);
		return newShape;
	}
}
