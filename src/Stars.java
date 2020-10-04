import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Stars extends Rectangle implements SpaceBodies
{
	/*private int size = (int)(Math.random()*2+1), posX = 500, posY = 500;
	private int speed = 600;
	
	public Stars()
	{
		this.setOpaque(false);
		if(size == 2)
			this.setPreferredSize(new Dimension(50,50));
		else
			this.setPreferredSize(new Dimension(25,25));
	}
	
	
	public Stars(int x, int y, int sp, int si)
	{
				
	}
	
	public void update()
	{
		//y_coord += speed;
		posY += speed;
	}
	
	@Override
    protected void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, size, size);
    }*/
	
	int posX, posY, spd, size;
	
	public Stars()
	{
		posX = (int)(Math.random()*1600);
		posY = 0;
		spd = (int)(Math.random()*40+10);
		size = (int)(Math.random()*50+25);
	}
	
	@SuppressWarnings("deprecation")
	public void update()
	{
		if(posY >= 2000)
		{
			posX = (int)(Math.random()*1600);
			posY = 0;
			spd = (int)(Math.random()*40+10);
			size = (int)(Math.random()*50+25);
			//resize(size,size);*/
		}
		else
			posY += spd;
	}
	
	public void draw(Graphics g)
	{
        g.setColor(Color.CYAN);
        g.fillRect(posX, posY, size, size);
	}
}
