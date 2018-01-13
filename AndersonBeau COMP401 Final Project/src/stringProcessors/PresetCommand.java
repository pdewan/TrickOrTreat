package stringProcessors;

import graphics.HalloweenSimulation;

public class PresetCommand implements Command
{
	HalloweenSimulation simToControl;
	int houseToStore;
	int presetNumber;
	
	public PresetCommand (HalloweenSimulation inputSim, int hNum, int pNum)
	{
		simToControl = inputSim;
		houseToStore = hNum;
		presetNumber = pNum;
	}
	
	public void execute()
	{
		simToControl.savePreset(houseToStore, presetNumber);
	}

	public void undo()
	{
		simToControl.undoPreset();
	}
}
