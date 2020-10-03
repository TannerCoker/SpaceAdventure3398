import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Stars extends JPanel implements SpaceBodies
{
	private int size = (int)(Math.random()*2+1), posX = 500, posY = 500;
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
		/*x_coord = x;
		y_coord = y;
		speed = sp;
		size = si;*/
		
		
	}
	
	public void move()
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
    }
}
