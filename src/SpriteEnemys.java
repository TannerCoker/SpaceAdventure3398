/*
 * Eric Figueroa
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
