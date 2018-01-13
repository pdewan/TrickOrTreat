package stringProcessors;

import graphics.HalloweenSimulation;

public class TakeCommand implements Command
{
	HalloweenSimulation simToControl;
	int numToTake;
	
	public TakeCommand (HalloweenSimulation inputSim, int tNum)
	{
		simToControl = inputSim;
		numToTake = tNum;
	}
	
	public void execute()
	{
		if (simToControl.getAnimationOn() == true)
		{
			simToControl.takeCupcakeThread(numToTake);
		}
		else
		{
			simToControl.takeCandy(numToTake);
		}
	}

	public void undo()
	{
		if (simToControl.getAnimationOn() == true)
		{
			simToControl.giveCupcakeThread(numToTake);
		}
		else
		{
			simToControl.giveCandy(numToTake);
		}
	}
}
