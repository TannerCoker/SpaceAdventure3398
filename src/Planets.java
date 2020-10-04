import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Planets extends JPanel implements SpaceBodies
{
	private int posX, posY, size, spd, BgWidth;

	public Planets()
	{
		
	}
	
	public void update()
	{
		posY += spd;
	}
	
	@Override
    protected void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(0, 0, getWidth(), getHeight());
	}
}
