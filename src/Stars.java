import javax.swing.*;
import java.awt.*;

public class Stars extends JPanel
{
	private int size = 4, posX = 500, posY = 500;
	private int speed = 5;
	
	public Stars()
	{
		
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
