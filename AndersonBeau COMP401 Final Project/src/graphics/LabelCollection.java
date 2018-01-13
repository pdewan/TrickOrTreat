package graphics;

import util.models.VectorListener;

public interface LabelCollection<GenericType>
{
	public void addElement(GenericType element);
	public void removeElement(GenericType element);
	public int size();
	public GenericType elementAt(int index);
	public void addVectorListener(VectorListener vectorListener);
}
