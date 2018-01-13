package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)

public class ACompleteHouseWithCandyCollection extends ALabelCollection<CompleteHouseWithCandy> implements CompleteHouseWithCandyCollection
{
	public ACompleteHouseWithCandyCollection()
	{
		super("Houses With Candy", 14);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 14;
		CompleteHouseWithCandy[] Houses = new ACompleteHouseWithCandy[MAX_SIZE];
		return Houses;
	}
}