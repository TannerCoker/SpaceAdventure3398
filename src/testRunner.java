import java.util.*;
import javax.swing.*;
import java.awt.*;

public class testRunner 
{

	public testRunner()
	{
		TestComponents();
	}
	
	private void TestComponents()
	{
		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setExtendedState();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Background b = new Background();
		b.addStars(new Stars());
		b.addStars(new Stars());
		b.addPlanets(new Planets());
		b.addPlanets(new Planets());
		
		
		frame.add(b);
		
		
		
		//frame.pack();
		frame.setVisible(true);
	}
	public static void main(String args[])
	{
		//Background b = new Background();
		//b.paintComponent(Graphics g);
		
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new testRunner();
			}
		});
	}

}
