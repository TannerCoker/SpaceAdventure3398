import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Stars extends Rectangle implements SpaceBodies
{
	
	//x,y location. speed. size. background width(in progress)
	private int posX, posY, spd, size, BgWidth;
	
	//attempts at getting the background to return a width have failed. It returns
	//0, 2, or 136
	public Stars()//int b)
	{
		//BgWidth = b;
		//System.out.println(BgWidth);
		posX = (int)(Math.random()*1936);//BgWidth);
		posY = 0;
		size = (int)(Math.random()*14+1);
		if(size < 5)
			spd = (int)(Math.random()*10+30);
		else if(size < 10)
			spd = (int)(Math.random()*10+20);
		else
			spd = (int)(Math.random()*10+10);
		
	}
	
	//checks to see if the star has gone off screen. If so then it recycles it
	//and moves it back to the top to keep a continuous stream of stars.
	@SuppressWarnings("deprecation")
	public void update()
	{
		if(posY >= 2000)
		{
			posX = (int)(Math.random()*1936);//BgWidth);
			posY = 0;
			size = (int)(Math.random()*15+5);
			if(size < 5)
				spd = (int)(Math.random()*10+10);
			else if(size < 10)
				spd = (int)(Math.random()*10+20);
			else
				spd = (int)(Math.random()*10+30);
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
