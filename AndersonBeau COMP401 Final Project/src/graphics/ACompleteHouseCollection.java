package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)
public class ACompleteHouseCollection extends ALabelCollection<CompleteHouse> implements CompleteHouseCollection
{
	public ACompleteHouseCollection()
	{
		super("Houses", 4);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 4;
		CompleteHouse[] Houses = new ACompleteHouse[MAX_SIZE];
		return Houses;
	}
}