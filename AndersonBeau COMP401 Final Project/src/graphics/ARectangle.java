package graphics;

public class ARectangle extends AShape
{
	boolean filled;
	
	public ARectangle(int initX, int initY, int initWidth, int initHeight, boolean fill)
	{
		super(initX, initY, initWidth, initHeight);
		filled = fill;
	}

	public boolean isFilled()
	{
		return filled;
	}
}
