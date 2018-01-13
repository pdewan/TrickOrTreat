package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class AHouse extends AGraphic implements PictureLabel
{
	public AHouse (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "House1.gif";
			imageText = "";
			width = 419;
			height = 372;
		}
		else if (typeOfGraphic == 2)
		{
			imageFile = "House2.gif";
			imageText = "";
			width = 419;
			height = 372;
		}
		else if (typeOfGraphic == 3)
		{
			imageFile = "House3.gif";
			imageText = "";
			width = 419;
			height = 372;
		}
		else if (typeOfGraphic == 4)
		{
			imageFile = "House4.gif";
			imageText = "";
			width = 419;
			height = 372;
		}
		else if (typeOfGraphic == 5)
		{
			imageFile = "UNCHouse.gif";
			imageText = "";
			width = 419;
			height = 372;
		}
		else
		{
			imageFile = "UNCHouse.gif";
			imageText = "";
			width = 419;
			height = 372;
		}
	}
}
