import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;

public class About extends JPanel
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private BufferedImage background;

  public About(MainMenu Menu)
  {
    try
    {
      background = ImageIO.read(new File("../images/background2.png"));
    }
    catch(Exception e)
    {
      System.out.println("background image not pulled");
    }
  }

  @Override
  public void paintComponent(Graphics g)
  {

  }
}
