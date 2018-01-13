package graphics;

public interface ConnectableAvatar extends CompleteAvatar
{
	public void connectHouse(int inputHouse);
	public void disconnectHouse();
	public int getConnectedHouseNumber();
	public boolean getIsConnected();
}
