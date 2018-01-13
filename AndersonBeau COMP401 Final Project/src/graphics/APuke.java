package graphics;

public class APuke extends AGraphic implements PictureLabel
{
	public APuke (int initX, int initY, int graphicType)
	{
		super(initX, initY, graphicType);
	}

	@Override
	void buildGraphic(int typeOfGraphic)
	{
		if (typeOfGraphic == 1)
		{
			imageFile = "Puke1.gif";
			imageText = "";
			width = 50;
			height = 25;
		}	
		else if (typeOfGraphic == 2)
		{
			imageFile = "Puke2.gif";
			imageText = "";
			width = 50;
			height = 25;
		}
		else if (typeOfGraphic == 3)
		{
			imageFile = "Puke3.gif";
			imageText = "";
			width = 50;
			height = 25;
		}
		else if (typeOfGraphic == 4)
		{
			imageFile = "Puke4.gif";
			imageText = "";
			width = 50;
			height = 25;
		}
		else if (typeOfGraphic == 5)
		{
			imageFile = "Puke5.gif";
			imageText = "";
			width = 50;
			height = 25;
		}
		else
		{
			imageFile = "Puke1.gif";
			imageText = "";
			width = 50;
			height = 25;
		}	
	}
}
