package graphics;

import java.beans.PropertyChangeListener;

public interface Shape
{
	public Point getLocation();
	public int getWidth();
	public int getHeight();
	public void setLocation(Point newVal);
	public void setXY(int newLocationX, int newLocationY);
	public void addPropertyChangeListener(PropertyChangeListener newListener);
	// Temp for trying to make houseListener - remove if no worky
	public void addHouseListener(CompleteHouse house);
	public void removeHouseListener(CompleteHouse house);
}
