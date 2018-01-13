package stringProcessors;

public class InvalidWord extends Error
{
	public InvalidWord(String input)
	{
		super(input, "Error: Invalid Input");
	}
}
