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

  public Alien(int x, int y)

  {
    locX = x;
    locY = y;
    speedX = 10;
    alive = true;
    bullet = new Projectile(1);
    shot = false;
    dice = new Random();
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


  public void update()

	{
		if(counter%2 != 1)
    {
      locX += speedX;
      if(locX > width-100)
        counter ++;
    }
    else
    {
      locX -= speedX;
      if(locX < 0)
        counter ++;
    }

    rand = dice.nextInt(2);

    if(alive)
    {
      if(rand == 0 && !shot)
      {
        bullet.setLoc(locX+25,locY+5);
        shot = true;
      }

      if(shot)
      {
        bullet.update();
        if(bullet.getY() >= 900)
        {
          bullet.setLoc(0,-5);
          shot = false;
        }
      }
    }
    else
      bullet.setLoc(0,-15);

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
		/*if(counter%2 != 1)
		{ 
			locX += speedX;
			if(locX > width-100)
			counter ++;
		}
		else
		{
			locX -= speedX;
			if(locX < 0)
			counter ++;
		}*/

		locX += ( speedX * direction ); 

		rand = dice.nextInt(50);

		if(alive)
		{
			if(rand == 0 && !shot)
			{
				bullet.setLoc(locX +  picture.getIconWidth()/2 , locY + (int)(picture.getIconHeight() * 0.9));
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
				g.drawImage(picture.getImage(),locX,locY,100,100,c);
			else
			{
				g.setColor(Color.BLUE);
				g.fillRect(x,y,width,height);
			}
		}
	}

}
