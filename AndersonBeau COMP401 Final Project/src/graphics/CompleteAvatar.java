package graphics;

public interface CompleteAvatar
{
	public int  getCompleteAvatarX();
	public int  getCompleteAvatarY();
	public int getCompleteAvatarFootX();
	public int getCompleteAvatarFootY();
	public void setAvatarXY(int xLocation, int yLocation);
	public Avatar getAnAvatar();
	public CupcakeContainer getCupcakeContainer();
	public Wheelbarrow getWheelbarrow();
	public void addCupcake();
	public void removeCupcake();
	public int getNumberOfCupcakes();
}
