package briceashburn.model;

import javax.swing.ImageIcon;

import briceashburn.constants.Constants;
import briceashburn.images.Image;
import briceashburn.images.ImageFactory;

public class Laser extends Sprite
{
	int dy = 100;
	
	public Laser()
	{
		
	}
	
	public Laser(int x, int y)
	{
		this.x = x;
	    this.y = y;
	    initialize();
	
	}
	
	private void initialize() 
	{
		ImageIcon imageIcon = ImageFactory.createImage(Image.LASER);
		setImage(imageIcon.getImage());
		
		setX((x+Constants.PLAYER_WIDTH/2)-11);
		setY(y);
		
	}
	
	@Override
	public void move()
	{
		
		// shots bottom to top
		y -= dy;
		
		
		if(this.y<0)
		{
			this.die(); // top is 0 so it dies
		}
	}
	
}	

