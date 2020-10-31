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
  private BufferedImage background;
  JButton back;

  public ScoreBoardDisplay(MainMenu Menu)
  {
    try
    {
      background = ImageIO.read(new File("../images/background2.png"));
    }
    catch(Exception e)
    {
      System.out.println("background image not pulled");
    }
    setButton();
  }

  private void setButton()
  {
    back = new JButton();
    back.setBounds(30,40,50,30);
    back.setText("Back");
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    
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
    g. setColor(Color.green);
    g.fillRect(500,500,200,100);
  }

}
