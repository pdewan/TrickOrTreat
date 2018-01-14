package util.trace.trickOrTreat;

import util.trace.TraceableInfo;

public class CommandInfo extends TraceableInfo{

	protected String command;
	public CommandInfo(String aMessage, String aCommand,
			Object aFinder) {
		super(aMessage, aFinder);
		command = aCommand;
	}
	public static CommandInfo newCase(Object aSource, String aCommand) {    	
		String aMessage = "Command:" + aCommand;
		CommandInfo retVal = new CommandInfo(aMessage, aCommand, aSource);
    	retVal.announce();
    	return retVal;
	}
}
