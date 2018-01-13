package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ABarrier extends AGraphic implements PictureLabel
{
	public ABarrier (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 0)
		{
			imageFile = "VerticalBarrier1.jpg";
			imageText = "";
			width = 40;
			height = 800;
		}
		else if (typeOfGraphic == 1)
		{
			imageFile = "VerticalBarrier2.jpg";
			imageText = "";
			width = 40;
			height = 800;
		}
		else if (typeOfGraphic == 2)
		{
			imageFile = "VerticalBarrier3.jpg";
			imageText = "";
			width = 40;
			height = 800;
		}
		else if (typeOfGraphic == 3)
		{
			imageFile = "HorizontalBarrier0.jpg";
			imageFile = "HorizontalBarrier1.jpg";
			imageText = "";
			width = 600;
			height = 40;
		}
		else if (typeOfGraphic == 4)
		{
			imageFile = "HorizontalBarrier1.jpg";
			imageText = "";
			width = 1200;
			height = 40;
		}
		else
		{
			imageFile = "HorizontalBarrier2.jpg";
			imageText = "";
			width = 2300;
			height = 40;
		}
	}
}