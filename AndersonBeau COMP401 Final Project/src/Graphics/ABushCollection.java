package Graphics;

public class ABushCollection extends ALabelCollection<PictureLabel> implements PictureLabelCollection
{	
	public ABushCollection()
	{
		super("Bushes", 6);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 6;
		PictureLabel[] Bushes = new ABush[MAX_SIZE];
		return Bushes;
	}
}