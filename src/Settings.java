/*
  Author: Tanner Coker

  This class will display the settings panel and it's various settings.
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import javax.swing.event.*; // ChangeListener

public class Settings extends JPanel implements ActionListener
{
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width = screenSize.width;
  int height = screenSize.height;
  private BufferedImage background,panelTitle;
  private ScreenManager manager;//screen manager
  private JButton back;//back button
  ImageIcon backPic;

  private JSlider diff; //difficulty setting
  JComboBox resolution; 
  Checkbox fullscreen;

  public Settings(ScreenManager manager)
  {
    this.manager = manager;
    backPic = new ImageIcon("../images/Back.png");

    //tries to get the buffered images
    try
    {
      background = ImageIO.read(new File("../images/stillBackground.png"));
      panelTitle = ImageIO.read(new File("../images/Settings_title.png"));
    }
    catch(Exception e)
    {
      System.out.println("background image not pulled");
    }
    this.setLayout(null);

    setButton();
    setElements();
  }

  //sets the back button
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

  private void setElements()
  {
	diff = new JSlider(JSlider.HORIZONTAL, 0, 20, 1);
	diff.setFont(new Font( "Courier", Font.BOLD, 15 ));
    diff.setMajorTickSpacing(5);
    diff.setMinorTickSpacing(1);
    diff.setPaintLabels(true);
    diff.setPaintTicks(true);
    diff.setSnapToTicks(true);
    diff.setPaintTrack(true);
    diff.setAutoscrolls(true);
    diff.setOpaque(false);
    diff.setPreferredSize(new Dimension(200,50));
    diff.setBounds(500,165,450,80);

	JLabel label;
	Hashtable<Integer, JComponent> table = new Hashtable<Integer, JComponent>();
	label = new JLabel("0");
	label.setForeground( new Color(51, 150, 255) );
    table.put(new Integer(0), label);
	label = new JLabel("5");
	label.setForeground( new Color(51, 150, 255) );
    table.put(new Integer(5), label);
	label = new JLabel("10");
	label.setForeground( new Color(51, 150, 255) );
    table.put(new Integer(10), label);
	label = new JLabel("15");
	label.setForeground( new Color(51, 150, 255) );
    table.put(new Integer(15), label);
	label = new JLabel("20");
	label.setForeground( new Color(51, 150, 255) );
    table.put(new Integer(20), label);
	diff.setLabelTable(table);

	diff.addChangeListener( new ChangeListener()
		{
        	@Override
        	public void stateChanged(ChangeEvent e) 
        	{
            	diff.getValue();
            	repaint();
        	}
        });
	this.add(diff);	


    String[] res = { "1000 x 500", "1200 x 800", "1920 x 1080" };
	resolution = new JComboBox(res);
	resolution.setFont(new Font( "Courier", Font.BOLD, 20 ));
    resolution.setPreferredSize(new Dimension(200,50));
    resolution.setBounds(500,280,200,30);
    resolution.setOpaque(true);
	resolution.setBackground(Color.BLACK);
	resolution.setForeground( new Color(51, 150, 255) );
    resolution.setBorder( null );
	//resolution.addActionListener(this); // TODO add proper listener
	this.add(resolution);	


    fullscreen = new Checkbox();
    fullscreen.setBounds(500,380,18,20);
	fullscreen.setBackground( new Color(51, 150, 255) );
	this.add(fullscreen);	

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
	  g.drawString("Difficulty  : ", 250, 200);
	  g.drawString("Resolution  : ", 250, 300);
	  g.drawString("Full Screen : ", 250, 400);
    }
    catch(Exception e)
    {
      g.drawString("Settings",width/2,10);
    }
  }
}
