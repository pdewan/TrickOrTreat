package graphics;

public interface CupcakeContainer
{
	public PictureLabel getBasket();
	public PictureLabelCollection getCupcakes();
	public PictureLabelCollection buildCupcakes();
	public int  getBasketX();
	public int  getBasketY();
	public void setBasketXY(int newLocationX, int newLocationY);
	public int getNumCupcakes();
	public void setNumCupcakes(int newVal);
	public void removeCupcake();
	public void addCupcake();
}
