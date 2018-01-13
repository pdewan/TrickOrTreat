package Graphics;

public class AOval extends AShape
{
	boolean filled;
	
	public AOval(int initX, int initY, int initWidth, int initHeight, boolean fill)
	{
		super(initX, initY, initWidth, initHeight);
		filled = fill;
	}

	public boolean isFilled()
	{
		return filled;
	}
}
