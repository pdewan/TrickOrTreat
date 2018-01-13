package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)
public class ARoadCollection extends ALabelCollection<PictureLabel> implements PictureLabelCollection
{	
	public ARoadCollection()
	{
		super("Roads", 14);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 14;
		PictureLabel[] Roads = new ARoad[MAX_SIZE];
		return Roads;
	}
}