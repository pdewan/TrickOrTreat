package stringProcessors;

import graphics.HalloweenSimulation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;
import veto.PropertyChangeVetoer;

public interface HalloweenCommandProcessor extends PropertyListenerRegisterer
{
	public String getInputString();
	public String getErrorMessages();
	public String getSimFeedback();
//	public boolean getIsAvatarConnected();
//	public String getHouseAvatarIsConnectedTo();
	public void setInputString(String newInputString);
	public boolean getAnimationActivated();
	public void setAnimationActivated(boolean toggle);
	public boolean preGetNumberOfSteps();
	public int getNumberOfSteps();
	public void setNumberOfSteps(int nSteps);
	public boolean preGetPauseTime();
	public int getPauseTime();
	public void setPauseTime(int pTime);
	public boolean getStatisticsActivated();
	public void setStatisticsActivated(boolean toggle);
	public boolean preGetStoredMacro();
	public String getStoredMacro();
	public boolean preGetWordCount();
	public int getWordCount();
	public boolean preGetCommandCount();
	public int getCommandCount();
	public boolean preGetHousesAdded();
	public int getHousesAdded();
	public boolean preGetHousesRemoved();
	public int getHousesRemoved();
	public boolean preGetDistanceMoved();
	public int getDistanceMoved();
	public boolean preGetCupcakesEaten();
	public int getCupcakesEaten();
	public boolean preGetWorldSize();
	public int getWorldSize();
	public boolean preGetHousePreset1();
	public boolean getHousePreset1();
	public boolean preGetHousePreset2();
	public boolean getHousePreset2();
	public boolean preGetHousePreset3();
	public boolean getHousePreset3();
	public boolean preGetHousePreset4();
	public boolean getHousePreset4();
	
	public boolean preUndoCommand();
	public void undoCommand();
	public boolean preRedoCommand();
	public void redoCommand();
	
	public void simulationListener(String simInput);
	public void addPropertyChangeListener(PropertyChangeListener newListener);
	void processCommand(String newInputString);
	public void init (HalloweenSimulation inputSim);

	void addPropertyChangeVetoer(PropertyChangeVetoer newVetoer);
	public void setAnimateCars(boolean newVal);
	
	public boolean getAnimateCars() ;
	public void notifyAllListeners(PropertyChangeEvent event);
	public void initSerializedObject ();
	boolean isConnectedToSimulation();
	void setConnectedToSimulation(boolean connectedToSimulation);

}
