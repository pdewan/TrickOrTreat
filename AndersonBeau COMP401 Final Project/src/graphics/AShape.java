package graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;

public abstract class AShape implements Shape
{
	int height;
	int width;
	Point location;	
	List<PropertyChangeListener> listeners = new Vector<PropertyChangeListener>();
	Vector<CompleteHouse> houseListener = new Vector<CompleteHouse>();
	
	public AShape(int Xloc, int Yloc, int sWidth, int sHeight)
	{
		height = sHeight;
		width = sWidth;
		location = new APoint(Xloc, Yloc);
	}
	
	public AShape()
	{
		// Intentionally Null for AGraphic to work
	}
	
	@Override
	public int getHeight()
	{
		return height;
	}

	@Override
	public Point getLocation()
	{
		return location;
	}

	@Override
	public int getWidth()
	{
		return width;
	}
	
	@Override
	public void setLocation(Point newLocation)
	{
		Point oldLocation = location;
		location = newLocation;
		notifyAllListeners(new PropertyChangeEvent(this, "Location", oldLocation, newLocation));
		notifyHouseListener(location.getX(), location.getY()+ height);
	}
	
	@Override
	public void setXY(int newLocationX, int newLocationY)
	{
		setLocation(new APoint(newLocationX, newLocationY));
	}

	private void notifyAllListeners(PropertyChangeEvent event)
	{
	    for(int i = 0; i < listeners.size(); i++)
	    {
	        listeners.get(i).propertyChange(event);
	    }
	}
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener newListener)
	{
		listeners.add(newListener);
	}

	private void notifyHouseListener(int newXLocation, int newYLocation)
	{
	    for(int i = 0; i < houseListener.size(); i++)
	    {
	    	// this will notify the house of the location of the avatar's foot.
	        houseListener.get(i).newCheckPath(newXLocation, newYLocation, i+1);
	    }
	}

	@Override
	public void addHouseListener(CompleteHouse house)
	{
		houseListener.add(house);
//		System.out.println(house + " is listening to AShape");
	}

	@Override
	public void removeHouseListener(CompleteHouse house)
	{
		houseListener.remove(house);
//		System.out.println(house + " is no longer listening to AShape");
	}
}