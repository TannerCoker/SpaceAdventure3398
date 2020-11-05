<<<<<<< HEAD
package com.players.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObj {

	Random r = new Random();
	
	public Player(int x, int y, ID id) {
		super(x, y, id);


	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH -37);
		y = Game.clamp(y, 0, Game.HEIGHT -60);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, 32, 32);
	}
	
	
=======
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
>>>>>>> 6f9788813b151a3e2b8454ac951ed628a3cd0347

}
