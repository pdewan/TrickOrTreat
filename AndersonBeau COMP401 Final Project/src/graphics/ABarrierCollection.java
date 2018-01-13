package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)
public class ABarrierCollection extends ALabelCollection<PictureLabel> implements PictureLabelCollection
{	
	public ABarrierCollection()
	{
		super("Barriers", 30);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 30;
		PictureLabel[] Barriers = new ABarrier[MAX_SIZE];
		return Barriers;
	}
}