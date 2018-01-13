package stringProcessors;

import java.util.List;
import java.util.Vector;
import util.annotations.Visible;

public class AHistoryUndoer implements Undoer
{
	List<Command> historyList = new Vector<Command>();
	int nextCommandIndex = 0;
	boolean canUndo = false;
	boolean canRedo = false;

	@Override
	public void execute (Command c)
	{
		if (nextCommandIndex != historyList.size())
		{
			historyList.clear(); //ignore remaining undone commands
			nextCommandIndex = 0;
			canUndo = false;
		}
		c.execute();
		historyList.add(c);
		nextCommandIndex++;
		canUndo = true;
	}

	@Override
	public void undo()
	{
		if (nextCommandIndex == 0)
		{
			canUndo = false;
			return;
		}
		nextCommandIndex--;
		Command c = historyList.get(nextCommandIndex);
		c.undo();
		canRedo = true;
		if (nextCommandIndex > 0)
		{
			canUndo = true;
		}
		else
		{
			canUndo = false;
		}
	}

	@Override
	public void redo()
	{
		if (nextCommandIndex == historyList.size())
		{
			canRedo = false;
			return;
		}
		Command c = historyList.get(nextCommandIndex);
		c.execute();
		nextCommandIndex++;
		canUndo = true;
		if (nextCommandIndex < historyList.size())
		{
			canRedo = true;
		}
		else
		{
			canRedo = false;
		}
	}
	
	@Visible(false)
	@Override
	public boolean getCanUndo()
	{
		return canUndo;
	}

	@Visible(false)
	@Override
	public boolean getCanRedo()
	{
		return canRedo;
	}
}