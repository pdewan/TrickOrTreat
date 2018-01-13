package stringProcessors;

import graphics.HalloweenSimulation;

public class removeHouseCommand implements Command
{
	HalloweenSimulation simToControl;

	public removeHouseCommand (HalloweenSimulation inputSim)
	{
		simToControl = inputSim;
	}
	
	public void execute()
	{
		if (simToControl.getAnimationOn() == true)
		{
			simToControl.removehouseThread();
		}
		else
		{
			simToControl.RemoveHouse();
		}
	}

	public void undo()
	{
		if (simToControl.getAnimationOn() == true)
		{
			simToControl.addhouseThread();
		}
		else
		{
			simToControl.AddHouse();
		}
	}
}
