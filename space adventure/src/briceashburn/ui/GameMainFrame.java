package briceashburn.ui;

import javax.swing.JFrame;


import briceashburn.images.Image;
import briceashburn.images.ImageFactory;
import briceashburn3.Constants;

public class GameMainFrame extends JFrame
{
	public GameMainFrame()
	{
		initializeLayout();
	}
	
	private void initializeLayout()
	{
		add(new GamePanel());
		setTitle(Constants.TITLE);
		setIconImage(ImageFactory.createImage(Image.PLAYER).getImage());
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}

