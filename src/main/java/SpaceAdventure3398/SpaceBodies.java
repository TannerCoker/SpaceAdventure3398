/*
 * Author: Tanner Coker
 * 
 * Interface to for stars, planets and other spacebodies.
 * They need a function to update, draw, and to get the framewidth
 */

import java.awt.*;
public interface SpaceBodies 
{
	public void update();
	public void draw(Graphics g);
	public void setFrameWidth(int x);
}
