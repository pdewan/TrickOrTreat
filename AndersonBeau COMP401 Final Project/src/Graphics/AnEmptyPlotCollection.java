package Graphics;

public class AnEmptyPlotCollection extends ALabelCollection<EmptyPlot> implements EmptyPlotCollection
{
	public AnEmptyPlotCollection()
	{
		super("Empty Lot For Sale", 14);
	}

	@Override
	Object[] buildCollectionArray()
	{
		final int MAX_SIZE = 14;
		EmptyPlot[] EmptyPlots = new AnEmptyPlot[MAX_SIZE];
		return EmptyPlots;
	}
}