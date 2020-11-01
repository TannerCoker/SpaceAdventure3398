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
  private BufferedImage background, panelTitle;
  private JButton back;//back button to return to menu
  private ScreenManager manager;//screen manager
  ImageIcon backPic;

  public ScoreBoardDisplay(ScreenManager manager)
  {
    this.manager = manager;
    backPic = new ImageIcon("../images/Back.png");

    //gets static background image
    try
    {
      background = ImageIO.read(new File("../images/stillBackground.png"));
      panelTitle = ImageIO.read(new File("../images/Score_Board_Panel.png"));
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
    back = new JButton(backPic);
    back.setBounds(30,40,80,30);
    back.setOpaque(false);
    back.setContentAreaFilled(false);
    back.setBorder(BorderFactory.createEmptyBorder());
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
    try
    {
      g.drawImage(panelTitle,width/2-panelTitle.getWidth()/2,10,this);
    }
    catch(Exception e)
    {
      g.drawString("ScoreBoard",width/2,10);
    }
  }

}
