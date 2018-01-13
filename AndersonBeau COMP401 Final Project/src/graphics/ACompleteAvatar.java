package graphics;

import util.annotations.Position;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class ACompleteAvatar implements CompleteAvatar
{
	int avatarX;
	int avatarY;
	int headHeight;
	int headWidth;
	int bodyLength;
	int numberOfCupcakes;
	Avatar myAvatar;
	CupcakeContainer avatarContainer;
	Wheelbarrow myWheelbarrow;
	
	public ACompleteAvatar (int initX, int initY, int hHeight, int hWidth, int bLength, int nCakes)
	{
		avatarX = initX;
		avatarY = initY;
		headHeight = hHeight;
		headWidth = hWidth;
		bodyLength = bLength;
		numberOfCupcakes = nCakes;
		myAvatar = new AnAvatar(avatarX, avatarY, headHeight, headWidth, bodyLength);
		myWheelbarrow = new AWheelbarrow(avatarX+(headWidth/2), avatarY+headHeight+(bodyLength-40));
		avatarContainer = new ACupcakeContainer(avatarX+(headWidth/2)+40, avatarY+headHeight+bodyLength-100, numberOfCupcakes);
	}
	
	@Position (5)
	@Override
	public Avatar getAnAvatar() 
	{
		return myAvatar;
	}

	@Override
	public int getCompleteAvatarX()
	{
		return avatarX;
	}

	@Override
	public int getCompleteAvatarY()
	{
		return avatarY;
	}

	@Override
	public int getCompleteAvatarFootX()
	{
		return (avatarX+(headWidth/2));
	}

	@Override
	public int getCompleteAvatarFootY()
	{
		return (avatarY+headHeight+bodyLength);
	}
	
	@Position (6)
	@Override
	public CupcakeContainer getCupcakeContainer()
	{
		return avatarContainer;
	}

	@Position (4)
	@Override
	public Wheelbarrow getWheelbarrow()
	{
		return myWheelbarrow;
	}

	@Override
	public void setAvatarXY(int xLocation, int yLocation)
	{
		avatarX = xLocation;
		avatarY = yLocation;
		myAvatar.setXY(avatarX, avatarY);
		myWheelbarrow.setWheelbarrowXY(avatarX+(headWidth/2), avatarY+headHeight+(bodyLength-40));
		avatarContainer.setBasketXY(avatarX+(headWidth/2)+40, avatarY+headHeight+bodyLength-100);
	}

	@Override
	public void addCupcake()
	{
		avatarContainer.addCupcake();
		numberOfCupcakes++;
	}
	
	@Override
	public void removeCupcake()
	{
		avatarContainer.removeCupcake();
		numberOfCupcakes--;
	}

	@Override
	public int getNumberOfCupcakes()
	{
		return numberOfCupcakes;
	}
}