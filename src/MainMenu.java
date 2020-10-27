/*
Author: Tanner Coker

This is a class that displays that main menu for the game SpaceAdventure 3398
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class MainMenu extends JPanel
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  ImageIcon title, play, score, settings, about, exit;
  MenuButtons playButton, scoreButton, settingsButton, aboutButton, exitButton;

  public MainMenu()
  {
    title = new ImageIcon("../images/Title.png");
    play = new ImageIcon("../images/possible_play_button.png");
    score = new ImageIcon("../images/Scoreboard.png");
    settings = new ImageIcon("../images/Settings.png");
    about = new ImageIcon("../images/About.png");
    exit = new ImageIcon("../images/Exit.png");

    playButton = new MenuButtons(0,0);
    scoreButton = new MenuButtons(0,50,25);
    settingsButton = new MenuButtons(0,100);
    aboutButton = new MenuButtons(0,150);
    exitButton = new MenuButtons(0,200);

    playButton.setPicture(play);
    scoreButton.setPicture(score);
    settingsButton.setPicture(settings);
    aboutButton.setPicture(about);
    exitButton.setPicture(exit);

    JButton testPlay = new JButton(play);
    testPlay.setOpaque(false);
    testPlay.setContentAreaFilled(false);
    testPlay.setBorder(BorderFactory.createEmptyBorder());

    this.add(testPlay);
  }


  public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
    playButton.draw(g,this);
    scoreButton.draw(g,this);
    settingsButton.draw(g,this);
    aboutButton.draw(g,this);
    exitButton.draw(g,this);

	}
}
