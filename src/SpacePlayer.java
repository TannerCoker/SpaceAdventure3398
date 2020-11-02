/*
 * Author: Eric Figueroa
 * SpacePlayer is the player of the game that will be fighting against SpaceEnemy by shooting
 * enemy ships to move onto the next level of the game. 
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

public class SpacePlayer extends GameObj{
	private int score = 0;

	// creation of player using image we have created	
	public SpacePlayer(int x, int y, SpaceAdventures game) {
		super(x, y, game);
	// try catch to load image
		try {
			this.setImage(getImage().getImageLoader().loadImage("/player-ship1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// prints graphics to the screen by setting X/Y with bounds
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
