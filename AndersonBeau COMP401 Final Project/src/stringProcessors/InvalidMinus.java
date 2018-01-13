package stringProcessors;

public class InvalidMinus extends Error
{
	public InvalidMinus(String input)
	{
		super(input, "Error: Cannot Subtract");
	}
}
