package stringProcessors;

public abstract class Error extends Token
{
	public Error(String input, String subType)
	{
		super(input, subType);
	}

	public Error(String input)
	{
		super(input, "Error");
	}
}