/*
 * Author: Tanner Coker
 *
 * This is a test runner class which is temporarily used to show the background feature.
 * Will likely be replaced in the future or modified
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class testRunner
{

	/*public testRunner()
	{
		TestComponents();
	}

	private void TestComponents()
	{
		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setExtendedState();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		//Background b = new Background();
		//frame.add(b);

		//MainMenu menu = new MainMenu();
		ScreenManager menu = new ScreenManager();
		frame.add(menu);

		frame.setVisible(true);
		//b.giveFrameWidth(frame.getWidth());
	}*/
	public static void main(String args[])
	{

		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new ScreenManager();
			}
		});
	}

}
