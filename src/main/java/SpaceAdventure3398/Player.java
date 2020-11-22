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
  ArrayList<Projectile> bullets;
  Projectile bullet;
  private int health;

  boolean shot = false;

  public Player(int x, int y)
  {
    locX = x;
    locY = y;
    speed = 0;
    bullets = new ArrayList<Projectile>();
    bullet = new Projectile(2);
    alive = true;
    health = 100;
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
    //bullets.add(new Projectile(2));
    //bullets.get(bullets.size()-1).setLoc(locX+(picture.getIconWidth()/2), locY-5);
    if(!shot)
    {
      bullet.setLoc(locX+(picture.getIconWidth()/2),locY-5);
      shot = true;
    }

  }

  public void update()
  {
    int counter = 0;
    locX += speed;
    /*while(counter != bullets.size())
    {
      if(bullets.get(counter).hitBound())
        bullets.remove(counter);
      else
      {
        bullets.get(counter).update();
        counter++;
      }
    }*/
    if(shot)
    {
      bullet.update();
      if(bullet.getYCoord() <= 0)
      {
        bullet.setLoc(0,-15);
        shot = false;
      }
    }

  }

  public void setSpeed(int s)
  {
    speed = s;
  }

  public void setX(int x)
  {
  	locX = x;
  }

  public Projectile getBullet()
  {
    return bullet;
  }

  public ArrayList<Projectile> getBullets()
  {
    System.out.println("getBullets");
    return bullets;
  }

  public void draw(Graphics g, Component c)
  {
    if(alive)
    {
      if(picture != null)
      {
        g.drawImage(picture.getImage(),locX,locY,50,50,c);
        bullet.draw(g,c);
        //for(Projectile b : bullets)
        //  b.draw(g,c);
      }
      else
      {
        g.setColor(Color.blue);
        g.fillRect(x,y,50,50);
      }
    }

  }


}
