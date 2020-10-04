import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Stars extends Rectangle implements SpaceBodies
{
	
	//x,y location. speed. size. background width(in progress)
	private int posX, posY, spd, size, BgWidth;
	
	public Stars(int b)
	{
		//BgWidth = b;
		posX = (int)(Math.random()*1936);
		posY = (int)(Math.random()*1500);
		size = (int)(Math.random()*5+1);
		if(size < 3)
			spd = (int)(Math.random()*1+1);
		else if(size < 5)
			spd = (int)(Math.random()*1+3);
		else
			spd = (int)(Math.random()*1+5);
		
	}
	
	//checks to see if the star has gone off screen. If so then it recycles it
	//and moves it back to the top to keep a continuous stream of stars.
	@SuppressWarnings("deprecation")
	public void update()
	{
		if(posY >= 1500)
		{
			posX = (int)(Math.random()*1936);//BgWidth);
			posY = 0;
			size = (int)(Math.random()*5+1);
			if(size < 5)
				spd = (int)(Math.random()*1+1);
			else if(size < 10)
				spd = (int)(Math.random()*1+3);
			else
				spd = (int)(Math.random()*1+5);
		}
		else
			posY += spd;
	}
	
	//draws the star based on it's location and size
	public void draw(Graphics g)
	{
        g.setColor(Color.white);
        g.fillRect(posX, posY, size, size);
	}
}
