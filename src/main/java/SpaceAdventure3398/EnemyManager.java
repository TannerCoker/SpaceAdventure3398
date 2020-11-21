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

  public EnemyManager()
  {
    alienPic = new ImageIcon("./src/main/java/SpaceAdventure3398/images/EnemyShip.png");
    aliens = new ArrayList<Alien>();

  }

  public void makeAliens()
  {
    int rowX = sWidth/4;
    int rowY = 15; //height to place the aliens on the same Y-coord on the same row
    for(int i = 0;i<30;i++)
    {
      if(i%10 == 0)
      {
        rowX = sWidth/4;
        rowY += 60;
      }
        aliens.add(new Alien(rowX,rowY,alienPic));
        rowX += 65;

    }
  }

  public boolean noAliens()
  {
    if(aliens.isEmpty())
      return true;
    return false;
  }

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

  public void checkHit(Rectangle r)
  {
    for(Alien a : aliens)
    {
      if(r.intersects(a))
      {
        a.kill();
        aliens.remove(a);
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
