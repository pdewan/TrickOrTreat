package graphics;

import util.annotations.ObserverRegisterer;
import util.annotations.ObserverTypes;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.VectorChangeEvent;
import util.models.VectorListener;

import java.util.Vector;
@StructurePattern(StructurePatternNames.VECTOR_PATTERN)
public abstract class ALabelCollection<GenericType> implements LabelCollection<GenericType>
{
	private int maxSize;
	int size = 0;
	String collectionName;
	Object[] collectionType;
	Vector<VectorListener> listeners = new Vector<VectorListener>();
	
	public ALabelCollection (String typeName, int sizeMax)
	{
		maxSize = sizeMax;
		collectionName = typeName;
		collectionType = buildCollectionArray();
	}
	    
	abstract Object[] buildCollectionArray();
	
	boolean isFull()
	{
		return size >= maxSize;
	}
	    
	@Override
	public void addElement(GenericType element)
	{
		if (isFull())
		{
			System.out.println("Too Many " + collectionName + "! Can only have up to " + maxSize + ".");
		}
		else
		{
			collectionType[size] = element;
		    size++;
		    notifyListeners(new VectorChangeEvent(this, VectorChangeEvent.AddComponentEvent, size-1, null, element, size));
		}
	}

	@Override
	public void removeElement(GenericType element)
	{
	    notifyListeners(new VectorChangeEvent(this, VectorChangeEvent.DeleteComponentEvent, size -1, null, element, size));
		size--;
		if (size < 0)
		{
			size = 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public GenericType elementAt(int index)
	{
		return (GenericType) collectionType[index];
	}

	@Override
	public int size()
	{
		return size;
	}
	
	@Override
	@ObserverRegisterer(ObserverTypes.VECTOR_LISTENER)
	public void addVectorListener(VectorListener vectorListener)
	{
		((Vector<VectorListener>) listeners).addElement(vectorListener);
	}
	
	void notifyListeners(VectorChangeEvent event)
	{
		for (int i = 0; i < listeners.size(); i++)
		{
			((Vector<VectorListener>) listeners).elementAt(i).updateVector(event);
		}
	}
}