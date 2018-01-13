package veto;

import java.beans.PropertyChangeEvent;

public interface PropertyChangeVetoer {
	public boolean vetoeablePropertyChange(PropertyChangeEvent anEvent);
}
