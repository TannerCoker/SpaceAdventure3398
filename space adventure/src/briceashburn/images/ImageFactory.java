package briceashburn.images;

import javax.swing.ImageIcon;

import briceashburn3.Constants;

public class ImageFactory
{
	public static ImageIcon createImage(Image image)
	{
		ImageIcon imageIcon = null;
		
		switch(image)
		{
		case ENEMY1:
			imageIcon = new ImageIcon(Constants.ENEMY1_IMAGE_URL);
			break;
		case PLAYER:
			imageIcon = new ImageIcon(Constants.PLAYER_IMAGE_URL);
			break;
		case LASER:
			imageIcon = new ImageIcon(Constants.LASER_IMAGE_URL);
			break;
		case BACKGROUND:
			imageIcon = new ImageIcon(Constants.BACKGROUNG_IMAGE_URL);
			break;
		default:
			break;
		}
		
		return imageIcon;
		
	}
}
