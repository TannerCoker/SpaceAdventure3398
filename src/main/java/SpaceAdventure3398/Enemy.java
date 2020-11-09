/*
 * Eric Figueroa
 * Enemy.java is the enemies of space-adventure-3398
 *
 */
package maingame;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy {
	
	private double x;
	private double y;
	private BufferedImage enemy;
	
	public Enemy(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		
		SpriteEnemys ss = new SpriteEnemys(game.getSpriteEnemys());
		enemy = ss.grabImage(1, 1, 400, 400);
	}
	
	public void tick() {
		y--;
	}
	public void render(Graphics g) {
		g.drawImage(enemy, (int)x, (int)y, null);
	}

}
