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
    backPic = new ImageIcon("src/main/java/SpaceAdventure3398/images/Back.png");

    //tries to get the images
    try
    {
      background = ImageIO.read(new File("src/main/java/SpaceAdventure3398/images/stillBackground.png"));
      panelTitle = ImageIO.read(new File("src/main/java/SpaceAdventure3398/images/About_title.png"));
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
      g.setFont(new Font( "Courier", Font.BOLD, 30 ));
	  g.setColor( new Color(51, 150, 255) );

	  int x = 260; // width/2 - stringWidth/2; 
	  int y = 200;

      g.drawString("Purpose:", x, y );	
      g.drawString(" This game is written for a class project in the ", x, y + 30 );	
      g.drawString(" CS 3398 Software Engineering class at Texas State", x, y + 60 );
      g.drawString(" University during Fall 2020.", x, y + 90 );		
      g.drawString("", x, y + 120 );	

	  y = 400;
      g.drawString("Authors:", x, y );	
      g.drawString(" - Lucas Anesti", x, y + 30);	
      g.drawString(" - Brice Ashburn", x, y + 60);	
      g.drawString(" - Tanner Coker", x, y + 90);	
      g.drawString(" - Erik Cortez", x, y + 120);	
      g.drawString(" - Eric Figueroa", x, y + 150);	

    }
    catch(Exception e)
    {
      g.drawString("About",width/2,10);
    }
  }
}
