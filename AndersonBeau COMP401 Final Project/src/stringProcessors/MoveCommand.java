package stringProcessors;

import graphics.HalloweenSimulation;

public class MoveCommand implements Command
{
	HalloweenSimulation simToControl;
	int xAmount;
	int yAmount;
	int undoXAmount;
	int undoYAmount;
	
	public MoveCommand (HalloweenSimulation inputSim, int xAmt, int yAmt)
	{
		simToControl = inputSim;
		xAmount = xAmt;
		yAmount = yAmt;
		undoXAmount = xAmount * (-1);
		undoYAmount = yAmount * (-1);
	}
	
	public void execute()
	{
		if (simToControl.getAnimationOn() == true)
		{
			simToControl.startMoveThread(xAmount, yAmount);
		}
		else
		{
			simToControl.MoveAvatar(xAmount, yAmount);
		}
	}

	public void undo()
	{
		if (simToControl.getAnimationOn() == true)
		{
			simToControl.startMoveThread(undoXAmount, undoYAmount);
		}
		else
		{
			simToControl.MoveAvatar(undoXAmount, undoYAmount);
		}
	}
}
