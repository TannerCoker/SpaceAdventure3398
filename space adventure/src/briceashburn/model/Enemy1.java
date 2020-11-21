package briceashburn.model;

import javax.swing.ImageIcon;

import briceashburn.images.Image;
import briceashburn.images.ImageFactory;

public class Enemy1 extends Sprite {
	
	private boolean visible = true; // ship does no "die" is becomes invisible
	
	
	
	public Enemy1(int x, int y)
	{
		this.x =x;
		this.y = y;
		initialize();
				
	}
	
	private void initialize() 
	{
		ImageIcon imageIcon = ImageFactory.createImage(Image.ENEMY1);
		setImage(imageIcon.getImage());
		
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void move(int direction )
	{
		this.x += direction;
	}
	
	@Override
	public void move()
	{
		
	}

}
