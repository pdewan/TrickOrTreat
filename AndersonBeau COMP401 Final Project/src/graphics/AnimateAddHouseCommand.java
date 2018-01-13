package graphics;

public class AnimateAddHouseCommand implements Runnable
{
	HalloweenSimulation animatedSim;
	boolean addingPreset;
	int presetNumber;

	public AnimateAddHouseCommand(HalloweenSimulation inputSim)
	{
		animatedSim = inputSim;
	}
	
	public AnimateAddHouseCommand(HalloweenSimulation inputSim, int pNum)
	{
		animatedSim = inputSim;
		addingPreset = true;
		presetNumber = pNum;
	}

	public void run()
	{
		if (addingPreset == true)
		{
			animatedSim.AddHouse(presetNumber);
		}
		else
		{
			animatedSim.AddHouse();
		}
	}
}
