package StringProcessors;

public class InvalidWord extends Error
{
	public InvalidWord(String input)
	{
		super(input, "Error: Invalid Input");
	}
}
