package stringProcessors;

import graphics.HalloweenSimulation;

public class addHouseCommand implements Command
{
	HalloweenSimulation simToControl;
	boolean addingPreset = false;
	int presetNumber;

	public addHouseCommand (HalloweenSimulation inputSim)
	{
		simToControl = inputSim;
	}
	
	public addHouseCommand (HalloweenSimulation inputSim, int pNum)
	{
		simToControl = inputSim;
		addingPreset = true;
		presetNumber = pNum;
	}
	
	public void execute()
	{
		if (simToControl.getAnimationOn() == true)
		{
			if (addingPreset == true)
			{
				simToControl.addhouseThread(presetNumber);
			}
			else
			{
				simToControl.addhouseThread();
			}
		}
		else
		{
			if (addingPreset == true)
			{
				simToControl.AddHouse(presetNumber);
			}
			else
			{
				simToControl.AddHouse();
			}
		}
	}

	public void undo()
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
}
