package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ACupcake extends AGraphic implements PictureLabel
{
	public ACupcake (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "EatCupcake1.gif";
			imageText = "";
			width = 26;
			height = 25;
		}
		else if (typeOfGraphic == 2)
		{
			imageFile = "EatCupcake2.gif";
			imageText = "";
			width = 26;
			height = 25;
		}
		else if (typeOfGraphic == 3)
		{
			imageFile = "EatCupcake3.gif";
			imageText = "";
			width = 26;
			height = 25;
		}
		else if (typeOfGraphic == 4)
		{
			imageFile = "EatCupcake4.gif";
			imageText = "";
			width = 26;
			height = 25;
		}
		else if (typeOfGraphic == 5)
		{
			imageFile = "EatCupcake5.gif";
			imageText = "";
			width = 26;
			height = 25;
		}
		else if (typeOfGraphic == 6)
		{
			imageFile = "EatCupcake6.gif";
			imageText = "";
			width = 26;
			height = 25;
		}
		else
		{
			imageFile = "Cupcake.gif";
			imageText = "";
			width = 26;
			height = 25;
		}
	}
}

