


public class AlienMovementFast implements AlienMovementType 
{
	public int move(int speedX, int direction) 
	{
		return ( speedX * direction * 2 );
	}
}

