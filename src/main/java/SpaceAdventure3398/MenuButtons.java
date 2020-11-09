/*
Author: Tanner

This class will allow us to create an object that will have an image of a word printed on it so that we can easily
make clickable buttons for the menu.
*/

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MenuButtons extends Rectangle
{
  ImageIcon picture;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  int x,y,stretch;

  MenuButtons(int x, int y)
  {
    this.x =x;
    this.y =y+60;
    stretch = 0;
    System.out.println(width + "\n" + height);
  }

  MenuButtons(int x, int y, int s)
  {
    this.x = x;
    this.y = y+60;
    stretch = s;
  }

  public void setPicture(ImageIcon p)
  {
    picture = p;
  }

  public void draw(Graphics g, Component c)
  {
    if(picture != null)
      g.drawImage(picture.getImage(),width/2-stretch/2,height/2+y,100+stretch,50, c);
    else
    {
      g.setColor(Color.white);
      g.fillRect(width/2-50,height/2-50,50,50);
    }
  }
}
