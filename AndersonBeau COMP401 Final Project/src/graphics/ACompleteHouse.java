package graphics;

import java.util.Vector;

import util.annotations.Position;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class ACompleteHouse implements CompleteHouse
{
	int houseX;
	int houseY;
	int mailboxDistance;
	int mailboxHeight;
	int mailboxWidth;
	int mailboxPostLength;
	int numberOfBushes;
	int numberOfShrubs;
	int numberOfTrees;
	int grassType;
	PictureLabel housePath;
	PictureLabel theGrass;
	HouseWithMailbox baseHouse;
	PictureLabelCollection bushCollection;
	PictureLabelCollection shrubCollection;
	PictureLabelCollection treeCollection;
	Vector<HalloweenSimulation> simulationListener = new Vector<HalloweenSimulation>();
	
	public ACompleteHouse (int initX, int initY, int houseType, int boxDist, int bHeight, int bWidth, int pLength, int nBush, int nShrub, int nTree, int pathType, int gType)
	{
		houseX = initX;
		houseY = initY;
		mailboxDistance = boxDist;
		mailboxHeight = bHeight;
		mailboxWidth = bWidth;
		mailboxPostLength = pLength;
		grassType = gType;
		baseHouse = new AHouseWithMailbox(houseX+100, houseY+50, houseType, mailboxDistance, mailboxHeight, mailboxWidth, mailboxPostLength);
		housePath = new APath((houseX+255), (houseY+415), pathType);
		theGrass = new AGrass(houseX, houseY, gType);
		numberOfBushes = nBush;
		if (numberOfBushes > 6)
		{
			numberOfBushes = 6;
		}
		bushCollection = buildBushes();
		
		numberOfShrubs = nShrub;
		if (numberOfShrubs > 6)
		{
			numberOfShrubs = 6;
		}
		shrubCollection = buildShrubs();

		numberOfTrees = nTree;
		if (numberOfTrees > 4)
		{
			numberOfTrees = 4;
		}
		treeCollection = buildTrees();
	}
	
	@Override
	public PictureLabelCollection buildBushes()
	{
		if (numberOfBushes < 1)
		{
			PictureLabelCollection allBushes = new ABushCollection();		
			return allBushes;
		}
		
		PictureLabelCollection allBushes = new ABushCollection();		
		int tempBushType = rNumGen(1, 4);
		PictureLabel Bush1 = new ABush((houseX+190), (houseY+390), tempBushType);
		allBushes.addElement(Bush1);		
		
		if (numberOfBushes >= 2)
		{
			tempBushType = rNumGen(1, 4);
			PictureLabel Bush2 = new ABush((houseX+340), (houseY+390), tempBushType);
			allBushes.addElement(Bush2);
		}
		if (numberOfBushes >= 3)
		{
			tempBushType = rNumGen(1, 4);
			PictureLabel Bush3 = new ABush((houseX+390), (houseY+360), tempBushType);
			allBushes.addElement(Bush3);
		}
		if (numberOfBushes >= 4)
		{
			tempBushType = rNumGen(1, 4);
			PictureLabel Bush4 = new ABush((houseX+140), (houseY+370), tempBushType);
			allBushes.addElement(Bush4);
		}
		if (numberOfBushes >= 5)
		{
			tempBushType = rNumGen(1, 4);
			PictureLabel Bush5 = new ABush((houseX+340), (houseY+440), tempBushType);
			allBushes.addElement(Bush5);
		}
		if (numberOfBushes >= 6)
		{
			tempBushType = rNumGen(1, 4);
			PictureLabel Bush6 = new ABush((houseX+190), (houseY+440), tempBushType);
			allBushes.addElement(Bush6);
		}
		return allBushes;
	}

	@Override
	public PictureLabelCollection buildShrubs()
	{
		if (numberOfShrubs < 1)
		{
			PictureLabelCollection allShrubs = new AShrubCollection();
			return allShrubs;
		}

		PictureLabelCollection allShrubs = new AShrubCollection();
		int tempShrubType = rNumGen(1, 4);
		PictureLabel Shrub1 = new AShrub((houseX+100), (houseY+350), tempShrubType);
		allShrubs.addElement(Shrub1);
			
		if (numberOfShrubs >= 2)
		{
			tempShrubType = rNumGen(1, 4);
			PictureLabel Shrub2 = new AShrub((houseX+100), (houseY+450), tempShrubType);
			allShrubs.addElement(Shrub2);
		}
		if (numberOfShrubs >= 3)
		{
			tempShrubType = rNumGen(1, 4);
			PictureLabel Shrub3 = new AShrub((houseX+155), (houseY+540), tempShrubType);
			allShrubs.addElement(Shrub3);
		}
		if (numberOfShrubs >= 4)
		{
			tempShrubType = rNumGen(1, 4);
			PictureLabel Shrub4 = new AShrub((houseX+360), (houseY+540), tempShrubType);
			allShrubs.addElement(Shrub4);
		}
		if (numberOfShrubs >= 5)
		{
			tempShrubType = rNumGen(1, 4);
			PictureLabel Shrub5 = new AShrub((houseX+490), (houseY+540), tempShrubType);
			allShrubs.addElement(Shrub5);
		}
		if (numberOfShrubs >= 6)
		{
			tempShrubType = rNumGen(1, 4);
			PictureLabel Shrub6 = new AShrub((houseX+490), (houseY+450), tempShrubType);
			allShrubs.addElement(Shrub6);
		}
		return allShrubs;
	}

	@Override
	public PictureLabelCollection buildTrees()
	{
		if (numberOfTrees < 1)
		{
			PictureLabelCollection allTrees = new ATreeCollection();
			return allTrees;
		}

		PictureLabelCollection allTrees = new ATreeCollection();
		int tempTreeType = rNumGen(1, 5);
		PictureLabel Tree1 = new ATree((houseX+460), (houseY+300), tempTreeType);
		allTrees.addElement(Tree1);
			
		if (numberOfTrees >= 2)
		{
			tempTreeType = rNumGen(1, 5);
			PictureLabel Tree2 = new ATree((houseX+115), (houseY+435), tempTreeType);
			allTrees.addElement(Tree2);
		}
		if (numberOfTrees >= 3)
		{
			tempTreeType = rNumGen(1, 5);
			PictureLabel Tree3 = new ATree((houseX+360), (houseY+435), tempTreeType);
			allTrees.addElement(Tree3);
		}
		if (numberOfTrees >= 4)
		{
			tempTreeType = rNumGen(1, 5);
			PictureLabel Tree4 = new ATree((houseX+100), (houseY+50), tempTreeType);
			allTrees.addElement(Tree4);
		}
		return allTrees;
	}
	
//	Test to see if avatar is touching the path
	@Override
	public boolean checkPath(CompleteAvatar avatarToCheck)
	{
		int avatarFootX = avatarToCheck.getCompleteAvatarFootX();
		int avatarFootY = avatarToCheck.getCompleteAvatarFootY();
//		System.out.println("foot (X,Y): (" + avatarFootX + "," + avatarFootY + ")");
//		System.out.println("path (X,Y): (" + (houseX+255) + "," + (houseY+415) + ") to (" + (houseX+235) + "," + (houseY+492) + ")");
		if (avatarFootX > (houseX+255) && avatarFootX < (houseX+335))
		{
			if (avatarFootY > (houseY+415) && avatarFootY < (houseY+575))
			{
				return true;
			}
		}		
//		return false if previous conditions are not met
		return false;
	}
	
	@Position (8)
	@Override
	public PictureLabel getGrass()
	{
		return theGrass;
	}

	@Position (7)
	@Override
	public HouseWithMailbox getHouse()
	{
		return baseHouse;
	}

	@Position (4)
	@Override
	public PictureLabelCollection getBush()
	{
		return bushCollection;
	}

	@Position (1)
	@Override
	public PictureLabel getPath()
	{
		return housePath;
	}

	@Position (3)
	@Override
	public PictureLabelCollection getShrub()
	{
		return shrubCollection;
	}

	@Position (2)
	@Override
	public PictureLabelCollection getTree()
	{
		return treeCollection;
	}
	
	@Visible(false)
	@Override
	public int getHouseX()
	{
		return houseX;
	}
	
	@Visible(false)
	@Override
	public int getHouseY()
	{
		return houseY;
	}

	@Visible(false)
	@Override
	public void setXY(int xPosition, int yPosition)
	{
		int oldHouseX = houseX;
		int oldHouseY = houseY;
		houseX = xPosition;
		houseY = yPosition;
		theGrass.setXY(houseX, houseY);
		baseHouse.setXY(houseX+100, houseY+50);
		housePath.setXY(houseX+255, houseY+415);
		for (int i=0; i<bushCollection.size(); i++)
		{
			bushCollection.elementAt(i).setXY(bushCollection.elementAt(i).getXLocation() - (oldHouseX - houseX), bushCollection.elementAt(i).getYLocation() - (oldHouseY - houseY));
		}
		for (int i=0; i<shrubCollection.size(); i++)
		{
			shrubCollection.elementAt(i).setXY(shrubCollection.elementAt(i).getXLocation() - (oldHouseX - houseX), shrubCollection.elementAt(i).getYLocation() - (oldHouseY - houseY));
		}
		for (int i=0; i<treeCollection.size(); i++)
		{
			treeCollection.elementAt(i).setXY(treeCollection.elementAt(i).getXLocation() - (oldHouseX - houseX), treeCollection.elementAt(i).getYLocation() - (oldHouseY - houseY));
		}
	}

	@Override
	public void newCheckPath(int xLocation, int yLocation, int houseNum)
	{
//		System.out.println("AVATAR MOVE DETECTED! => (" + xLocation + "," + yLocation + ")  Listener reporting is House" + houseNum);
		if (xLocation > (houseX+255) && xLocation < (houseX+335))
		{
			if (yLocation > (houseY+415) && yLocation < (houseY+575))
			{
//					System.out.println("Avatar is on the path!");
					notifySimulationListener(houseNum);
			}
		}		
	}

	private void notifySimulationListener(int numOfHouseToReport)
	{
	    for(int i = 0; i < simulationListener.size(); i++)
	    {
	    	// this will notify the simulation of the house number based on listener position.
	        simulationListener.get(i).connectMyAvatar(numOfHouseToReport);
//	        simulationListener.get(i).preTakeCandy();
	    }
	}

	@Override
	public void addSimulationListener(HalloweenSimulation sim)
	{
		simulationListener.add(sim);
	}

	@Override
	public void removeSimulationListener(HalloweenSimulation sim)
	{
		simulationListener.removeAllElements();
//		System.out.println("Simulation is no longer listening to house" + (sim.getCompleteHouses().size() + 1));
	}
	
	int rNumGen(int low, int high)
	{
		int mult = 10;
		int randNum = low - 1;
		while (randNum < low || randNum > high)
		{
			randNum = (int) (Math.random()*mult);
		}
		return randNum;
	}
}
