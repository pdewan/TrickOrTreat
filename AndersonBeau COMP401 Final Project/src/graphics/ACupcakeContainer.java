package graphics;

import util.annotations.Position;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;
import bus.uigen.ObjectEditor;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class ACupcakeContainer implements CupcakeContainer
{
	int basketX;
	int basketY;
	int numberOfCupcakes;
	PictureLabel cupcakeBasket;
	PictureLabelCollection cupcakeCollection;

	public ACupcakeContainer (int initX, int initY, int nCakes)
	{
		basketX = initX;
		basketY = initY;
		numberOfCupcakes = nCakes;
		if (numberOfCupcakes > 6)
		{
			numberOfCupcakes = 6;
		}
		cupcakeBasket = new ABasket(basketX, basketY, 0);
		cupcakeCollection = buildCupcakes();
	}

	@Position (1)
	@Override
	public PictureLabel getBasket()
	{
		return cupcakeBasket;
	}
	
	@Override
	public PictureLabelCollection buildCupcakes()
	{		
		if (numberOfCupcakes < 1)
		{
			PictureLabelCollection allCupcakes = new ACupcakeCollection();
			return allCupcakes;
		}

		PictureLabelCollection allCupcakes = new ACupcakeCollection();
		PictureLabel Cupcake1 = new ACupcake((basketX+22), (basketY+63), 0);
		allCupcakes.addElement(Cupcake1);

		if (numberOfCupcakes >= 2)
		{
			PictureLabel Cupcake2 = new ACupcake((basketX+48), (basketY+63), 0);
			allCupcakes.addElement(Cupcake2);
		}
		if (numberOfCupcakes >= 3)
		{
			PictureLabel Cupcake3 = new ACupcake((basketX+22), (basketY+38), 0);
			allCupcakes.addElement(Cupcake3);
		}
		if (numberOfCupcakes >= 4)
		{
			PictureLabel Cupcake4 = new ACupcake((basketX+48), (basketY+38), 0);
			allCupcakes.addElement(Cupcake4);
		}
		if (numberOfCupcakes >= 5)
		{
			PictureLabel Cupcake5 = new ACupcake((basketX+22), (basketY+13), 0);
			allCupcakes.addElement(Cupcake5);
		}
		if (numberOfCupcakes >= 6)
		{
			PictureLabel Cupcake6 = new ACupcake((basketX+48), (basketY+13), 0);
			allCupcakes.addElement(Cupcake6);
		}
		return allCupcakes;
	}
	
	@Position (0)
	@Override
	public PictureLabelCollection getCupcakes()
	{
		return cupcakeCollection;
	}
	
	@Visible(false)
	@Override
	public int getBasketX()
	{
		return basketX;
	}
	
	@Visible(false)
	@Override
	public int getBasketY()
	{
		return basketY;
	}

	@Visible(false)
	@Override
	public void setBasketXY(int newLocationX, int newLocationY)
	{
		int oldBasketX = basketX;
		int oldBasketY = basketY;
		basketX = newLocationX;
		basketY = newLocationY;
		cupcakeBasket.setXY(basketX, basketY);
//		Recursively Update positions of cupcakes
		for (int i=0; i<cupcakeCollection.size(); i++)
		{
			cupcakeCollection.elementAt(i).setXY(cupcakeCollection.elementAt(i).getXLocation() - (oldBasketX - basketX), cupcakeCollection.elementAt(i).getYLocation() - (oldBasketY - basketY));
		}
	}

	@Visible(false)
	@Override
	public int getNumCupcakes()
	{
		return numberOfCupcakes;
	}
	
	@Visible(false)
	@Override
	public void setNumCupcakes(int newVal)
	{
		numberOfCupcakes = newVal;
		if (numberOfCupcakes > 6)
		{
			numberOfCupcakes = 6;
		}
		else if (numberOfCupcakes < 0)
		{
			numberOfCupcakes = 0;
		}
		cupcakeCollection = buildCupcakes();
	}

	@Override
	public void removeCupcake()
	{
		numberOfCupcakes--;
		if (numberOfCupcakes >= 0)
		{
			PictureLabel tempCupcake = cupcakeCollection.elementAt(numberOfCupcakes);
			cupcakeCollection.removeElement(tempCupcake);
		}
		if (numberOfCupcakes < 0)
		{
			numberOfCupcakes = 0;
		}
	}

	@Override
	public void addCupcake()
	{
		if (numberOfCupcakes == 0)
		{
			PictureLabel Cupcake1 = new ACupcake((basketX+22), (basketY+63), 0);
			cupcakeCollection.addElement(Cupcake1);
		}
		else if (numberOfCupcakes == 1)
		{
			PictureLabel Cupcake2 = new ACupcake((basketX+48), (basketY+63), 0);
			cupcakeCollection.addElement(Cupcake2);
		}
		else if (numberOfCupcakes == 2)
		{
			PictureLabel Cupcake3 = new ACupcake((basketX+22), (basketY+38), 0);
			cupcakeCollection.addElement(Cupcake3);
		}
		else if (numberOfCupcakes == 3)
		{
			PictureLabel Cupcake4 = new ACupcake((basketX+48), (basketY+38), 0);
			cupcakeCollection.addElement(Cupcake4);
		}
		else if (numberOfCupcakes == 4)
		{
			PictureLabel Cupcake5 = new ACupcake((basketX+22), (basketY+13), 0);
			cupcakeCollection.addElement(Cupcake5);
		}
		else if (numberOfCupcakes == 5)
		{
			PictureLabel Cupcake6 = new ACupcake((basketX+48), (basketY+13), 0);
			cupcakeCollection.addElement(Cupcake6);
		}
		numberOfCupcakes++;
		if (numberOfCupcakes > 6)
		{
			numberOfCupcakes = 6;
		}
	}
	public static void main (String[] args) {
		CupcakeContainer container = new ACupcakeContainer(50, 50, 1);
		ObjectEditor.edit(container);
	}
}
