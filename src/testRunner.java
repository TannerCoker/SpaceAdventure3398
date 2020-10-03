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
		
		Stars s = new Stars();
		Planets p = new Planets();
		p.setOpaque(false);
		p.setPreferredSize(new Dimension(400,400));
		
		Background b = new Background();
		b.addStars(s);
		b.addPlanets(p);
		
		
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
