import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Planets extends JPanel 
{
	private int size = 200, posX = 500, posY = 1000;
	private int speed = 5;

	public Planets()
	{
		
	}
	
	public Planets(int s)
	{
		
	}
	
	public void move()
	{
		posY += speed;
	}
	
	@Override
    protected void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(0, 0, getWidth(), getHeight());
	}
}
