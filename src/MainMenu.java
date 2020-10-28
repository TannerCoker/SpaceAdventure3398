/*
Author: Tanner Coker

This is a class that displays that main menu for the game SpaceAdventure 3398
*/
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;

public class MainMenu extends JPanel implements ActionListener
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private BufferedImage title, background;
  ImageIcon play, score, settings, about, exit;
  JButton playButton, scoreButton, settingsButton, aboutButton, exitButton;

  public MainMenu()
  {
    //assigns the buffered image for title picture
    try
    {
      title = ImageIO.read(new File("../images/Title.png"));
      background = ImageIO.read(new File("../images/background2.png"));
    }
    catch(Exception e)
    {
      System.out.println("title image not pulled");
    }
    //assigns the pics for the buttons to use
    play = new ImageIcon("../images/possible_play_button.png");
    score = new ImageIcon("../images/Scoreboard.png");
    settings = new ImageIcon("../images/Settings.png");
    about = new ImageIcon("../images/About.png");
    exit = new ImageIcon("../images/Exit.png");
    //sets no layout for the mainmenu
    this.setLayout(null);
    //calls the method that will make all of the buttons and set their locations
    makeButtons();

    //add the buttons to the mainmenu panel
    this.add(playButton);
    this.add(scoreButton);
    this.add(settingsButton);
    this.add(aboutButton);
    this.add(exitButton);
  }

  //makes the buttons and sets them to be transparent except for the png on them.
  //also sets the bounds for the buttons.
  private void makeButtons()
  {
    //offset is used to space the buttons out by height.
    int offset = 0;
    playButton = new JButton(play);
    playButton.setBounds(width/2-play.getIconWidth()/2,height/2,play.getIconWidth(),play.getIconHeight());
    playButton.setOpaque(false);
    playButton.setContentAreaFilled(false);
    playButton.setBorder(BorderFactory.createEmptyBorder());
    playButton.addActionListener(this);
    offset += (play.getIconHeight() + 10);

    scoreButton = new JButton(score);
    scoreButton.setBounds(width/2-score.getIconWidth()/2,height/2+offset,score.getIconWidth() ,score.getIconHeight());
    scoreButton.setOpaque(false);
    scoreButton.setContentAreaFilled(false);
    scoreButton.setBorder(BorderFactory.createEmptyBorder());
    scoreButton.addActionListener(this);
    offset += (score.getIconHeight() + 10);

    settingsButton = new JButton(settings);
    settingsButton.setBounds(width/2-settings.getIconWidth()/2,height/2+offset,settings.getIconWidth(),settings.getIconHeight());
    settingsButton.setOpaque(false);
    settingsButton.setContentAreaFilled(false);
    settingsButton.setBorder(BorderFactory.createEmptyBorder());
    settingsButton.addActionListener(this);
    offset += (settings.getIconHeight() + 10);

    aboutButton = new JButton(about);
    aboutButton.setBounds(width/2-about.getIconWidth()/2,height/2+offset,about.getIconWidth(),about.getIconHeight());
    aboutButton.setOpaque(false);
    aboutButton.setContentAreaFilled(false);
    aboutButton.setBorder(BorderFactory.createEmptyBorder());
    aboutButton.addActionListener(this);
    offset += (about.getIconHeight() + 10);

    exitButton = new JButton(exit);
    exitButton.setBounds(width/2-exit.getIconWidth()/2,height/2+offset,exit.getIconWidth(),exit.getIconHeight());
    exitButton.setOpaque(false);
    exitButton.setContentAreaFilled(false);
    exitButton.setBorder(BorderFactory.createEmptyBorder());
    exitButton.addActionListener(this);
  }

  //action listener to run commands based on button press
  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == playButton)
    {
      System.out.println("play");
    }
    else if(e.getSource() == scoreButton)
    {
      System.out.println("score");
    }
    else if(e.getSource() == settingsButton)
    {
      System.out.println("settings");
    }
    else if(e.getSource() == aboutButton)
    {
      System.out.println("about");
    }
    else if(e.getSource() == exitButton)
    {
      System.out.println("exit");
    }
  }

  public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//g.setColor(Color.black);
		//g.fillRect(0, 0, getWidth(), getHeight());
    g.drawImage(background,0,0,width,height,this);
    g.drawImage(title,width/2-title.getWidth()/2,150,this);

	}
}
