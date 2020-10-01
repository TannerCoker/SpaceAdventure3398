import javax.swing.*;

public abstract class SpaceBodies 
{

	int x_coord;
	int y_coord; 
	int speed;
	int size;
	//needs image variable?
	 
	public SpaceBodies()
	{
         
	}
	
	protected abstract void move();
}
