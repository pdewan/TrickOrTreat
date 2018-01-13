package graphics;

import java.util.Vector;

import stringProcessors.HalloweenCommandProcessor;
import util.annotations.Position;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AHalloweenSimulation implements HalloweenSimulation
{
	int windowTopXBound;
	int windowTopYBound;
	int windowWidth;
	int windowHeight;
	int xOffset;
	int yOffset;
	int worldSize;
	ConnectableAvatar MyAvatar;
	CompleteHouseWithCandy[] House = new CompleteHouseWithCandy[14];
	CompleteHouseWithCandyCollection aHouseCollection = new ACompleteHouseWithCandyCollection();
	EmptyPlot[] Plot = new EmptyPlot[14];
	EmptyPlotCollection aEmptyPlotCollection = new AnEmptyPlotCollection();
	PictureLabel leftBarrier;
	PictureLabel rightBarrier;
	PictureLabel[] topBarrier = new PictureLabel[14];
	PictureLabel[] bottomBarrier = new PictureLabel[14];
	PictureLabelCollection worldBorder = new ABarrierCollection();
	PictureLabel[] Road = new PictureLabel[14];
	PictureLabelCollection roadCollection = new ARoadCollection();
	PictureLabel carPointedRight;
//	PictureLabel carPointedLeft;
	PictureLabelCollection sickPuke = new APukeCollection();
	String errorMessages = "";
	int isAvatarSick = 0;
	int avatarSickTimer = 0;
	boolean animationOn = true;
	int animationSteps = 20;
	int pauseTime = 1000;
	int distanceMoved = 0;
	int totalHouseAdds = 0;
	int totalHouseRems = 0;
	int totalCupcakesEaten = 0;
	int[] presetStorage = new int[270];
	boolean preset1;
	boolean preset2;
	boolean preset3;
	boolean preset4;
	Vector<HalloweenCommandProcessor> commandLineListener = new Vector<HalloweenCommandProcessor>();
	
	public AHalloweenSimulation(int wX, int wY, int wWidth, int wHeight, int offsetX, int offsetY, int wSize)
	{
		windowTopXBound = wX;
		windowTopYBound = wY;
		xOffset = offsetX;
		yOffset = offsetY;
		worldSize = wSize;
		if (worldSize < 3) { worldSize = 3; }
		else if (worldSize > 14) { worldSize = 14; }
		
		// Need to add getters for avatar width, height, and body length so I can make this more accurate
		MyAvatar = new AConnectableAvatar(200 - xOffset, 500 - yOffset, 40, 20, 80, 0);
					// 160 is temporary - need to replace it with values obtained from the avatar
		windowWidth = wWidth - 160;
		if (windowWidth < 300)
		{
			windowWidth = 300;
		}
		windowHeight = wHeight - 240;
		if (windowHeight < 300)
		{
			windowHeight = 300;
		}
		// Build Houses Randomly Using My New Random House Builder
		House[0] = buildHouse(1, 0 - xOffset, 0 - yOffset, 6);
		House[1] = buildHouse(2, 550 - xOffset, 0 - yOffset, 5);
		House[2] = buildHouse(3, 1100 - xOffset, 0 - yOffset, 4);
		House[3] = buildHouse(4, 1650 - xOffset, 0 - yOffset, 3);
		House[4] = buildHouse(5, 2200 - xOffset, 0 - yOffset, 2);
		House[5] = buildHouse(6, 2750 - xOffset, 0 - yOffset, 1);
		House[6] = buildHouse(7, 3300 - xOffset, 0 - yOffset, 3);
		House[7] = buildHouse(8, 3850 - xOffset, 0 - yOffset, 5);
		House[8] = buildHouse(9, 4400 - xOffset, 0 - yOffset, 6);
		House[9] = buildHouse(10, 4950 - xOffset, 0 - yOffset, 4);
		House[10] = buildHouse(11, 5500 - xOffset, 0 - yOffset, 0);
		House[11] = buildHouse(12, 6050 - xOffset, 0 - yOffset, 2);
		House[12] = buildHouse(13, 6600 - xOffset, 0 - yOffset, 3);
		House[13] = buildHouse(14, 7150 - xOffset, 0 - yOffset, 6);
		Plot[0] = new AnEmptyPlot(0 - xOffset, 0 - yOffset, 4, 400 - xOffset, 400 - yOffset, 1);
		Plot[1] = new AnEmptyPlot(550 - xOffset, 0 - yOffset, 3, 600 - xOffset, 350 - yOffset, 0);
		Plot[2] = new AnEmptyPlot(1100 - xOffset, 0 - yOffset, 6, 1300 - xOffset, 300 - yOffset, 1);
		Plot[3] = new AnEmptyPlot(1650 - xOffset, 0 - yOffset, 1, 2000 - xOffset, 350 - yOffset, 0);
		Plot[4] = new AnEmptyPlot(2200 - xOffset, 0 - yOffset, 3, 2600 - xOffset, 400 - yOffset, 1);
		Plot[5] = new AnEmptyPlot(2750 - xOffset, 0 - yOffset, 5, 3000 - xOffset, 350 - yOffset, 0);
		Plot[6] = new AnEmptyPlot(3300 - xOffset, 0 - yOffset, 6, 3500 - xOffset, 400 - yOffset, 1);
		Plot[7] = new AnEmptyPlot(3850 - xOffset, 0 - yOffset, 3, 4200 - xOffset, 350 - yOffset, 0);
		Plot[8] = new AnEmptyPlot(4400 - xOffset, 0 - yOffset, 1, 4800 - xOffset, 300 - yOffset, 1);
		Plot[9] = new AnEmptyPlot(4950 - xOffset, 0 - yOffset, 4, 5100 - xOffset, 400 - yOffset, 0);
		Plot[10] = new AnEmptyPlot(5500 - xOffset, 0 - yOffset, 3, 5850 - xOffset, 300 - yOffset, 1);
		Plot[11] = new AnEmptyPlot(6050 - xOffset, 0 - yOffset, 2, 6350 - xOffset, 250 - yOffset, 0);
		Plot[12] = new AnEmptyPlot(6600 - xOffset, 0 - yOffset, 5, 7000 - xOffset, 300 - yOffset, 1);
		Plot[13] = new AnEmptyPlot(7150 - xOffset, 0 - yOffset, 6, 7500 - xOffset, 200 - yOffset, 0);
		leftBarrier = new ABarrier(0 - xOffset, 0 - yOffset, 1);
		rightBarrier = new ABarrier(((worldSize * 550) +50) - xOffset, 0 - yOffset, 2);
		worldBorder.addElement(leftBarrier);
		worldBorder.addElement(rightBarrier);
		for (int i=0; i < worldSize; i++)
		{
			topBarrier[i] = new ABarrier((i * 550) - xOffset, 0 - yOffset, 3);
			bottomBarrier[i] = new ABarrier((i * 550) - xOffset, 760 - yOffset, 3);
			worldBorder.addElement(topBarrier[i]);
			worldBorder.addElement(bottomBarrier[i]);

			Road[i] = new ARoad((i * 550) - xOffset, 600 - yOffset, 0);
			roadCollection.addElement(Road[i]);
			
			aEmptyPlotCollection.addElement(Plot[i]);
		}
		
		carPointedRight = new ACarPointedRight(-300, (windowWidth + 100), 1);
//		carPointedRight = new ACarPointedLeft(-300, (windowWidth + 100), 1);

		aHouseCollection.addElement(House[0]);
		aHouseCollection.addElement(House[1]);
		
		// YES! So far this code works, I drilled down to AShape through MyAvatar,
		// and I registered house1 as a listener, which updated on the console correctly
		// upon an avatar move.  Since I am drilling down through the bottom line, the
		// x,y location returned by the observable is the location of the avatars foot!
		// Also, only need to register two houses since thats all we start with
		MyAvatar.getAnAvatar().getBottomLine().addHouseListener(House[0]);
		MyAvatar.getAnAvatar().getBottomLine().addHouseListener(House[1]);
		// Stage 2 is to have the simulation listen to the houses to report if avatar is on path
		House[0].addSimulationListener(this);
		House[1].addSimulationListener(this);		
//		Update Avatar Path Condition by initiating a move of 0,0 to update listeners
		MoveAvatar(0,0);
	}

	@Visible(false)
	@Override
	public void connectMyAvatar(int toHouseNumber)
	{
		MyAvatar.connectHouse(toHouseNumber);
	}
	
	@Visible(false)
	@Override
	public void toggleAnimation(boolean tog, int steps, int pTime)
	{
		animationOn = tog;
		animationSteps = steps;
		pauseTime = pTime;		
	}

	@Visible(false)
	@Override
	public void startMoveThread(int xAmount, int yAmount)
	{
		Runnable animateCommand = new AnimateMoveCommand(this, xAmount, yAmount);
		Thread thread = new Thread(animateCommand);
		thread.setName("Animate Avatar Movement");
		thread.start();
	}
	
	@Visible(false)
	@Override
	public void addhouseThread()
	{
		Runnable animateCommand = new AnimateAddHouseCommand(this);
		Thread thread = new Thread(animateCommand);
		thread.setName("Animate Add House");
		thread.start();
	}

	@Visible(false)
	@Override
	public void addhouseThread(int pNum)
	{
		Runnable animateCommand = new AnimateAddHouseCommand(this, pNum);
		Thread thread = new Thread(animateCommand);
		thread.setName("Animate Add House");
		thread.start();
	}

	@Visible(false)
	@Override
	public void removehouseThread()
	{
		Runnable animateCommand = new AnimateRemoveHouseCommand(this);
		Thread thread = new Thread(animateCommand);
		thread.setName("Animate Remove House");
		thread.start();
	}
	
	@Visible(false)
	@Override
	public void giveCupcakeThread(int amtToGive)
	{
		Runnable animateCommand = new AnimateGiveCommand(this, amtToGive);
		Thread thread = new Thread(animateCommand);
		thread.setName("Animate Give Cupcakes");
		thread.start();
	}

	@Visible(false)
	@Override
	public void takeCupcakeThread(int amtToTake)
	{
		Runnable animateCommand = new AnimateTakeCommand(this, amtToTake);
		Thread thread = new Thread(animateCommand);
		thread.setName("Animate Take Cupcakes");
		thread.start();
	}

	@Visible(false)
	@Override
	public void eatCupcakeThread()
	{
		Runnable animateCommand = new AnimateEatCommand(this);
		Thread thread = new Thread(animateCommand);
		thread.setName("Animate Eating A Cupcake");
		thread.start();
	}
	
	@Visible(false)
	@Override
	public synchronized void animateMovement(int xAmount, int yAmount)
	{
		int xToAdd;
		int yToAdd;
		// Check and set X Increment
		double temp = (double) xAmount / (double) (animationSteps - 1);
		xToAdd = (int) Math.rint(temp + 0.0000000001);

		// Check and set Y Increment
		temp = (double) yAmount / (double) (animationSteps - 1);
		yToAdd = (int) Math.rint(temp + 0.0000000001);
		
		for (int i = 0; i < (animationSteps - 1); i++)
		{
			MoveAvatar(xToAdd, yToAdd);
			sleep();
			xAmount -= xToAdd;
			temp = (double) xAmount / (double) (animationSteps - 1 - i);
			xToAdd = (int) Math.rint(temp + 0.0000000001);
			yAmount -= yToAdd;
			temp = (double) yAmount / (double) (animationSteps - 1 - i);
			yToAdd = (int) Math.rint(temp + 0.0000000001);
		}
		MoveAvatar(xToAdd, yToAdd);
	}
	
	@Override
	public void MoveAvatar(int xAmount, int yAmount)
	{
		int oldAvatarX = MyAvatar.getCompleteAvatarX();
		int oldAvatarY = MyAvatar.getCompleteAvatarY();
		int newAvatarX = (xAmount + oldAvatarX);
		int newAvatarY = (yAmount + oldAvatarY);
		int xDifference = 0;
		int yDifference = 0;
		if (newAvatarX > windowWidth)
		{
			xDifference = newAvatarX - windowWidth;
			newAvatarX = windowWidth;
		}
		if (newAvatarX < windowTopXBound)
		{
			if (xAmount < windowTopXBound && xAmount > 0)
			{
				xDifference = (xAmount*(-1));
			}
			else
			{
			xDifference = ((xAmount + oldAvatarX) - windowTopXBound);
			}
			newAvatarX = windowTopXBound;
		}
		if (newAvatarY > windowHeight)
		{
			yDifference = newAvatarY - windowHeight;
			newAvatarY = windowHeight;
		}
		if (newAvatarY < windowTopYBound)
		{
			if (yAmount < windowTopYBound && yAmount > 0)
			{
				yDifference = (yAmount*(-1));
			}
			else
			{
				yDifference = ((yAmount + oldAvatarY) - windowTopYBound);
			}
			newAvatarY = windowTopYBound;
		}
		
		// Make sure avatar cannot go past the simulation borders
		if (leftBarrier.getXLocation() > xDifference)
		{
			xDifference = leftBarrier.getXLocation();
		}
		if (leftBarrier.getYLocation() > yDifference)
		{
			yDifference = leftBarrier.getYLocation();
		}
		if ((rightBarrier.getXLocation()-xDifference) < (windowWidth + 160))
		{
			xDifference = rightBarrier.getXLocation() - (windowWidth + 160);
		}
		if ((bottomBarrier[0].getYLocation()-yDifference) < (windowHeight + 180))
		{
			yDifference = bottomBarrier[0].getYLocation() - (windowHeight + 180);
		}
		
		// Force Disconnect only if currently connected
		if (getIsAvatarConnected() == true)
		{
			MyAvatar.disconnectHouse();
		}
		// Move Avatar
		MyAvatar.setAvatarXY(newAvatarX, newAvatarY);

		// If the avatar is on the border of the simulation, this will move the world
		if (xDifference != 0 || yDifference != 0)
		{
			leftBarrier.setXY(leftBarrier.getXLocation() - xDifference, leftBarrier.getYLocation() - yDifference);
			rightBarrier.setXY(rightBarrier.getXLocation() - xDifference, rightBarrier.getYLocation() - yDifference);
			for (int t=0; t < worldSize; t++)
			{
				House[t].setXY(House[t].getHouseX() - xDifference, House[t].getHouseY() - yDifference);
				Plot[t].setXY(Plot[t].getGrass().getXLocation() - xDifference, Plot[t].getGrass().getYLocation() - yDifference);
				topBarrier[t].setXY(topBarrier[t].getXLocation() - xDifference, topBarrier[t].getYLocation() - yDifference);
				bottomBarrier[t].setXY(bottomBarrier[t].getXLocation() - xDifference, bottomBarrier[t].getYLocation() - yDifference);
				Road[t].setXY(Road[t].getXLocation() - xDifference, Road[t].getYLocation() - yDifference);
			}
			if (isAvatarSick > 10)
			{
				for (int i=0; i < sickPuke.size(); i++)
				{
					sickPuke.elementAt(i).setXY(sickPuke.elementAt(i).getXLocation() - xDifference, sickPuke.elementAt(i).getYLocation() - yDifference);
				}
			}
		}
		sickTimer();
		distanceMoved += (Math.abs(newAvatarX - oldAvatarX) + Math.abs(newAvatarY - oldAvatarY) + Math.abs(xDifference) + Math.abs(yDifference));
		int carAppearance = rNumGen(1, 99);
		if (carAppearance > 95) {driveCar(1);}
	}
	boolean animateCars;
	public void setAnimateCars(boolean newVal) {
		animateCars = newVal;
		
	}
	
	public boolean getAnimateCars() {
		return animateCars;
	}

	void sickTimer()
	{
		if (isAvatarSick > 10)
		{
			avatarSickTimer++;
			if (avatarSickTimer == 4)
			{
				PictureLabel Puke5 = sickPuke.elementAt(4);
				sickPuke.removeElement(Puke5);
				isAvatarSick++;
			}
			if (avatarSickTimer == 8)
			{
				PictureLabel Puke4 = sickPuke.elementAt(3);
				sickPuke.removeElement(Puke4);
				isAvatarSick++;
			}
			if (avatarSickTimer == 12)
			{
				PictureLabel Puke3 = sickPuke.elementAt(2);
				sickPuke.removeElement(Puke3);
				isAvatarSick++;
			}
			if (avatarSickTimer == 16)
			{
				PictureLabel Puke2 = sickPuke.elementAt(1);
				sickPuke.removeElement(Puke2);
				isAvatarSick++;
			}
			if (avatarSickTimer >= 20)
			{
				PictureLabel Puke1 = sickPuke.elementAt(0);
				sickPuke.removeElement(Puke1);
				isAvatarSick = 0;
				avatarSickTimer = 0;
			}
		}
	}


	@Override
	public boolean preAddHouse()
	{
		if (aHouseCollection.size() >= worldSize)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public synchronized void AddHouse()
	{
		assert (preAddHouse());
		int hToBuild = aHouseCollection.size();
		if (aHouseCollection.size() >= worldSize)
		{
			errorMessages += "The Neighborhood is Full!";
		}
		else
		{
			int tempXLoc = House[hToBuild].getHouseX();
			int tempYLoc = House[hToBuild].getHouseY();
			House[hToBuild] = buildHouse((hToBuild + 1), tempXLoc, tempYLoc, 6);
			aHouseCollection.addElement(House[hToBuild]);
			MyAvatar.getAnAvatar().getBottomLine().addHouseListener(House[hToBuild]);
			House[hToBuild].addSimulationListener(this);
			totalHouseAdds++;
		}
//		Update Avatar Path Condition by initiating a move of 0,0 to update listeners
		if (animationOn == true) {sleep(500);}
		MoveAvatar(0,0);
	}

	@Override
	public synchronized void AddHouse(int pNum)
	{
		assert (preAddHouse());
		int hToBuild = aHouseCollection.size();
		if (aHouseCollection.size() >= worldSize)
		{
			errorMessages += "The Neighborhood is Full!";
		}
		else
		{
			int tempXLoc = House[hToBuild].getHouseX();
			int tempYLoc = House[hToBuild].getHouseY();
			House[hToBuild] = buildHouse((hToBuild + 1), tempXLoc, tempYLoc, 6, pNum);
			aHouseCollection.addElement(House[hToBuild]);
			MyAvatar.getAnAvatar().getBottomLine().addHouseListener(House[hToBuild]);
			House[hToBuild].addSimulationListener(this);
			totalHouseAdds++;
		}
//		Update Avatar Path Condition by initiating a move of 0,0 to update listeners
		if (animationOn == true) {sleep(500);}
		MoveAvatar(0,0);
	}

	@Override
	public boolean preRemoveHouse()
	{
		if (aHouseCollection.size() > 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public synchronized void RemoveHouse()
	{
		assert (preRemoveHouse());
		int hToDemolish = (aHouseCollection.size() - 1);
		if (aHouseCollection.size()<=0)
		{
			errorMessages += "All Houses Demolished!";
		}
		else
		{
			aHouseCollection.removeElement(House[hToDemolish]);
			House[hToDemolish].removeSimulationListener(this);
			MyAvatar.getAnAvatar().getBottomLine().removeHouseListener(House[hToDemolish]);
			totalHouseRems++;
		}
//		Update Avatar Path Condition by initiating a move of 0,0 to update listeners
		if (animationOn == true) {sleep(500);}
		MoveAvatar(0,0);
	}

	@Position (0)
	@Override
	public PictureLabelCollection getAvatarPuke()
	{
		return sickPuke;
	}

	@Position (1)
	@Override
	public PictureLabelCollection getWorldBorder()
	{
		return worldBorder;
	}

	@Position (2)
	@Override
	public PictureLabel getCar()
	{
		return carPointedRight;
	}
	
	@Position (3)
	@Override
	public CompleteAvatar getCompleteAvatar()
	{
		return MyAvatar;
	}

	@Position (4)
	@Override
	public CompleteHouseWithCandyCollection getCompleteHouses()
	{
		return aHouseCollection;
	}
	
	@Position (5)
	@Override
	public EmptyPlotCollection getEmptyPlots()
	{
		return aEmptyPlotCollection;
	}
	
	@Position (6)
	@Override
	public PictureLabelCollection getRoads()
	{
		return roadCollection;
	}

/*	
	@Visible(false)
	@Override
	public int getCandyAmount(int houseNum)
	{
		if (houseNum==4)
		{
			return House4.getNumberOfCupcakes();
		}
		else if (houseNum==3)
		{
			return House3.getNumberOfCupcakes();
		}
		else if (houseNum==2)
		{
			return House2.getNumberOfCupcakes();
		}
		else if (houseNum==1)
		{
			return House1.getNumberOfCupcakes();
		}
		else
		{
			return 0;
		}
	}
*/
	@Visible(false)
	@Override
	public int getHouseX(int houseNum)
	{
		return House[(houseNum - 1)].getHouseX();
	}
	
	@Visible(false)
	@Override
	public int getHouseY(int houseNum)
	{
		return House[(houseNum - 1)].getHouseY();
	}

	@Override
	public boolean preEatCandy()
	{
		if (MyAvatar.getNumberOfCupcakes() > 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public synchronized void eatCandy()
	{
		assert (preEatCandy());
		if (MyAvatar.getNumberOfCupcakes() > 0)
		{
			if (isAvatarSick < 0) {isAvatarSick = 0;}
			if (isAvatarSick < 10)
			{
				totalCupcakesEaten ++;
				isAvatarSick ++;
				if (animationOn == true)
				{
					int cToEat = MyAvatar.getNumberOfCupcakes() - 1;
					int xLoc = MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToEat).getXLocation();
					int yLoc = MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToEat).getYLocation();
					PictureLabel Cupcake;
					MyAvatar.removeCupcake();
					for (int i = 1; i < 7; i++)
					{
						Cupcake = new ACupcake(xLoc, yLoc, i);
						MyAvatar.getCupcakeContainer().getCupcakes().addElement(Cupcake);
						sleep();
						MyAvatar.getCupcakeContainer().getCupcakes().removeElement(Cupcake);
					}
				}
				else
				{
					MyAvatar.removeCupcake();
				}
				if (isAvatarSick == 1) {errorMessages += "Yum Yum, I want more! ";}
				if (isAvatarSick == 2) {errorMessages += "Yum, That was a good cupcake! ";}
				if (isAvatarSick == 3) {errorMessages += "I Like Chocolate! ";}
				if (isAvatarSick == 4) {errorMessages += "That cupcake was delicious! ";}
				if (isAvatarSick == 5) {errorMessages += "I Love Cupcakes! ";}
				if (isAvatarSick == 6) {errorMessages += "Mother says stop eating so many cupcakes! ";}
				if (isAvatarSick == 7) {errorMessages += "Mother says you are going to get sick! ";}
				if (isAvatarSick == 8) {errorMessages += "Ohhh, I don't feel so good! ";}
				if (isAvatarSick == 9) {errorMessages += "I think I'm going to be sick... ";}
			}
			if (isAvatarSick == 11) {errorMessages += "I JUST THREW UP!  Please wait a while... "; sickTimer();}
			if (isAvatarSick == 12) {errorMessages += "Still not feeling good, please wait... "; sickTimer();}
			if (isAvatarSick == 13) {errorMessages += "Seriously, let me recover... "; sickTimer();}
			if (isAvatarSick == 14) {errorMessages += "I feel a little better, but still queasy... "; sickTimer();}
			if (isAvatarSick == 15) {errorMessages += "Ok, I can almost hold one down... try again. "; sickTimer();}
			if (isAvatarSick == 10)
			{
				errorMessages += "BLarhrfghhghrl ";
				int tempPukeType = rNumGen(1, 5);
				PictureLabel tempPuke;
				for (int l=1; l < 4; l++)
				{
					tempPuke = new APuke((MyAvatar.getCompleteAvatarX()+(l*25)), (MyAvatar.getCompleteAvatarY()+(l*10)), tempPukeType);
					sickPuke.addElement(tempPuke);
					tempPukeType = rNumGen(1, 5);
					if (animationOn == true)
					{
						sickPuke.elementAt(l-1).setXY(MyAvatar.getCompleteAvatarX()+10, MyAvatar.getCompleteAvatarY()+10);
						int chaosValue = rNumGen(3,9);
						for (int m=0; m < 20; m++)
						{
							tempPukeType = rNumGen(1, 5);
							if (tempPukeType <= 3) {sickPuke.elementAt(l-1).setXY(sickPuke.elementAt(l-1).getXLocation() + (tempPukeType+chaosValue), sickPuke.elementAt(l-1).getYLocation() + tempPukeType-1);}
							if (tempPukeType > 3) {sickPuke.elementAt(l-1).setXY(sickPuke.elementAt(l-1).getXLocation() + (tempPukeType+(chaosValue+1)), sickPuke.elementAt(l-1).getYLocation() + tempPukeType+(chaosValue-3));}
							chaosValue = rNumGen(3, 9);
							sleep(150);
						}
						sleep();
					}
				}
				for (int n=1; n < 3; n++)
				{
					tempPuke = new APuke((MyAvatar.getCompleteAvatarX()+(n*30)), (MyAvatar.getCompleteAvatarY()+((n*10)+25)), tempPukeType);
					sickPuke.addElement(tempPuke);
					tempPukeType = rNumGen(1, 5);
					if (animationOn == true)
					{
						sickPuke.elementAt(n+2).setXY(MyAvatar.getCompleteAvatarX()+10, MyAvatar.getCompleteAvatarY()+10);
						int moreChaosValue = rNumGen(3, 9);
						for (int p=0; p < 20; p++)
						{
							tempPukeType = rNumGen(1, 5);
							if (moreChaosValue <= 5) {sickPuke.elementAt(n+2).setXY(sickPuke.elementAt(n+2).getXLocation() + (tempPukeType+moreChaosValue), sickPuke.elementAt(n+2).getYLocation() + (tempPukeType-moreChaosValue));}
							if (moreChaosValue > 5) {sickPuke.elementAt(n+2).setXY(sickPuke.elementAt(n+2).getXLocation() + (tempPukeType+moreChaosValue), sickPuke.elementAt(n+2).getYLocation() + (tempPukeType+moreChaosValue));}
							moreChaosValue = rNumGen(3, 9);
							sleep(150);
						}
						sleep();
					}
				}
				isAvatarSick ++;
			}
		}
		else
		{
			errorMessages += "You have no cupcakes to eat!  Better go do some trick-or-treating...";
		}
		notifyCommandLineListener(errorMessages);
	}

	@Override
	public boolean preGiveCandy()
	{
		return MyAvatar.getIsConnected();
	}

	@Override
	public synchronized void giveCandy(int cAmount)
	{
		assert (preGiveCandy());
		boolean connected = getIsAvatarConnected();
		int avatarCupcakesLeft = MyAvatar.getNumberOfCupcakes();
		if (connected == true && avatarCupcakesLeft >= cAmount)
		{
			int amountToGive = cAmount;
			int houseNumber = getAvatarConnectedHouseNumber();

			// Translates the pointer that the avatar knows its connected to into the appropriate house
			// This way the avatar has no knowledge of the amount of houses there are, it only knows what
			// house it is connected to (1, 2, or 3) Don't need error checking on this line since we 
			// already checked to make sure we are connected to a house.
			CompleteHouseWithCandy houseToGiveCupcakesTo = aHouseCollection.elementAt(houseNumber - 1);

			int cupcakesLeft = houseToGiveCupcakesTo.getNumberOfCupcakes();

			if (cupcakesLeft == 6)
			{
				errorMessages += "Sorry, We do not need anymore cupcakes, you can keep them!";
			}
				
			if (amountToGive > (6 - cupcakesLeft) && cupcakesLeft != 6)
			{
				errorMessages += ("You are so generous! I appreciate your offer of " + amountToGive + " cupcake(s), but I can only take " + (6 - cupcakesLeft) + " cupcake(s).  Thank You!");
				amountToGive = (6 - cupcakesLeft);
			}
			
			if (amountToGive > 0 && amountToGive <= (6 - cupcakesLeft))
			{
				for (int i=0; i!=amountToGive; i++)
				{
					if (animationOn == true)
					{
						int cToMove = (MyAvatar.getCupcakeContainer().getCupcakes().size() - 1);
						int xStart = MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToMove).getXLocation();
						int yStart = MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToMove).getYLocation();
						int xEnd = houseToGiveCupcakesTo.getCupcakeContainer().getBasketX() + 19;
						int yEnd = houseToGiveCupcakesTo.getCupcakeContainer().getBasketY() - 100;
						for (int j=0; j < 20; j++)
						{
							MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToMove).setXY(xStart, yStart - 5);
							yStart = MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToMove).getYLocation();
							sleep();
						}
						int xInc = (xStart - xEnd) / animationSteps;
						if (xInc == 0) {xInc = 1;}
						int yInc = (yStart - yEnd) / animationSteps;
						if (yInc == 0) {yInc = 1;}
						for (int j=0; j < animationSteps; j++)
						{
							if (xStart < xEnd) {xStart = xEnd;}
							if (yStart < yEnd) {yStart = yEnd;}
							MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToMove).setXY(xStart - xInc, yStart - yInc);
							xStart = MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToMove).getXLocation();
							yStart = MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToMove).getYLocation();
							sleep();
						}
						for (int j=0; j < 20; j++)
						{
							MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToMove).setXY(xStart, MyAvatar.getCupcakeContainer().getCupcakes().elementAt(cToMove).getYLocation() + 5);
							sleep();
						}
						MyAvatar.removeCupcake();
						houseToGiveCupcakesTo.addCupcake();
					}
					else
					{
						MyAvatar.removeCupcake();
						houseToGiveCupcakesTo.addCupcake();
					}
				}
			}
			else if (amountToGive == 0)
			{
				errorMessages += "Trying to give 0 cupcakes makes no sense!";
			}			
		}
		else if (avatarCupcakesLeft < cAmount)
		{
			errorMessages += ("You don't have " + cAmount + " cupcake(s) to give!");
		}		
		else
		{
			errorMessages += "Avatar is not connected to a house!";
		}
	}

	@Override
	public boolean preTakeCandy()
	{
		return MyAvatar.getIsConnected();
	}
	
	@Override
	public synchronized void takeCandy(int cAmount)
	{
		assert (preTakeCandy());
		boolean connected = getIsAvatarConnected();
		int avatarEmptyCupcakeSpaces = (6 - MyAvatar.getNumberOfCupcakes());
		if (connected == true && avatarEmptyCupcakeSpaces >= cAmount)
		{
			int amountToTake = cAmount;
			int houseNumber = getAvatarConnectedHouseNumber();

			// Translates the pointer that the avatar knows its connected to into the appropriate house
			// This way the avatar has no knowledge of the amount of houses there are, it only knows what
			// house it is connected to (1, 2, or 3) Don't need error checking on this line since we 
			// already checked to make sure we are connected to a house.
			CompleteHouseWithCandy houseToTakeCupcakesFrom = aHouseCollection.elementAt(houseNumber - 1);

			int cupcakesLeft = houseToTakeCupcakesFrom.getNumberOfCupcakes();

			if (cupcakesLeft == 0)
			{
				errorMessages += "Sorry, This house is out of cupcakes!";
			}
			
			if (amountToTake > cupcakesLeft && cupcakesLeft != 0)
			{
				errorMessages += ("I know you want " + amountToTake + " but I can only give you " + cupcakesLeft + " cupcakes.  That's the best I can do!");
				amountToTake = cupcakesLeft;
			}
			
			if (amountToTake > 0 && amountToTake <= cupcakesLeft)
			{
				for (int i=0; i!=amountToTake; i++)
				{
					if (animationOn == true)
					{
						int cToMove = (houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().size() - 1);
						int xStart = houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().elementAt(cToMove).getXLocation();
						int yStart = houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().elementAt(cToMove).getYLocation();
						int xEnd = MyAvatar.getCupcakeContainer().getBasketX() + 40;
						int yEnd = MyAvatar.getCupcakeContainer().getBasketY() - 100;
						for (int j=0; j < 20; j++)
						{
							houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().elementAt(cToMove).setXY(xStart, yStart - 5);
							yStart = houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().elementAt(cToMove).getYLocation();
							sleep();
						}
						int xInc = (xEnd - xStart) / animationSteps;
						if (xInc == 0) {xInc = 1;}
						int yInc = (yEnd - yStart) / animationSteps;
						if (yInc == 0) {yInc = 1;}
						for (int j=0; j < animationSteps; j++)
						{
							if (xStart > xEnd) {xStart = xEnd;}
							if (yStart > yEnd) {yStart = yEnd;}
							houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().elementAt(cToMove).setXY(xStart + xInc, yStart + yInc);
							xStart = houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().elementAt(cToMove).getXLocation();
							yStart = houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().elementAt(cToMove).getYLocation();
							sleep();
						}
						for (int j=0; j < 20; j++)
						{
							houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().elementAt(cToMove).setXY(xStart, houseToTakeCupcakesFrom.getCupcakeContainer().getCupcakes().elementAt(cToMove).getYLocation() + 5);
							sleep();
						}
						houseToTakeCupcakesFrom.removeCupcake();
						MyAvatar.addCupcake();
					}
					else
					{
						houseToTakeCupcakesFrom.removeCupcake();
						MyAvatar.addCupcake();
					}
				}
			}
			else if (amountToTake == 0)
			{
				errorMessages += "Trying to take 0 cupcakes makes no sense!";
			}			
		}
		else if (avatarEmptyCupcakeSpaces < cAmount)
		{
			errorMessages += ("You don't have room in your basket for " + cAmount + " cupcake(s)!");
		}
		else
		{
			errorMessages += "Avatar is not connected to a house!";
		}
	}
	
	@Override
	public boolean getIsAvatarConnected()
	{
		return MyAvatar.getIsConnected();
	}

	@Override
	public int getAvatarConnectedHouseNumber()
	{
		return MyAvatar.getConnectedHouseNumber();
	}
	
	@Override
	public String getErrorMessages()
	{
		return errorMessages;
	}
	
	@Visible(false)
	@Override
	public void clearErrorMessages()
	{
		errorMessages = "";
	}

	@Visible(false)
	@Override
	public void sleep()
	{
		try {
			// OS suspends program for pauseTime
			Thread.sleep(pauseTime);
		} catch (InterruptedException e) {
			// program may be forcibly interrupted while sleeping
			e.printStackTrace();
		}
	}

	@Visible(false)
	public void sleep(int sleepTime)
	{
		try {
			// OS suspends program for pauseTime
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// program may be forcibly interrupted while sleeping
			e.printStackTrace();
		}
	}

	CompleteHouseWithCandy buildHouse(int hNum, int xLoc, int yLoc, int numCupcakes)
	{
		//Choose House Type
		int tempHouseType = rNumGen(1, 5);
		// Choose Mailbox Size (Distance remains fixed at 490)
		int tempBoxHeight = rNumGen(10, 40);
		int tempBoxWidth = rNumGen(10, 40);
		int tempPostLength = 60 - tempBoxHeight;
		// Randomize # Of Bushes
		int tempNumBushes = rNumGen(0, 6);
		// Randomize # Of Shrubs
		int tempNumShrubs = rNumGen(0, 6);
		// Randomize # Of Trees
		int tempNumTrees = rNumGen(0, 4);
		// Randomize Path Type
		int tempPath = rNumGen(1, 5);
		// Randomize Grass Type
		int tempGrass = rNumGen(1, 6);
		
		// Build House With:											X, 		Y, 		HouseType, 	boxDist, boxHeight, BoxWidth, 		PostLength, 	#Bush,			#Shrub,			#Tree,	PathType, GrassType, #Cupcakes
		CompleteHouseWithCandy tempHouse = new ACompleteHouseWithCandy (xLoc, yLoc, tempHouseType, 490, tempBoxHeight, tempBoxWidth, tempPostLength, tempNumBushes, tempNumShrubs, tempNumTrees, tempPath, tempGrass, numCupcakes);
		
		// Save preset data
		int positionMultiplier = ((hNum-1) * 15);
		presetStorage[positionMultiplier] = tempHouseType;
		presetStorage[(positionMultiplier+1)] = 490;
		presetStorage[(positionMultiplier+2)] = tempBoxHeight;
		presetStorage[(positionMultiplier+3)] = tempBoxWidth;
		presetStorage[(positionMultiplier+4)] = tempPostLength;
		presetStorage[(positionMultiplier+5)] = tempNumBushes;
		presetStorage[(positionMultiplier+6)] = tempNumShrubs;
		presetStorage[(positionMultiplier+7)] = tempNumTrees;
		presetStorage[(positionMultiplier+8)] = tempPath;
		presetStorage[(positionMultiplier+9)] = tempGrass;
		presetStorage[(positionMultiplier+10)] = numCupcakes;
		
		// Send back the built house...
		return tempHouse;
	}

	// Build house from preset
	CompleteHouseWithCandy buildHouse(int hNum, int xLoc, int yLoc, int numCupcakes, int pNum)
	{
		if (pNum == 1 && preset1 == true)
		{
			int tempHouseType = presetStorage[210];
			int boxDist = presetStorage[211];
			int tempBoxHeight = presetStorage[212];
			int tempBoxWidth = presetStorage[213];
			int tempPostLength = presetStorage[214];
			int tempNumBushes = presetStorage[215];
			int tempNumShrubs = presetStorage[216];
			int tempNumTrees = presetStorage[217];
			int tempPath = presetStorage[218];
			int tempGrass = presetStorage[219];
			numCupcakes = presetStorage[220];
			// Build House With:											X, 		Y, 		HouseType, 	boxDist, boxHeight, BoxWidth, 		PostLength, 	#Bush,			#Shrub,			#Tree,	PathType, GrassType, #Cupcakes
			CompleteHouseWithCandy tempHouse = new ACompleteHouseWithCandy (xLoc, yLoc, tempHouseType, boxDist, tempBoxHeight, tempBoxWidth, tempPostLength, tempNumBushes, tempNumShrubs, tempNumTrees, tempPath, tempGrass, numCupcakes);
			// Send back the built house...
			return tempHouse;
		}
		if (pNum == 2 && preset2 == true)
		{
			int tempHouseType = presetStorage[225];
			int boxDist = presetStorage[226];
			int tempBoxHeight = presetStorage[227];
			int tempBoxWidth = presetStorage[228];
			int tempPostLength = presetStorage[229];
			int tempNumBushes = presetStorage[230];
			int tempNumShrubs = presetStorage[231];
			int tempNumTrees = presetStorage[232];
			int tempPath = presetStorage[233];
			int tempGrass = presetStorage[234];
			numCupcakes = presetStorage[235];
			// Build House With:											X, 		Y, 		HouseType, 	boxDist, boxHeight, BoxWidth, 		PostLength, 	#Bush,			#Shrub,			#Tree,	PathType, GrassType, #Cupcakes
			CompleteHouseWithCandy tempHouse = new ACompleteHouseWithCandy (xLoc, yLoc, tempHouseType, boxDist, tempBoxHeight, tempBoxWidth, tempPostLength, tempNumBushes, tempNumShrubs, tempNumTrees, tempPath, tempGrass, numCupcakes);
			// Send back the built house...
			return tempHouse;
		}
		if (pNum == 3 && preset3 == true)
		{
			int tempHouseType = presetStorage[240];
			int boxDist = presetStorage[241];
			int tempBoxHeight = presetStorage[242];
			int tempBoxWidth = presetStorage[243];
			int tempPostLength = presetStorage[244];
			int tempNumBushes = presetStorage[245];
			int tempNumShrubs = presetStorage[246];
			int tempNumTrees = presetStorage[247];
			int tempPath = presetStorage[248];
			int tempGrass = presetStorage[249];
			numCupcakes = presetStorage[250];
			// Build House With:											X, 		Y, 		HouseType, 	boxDist, boxHeight, BoxWidth, 		PostLength, 	#Bush,			#Shrub,			#Tree,	PathType, GrassType, #Cupcakes
			CompleteHouseWithCandy tempHouse = new ACompleteHouseWithCandy (xLoc, yLoc, tempHouseType, boxDist, tempBoxHeight, tempBoxWidth, tempPostLength, tempNumBushes, tempNumShrubs, tempNumTrees, tempPath, tempGrass, numCupcakes);
			// Send back the built house...
			return tempHouse;
		}
		if (pNum == 4 && preset4 == true)
		{
			int tempHouseType = presetStorage[255];
			int boxDist = presetStorage[256];
			int tempBoxHeight = presetStorage[257];
			int tempBoxWidth = presetStorage[258];
			int tempPostLength = presetStorage[259];
			int tempNumBushes = presetStorage[260];
			int tempNumShrubs = presetStorage[261];
			int tempNumTrees = presetStorage[262];
			int tempPath = presetStorage[263];
			int tempGrass = presetStorage[264];
			numCupcakes = presetStorage[265];
			// Build House With:											X, 		Y, 		HouseType, 	boxDist, boxHeight, BoxWidth, 		PostLength, 	#Bush,			#Shrub,			#Tree,	PathType, GrassType, #Cupcakes
			CompleteHouseWithCandy tempHouse = new ACompleteHouseWithCandy (xLoc, yLoc, tempHouseType, boxDist, tempBoxHeight, tempBoxWidth, tempPostLength, tempNumBushes, tempNumShrubs, tempNumTrees, tempPath, tempGrass, numCupcakes);
			// Send back the built house...
			return tempHouse;
		}
		errorMessages += (" Preset " + pNum + " is empty! Adding Randomized House...");
		
		//Choose House Type
		int tempHouseType = rNumGen(1, 5);
		// Choose Mailbox Size (Distance remains fixed at 490)
		int tempBoxHeight = rNumGen(10, 40);
		int tempBoxWidth = rNumGen(10, 40);
		int tempPostLength = 60 - tempBoxHeight;
		// Randomize # Of Bushes
		int tempNumBushes = rNumGen(0, 6);
		// Randomize # Of Shrubs
		int tempNumShrubs = rNumGen(0, 6);
		// Randomize # Of Trees
		int tempNumTrees = rNumGen(0, 4);
		// Randomize Path Type
		int tempPath = rNumGen(1, 5);
		// Randomize Grass Type
		int tempGrass = rNumGen(1, 6);
		
		// Build House With:											X, 		Y, 		HouseType, 	boxDist, boxHeight, BoxWidth, 		PostLength, 	#Bush,			#Shrub,			#Tree,	PathType, GrassType, #Cupcakes
		CompleteHouseWithCandy tempHouse = new ACompleteHouseWithCandy (xLoc, yLoc, tempHouseType, 490, tempBoxHeight, tempBoxWidth, tempPostLength, tempNumBushes, tempNumShrubs, tempNumTrees, tempPath, tempGrass, numCupcakes);
		
		// Send back the built house...
		return tempHouse;
	}

	int rNumGen(int low, int high)
	{
		int mult = 10;
		if (high > 9) {mult = 100;}
		int randNum = low - 1;
		while (randNum < low || randNum > high)
		{
			randNum = (int) (Math.random()*mult);
		}
		return randNum;
	}

	@Visible(false)
	@Override
	public boolean getAnimationOn()
	{
		return animationOn;
	}

	@Visible(false)
	@Override
	public void undoEat()
	{
		errorMessages += " Cannot undo an Eat Command...  Just Keep Eating More! ";
	}
	

	@Visible(false)
	@Override
	public void addCommandLineListener(HalloweenCommandProcessor commandLine)
	{
		commandLineListener.add(commandLine);
//		System.out.println("Command Line Listener Added");
	}

	@Visible(false)
	@Override
	public void removeCommandLineListener(HalloweenCommandProcessor commandLine)
	{
		commandLineListener.removeAllElements();
	}

	private void notifyCommandLineListener(String messageToSend)
	{
	    for(int i = 0; i < commandLineListener.size(); i++)
	    {
	    	// this will notify the commandLine of the message String (IE Status Message)
	        commandLineListener.get(i).simulationListener(messageToSend);
	    }
	}

	@Override
	public int getCupcakesEaten()
	{
		return totalCupcakesEaten;
	}

	@Override
	public int getDistanceMoved()
	{
		return distanceMoved;
	}

	@Override
	public int getHousesAdded()
	{
		return totalHouseAdds;
	}

	@Override
	public int getHousesRemoved()
	{
		return totalHouseRems;
	}

	@Override
	public void savePreset(int hNum, int pNum)
	{
		int presetMultiplier = ((pNum+13) * 15);
		int houseMultiplier = ((hNum - 1)* 15);
		presetStorage[presetMultiplier] = presetStorage[houseMultiplier];
		presetStorage[(presetMultiplier+1)] = presetStorage[(houseMultiplier+1)];
		presetStorage[(presetMultiplier+2)] = presetStorage[(houseMultiplier+2)];
		presetStorage[(presetMultiplier+3)] = presetStorage[(houseMultiplier+3)];
		presetStorage[(presetMultiplier+4)] = presetStorage[(houseMultiplier+4)];
		presetStorage[(presetMultiplier+5)] = presetStorage[(houseMultiplier+5)];
		presetStorage[(presetMultiplier+6)] = presetStorage[(houseMultiplier+6)];
		presetStorage[(presetMultiplier+7)] = presetStorage[(houseMultiplier+7)];
		presetStorage[(presetMultiplier+8)] = presetStorage[(houseMultiplier+8)];
		presetStorage[(presetMultiplier+9)] = presetStorage[(houseMultiplier+9)];
		presetStorage[(presetMultiplier+10)] = presetStorage[(houseMultiplier+10)];
		presetStorage[(presetMultiplier+11)] = presetStorage[(houseMultiplier+11)];
		presetStorage[(presetMultiplier+12)] = presetStorage[(houseMultiplier+12)];
		presetStorage[(presetMultiplier+13)] = presetStorage[(houseMultiplier+13)];
		presetStorage[(presetMultiplier+14)] = -1;
		errorMessages += (" Preset " + pNum + " saved with house " + hNum + " general pattern!");
		
		if (presetStorage[224] == -1)
		{
			preset1 = true;
		}
		if (presetStorage[239] == -1)
		{
			preset2 = true;
		}
		if (presetStorage[254] == -1)
		{
			preset3 = true;
		}
		if (presetStorage[269] == -1)
		{
			preset4 = true;
		}
	}

	@Visible(false)
	@Override
	public void undoPreset()
	{
		errorMessages += " Cannot undo saving a preset - just add/remove house until you find a new one you like!";
	}

	@Visible(false)
	@Override
	public boolean getPreset1()
	{
		return preset1;
	}

	@Visible(false)
	@Override
	public boolean getPreset2()
	{
		return preset2;
	}

	@Visible(false)
	@Override
	public boolean getPreset3()
	{
		return preset3;
	}

	@Visible(false)
	@Override
	public boolean getPreset4()
	{
		return preset4;
	}

	@Visible(false)
	@Override
	public int getWorldSize()
	{
		return worldSize;
	}

	@Visible(false)
	@Override
	public synchronized void animateCar(int dToGo)
	{
		if (!animateCars) return;

		if (dToGo > 0)
		{
			int yLoc = (topBarrier[0].getYLocation() + windowHeight + 130);
			for (int c=-450;c<(windowWidth+400);c+=10)
			{
				carPointedRight.setXY(c, yLoc);
				sleep(40);
			}				
		}
	}

	@Visible(false)
	@Override
	public void driveCar(int dToGo)
	{
		if (!animateCars) return;
		Runnable animateCommand = new AnimateCarCommand(this, dToGo);
		Thread thread = new Thread(animateCommand);
		thread.setName("Animate Car Driving Right To Left");
		thread.start();
	}
	
//	public void drive()
//	{
//		driveCar(4);
//	}
}