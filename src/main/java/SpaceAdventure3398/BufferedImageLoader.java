/* 
 * Eric Figueroa
 * BufferedImageLoader.java is the class needed to upload image files for
 * player and enemy to screen and background.
 */
package maingame;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage image;
	
	public BufferedImage loadImage(String path) throws IOException {
		
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}

}
