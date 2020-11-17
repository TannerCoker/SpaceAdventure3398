import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Player extends Rectangle
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  ImageIcon picture;
  boolean alive;
  int locX, locY, speed, myWidth, myHeight;
  Projectile bullet;

  public Player(int x, int y)
  {
    locX = x;
    locY = y;
    speed = 0;
    bullet = new Projectile(2);
    alive = true;
  }

  public void setPicture(ImageIcon p)
	{
		picture = p;
	}

  public void kill()
  {
    locX = 0-picture.getIconWidth();
    locY = 0-picture.getIconHeight();
    alive = false;
  }

  public void shoot()
  {
    bullet.setLoc(locX+(picture.getIconWidth()/2), locY-5);
  }

  public void update()
  {
    locX += speed;
    //System.out.println(locX + " " + locY);
    bullet.update();
  }

  public void setSpeed(int s)
  {
    speed = s;
  }
<<<<<<< HEAD
=======
	
  public void setX(int x)
  {
  	locX = x;
  }
>>>>>>> 6297f4be926e313420dfa85e31b855048050b504

  public void draw(Graphics g, Component c)
  {
    if(alive)
    {
      if(picture != null)
<<<<<<< HEAD
        g.drawImage(picture.getImage(),locX,locY,100,100,c);
=======
        g.drawImage(picture.getImage(),locX,locY,50,50,c);
>>>>>>> 6297f4be926e313420dfa85e31b855048050b504
      else
      {
        g.setColor(Color.blue);
        g.fillRect(x,y,50,50);
      }
    }

  }


}
