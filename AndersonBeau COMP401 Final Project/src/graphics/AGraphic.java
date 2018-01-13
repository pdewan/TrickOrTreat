package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;


public abstract class AGraphic extends AShape implements PictureLabel
{
	int xLocation;
	int yLocation;
	String imageFile;
	String imageText;
	
	public AGraphic (int xLoc, int yLoc, int gType)
	{
		xLocation = xLoc;
		yLocation = yLoc;
		location = new APoint(xLocation, yLocation);
		buildGraphic(gType);
	}

	abstract void buildGraphic(int typeOfG);

	@Override
	public void setXY(int newLocationX, int newLocationY)
	{
		xLocation = newLocationX;
		yLocation = newLocationY;
		setLocation(new APoint(xLocation, yLocation));
	}

	@Override
	public String getImageFileName()
	{
		return imageFile;
	}

	@Override
	public String getText()
	{
		return imageText;
	}

	@Override
	public int getXLocation()
	{
		return xLocation;
	}
	
	@Override
	public int getYLocation()
	{
		return yLocation;
	}
}