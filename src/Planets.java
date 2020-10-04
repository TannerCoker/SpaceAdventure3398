import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Planets extends Rectangle implements SpaceBodies
{
	private int posX, posY, size, spd, BgWidth;

	public Planets()
	{
		posX = (int)(Math.random()*1936);
		posY = (int)(Math.random()*2500);
		size = (int)(Math.random()*10+20);
		if(size < 23)
			spd = (int)(Math.random()*1+5);
		else if(size < 27)
			spd = (int)(Math.random()*2+7);
		else
			spd = (int)(Math.random()*1+10);
	}
	
	public void update()
	{
		if(posY >= 2500)
		{
			posX = (int)(Math.random()*1936);
			posY = -10000;
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
	
	public void draw(Graphics g)
	{
		g.setColor(new Color(0,153,0));
		g.fillRect(posX, posY, size, size);
	}
}
