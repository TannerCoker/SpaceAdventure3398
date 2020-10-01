import javax.swing.*; 
import java.awt.*;

public class Background extends JPanel
{
	private int width = JFrame.MAXIMIZED_HORIZ;
	private int height = JFrame.MAXIMIZED_VERT;

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
		add(p);
	}
	
	//adds object stars
	public void addStars(Stars s)
	{
		add(s);
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
