package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public class ACarPointedRight extends AGraphic implements PictureLabel
{	
	public ACarPointedRight (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "Car1RightBig.gif";
			imageText = "";
			width = 450;
			height = 150;
		}
//		else if (typeOfGraphic == 2)
//		{
//			imageFile = "Car2Right.gif";
//			imageText = "";
//			width = 60;
//			height = 50;
//		}
		else
		{
			imageFile = "Car1Right.gif";
			imageText = "";
			width = 300;
			height = 100;
		}
	}
}
