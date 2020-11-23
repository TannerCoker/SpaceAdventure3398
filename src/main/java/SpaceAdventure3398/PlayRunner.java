/*
  Author: Tanner Coker

  This class will be running the game and it's various moving components such as the background, player, and enemies
*/
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.IOException;
import javax.swing.Timer;




public class PlayRunner extends JPanel implements ActionListener
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private JButton back,restart;//back button to return to the menu. restart to reset the game once it's over.
  ImageIcon backPic, playerPic, alienPic,restartPic;
  private volatile boolean running;
  private ScreenManager manager;
  Background background = new Background();

  Player playerShip;
  Alien alienShip;
  ArrayList<Projectile> b;
  EnemyManager aMan = new EnemyManager();


  Action leftAction;

  // variables used to move and maintain player ship position
  private int xDelta = 0;
  private int keyPressCount = 0;
  private Timer repaintTimer;
  private int xPos = width/2;
  private int radius = 10;

  public PlayRunner(ScreenManager manager)
  {
    this.manager = manager;
    backPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/Back.png");
    restartPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/Restart.png");
    playerPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/PlayerShip.png");

    this.setLayout(null);

    this.add(background);//adds the animated background to game panel
    setButton();//adds the back button

    playerShip = new Player(width/2, (int)(height*0.80) );
    playerShip.setPicture(playerPic);
    b = playerShip.getBullets();


	/*************************************************************************/
	/* Solution suggested by MadProgrammer on stackoverflow at:
	/*    https://stackoverflow.com/questions/15192610/java-object-movement
	/*************************************************************************/
	// Used to move and maintain ship position
	InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
	ActionMap am = getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "pressed.left");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "pressed.right");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "pressed.space");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "released.left");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "released.right");

    am.put("pressed.left", new MoveAction(-15, true));
    am.put("pressed.right", new MoveAction(15, true));
    am.put("pressed.space", new AbstractAction()
    {
      public void actionPerformed(ActionEvent e)
      {
        playerShip.shoot();
      }
    });
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

    aMan.makeAliens();

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


  //makes the back button and restart button
  private void setButton()
  {
    back = new JButton(backPic);
    back.setBounds(30,40,80,30);
    back.setOpaque(false);
    back.setContentAreaFilled(false);
    back.setBorder(BorderFactory.createEmptyBorder());
    back.addActionListener(this);
    /*Action blank = new AbstractAction()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {}
    };
    ActionMap bm = back.getActionMap();
    bm.put("pressed", blank);
    bm.put("released", blank);*/
    this.add(back);

    restart = new JButton(restartPic);
    restart.setBounds(width/2-restartPic.getIconWidth()/2, height/2, 100,50);
    restart.setOpaque(false);
    restart.setContentAreaFilled(false);
    restart.setBorder(BorderFactory.createEmptyBorder());
    restart.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        aMan.killAllAliens();
        aMan.makeAliens();
        playerShip.revive();
        xPos = width/2;
        restart.setVisible(false);
        manager.showMenu();
      }
    });
    restart.setVisible(false);
    this.add(restart);
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
      aMan.update();
      aMan.checkHit(playerShip.getBullet());


      if(playerShip.isAlive())
      {
        playerShip.checkHit(aMan.getAlienBullets());
        playerShip.update();
      }
      else
      {
        restart.setVisible(true);
      }

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
    aMan.draw(g,this);

		playerShip.setX(xPos);
		playerShip.draw(g,this);
		//playerShip.bullet.draw(g,this);

	}

}
