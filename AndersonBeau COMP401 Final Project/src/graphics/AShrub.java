package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class AShrub extends AGraphic implements PictureLabel
{
	public AShrub (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "Shrub1.gif";
			imageText = "";
			width = 70;
			height = 60;
		}	
		else if (typeOfGraphic == 2)
		{
			imageFile = "Shrub2.gif";
			imageText = "";
			width = 90;
			height = 60;
		}
		else if (typeOfGraphic == 3)
		{
			imageFile = "Shrub3.gif";
			imageText = "";
			width = 90;
			height = 60;
		}
		else if (typeOfGraphic == 4)
		{
			imageFile = "Shrub4.gif";
			imageText = "";
			width = 50;
			height = 60;
		}
		else
		{
			imageFile = "Shrub1.gif";
			imageText = "";
			width = 70;
			height = 60;
		}	
	}
}
