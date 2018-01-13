package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ATire extends AGraphic implements PictureLabel
{
	public ATire (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		imageFile = "Tire.gif";
		imageText = "";
		width = 50;
		height = 50;
	}
}
