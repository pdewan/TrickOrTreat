package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ABasket extends AGraphic implements PictureLabel
{
	public ABasket (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic !=1)
		{
			imageFile = "Basket.gif";
			imageText = "";
			width = 92;
			height = 100;
		}
		else
		{
			imageFile = "Basket.jpg";
			imageText = "";
			width = 92;
			height = 100;
		}
	}
}
