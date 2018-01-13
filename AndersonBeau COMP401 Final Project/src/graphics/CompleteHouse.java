package graphics;

public interface CompleteHouse
{
	public boolean checkPath(CompleteAvatar avatarToCheck);
	public HouseWithMailbox getHouse();
	public PictureLabel getPath();
	public PictureLabelCollection buildShrubs();
	public PictureLabelCollection getShrub();
	public PictureLabelCollection buildTrees();
	public PictureLabelCollection getTree();
	public PictureLabelCollection buildBushes();
	public PictureLabelCollection getBush();
	public PictureLabel getGrass();
	public int getHouseX();
	public int getHouseY();
	public void setXY(int xPosition, int yPosition);
	// For Observing the Avatar - remove if doesn't work
	public void newCheckPath(int xLocation, int yLocation, int houseNum);
	// For Letting Simulation Observe House - remove if doesn't work
	public void addSimulationListener(HalloweenSimulation sim);
	public void removeSimulationListener(HalloweenSimulation sim);
}
