package graphics;

public class ATreeCollection extends ALabelCollection<PictureLabel> implements PictureLabelCollection
{
	public ATreeCollection()
	{
		super("Trees", 4);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 4;
		PictureLabel[] Trees = new ATree[MAX_SIZE];
		return Trees;
	}
}