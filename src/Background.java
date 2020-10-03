import javax.swing.*; 
import java.util.*;
import java.awt.*;

public class Background extends JPanel
{
	private int width = JFrame.MAXIMIZED_HORIZ;
	private int height = JFrame.MAXIMIZED_VERT;
	private ArrayList<SpaceBodies> bodies = new ArrayList<SpaceBodies>();

	public Background()
	{
		/*JFrame frame = new JFrame("b");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
		//frame.getContentPane().setBackground(Color.black);
		//frame.add(s);
		setLayout(null);
		frame.setVisible(true);*/
	}
	
	
	//adds object planet
	public void addPlanets(Planets p)
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
		add(s);
		bodies.add(s);
	}
	
	public void update()
	{
		for(SpaceBodies sb : bodies)
		{
			sb.move();
		}
	}
	
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
		
	}
}
