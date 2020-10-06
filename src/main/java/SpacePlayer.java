package game.objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import game.SpaceAdventures;
// Space player is the player of the game
public class SpacePlayer extends GameObj{
	private int score = 0;
	
	public SpacePlayer(int x, int y, SpaceAdventures game) {
		super(x, y, game);
		try {
			this.setImage(getImage().getImageLoader().loadImage("/player-ship1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getImage(), getX(), getY();
	}

	private int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	private Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addScore(int i) {
		this.score += i;
	}