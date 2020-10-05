/*
 * Author: Tanner Coker
 * 
 * Planets class is a class that will display larger green circles (planets) on the background class.
 * They will move downward across the screen constantly so that it simulates movement in space.
 * Once the planet reach an upper limit it will go back between a random location on y=-10000 to y=-5000
 * and be given a new size and a speed based on the size. The reason for respawning them in that range is so 
 * that they don't stay in the same location next to each other.The bigger planets move faster than the 
 * smaller ones in order to create a sense of depth and movement.
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Planets extends Rectangle implements SpaceBodies
{
	private int posX, posY, size, spd, BgWidth;

	//constructs the planet with speed based off of size
	public Planets()
	{
		BgWidth = 1936;
		posX = (int)(Math.random()*BgWidth);
		posY = (int)(Math.random()*2500);
		size = (int)(Math.random()*10+20);
		if(size < 23)
			spd = (int)(Math.random()*1+5);
		else if(size < 27)
			spd = (int)(Math.random()*2+7);
		else
			spd = (int)(Math.random()*1+10);
		
	}
	
	//updates the position of the planet to make it move down. Once it reaches the lowest it can go
	//it will be move between y= -10000->-5000 on the panel and be given a different size and a speed
	//based off of that
	public void update()
	{
		if(posY >= 2500)
		{
			posX = (int)(Math.random()*BgWidth);
			posY = (int)(Math.random()*5000+5000)*(-1);
			size = (int)(Math.random()*10+20);
			if(size < 23)
				spd = (int)(Math.random()*1+5);
			else if(size < 27)
				spd = (int)(Math.random()*2+7);
			else
				spd = (int)(Math.random()*1+10);
		}
		else
			posY += spd;
	}
	
	//sets the width of the background/frame that it is on to set an upper bound on which the planets spawn
	public void setFrameWidth(int w)
	{
		BgWidth = w;
	}
	
	//draws 3 rectangles to make the planet look like a circle
	public void draw(Graphics g)
	{
		g.setColor(new Color(0,153,0));
		g.fillRect(posX, posY, size, size);
		g.fillRect(posX+5, posY-5, size-10, size+10);
		g.fillRect(posX-5, posY+5, size+10, size-10);
	}
}
