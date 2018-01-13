package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)
public class ACupcakeCollection extends ALabelCollection<PictureLabel> implements PictureLabelCollection
{
	public ACupcakeCollection()
	{
		super("Cupcakes", 6);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 6;
		PictureLabel[] Cupcakes = new ACupcake[MAX_SIZE];
		return Cupcakes;
	}
}