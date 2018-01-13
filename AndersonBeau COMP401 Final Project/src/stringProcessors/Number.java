package stringProcessors;

public class Number extends Token implements NumberInterface
{
	public Number(String input, String tName)
	{
		super (input, tName);
	}

	public Number(String input)
	{
		super (input, "Number");
	}

//	@Override
	public int convertToInt()
	{
		if (this.inputString.charAt(0)=='+')
		{
			return Integer.parseInt(this.inputString.substring(1));
		}
		return Integer.parseInt(this.inputString);
	}
}
