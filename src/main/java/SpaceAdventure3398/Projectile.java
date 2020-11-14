import javax.swing.*;
import java.awt.*;

public class Projectile extends Rectangle
{

  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int ScreenWidth = screenSize.width;
  int ScreenHeight = screenSize.height;
  int locx, locy, myWidth, myHeight, speed, owner;//1 = alien, 2 = player

  //pass either a 1 or 2 to the class to control the direction that the bullet travels in
  //this will make it go up if it's from a player and down if it's from an alien
  //it also will tell if the bullet belongs to a player or an enemy if needed
	Projectile(int owner)
	{
		locx= 0;
		locy = -15;
		myWidth = 7;
	  myHeight = 10;
    speed = 10;
    this.owner = owner;
	}

	public void update()
	{
    if(locy > -15 && locy < ScreenHeight+15)
      if(owner == 1)
        locy += speed;
      else if(owner == 2)
        locy -= speed;
	}

  public void setLoc(int x, int y)
  {
    locx = x;
    locy = y;
  }


  public void draw(Graphics g, Component c)
	{
		g.setColor(Color.yellow);
    g.fillRect(locx,locy,myWidth,myHeight);
	}


}
