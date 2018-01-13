package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ACarPointedLeft extends AGraphic implements PictureLabel
{	
	public ACarPointedLeft (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "Car1LeftBig.gif";
			imageText = "";
			width = 450;
			height = 150;
		}
//		else if (typeOfGraphic == 2)
//		{
//			imageFile = "Car2Left.gif";
//			imageText = "";
//			width = 60;
//			height = 50;
//		}
		else
		{
			imageFile = "Car1Left.gif";
			imageText = "";
			width = 300;
			height = 100;
		}
	}
}
