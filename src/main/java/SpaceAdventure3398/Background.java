/*
 * Author: Tanner Coker
 *
 * Background is a background that will display a black square on which everything else will
 * lay on top of. It currently has a UpdateThread that will update the location of all of the
 * stars and planets on it.
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.*;

public class Background extends JPanel
{
	private int width = JFrame.MAXIMIZED_HORIZ;
	private int height = JFrame.MAXIMIZED_VERT;
	private int frameWidth;
	private ArrayList<SpaceBodies> bodies = new ArrayList<SpaceBodies>();


	//adds stars and planets to an arraylist of type SpaceBodies
	//also makes a UpdateThread that will call Update()
	public Background()
	{

		//changes the amount of stars
		for(int i=0;i<500;i++)
		{
			Stars s = new Stars();
			bodies.add(s);
		}

		//changes the amount of planets
		for(int i=0;i<7;i++)
		{
			Planets p = new Planets();
			bodies.add(p);
		}

		//thread to run update
		
	}

	//passes the width of the frame to the stars and planets
	public void giveFrameWidth(int w)
	{
		for(SpaceBodies sb : bodies)
		{
			sb.setFrameWidth(w);
		}
	}

	//updates the stars and planets and causes them to update their position
	public void update()
	{
		for(SpaceBodies sb : bodies)
		{
			sb.update();
		}
		repaint();
	}

	//paints the black background and all of the stars and planets
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		for(SpaceBodies sb : bodies)
		{
			sb.draw(g);
		}
	}
}
