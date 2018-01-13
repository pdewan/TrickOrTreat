package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class AnEmptyPlot implements EmptyPlot
{
	PictureLabel emptyPlotGrass;
	PictureLabel forSaleSign;
	
	public AnEmptyPlot(int initX, int initY, int gType, int signX, int signY, int signType)
	{
		emptyPlotGrass = new AGrass(initX, initY, gType);
		forSaleSign = new AForSaleSign(signX, signY, signType);
	}

	@Override
	public PictureLabel getGrass()
	{
		return emptyPlotGrass;
	}

	@Override
	public PictureLabel getForSaleSign()
	{
		return forSaleSign;
	}
	
	@Override
	public void setXY(int newLocationX, int newLocationY)
	{
		forSaleSign.setXY((forSaleSign.getXLocation() - emptyPlotGrass.getXLocation()) + newLocationX, (forSaleSign.getYLocation() - emptyPlotGrass.getYLocation()) + newLocationY);
		emptyPlotGrass.setXY(newLocationX, newLocationY);
	}
}
