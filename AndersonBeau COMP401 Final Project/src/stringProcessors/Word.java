package stringProcessors;

public class Word extends Token
{
	public Word(String input, String subType)
	{
		super(input, subType);
	}

	public Word(String input)
	{
		super(input, "Word");
	}
}