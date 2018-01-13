package graphics;

public class AnimateGiveCommand implements Runnable
{
	HalloweenSimulation animatedSim;
	int numToGive;

	public AnimateGiveCommand(HalloweenSimulation inputSim, int inputNum)
	{
		animatedSim = inputSim;
		numToGive = inputNum;
	}
	
	public void run()
	{
		animatedSim.giveCandy(numToGive);
	}
}