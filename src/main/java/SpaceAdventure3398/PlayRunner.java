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

public class PlayRunner extends JPanel implements ActionListener, KeyListener
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private JButton back;//back button to return to the menu
  ImageIcon backPic, playerPic, alienPic;
  private volatile boolean running;
  private ScreenManager manager;
  Background background = new Background();

  Player ship;
  Alien a1;

  Action leftAction;

  public PlayRunner(ScreenManager manager)
  {
    this.manager = manager;
    backPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/Back.png");
    playerPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/PlayerShip.png");
    alienPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/EnemyShip.png");

    this.setLayout(null);

    this.add(background);//adds the animated background to game panel
    setButton();//adds the back button

    ship = new Player(width/2, height/2);
    ship.setPicture(playerPic);
	requestFocus();
	//addKeyListener(new KeyMovement(this));

    this.addKeyListener(this);
    this.setFocusable(true);
	requestFocus(); 
    this.requestFocusInWindow();

    a1 = new Alien(width/2, 100);
    a1.setPicture(alienPic);

    running = false;
    UpdateBG ub = new UpdateBG(this);
    ub.start();

    leftAction = new LeftAction();

    this.getInputMap().put(KeyStroke.getKeyStroke("W"), "leftA");
    this.getActionMap().put("leftA", leftAction);

  }

  public class LeftAction extends AbstractAction
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      ship.setSpeed(-5);
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
      a1.update();

      if(ship.bullet.intersects(a1))
			{
				a1.kill();
        System.out.println("Alien dead");
			}
			if(a1.intersects(ship))
			{
				ship.kill();
        System.out.println("Ship dead");
			}
			if(a1.bullet.intersects(ship))
			{
				ship.kill();
        System.out.println("Ship dead");
			}

      ship.update();
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


	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			ship.setSpeed(5);  System.out.println("right");
		}	
		else if (key == KeyEvent.VK_LEFT) {
			ship.setSpeed(-5);
		}	
		/*else if (key == KeyEvent.VK_DOWN) {
			ship.setVelY(5);
		}
		else if (key == KeyEvent.VK_UP) {
			ship.setVelY(-5);
		}*/
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			ship.setSpeed(0);
		}	
		else if (key == KeyEvent.VK_LEFT) {
			ship.setSpeed(0);
		}	
		/*else if (key == KeyEvent.VK_DOWN) {
			ship.setVelY(0);
		}
		else if (key == KeyEvent.VK_UP) {
			ship.setVelY(0);
		}*/
	}
/*
  //@Override
  public void keyPressed(KeyEvent k)
  {
    char c = k.getKeyChar();

    if(k.getKeyCode() == KeyEvent.VK_RIGHT)
      {ship.setSpeed(5); System.out.println("right");}
    if(k.getKeyCode() == KeyEvent.VK_LEFT)
      {ship.setSpeed(-5); System.out.println("left");}
    if(c == ' ')
      {ship.shoot(); System.out.println("shoot");}
  }

  //@Override
  public void keyReleased(KeyEvent k)
  {
    if(k.getKeyCode() == KeyEvent.VK_LEFT &&  k.getKeyCode() == KeyEvent.VK_RIGHT)
      ship.setSpeed(0);
  }
*/
  public void keyTyped(KeyEvent k)
  {
  }

  //paints the components
  @Override
  public void paintComponent(Graphics g)
  {
    g.setColor(Color.black);
    g.fillRect(0,0,width,height);
    background.paintComponent(g);
    a1.draw(g,this);
    a1.bullet.draw(g,this);
    ship.draw(g,this);
    ship.bullet.draw(g,this);

  }
}