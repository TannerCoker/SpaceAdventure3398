package briceashburn.model;

import java.awt.event.KeyEvent;

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
		
		int start_x = Constants.BOARD_WIDTH/2-Constants.PLAYER_WIDTH/2; // be put in middl of screen
		int start_y = Constants.BOARD_HEIGHT-100; // same
		
		setX(start_x);
		setY(start_y);
	}

	@Override
	public void move()
	{
		x += dx;
		
		if(x<Constants.PLAYER_WIDTH) //left side of screen is 0 = x
		{ 
			x=Constants.PLAYER_WIDTH; // gives space/boundry the size of the spaceship. 
		}
		if(x >= Constants.BOARD_WIDTH-2*Constants.PLAYER_WIDTH) // screen size - weight of ship. 
		{ 
			x=Constants.BOARD_WIDTH-2*Constants.PLAYER_WIDTH; // gives space/boundry the size of the spaceship. 
		}
	}

	public void keyPressed(KeyEvent c) 
	{
		
		int key = c.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT) // left arrow key
		{
			dx = -8; // 6 pixels left 
		}
		if(key==KeyEvent.VK_RIGHT) // right arrow key
		{
			dx = 8; // move 6 pixels right (think of speed kinda)
		}
	}
	public void keyReleased(KeyEvent c)
	{
		
		int key = c.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT) // let go ofleft arrow key
		{
			dx = 0; // dont move
		}
		if(key==KeyEvent.VK_RIGHT) // let go of right arrow key
		{
			dx = 0; // dont move
		}
		// if user hits 'SPACE' then shoot a laser
	}
}
