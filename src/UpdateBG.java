/*
 * Author: Tanner Coker
 * 
 * Class that extends Thread. It is used by background class to call update()
 */

import javax.swing.*;

public class UpdateBG extends Thread
{
	Background b;
	
	UpdateBG(Background b)
	{
		this.b = b;
	}
	
	public void run()
	{
		while(true)
		{
			b.update();
			
			try 
			{
				Thread.sleep(20);
			}
			catch(Exception e)
			{
			}
		}
	}
}
