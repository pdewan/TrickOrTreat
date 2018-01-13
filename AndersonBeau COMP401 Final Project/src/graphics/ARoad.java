package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ARoad extends AGraphic implements PictureLabel
{
	public ARoad (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		imageFile = "HorizontalRoad0.jpg";
		imageFile = "HorizontalRoad1.jpg";
		imageText = "";
		width = 600;
		height = 200;
	}
}
