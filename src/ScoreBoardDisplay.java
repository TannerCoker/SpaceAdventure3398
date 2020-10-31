/*
  Author: Tanner Coker

  This class is intended to display the current contents of the scoreboard for the game
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;

public class ScoreBoardDisplay extends JPanel implements ActionListener
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private BufferedImage background;
  private JButton back;//back button to return to menu
  private ScreenManager manager;//screen manager

  public ScoreBoardDisplay(ScreenManager manager)
  {
    this.manager = manager;
    //gets static background image
    try
    {
      background = ImageIO.read(new File("../images/background2.png"));
    }
    catch(Exception e)
    {
      System.out.println("background image not pulled");
    }
    this.setLayout(null);
    setButton();
  }

  //sets the backbutton to return to the menu
  private void setButton()
  {
    back = new JButton();
    back.setBounds(30,40,80,30);
    back.setText("Back");
    back.addActionListener(this);
    this.add(back);
  }

  //makes the back button got back to the menu
  @Override
  public void actionPerformed(ActionEvent e)
  {
    manager.showMenu();
  }

  @Override
  public void paintComponent(Graphics g)
  {
    try
    {
      g.drawImage(background,0,0,width,height,this);
    }
    catch(Exception e)
    {
      g.setColor(Color.black);
      g.fillRect(0,0,width,height);
    }
    g. setColor(Color.green);
    g.fillRect(500,500,200,100);
  }

}
