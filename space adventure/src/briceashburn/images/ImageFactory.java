package briceashburn.images;

import javax.swing.ImageIcon;

import briceashburn.constants.Constants;

public class ImageFactory {

	public static ImageIcon createImage(Image image) {
		
		ImageIcon imageIcon = null;
		
		switch(image)
		{		
		case PLAYER:
			imageIcon = new ImageIcon(Constants.PLAYER_IMAGE_URL);
			break;
		case ENEMY1:
			imageIcon = new ImageIcon(Constants.ENEMY1_IMAGE_URL);
			break;
		case LASER:
			imageIcon = new ImageIcon(Constants.LASER_IMAGE_URL);
			break;
		case BACKGROUND:
			imageIcon = new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
			break;
		default:
			return null;
		
		
		
		}
		
		
		
		return imageIcon;
	}
	
}
