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
  private BufferedImage background,panelTitle;
  private ScreenManager manager;
  private JButton back;//back button
  ImageIcon backPic;

  public About(ScreenManager manager)
  {
    this.manager = manager;
    backPic = new ImageIcon("../images/Back.png");

    //tries to get the images
    try
    {
      background = ImageIO.read(new File("../images/stillBackground.png"));
      panelTitle = ImageIO.read(new File("../images/About_title.png"));
    }
    catch(Exception e)
    {
      System.out.println("image not pulled");
    }
    this.setLayout(null);
    setButton();
  }

  //makes the back button
  private void setButton()
  {
    back = new JButton(backPic);
    back.setBounds(30,40,80,30);
    back.setOpaque(false);
    back.setContentAreaFilled(false);
    back.setBorder(BorderFactory.createEmptyBorder());
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
    try
    {
      g.drawImage(background,0,0,width,height,this);
    }
    catch(Exception e)
    {
      g.setColor(Color.black);
      g.fillRect(0,0,width,height);
    }
    try
    {
      g.drawImage(panelTitle,width/2-panelTitle.getWidth()/2,10,this);
    }
    catch(Exception e)
    {
      g.drawString("About",width/2,10);
    }
  }
}
