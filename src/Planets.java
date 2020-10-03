import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Planets extends JPanel implements SpaceBodies
{
	private int size = (int)(Math.random()*2+1), posX = 500, posY = 1000;
	private int speed = 5;

	public Planets()
	{
		this.setOpaque(false);
		if(size == 2)
			this.setPreferredSize(new Dimension(300,300));
		else
			this.setPreferredSize(new Dimension(150,150));
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
