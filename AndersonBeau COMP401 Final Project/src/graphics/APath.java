package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class APath extends AGraphic implements PictureLabel
{
	public APath (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "Path1.jpg";
			imageText = "";
			width = 80;
			height = 160;
		}
		else if (typeOfGraphic == 2)
		{
			imageFile = "Path2.jpg";
			imageText = "";
			width = 80;
			height = 160;
		}
		else if (typeOfGraphic == 3)
		{
			imageFile = "Brickpath1.jpg";
			imageText = "";
			width = 80;
			height = 160;
		}
		else if (typeOfGraphic == 4)
		{
			imageFile = "Brickpath2.jpg";
			imageText = "";
			width = 80;
			height = 160;
		}
		else if (typeOfGraphic == 5)
		{
			imageFile = "Brickpath3.jpg";
			imageText = "";
			width = 80;
			height = 160;
		}
		else
		{
			imageFile = "Brickpath3.jpg";
			imageText = "";
			width = 80;
			height = 160;
		}
	}
}