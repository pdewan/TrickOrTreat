package util.trace.trickOrTreat;

import util.trace.TraceableInfo;

public class CommandSubmitted extends CommandInfo{

	protected String command;
	public CommandSubmitted(String aMessage, Object aFinder,
			String aCommand) {
		super(aMessage, aCommand, aFinder);
	}
	public static CommandSubmitted newCase(Object aSource, String aCommand) {    	
		String aMessage = "Command:" + aCommand;
		CommandSubmitted retVal = new CommandSubmitted(aMessage, aSource, aCommand);
    	retVal.announce();
    	return retVal;
	}
}
