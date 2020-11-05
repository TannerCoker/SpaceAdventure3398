package briceashburn.ui;

import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import briceashburn.images.Image;
import briceashburn.images.ImageFactory;
import briceashburn.objects.Player;
import briceashburn3.Constants;

public class GamePanel extends JPanel
{
	private ImageIcon backgroundImage;
	private Timer timer;
	private Player player;
	
	public GamePanel()
	{
		initializeVariables();
		initializeLayout();
	}

	private void initializeVariables() 
	{
		this.player = new Player();
		this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND);
		this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
		this.timer.start();
		
		
	}

	private void initializeLayout() 
	{
		
		setPreferredSize(new Dimension(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT));
		
	}
	
	private void drawSpaceship(Graphics g)
	{
		g.drawImage(player.getImage(), player.getX(), player.getY(),this);
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(backgroundImage.getImage(),0,0,null);
		
		doDrawing(g);
	}

	private void doDrawing(Graphics g)
	{
		drawSpaceship(g);
		
	}

	public void doOneLoop() 
	{
		update();
		repaint();
	}
	
	private void update()
	{
		
	}
	
	
}
