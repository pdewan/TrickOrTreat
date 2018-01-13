package graphics;

import util.annotations.Position;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class ACompleteHouseWithCandy extends ACompleteHouse implements CompleteHouseWithCandy
{
	int numberOfCupcakes;
	CupcakeContainer houseContainer;
	
	public ACompleteHouseWithCandy (int initX, int initY, int hType, int boxDist, int bHeight, int bWidth, int pLength, int nBush, int nShrub, int nTree, int pathType, int gType, int nCakes)
	{
		super (initX, initY, hType, boxDist, bHeight, bWidth, pLength, nBush, nShrub, nTree, pathType, gType);
		numberOfCupcakes = nCakes;
		houseContainer = new ACupcakeContainer((houseX+247),(houseY+310), numberOfCupcakes);
	}
	
	@Position (0)
	@Override
	public CupcakeContainer getCupcakeContainer()
	{
		return houseContainer;
	}
	
	@Override
	public int getNumberOfCupcakes()
	{
		return numberOfCupcakes;
	}
	
	@Override
	public void setNumberOfCupcakes(int nCakes)
	{
		numberOfCupcakes = nCakes;
		houseContainer.setNumCupcakes(numberOfCupcakes);
	}

	@Override
	public void addCupcake()
	{
		houseContainer.addCupcake();
		numberOfCupcakes++;
	}

	@Override
	public void removeCupcake()
	{
		houseContainer.removeCupcake();
		numberOfCupcakes--;
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
		houseContainer.setBasketXY(houseX+247, houseY+310);
//		Recursively Update positions of bushes 
		for (int i=0; i<bushCollection.size(); i++)
		{
			bushCollection.elementAt(i).setXY(bushCollection.elementAt(i).getXLocation() - (oldHouseX - houseX), bushCollection.elementAt(i).getYLocation() - (oldHouseY - houseY));
		}
//		Recursively Update positions of shrubs
		for (int i=0; i<shrubCollection.size(); i++)
		{
			shrubCollection.elementAt(i).setXY(shrubCollection.elementAt(i).getXLocation() - (oldHouseX - houseX), shrubCollection.elementAt(i).getYLocation() - (oldHouseY - houseY));
		}
//		Recursively Update positions of trees
		for (int i=0; i<treeCollection.size(); i++)
		{
			treeCollection.elementAt(i).setXY(treeCollection.elementAt(i).getXLocation() - (oldHouseX - houseX), treeCollection.elementAt(i).getYLocation() - (oldHouseY - houseY));
		}
	}
}
