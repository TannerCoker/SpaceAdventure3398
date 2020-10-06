/*
 * Author: Tanner Coker
 * 
 * Stars class is a class that will display small white squares (stars) on the background class.
 * They will move downward across the screen constantly so that it simulates movement in space.
 * Once the stars reach an upper limit it will go back to y=0 and be given a new size and speed based
 * on the size. The bigger stars move faster than the smaller ones in order to create a sense of depth
 * and movement.
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Stars extends Rectangle implements SpaceBodies
{
	
	//x,y location. speed. size. background width(in progress)
	private int posX, posY, spd, size, BgWidth;
	
	public Stars()
	{
		BgWidth = 1936;
		posX = (int)(Math.random()*1936);
		posY = (int)(Math.random()*1500);
		size = (int)(Math.random()*3+1);
		if(size < 3)
			spd = (int)(Math.random()*1+1);
		else
			spd = (int)(Math.random()*1+3);

		
	}
	
	//checks to see if the star has gone off screen. If so then it recycles it
	//and moves it back to the top to keep a continuous stream of stars.
	@SuppressWarnings("deprecation")
	public void update()
	{
		if(posY >= 1500)
		{
			posX = (int)(Math.random()*1936);
			posY = 0;
			size = (int)(Math.random()*3+1);
			if(size < 3)
				spd = (int)(Math.random()*1+1);
			else
				spd = (int)(Math.random()*1+3);

		}
		else
			posY += spd;
	}
	
	//sets the width of the background/frame that it is on to set an upper bound on which the stars spawn
	public void setFrameWidth(int w)
	{
		BgWidth = w;
	}
	
	//draws the star based on it's location and size
	public void draw(Graphics g)
	{
        g.setColor(Color.white);
        g.fillRect(posX, posY, size, size);
	}
}
