package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AConnectableAvatar extends ACompleteAvatar implements ConnectableAvatar
{	
	boolean isConnected;
	int connectedHouse;
	
	public AConnectableAvatar (int initX, int initY, int hHeight, int hWidth, int bLength, int nCakes)
	{
		super (initX, initY, hHeight, hWidth, bLength, nCakes);
	}
	
	@Override
	public void connectHouse(int inputHouse)
	{
		// If we jump straight from one house to another, we need to force a disconnect
		if (isConnected == true)
		{
			if (inputHouse != connectedHouse)
			{
//				could just do this but for sake of continuity i'll call the disconnect method
//				connectedHouse = inputHouse;
				disconnectHouse();
			}
		}
		
		if (isConnected == false)
		{
			connectedHouse = inputHouse;
			isConnected = true;
//			System.out.println("Now connected to house" + connectedHouse);
		}
		else
		{
			System.out.println("The avatar is already connected to a house!");
		}
	}

	@Override
	public void disconnectHouse()
	{
		if (isConnected == true)
		{
//			System.out.println("Now disconnected from house" + connectedHouse);
			connectedHouse = 0;
			isConnected = false;
		}
		else
		{
			System.out.println("The avatar is not connected to a house!");
		}
	}

	@Override
	public int getConnectedHouseNumber()
	{
		return connectedHouse;
	}

	@Override
	public boolean getIsConnected()
	{
		return isConnected;
	}
}