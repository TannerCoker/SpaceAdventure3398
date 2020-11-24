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

import java.awt.GradientPaint;
import java.awt.Color;

public class ScoreBoardDisplay extends JPanel implements ActionListener
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private BufferedImage background, panelTitle;
  private JButton back;//back button to return to menu
  private ScreenManager manager;//screen manager
  ImageIcon backPic;
  private Scoreboard scoreboard;

  public ScoreBoardDisplay(ScreenManager manager)
  {
    this.manager = manager;
	  this.backPic = new ImageIcon("src/main/java/SpaceAdventure3398/images/Back.png");

    //gets static background image
    try
    {
      background = ImageIO.read(new File("src/main/java/SpaceAdventure3398/images/stillBackground.png"));
      panelTitle = ImageIO.read(new File("src/main/java/SpaceAdventure3398/images/Score_Board_Panel.png"));
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

  void setScoreboard(Scoreboard s)
  {
    this.scoreboard	 = s;
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

	  /* Display the top scores  */
	  scoreboard.readFile();
	  String[] lines = scoreboard.getScores().split("\n");

	  // TODO: determine the x and y coordinates dynamically
	  // Determine the width of a line in order to center the score display
	  int stringWidth = g.getFontMetrics().stringWidth(lines[0]);
	  int x = 460; // width/2 - stringWidth/2;
	  int y = 200;

      g.setFont(new Font( "Courier", Font.BOLD, 30 ));
	  g.setColor( new Color(51, 150, 255) );

	  // The drawString method does not process \n well, so split it
	  // into lines and output the lines at 30 pixel intervals
      int lineNum = 0;
	  int offset = 30;
	  for(String line : lines)
	  {
      	g.drawString(line, x, y + lineNum*offset );
		++lineNum;
	  }
    }
    catch(Exception e)
    {
      g.drawString("ScoreBoard",width/2,10);
    }

  }

}
