package stringProcessors;

public abstract class Token implements TokenInterface
{
	String inputString;
	String tokenType;
	
	public Token(String input, String tType)
	{
		inputString = input;
		tokenType = tType;
	}

	@Override
	public String getTokenType()
	{
		return tokenType;
	}

	@Override
	public String getUserInputString()
	{
		return inputString.toLowerCase();
	}
	
	@Override
	public String toString()
	{
		return inputString;
	}
}