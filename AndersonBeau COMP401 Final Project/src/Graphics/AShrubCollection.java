package Graphics;

public class AShrubCollection extends ALabelCollection<PictureLabel> implements PictureLabelCollection
{
	public AShrubCollection()
	{
		super("Shrubs", 6);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 6;
		PictureLabel[] Shrubs = new AShrub[MAX_SIZE];
		return Shrubs;
	}
}