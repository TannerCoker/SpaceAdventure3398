import javax.swing.*; 
import java.util.*;
import java.awt.*;
import java.io.*;

public class Background extends JPanel
{
	private int width = JFrame.MAXIMIZED_HORIZ;
	private int height = JFrame.MAXIMIZED_VERT;
	private int frameWidth;
	private ArrayList<SpaceBodies> bodies = new ArrayList<SpaceBodies>();
	

	public Background(int w)
	{
	
		//changes the amount of stars
		for(int i=0;i<500;i++)
		{
			Stars s = new Stars(w);
			bodies.add(s);
		}
		
		//changes the amount of planets
		for(int i=0;i<4;i++)
		{
			Planets p = new Planets();
			bodies.add(p);
		}
		
		//thread to run update
		UpdateBG ub = new UpdateBG(this);
		ub.start();
	}
	
	public void setFrameWidth(int fw)
	{
		frameWidth = fw;
	}
	
	//updates the stars/spacebodies and causes them to update their position
	public void update()
	{
		for(SpaceBodies sb : bodies)
		{
			sb.update();
		}
		repaint();
	}
	
	//returns a dimension
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(width,height);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		for(SpaceBodies sb : bodies)
		{
			sb.draw(g);
		}
	}
}
