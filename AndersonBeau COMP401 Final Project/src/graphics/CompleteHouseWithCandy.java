package graphics;

public interface CompleteHouseWithCandy extends CompleteHouse
{
	public CupcakeContainer getCupcakeContainer();
	public int getNumberOfCupcakes();
	public void setNumberOfCupcakes(int nCakes);
	public void addCupcake();
	public void removeCupcake();
}
