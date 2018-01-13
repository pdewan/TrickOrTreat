package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.LINE_PATTERN)

public class ALine extends AShape
{
	public ALine(int initX, int initY, int initWidth, int initHeight)
	{
		super(initX, initY, initWidth, initHeight);
	}
}
