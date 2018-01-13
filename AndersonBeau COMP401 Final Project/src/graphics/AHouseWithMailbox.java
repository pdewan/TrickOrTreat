package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class AHouseWithMailbox implements HouseWithMailbox
{
	int mailboxDistance;
	PictureLabel house;
	Mailbox mailbox;
	
	public AHouseWithMailbox (int initX, int initY, int houseType, int boxDist, int bHeight, int bWidth, int pLength)
	{
		mailboxDistance = boxDist;
		house = new AHouse(initX, initY, houseType);
		mailbox = new AMailbox(initX, (initY+mailboxDistance), bHeight, bWidth, pLength);
	}

	@Override
	public PictureLabel getHouse()
	{
		return house;
	}

	@Override
	public Mailbox getMailbox()
	{
		return mailbox;
	}

	@Override
	public void setXY(int newLocationX, int newLocationY)
	{
		house.setXY(newLocationX, newLocationY);		
		mailbox.setXY(newLocationX, newLocationY+mailboxDistance);
	}
}