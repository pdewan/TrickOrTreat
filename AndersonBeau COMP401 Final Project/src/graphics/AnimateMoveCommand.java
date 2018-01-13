package graphics;

public class AnimateMoveCommand implements Runnable
{
	HalloweenSimulation animatedSim;
	int xLocation;
	int yLocation;
//	int steps;
//	int pauseTime;

//	public AnimateMoveCommand(HalloweenSimulation inputSim, int newXPos, int newYPos, int nSteps, int pTime)
	public AnimateMoveCommand(HalloweenSimulation inputSim, int newXPos, int newYPos)
	{
		animatedSim = inputSim;
		xLocation = newXPos;
		yLocation = newYPos;
//		steps=nSteps;
//		pauseTime=pTime;
	}
	
	public void run()
	{
		animatedSim.animateMovement(xLocation, yLocation);
	}
}
