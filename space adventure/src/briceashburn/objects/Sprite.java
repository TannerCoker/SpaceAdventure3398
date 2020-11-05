package briceashburn.objects;

import java.awt.Image;

public abstract class Sprite 
{

	private Image image;
	private boolean dead;
	
	protected int x;
	protected int y;
	protected int dx;
	
	
	public abstract void move();
	
	public Sprite()
	{
		this.dead = false;
	}
	
	public void die()
	{
		this.dead = true;
	}
	
	public Image getImage()
	{
		return this.image;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.x = y;
	}
	public int getY()
	{
		return this.y;
	}
	public int getX()
	{
		return this.x;
	}
	public void setDead(boolean dead)
	{
		this.dead = dead;
	}
	public boolean isDead()
	{
		return this.dead;
	}

	
}
