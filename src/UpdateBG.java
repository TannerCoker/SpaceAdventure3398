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
				Thread.sleep(25);
			}
			catch(Exception e)
			{
			}
		}
	}
}
