package graphics;

public interface Wheelbarrow
{
	public Shape getWheelbarrowAxle();
	public Shape getWheelbarrowBottom();
	public Shape getWheelbarrowBack();
	public PictureLabel getWheelbarrowWheel();
	public Shape getWheelbarrowHub();
	public Shape getWheelbarrowHandlebar();
	public Shape getWheelbarrowHandle();
	public int getWheelbarrowX();
	public int getWheelbarrowY();
	public void setWheelbarrowXY(int xLocation, int yLocation);
}
