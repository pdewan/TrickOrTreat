package graphics;

public class AnimateRemoveHouseCommand implements Runnable
{
	HalloweenSimulation animatedSim;

	public AnimateRemoveHouseCommand(HalloweenSimulation inputSim)
	{
		animatedSim = inputSim;
	}
	
	public void run()
	{
		animatedSim.RemoveHouse();
	}
}
