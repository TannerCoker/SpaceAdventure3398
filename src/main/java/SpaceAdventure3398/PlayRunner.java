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
  private JButton back;//back button to return to the menu
  ImageIcon backPic, playerPic, alienPic;
  private volatile boolean running;
  private ScreenManager manager;
  Background background = new Background();

  Player playerShip;
  Alien alienShip;
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
    playerPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/PlayerShip.png");
    //alienPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/EnemyShip.png");

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
      aMan.update();



    /*  if(playerShip.bullet.intersects(alienShip))
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
			}*/

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
    aMan.draw(g,this);

		playerShip.setX(xPos);
		playerShip.draw(g,this);
		playerShip.bullet.draw(g,this);

	}

}
