import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;

public class ScreenManager
{
  public ScreenManager()
	{
		TestComponents();
	}
  JFrame frame = new JFrame();
  JPanel container = new JPanel();
  MainMenu menu = new MainMenu(this);
  PlayRunner pRun = new PlayRunner(this);
  
  CardLayout cl = new CardLayout();


	private void TestComponents()
	{
    container.setLayout(cl);
    container.add(menu, "1");
    container.add(pRun, "2");
    cl.show(container, "1");




		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
    frame.add(container);
		frame.setVisible(true);
	}

  public void showPlay()
  {
    cl.show(container, "2");
  }

  public void showMenu()
  {
    cl.show(container, "1");
  }




  /*private MainMenu menu;
  private PlayRunner pRun;

  public ScreenManager()
  {
    menu = new MainMenu(this);
    pRun = new PlayRunner(this);
    menu.setVisible(true);
    repaint();
    //pRun.setVisible(false);
  }*/


}
