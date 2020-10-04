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
	private ArrayList<Stars> stars = new ArrayList<Stars>();
	

	public Background()
	{
	
		for(int i=0;i<100;i++)
		{
			Stars s = new Stars();//frameWidth);
			stars.add(s);
		}
		
		//thread to run update
		UpdateBG ub = new UpdateBG(this);
		ub.start();
	}
	
	
	//adds object planet
	/*public void addPlanets(Planets p)
	{
		p.setLocation(150,500);
		add(p);
		bodies.add(p);
	}
	
	//adds object stars
	public void addStars(Stars s)
	{
		if((int)(Math.random()*2+1) == 2)
			s.setLocation(50,50);
		else
			s.setLocation(10,10);
		//add(s);
		bodies.add(s);
	}*/
	
	public void setFrameWidth(int fw)
	{
		frameWidth = fw;
	}
	
	
	
	//updates the stars/spacebodies and causes them to update their position
	public void update()
	{
		for(Stars sb : stars)
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
		
		for(Stars sb : stars)
		{
			sb.draw(g);
		}
	}
}
