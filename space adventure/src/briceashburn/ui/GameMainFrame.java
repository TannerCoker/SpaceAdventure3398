package briceashburn.ui;

import javax.swing.JFrame;

import briceashburn.constants.Constants;
import briceashburn.images.Image;
import briceashburn.images.ImageFactory;

public class GameMainFrame extends JFrame {
	
	public GameMainFrame() {
		initializeLayout();
	}

	private void initializeLayout() {
		
		add (new GamePanel()); // adds component to JFrame
		
		setTitle(Constants.TITLE); // sets title of JFrame
		setIconImage(ImageFactory.createImage(Image.PLAYER).getImage()); //sets app icon to be the player(spaceship)
		
		pack(); //access to GamePanel
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // game exits when pressed
		setLocationRelativeTo(null); // places JFrame in middle of frame
		setResizable(false); //user unable to resize window
		setVisible(true); //tells java to show it
		
		
	}

}
