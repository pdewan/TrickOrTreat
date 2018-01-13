package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ABush extends AGraphic implements PictureLabel
{	
	public ABush (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "Bush1.gif";
			imageText = "";
			width = 50;
			height = 40;
		}
		else if (typeOfGraphic == 2)
		{
			imageFile = "Bush2.gif";
			imageText = "";
			width = 60;
			height = 50;
		}
		else if (typeOfGraphic == 3)
		{
			imageFile = "Bush3.gif";
			imageText = "";
			width = 60;
			height = 50;
		}
		else if (typeOfGraphic == 4)
		{
			imageFile = "Bush4.gif";
			imageText = "";
			width = 70;
			height = 40;
		}
		else
		{
			imageFile = "Bush1.gif";
			imageText = "";
			width = 50;
			height = 40;
		}
	}
}
