package stringProcessors;

public class InvalidPlus extends Error
{
	public InvalidPlus(String input)
	{
		super(input, "Error: Cannot Add");
	}
}
