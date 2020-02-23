package util.trace.trickOrTreat;

import util.trace.TraceableInfo;

public class ConnectedToSimulation extends TraceableInfo {	
	protected boolean connected;
	public ConnectedToSimulation(String aMessage, Object aFinder,
			boolean newValue) {
		super(aMessage, aFinder);
		connected = newValue;
	}
	public static ConnectedToSimulation newCase(Object aSource, boolean newValue) {    	
		String aMessage = "Connected To Simulation:" + newValue;
		ConnectedToSimulation retVal = new ConnectedToSimulation(aMessage, aSource, newValue);
    	retVal.announce();
    	return retVal;
	}
}
