package graphics;

public class AnimateCarCommand implements Runnable
{
	HalloweenSimulation animatedSim;
	int directionToGo;

	public AnimateCarCommand(HalloweenSimulation inputSim, int inputD)
	{
		animatedSim = inputSim;
		directionToGo = inputD;
	}
	
	public void run()
	{
		animatedSim.animateCar(directionToGo);
	}
}