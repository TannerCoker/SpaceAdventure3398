/*
EnemyManager class will handle all of the enemies creation and movements. It will generate an arraylist of abstract aliens
and it will check if anyone of them has hit the screen bounds and will call on them to move and it will draw them to the
play panel. It can also return if there are no aliens and it should be able to check if any of the aliens were shot by a bullet.
*/

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class EnemyManager
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int sWidth = screenSize.width;
  int sHeight = screenSize.height;
  ArrayList<Alien> aliens;
  ImageIcon alienPic;


  Rectangle b1 = new Rectangle(70, -70, 7,10);

  //constructor
  public EnemyManager()
  {
    alienPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/EnemyShip.png");
    aliens = new ArrayList<Alien>();
  }

  //fills an arraylist full of abstract aliens and puts them in a row format.
  public void makeAliens()
  {
    int rowX = sWidth/4;//x value to place the aliens
    int rowY = 15; //height to place the aliens on the same Y-coord on the same row
    for(int i = 0;i<30;i++)//produces x aliens
    {
      if(i%10 == 0)//limits x aliens per row
      {
        rowX = sWidth/4;
        rowY += 60;
      }
        aliens.add(new Alien(rowX,rowY,alienPic));
        rowX += 65;
    }

  }

  //can be used to determine if there are anymore aliens
  public boolean noAliens()
  {
    if(aliens.isEmpty())
      return true;
    return false;
  }

  //determine if any of the aliens has reached either the left or right side of the screen.
  //if an alien reaches it then it reverses the movement direction of all aliens.
  //Then calls for the aliens to update/move.
  public void update()
  {
    boolean boundReached = false;
    for(Alien a : aliens)
    {
      if(a.reachedScreenBounds())
      {
        boundReached = true;
        break;
      }
    }
    if(boundReached)
      for(Alien a : aliens)
        a.reverseDirection();
    for(Alien a : aliens)
      a.update();
  }

  //should be able to check if an alien was hit by a rectangle/bullet.
  //if true then it will kill the alien and remove it from the arraylist.
  /*public void checkHit(ArrayList<Projectile> b)
  {
    for(Alien a : aliens)
    {
      System.out.println("check aliens");
      for(Projectile p : b)
      {
        System.out.println("proj loop");
        if(a.intersects(p))
        {
          System.out.println("proj loop true");
          a.kill();
          aliens.remove(a);
        }
      }

    }

  }*/



  public void checkHit(Projectile b)
  {
    for(Alien a : aliens)
    {
      //if(b.getYCoord() < a.getY()+50 && b.getYCoord() > a.getY() && b.getXCoord() < a.getX()+50 && b.getXCoord() > a.getX())

      b1.move(b.getXCoord(),b.getYCoord());

      if(a.gotHit(b1))
      {
        System.out.println("hit");
        a.kill();
        aliens.remove(a);
        b.setLoc(0,-15);
        break;
      }
    }
  }

  public void draw(Graphics g, Component c)
  {
    for(Alien a : aliens)
    {
      a.draw(g,c);
    }

  }


}
