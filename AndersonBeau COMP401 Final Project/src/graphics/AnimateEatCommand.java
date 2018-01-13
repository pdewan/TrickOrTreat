package graphics;

public class AnimateEatCommand implements Runnable
{
	HalloweenSimulation animatedSim;

	public AnimateEatCommand(HalloweenSimulation inputSim)
	{
		animatedSim = inputSim;
	}
	
	public void run()
	{
		animatedSim.eatCandy();
	}
}
