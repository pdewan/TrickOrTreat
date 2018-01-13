package stringProcessors;

import graphics.HalloweenSimulation;

public class GiveCommand implements Command
{
	HalloweenSimulation simToControl;
	int numToGive;
	
	public GiveCommand (HalloweenSimulation inputSim, int gNum)
	{
		simToControl = inputSim;
		numToGive = gNum;
	}
	
	public void execute()
	{
		if (simToControl.getAnimationOn() == true)
		{
			simToControl.giveCupcakeThread(numToGive);
		}
		else
		{
			simToControl.giveCandy(numToGive);
		}
	}

	public void undo()
	{
		if (simToControl.getAnimationOn() == true)
		{
			simToControl.takeCupcakeThread(numToGive);
		}
		else
		{
			simToControl.takeCandy(numToGive);
		}
	}
}
