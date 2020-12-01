


public class AlienMovementBasic implements AlienMovementType 
{
	public int move(int speedX, int direction) 
	{
		return ( speedX * direction );
	}
}
