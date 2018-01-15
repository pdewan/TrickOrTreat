package veto;

import java.beans.PropertyChangeEvent;

public interface PropertyChangeVetoer {
	public boolean allowPropertyChange(PropertyChangeEvent anEvent);
}
