/*
  Author: Tanner Coker

  This class will be running the game and it's various moving components such as the background, player, and enemies
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.util.ArrayList;



public class PlayRunner extends JPanel implements ActionListener
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private JButton back;//back button to return to the menu
  ImageIcon backPic, playerPic, alienPic;
  private volatile boolean running;
  private ScreenManager manager;
  Background background = new Background();

  Player playerShip;
  Alien alienShip;
  ArrayList<Alien> aliens = new ArrayList<Alien>();
  

  Action leftAction;

  // variables used to move and maintain player ship position
  private int xDelta = 0;
  private int keyPressCount = 0;
  private Timer repaintTimer;
  private int xPos = 0;
  private int radius = 10;

  public PlayRunner(ScreenManager manager)
  {
    this.manager = manager;
    backPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/Back.png");
    playerPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/PlayerShip.png");
    alienPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/EnemyShip.png");

    this.setLayout(null);

    this.add(background);//adds the animated background to game panel
    setButton();//adds the back button

    playerShip = new Player(width/2, (int)(height*0.80) );
    playerShip.setPicture(playerPic);


	/*************************************************************************/
	/* Solution suggested by MadProgrammer on stackoverflow at:
	/*    https://stackoverflow.com/questions/15192610/java-object-movement
	/*************************************************************************/
	// Used to move and maintain ship position
	InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
	ActionMap am = getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "pressed.left");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "pressed.right");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "released.left");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "released.right");

    am.put("pressed.left", new MoveAction(-15, true));
    am.put("pressed.right", new MoveAction(15, true));
    am.put("released.left", new MoveAction(0, false));
    am.put("released.right", new MoveAction(0, false));

    repaintTimer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            xPos += xDelta;
            if (xPos < 0) {
                xPos = 0;
            } else if (xPos + radius > getWidth()) {
                xPos = getWidth() - radius;
            }
            repaint();
        }
    });
    repaintTimer.setInitialDelay(0);
    repaintTimer.setRepeats(true);
    repaintTimer.setCoalesce(true);
	/***************************************************************/

	// TODO: Move to EnemyManager
	// Place 5 enemies on the screen at regular intervals
	// TODO: placing too many enemies at regular intervals will draw
	// enemies off screen. Draw them closer to each other if many enemies
	// are present using screen measurements.
	for(int i = 0; i < 5; i++)
	{
		//segment = (width / numOfEnemies) * 0.5
		int y = (int)( i*( width * 0.1 ) ); 
    	alienShip = new Alien( y, 100 );
    	alienShip.setPicture(alienPic);
		aliens.add(alienShip);
	}

    running = false;
    UpdateBG ub = new UpdateBG(this);
    ub.start();
  }

	public class MoveAction extends AbstractAction {

		private int direction;
		private boolean keyDown;

		public MoveAction(int direction, boolean down) {
		    this.direction = direction;
		    keyDown = down;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		    xDelta = direction;
		    if (keyDown) {
		        if (!repaintTimer.isRunning()) {
		            repaintTimer.start();
		        }
		    } else {
		        repaintTimer.stop();
		    }
		}
	}


  //makes the back button
  private void setButton()
  {
    back = new JButton(backPic);
    back.setBounds(30,40,80,30);
    back.setOpaque(false);
    back.setContentAreaFilled(false);
    back.setBorder(BorderFactory.createEmptyBorder());
    back.addActionListener(this);
    this.add(back);
  }

  //starts the update thread which should update all gameplay parts
  public void startPlay()
  {
    running = true;
  }

  //updates all of the gameplay parts   
  public void update()
  {
    if(running)
    {
      background.update();

		// TODO: move next 3 blocks to EnemyManager
		// check to see if any one of the ships have reached the
		// end of the screen on the left or right
		boolean reverse = false;
		for(Alien alienShip : aliens)
		{
			if(alienShip.reachedScreenBounds() ) 
			{
				reverse = true;
				break;
			}	
		}

		// if at least one ship has reached the end of the screen, reverse the direction
		// of all the ships to make them move in synch.
		if(reverse)
		{
			for(Alien alienShip : aliens)
			{
				alienShip.reverseDirection();
			}
		}

		// Use this check only if the aliens array is resized after enemies die
		// if(aliens[0].reachedScreenBounds() || aliens[aliens.size()-1].reachedScreenBounds() )

		for(Alien alienShip : aliens)
		{
			alienShip.update();
		}



      if(playerShip.bullet.intersects(alienShip))
			{
				alienShip.kill();
        System.out.println("Alien dead");
			}
			if(alienShip.intersects(playerShip))
			{
				playerShip.kill();
        System.out.println("Ship dead");
			}
			if(alienShip.bullet.intersects(playerShip))
			{
				playerShip.kill();
        System.out.println("Ship dead");
			}

      playerShip.update();
      repaint();
    }
  }

  //goes back to the menu screen
 // @Override
  public void actionPerformed(ActionEvent e)
  {
    running = false;
    manager.showMenu();
  }


	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.black);
		g.fillRect(0,0,width,height);
		background.paintComponent(g);

		// TODO: EnemyManager
		for(Alien alienShip : aliens)
		{
			alienShip.draw(g,this);
			alienShip.bullet.draw(g,this);
		}

		playerShip.setX(xPos);
		playerShip.draw(g,this);
		playerShip.bullet.draw(g,this);

		Graphics2D g2d = (Graphics2D) g.create();
		//g2d.setColor(Color.BLACK);
		//g2d.drawOval(xPos, 0, radius, radius);
		g2d.dispose();
	}

}



