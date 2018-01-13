package stringProcessors;

import graphics.HalloweenSimulation;

public class EatCommand implements Command
{
	HalloweenSimulation simToControl;

	public EatCommand (HalloweenSimulation inputSim)
	{
		simToControl = inputSim;
	}
	
	public void execute()
	{
		if (simToControl.getAnimationOn() == true)
		{
			simToControl.eatCupcakeThread();
		}
		else
		{
			simToControl.eatCandy();
		}
	}

	public void undo()
	{
		simToControl.undoEat();
	}
}
