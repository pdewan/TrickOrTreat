package coupledsims;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import veto.PropertyChangeVetoer;

import StringProcessors.HalloweenCommandProcessor;

public class AVetoingSimulationCoupler extends ASimulationCoupler implements PropertyChangeVetoer {
	HalloweenCommandProcessor observedSimulation;
	PropertyChangeEvent lastPropertyChangeEvent; // should be a queue in general
	
	public AVetoingSimulationCoupler (HalloweenCommandProcessor anObservedSimulaton, HalloweenCommandProcessor anObservingSimulation) {
		super(anObservedSimulaton, anObservingSimulation);
		observedSimulation = anObservedSimulaton;
		anObservedSimulaton.addPropertyChangeVetoer(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent anEvent) {
		super.propertyChange(anEvent);
		if (!anEvent.getPropertyName().equals("InputString")) return;
		String newCommand = (String) anEvent.getNewValue();
		System.out.println("Doing delayed processing of observed command:" + newCommand);
		observedSimulation.processCommand(newCommand);
	}

	@Override
	public boolean vetoeablePropertyChange(PropertyChangeEvent event) {
		lastPropertyChangeEvent = event;
		return false;
	}

}
