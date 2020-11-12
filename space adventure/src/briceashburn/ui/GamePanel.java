package briceashburn.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import briceashburn.callbacks.GameEventListener;
import briceashburn.constants.Constants;
import briceashburn.images.Image;
import briceashburn.images.ImageFactory;
import briceashburn.model.Laser;
import briceashburn.model.Player;

public class GamePanel extends JPanel 
{
	private ImageIcon backgroundImage;
	private Laser laser;
	private Timer timer;
	private Player player;
	private boolean inGame = true;
	
	
	public GamePanel() 
	{
		initializeVariables();	
		initializeLayout();	
	}
	
	public void initializeVariables()
	{
		this.player = new Player();
		this.laser = new Laser();
		this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND); //import .jpg
		this.timer = new Timer(Constants.GAME_SPEED,new GameLoop(this));  //calls gameloop ever 10 ms 
		this.timer.start();
	}
	

	private void initializeLayout() 
	{
		addKeyListener(new GameEventListener(this));
		setFocusable(true);
		setPreferredSize(new Dimension (Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT)); //parameters for height and width	
	}
	
	private void drawSpaceShip(Graphics g) 
	{
		g.drawImage(player.getImage(), player.getX(), player.getY(), this); // draws spaceship and places in correct location
	}
		
	
	private void drawLaser(Graphics g) 
	{
		{
		g.drawImage(laser.getImage(), laser.getX(), laser.getY(), this); // draws laser and places in correct location
		}
	}
		
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(backgroundImage.getImage(),0,0,null); // starts at top left corner, then fills entire JPanel
		doDrawing(g);
		
	}
	
	private void doDrawing(Graphics g)
	{
		if(inGame)
		{
			drawSpaceShip(g);
			drawLaser(g);
		}	
				else
				{
					if(timer.isRunning())
					{
					timer.stop();
					}
				}
		Toolkit.getDefaultToolkit().sync();
	}

	public void doOneLoop()
	{
		update();
		repaint();
	}

	private void update()
	{
		this.player.move();
		this.laser.move();
		
	}

	public void keyReleased(KeyEvent c)
	{
		this.player.keyReleased(c);
	}

	public void keyPressed(KeyEvent c) 
	{
		this.player.keyPressed(c);
		
		int key = c.getKeyCode();
		
		if(key == KeyEvent.VK_SPACE)
		{
			int laserX = this.player.getX();
			int laserY = this.player.getY();
	
		
				if(inGame && laser.isDead())
				{
					laser = new Laser(laserX,laserY); // can only shot after pervious dies
				}
		
		}
	} 
	
}
