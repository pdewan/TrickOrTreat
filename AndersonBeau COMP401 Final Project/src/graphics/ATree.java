package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ATree extends AGraphic implements PictureLabel
{
	public ATree (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "Tree1.gif";
			imageText = "";
			width = 130;
			height = 164;
		}
		else if (typeOfGraphic == 2)
		{
			imageFile = "Tree2.gif";
			imageText = "";
			width = 100;
			height = 150;
		}
		else if (typeOfGraphic == 3)
		{
			imageFile = "Tree3.gif";
			imageText = "";
			width = 130;
			height = 110;
		}
		else if (typeOfGraphic == 4)
		{
			imageFile = "Tree4.gif";
			imageText = "";
			width = 100;
			height = 165;
		}
		else if (typeOfGraphic == 5)
		{
			imageFile = "Tree5.gif";
			imageText = "";
			width = 130;
			height = 150;
		}
		else
		{
			imageFile = "Tree1.gif";
			imageText = "";
			width = 130;
			height = 164;
		}
	}
}