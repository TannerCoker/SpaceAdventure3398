<<<<<<< HEAD
/* 
 * Eric Figueroa
 * SpritePlayers.java is the sprite class needed to create players for Space
 * Adventure 3398
 */ 
=======
/*
 * Eric Figueroa
 * SpritePlayers.java is the class needed to help create players
 *
 */
package maingame;

import java.awt.image.BufferedImage;

public class SpritePlayers {
	
	private BufferedImage image;
	
	public SpritePlayers(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage((col * 32) - 32,(row * 32) - 32, width, height);
		return img;
	}

}
>>>>>>> 6f9788813b151a3e2b8454ac951ed628a3cd0347
