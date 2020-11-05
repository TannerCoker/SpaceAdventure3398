/* 
 * Eric Figueroa
<<<<<<< HEAD
 * BufferedImageLoader.java is the class needed to upload images created 
 * to the screen properly for Space Adventures 3398
 */
=======
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
>>>>>>> 6f9788813b151a3e2b8454ac951ed628a3cd0347
