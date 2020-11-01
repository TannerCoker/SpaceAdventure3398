/*
  Author: Tanner Coker

  This class will manage which screen is currently being displayed for the game.
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;

public class ScreenManager
{
  JFrame frame = new JFrame();
  JPanel container = new JPanel();
  MainMenu menu = new MainMenu(this);
  PlayRunner pRun = new PlayRunner(this);
  ScoreBoardDisplay sDisp = new ScoreBoardDisplay(this);
  Settings setDisp = new Settings(this);
  About abDisp = new About(this);
  CardLayout cl = new CardLayout();


  public ScreenManager()
	{
		runPanels();
	}

  //this adds the various panels to the screen manager so that it can switch between them easily.
  //it also sets the frame for the game.
	private void runPanels()
	{
    container.setLayout(cl);
    container.add(menu, "1");
    container.add(pRun, "2");
    container.add(sDisp, "3");
    container.add(setDisp, "4");
    container.add(abDisp, "5");
    cl.show(container, "1");

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
    frame.add(container);
		frame.setVisible(true);
	}

  //switches to the main menu screen
  public void showMenu()
  {
    cl.show(container, "1");
  }

  //swtiches to the gameplay panel
  public void showPlay()
  {
    cl.show(container, "2");
    pRun.startPlay();
  }

  //switches to the scoreboard
  public void showScoreB()
  {
    cl.show(container, "3");
  }

  //switches to the settings panel
  public void showSettings()
  {
    cl.show(container, "4");
  }

  //switches to the about panel
  public void showAbout()
  {
    cl.show(container, "5");
  }

}
