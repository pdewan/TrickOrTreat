package Graphics;

public class APukeCollection extends ALabelCollection<PictureLabel> implements PictureLabelCollection
{	
	public APukeCollection()
	{
		super("Puke", 6);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 6;
		PictureLabel[] Puke = new APuke[MAX_SIZE];
		return Puke;
	}
}