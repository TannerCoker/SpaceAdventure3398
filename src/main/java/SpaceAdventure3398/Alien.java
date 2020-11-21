/*
  The alien class is for the alien objects in the game. Aliens will move left and right
  across the screen until a bound is detected in which it will then reverse. It will
  also randomly shoot a bullet towards the players side of the screen. If it is hit
  then it should die.
*/
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.imageio.ImageIO;

public class Alien extends Rectangle
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  ImageIcon picture;
	boolean alive, shot;
  int locX, locY, speedX, speedY, counter, rand;
  Random dice;
  Projectile bullet;

  int direction = 1;

  public Alien(int x, int y,ImageIcon pic)
  {
    locX = x + 5; // start each ship with a slight offset to the right
    locY = y;
    speedX = 3;
    alive = true;
    bullet = new Projectile(1);
    shot = false;
    dice = new Random();
    picture = pic;
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

	// check if the ship has reached end of screen left or right
	boolean reachedScreenBounds()
	{
		return (locX > width-picture.getIconWidth() || locX < 0 );  //explain
	}

	void reverseDirection()
	{
		direction *= -1;
	}

	public void update()
	{
		locX += ( speedX * direction );

		rand = dice.nextInt(200);

		if(alive)
		{
			if(rand == 0 && !shot)
			{
				bullet.setLoc(locX +  picture.getIconWidth()/2 , locY + (int)(picture.getIconHeight() * 0.9));
        //bullet.setLoc(locX +  picture.getIconWidth()/2 , locY + (picture.getIconHeight() + 5));
				shot = true;
			}

			if(shot)
			{
				bullet.update();
				if(bullet.getYCoord() >= height-10)
				{
					bullet.setLoc(0,-5);
	  				shot = false;
				}
			}
		}
		else
			bullet.setLoc(0,-15);
	}



  public void draw(Graphics g, Component c)
	{
		if(alive)
		{
			if( picture != null )
      {
        g.drawImage(picture.getImage(),locX,locY,50,50,c);
        bullet.draw(g,c);
      }
			else
			{
				g.setColor(Color.BLUE);
				g.fillRect(x,y,width,height);
			}
		}
	}

}
