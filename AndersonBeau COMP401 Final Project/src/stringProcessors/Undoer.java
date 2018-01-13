package stringProcessors;

public interface Undoer
{   
    public void undo();
    public void execute(Command command);
    public void redo();
	public boolean getCanUndo();
	public boolean getCanRedo();
}
