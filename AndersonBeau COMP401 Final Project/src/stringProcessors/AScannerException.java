package stringProcessors;

@SuppressWarnings("serial")
public class AScannerException extends java.io.IOException
{
	TokenInterface thrownToken;
	
	public AScannerException(String inputError)
	{
		super(inputError);
		thrownToken = new InvalidWord("NullBad!");
	}

	public AScannerException(String inputError, TokenInterface token)
	{
		super(inputError);
		thrownToken = token;
	}
	
	public TokenInterface getThrownToken()
	{
		return thrownToken;
	}
}
