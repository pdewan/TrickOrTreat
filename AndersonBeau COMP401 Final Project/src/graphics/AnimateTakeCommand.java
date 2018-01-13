package graphics;

public class AnimateTakeCommand implements Runnable
{
	HalloweenSimulation animatedSim;
	int numToTake;

	public AnimateTakeCommand(HalloweenSimulation inputSim, int inputNum)
	{
		animatedSim = inputSim;
		numToTake = inputNum;
	}
	
	public void run()
	{
		animatedSim.takeCandy(numToTake);
	}
}