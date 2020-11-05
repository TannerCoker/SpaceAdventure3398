/*
 * Author: Tanner Coker
 *
 * This class is will start the running of the game and is what kicks everything off.
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class GameRunner
{
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
