package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class AGrass extends AGraphic implements PictureLabel
{
	public AGrass (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "BigGrass1.jpg";
			imageText = "";
			width = 600;
			height = 600;
		}
		else if (typeOfGraphic == 2)
		{
			imageFile = "BigGrass2.jpg";
			imageText = "";
			width = 600;
			height = 600;
		}
		else if (typeOfGraphic == 3)
		{
			imageFile = "BigGrass3.jpg";
			imageText = "";
			width = 600;
			height = 600;
		}
		else if (typeOfGraphic == 4)
		{
			imageFile = "BigGrass4.jpg";
			imageText = "";
			width = 600;
			height = 600;
		}
		else if (typeOfGraphic == 5)
		{
			imageFile = "BigGrass5.jpg";
			imageText = "";
			width = 600;
			height = 600;
		}
		else if (typeOfGraphic == 6)
		{
			imageFile = "BigGrass6.jpg";
			imageText = "";
			width = 600;
			height = 600;
		}
		else
		{
			imageFile = "BigGrass6.jpg";
			imageText = "";
			width = 600;
			height = 600;
		}
	}
}