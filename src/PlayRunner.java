/*
  Author: Tanner Coker

  This class will be running the game and it's various moving components such as the background, player, and enemies
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;

public class PlayRunner extends JPanel implements ActionListener
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private JButton back;//back button to return to the menu

  private ScreenManager manager;
  Background background = new Background();

  public PlayRunner(ScreenManager manager)
  {
    this.manager = manager;
    this.setLayout(null);

    this.add(background);//adds the animated background to game panel
    setButton();//adds the back button

    //starts the update thread which should update all gameplay parts
    UpdateBG ub = new UpdateBG(this);
		ub.start();
  }

  //makes the back button
  private void setButton()
  {
    back = new JButton();
    back.setBounds(30,40,80,30);
    back.setText("Back");
    back.addActionListener(this);
    this.add(back);
  }

  //updates all of the gameplay parts
  public void update()
  {
    background.update();
    repaint();
  }

  //goes back to the menu screen
  @Override
  public void actionPerformed(ActionEvent e)
  {
    ub.stop();
    manager.showMenu();
  }

  //paints the components
  @Override
  public void paintComponent(Graphics g)
  {
    g.setColor(Color.black);
    g.fillRect(0,0,width,height);
    background.paintComponent(g);
  }
}
