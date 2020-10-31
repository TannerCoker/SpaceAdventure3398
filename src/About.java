/*
  Author: Tanner Coker

  This class will display the about panel of the game. It will show details of the game such as who made it.
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;

public class About extends JPanel implements ActionListener
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private BufferedImage background;
  private ScreenManager manager;
  private JButton back;//back button

  public About(ScreenManager manager)
  {
    this.manager = manager;
    //tries to get the background image
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

  //makes the back button
  private void setButton()
  {
    back = new JButton();
    back.setBounds(30,40,80,30);
    back.setText("Back");
    back.addActionListener(this);
    this.add(back);
  }

  //makes the back button return to the menu
  @Override
  public void actionPerformed(ActionEvent e)
  {
    manager.showMenu();
  }

  @Override
  public void paintComponent(Graphics g)
  {
    g.setColor(Color.black);
    g.fillRect(0,0,width,height);
    g. setColor(Color.red);
    g.fillRect(500,500,200,100);
  }
}
