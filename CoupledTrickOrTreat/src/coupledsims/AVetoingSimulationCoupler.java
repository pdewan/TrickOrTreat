package coupledsims;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import stringProcessors.HalloweenCommandProcessor;
import veto.PropertyChangeVetoer;

public class AVetoingSimulationCoupler extends ASimulationCoupler implements PropertyChangeVetoer {
	public static final String VETOED_COMMAND = "undo";
	public AVetoingSimulationCoupler (HalloweenCommandProcessor anObservedSimulaton, HalloweenCommandProcessor anObservingSimulation) {
		super(anObservedSimulaton, anObservingSimulation);
		anObservedSimulaton.addPropertyChangeVetoer(this);
	}

	@Override
	public boolean allowPropertyChange(PropertyChangeEvent anEvent) {
		if (!anEvent.getPropertyName().equals("InputString")) return true;
		return !VETOED_COMMAND.equals(anEvent.getNewValue());
	}

}
