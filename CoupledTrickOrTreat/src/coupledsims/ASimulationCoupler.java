package coupledsims;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import stringProcessors.HalloweenCommandProcessor;
import util.trace.trickOrTreat.LocalCommandObserved;
import veto.PropertyChangeVetoer;

public class ASimulationCoupler implements PropertyChangeListener {
	HalloweenCommandProcessor observingSimulation;
	
//	public ASimulationCoupler (HalloweenCommandProcessor anObservedSimulaton, HalloweenCommandProcessor anObservingSimulation) {
//		anObservedSimulaton.addPropertyChangeListener(this);
//		observingSimulation = anObservingSimulation;
//	}
	public ASimulationCoupler (HalloweenCommandProcessor anObservingSimulation) {
		observingSimulation = anObservingSimulation;
	}
	

	@Override
	public void propertyChange(PropertyChangeEvent anEvent) {
		if (!anEvent.getPropertyName().equals("InputString")) return;
		String newCommand = (String) anEvent.getNewValue();
		LocalCommandObserved.newCase(this, newCommand);
//		System.out.println("Received command:" + newCommand);
		observingSimulation.processCommand(newCommand);
	}

	

}
