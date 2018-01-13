package graphics;

import stringProcessors.HalloweenCommandProcessor;

public interface HalloweenSimulation
{
	public CompleteAvatar getCompleteAvatar();
	public CompleteHouseWithCandyCollection getCompleteHouses();
	public EmptyPlotCollection getEmptyPlots();
	public PictureLabelCollection getAvatarPuke();
	public PictureLabelCollection getRoads();
	public void AddHouse();
	public void AddHouse(int pNum);
	public void RemoveHouse();
	public void MoveAvatar(int xAmount, int yAmount);
	public void takeCandy(int cAmount);
	public void giveCandy(int cAmount);
	public void eatCandy();
//	public int getCandyAmount(int houseNum);
	public int getHouseX(int houseNum);
	public int getHouseY(int houseNum);
	public boolean getIsAvatarConnected();
	public int getAvatarConnectedHouseNumber();
	public String getErrorMessages();
	public void clearErrorMessages();
	public PictureLabelCollection getWorldBorder();
	public void connectMyAvatar(int toHouseNumber);
	public void toggleAnimation(boolean tog, int steps, int pTime);
	public void startMoveThread(int xAmount, int yAmount);
	public void animateMovement(int xAmount, int yAmount);
	public void addhouseThread();
	public void addhouseThread(int pNum);
	public void removehouseThread();
	public void eatCupcakeThread();
	public void giveCupcakeThread(int amtToGive);
	public void takeCupcakeThread(int amtToTake);
	public void sleep();
	public void savePreset(int hNum, int pNum);
	public boolean getAnimationOn();
	public void undoEat();
	public void undoPreset();
	public void addCommandLineListener(HalloweenCommandProcessor commandLine);
	public void removeCommandLineListener(HalloweenCommandProcessor commandLine);
	public void driveCar(int dToGo);
	public void animateCar(int dToGo);
	public PictureLabel getCar();
	public boolean preGiveCandy();
	public boolean preTakeCandy();
	public boolean preAddHouse();
	public boolean preRemoveHouse();
	public boolean preEatCandy();
	public int getDistanceMoved();
	public int getHousesAdded();
	public int getHousesRemoved();
	public int getCupcakesEaten();
	public boolean getPreset1();
	public boolean getPreset2();
	public boolean getPreset3();
	public boolean getPreset4();
	public int getWorldSize();
	public void setAnimateCars(boolean newVal) ;
	
	public boolean getAnimateCars() ;
}
