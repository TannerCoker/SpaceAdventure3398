/*
 * Eric Figueroa
<<<<<<< HEAD
 * SpriteEnemys.java is the class needed to create enemys for Space
 * Adventures 3398
 */
=======
 * SpriteEnemys.java is the class needed to create enemy players. 
 *
 */
package maingame;

import java.awt.image.BufferedImage;

public class SpriteEnemys {
	
	private BufferedImage image;
	
	public SpriteEnemys(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage((col * 32) - 32,(row * 32) - 32, width, height);
		return img;
	}

}
>>>>>>> 6f9788813b151a3e2b8454ac951ed628a3cd0347
