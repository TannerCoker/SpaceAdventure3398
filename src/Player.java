package maingame;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	
	private double x;
	private double y;
	private BufferedImage player;
	
	public Player(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		
		SpritePlayers ss = new SpritePlayers(game.getSpritePlayers());
		player = ss.grabImage(1, 1, 400, 400);
	}
	
	public void tick() {
		x++;
	}
	public void render(Graphics g) {
		g.drawImage(player, (int)x, (int)y, null);
	}

}
