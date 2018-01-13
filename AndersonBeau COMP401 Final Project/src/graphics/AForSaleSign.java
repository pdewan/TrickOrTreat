package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class AForSaleSign extends AGraphic implements PictureLabel
{
	public AForSaleSign (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 0)
		{
			imageFile = "ForSaleSign1.gif";
			imageText = "";
			width = 200;
			height = 200;
		}
		else
		{
			imageFile = "ForSaleSign2.gif";
			imageText = "";
			width = 160;
			height = 200;
		}
	}
}