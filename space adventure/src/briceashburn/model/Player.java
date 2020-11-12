package briceashburn.model;

import javax.swing.ImageIcon;

import briceashburn.constants.Constants;
import briceashburn.images.Image;
import briceashburn.images.ImageFactory;

public class Player extends Sprite
{
	public Player()
	{
		initialize();
	}
	
	private void initialize() 
	{
		ImageIcon imageIcon = ImageFactory.createImage(Image.PLAYER);
		setImage(imageIcon.getImage());
		
		int start_x = Constants.BOARD_WIDTH/2-Constants.PLAYER_WIDTH/2;
		int start_y = Constants.BOARD_HEIGHT-100;
		
		setX(start_x);
		setY(start_y);
	}

	@Override
	public void move()
	{
		
	}
}
