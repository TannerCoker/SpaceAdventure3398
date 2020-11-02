package game.objects;

import java.io.IOException;

import game.Game;
import game.SpaceAdventures;
// EnemyPlayer is the enemy of the game
public class EnemyPlayer extends GameObj implements Runnable {
	
	private int motion;
	private boolean running = false;
	private Thread thread;
	private int velocity = 5;
	
	public EnemyPlayer(int start, int i, SpaceAdventures game, int type, int motion2) {
		// TODO Auto-generated constructor stub
	}
	public void EnemyPlayer (int x, int y, Game game, int type, int motion) {
		super (x, y, game);
		try {
			if(type == 0){
				this.setImage(getGame().getImageLoader().loadImage("/enemy-ship1.png"));
			}else if(type == 1){
				this.setImage(getGame().getImageLoader().loadImage("/enemy-ship2.png"));
			}else{
				this.setImage(getGame().getImageLoader().loadImage("/enemy-ship3.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.motion = motion;
	}
	public void goDown(){
		setY(getY() + velocity);
		
		if(motion == 0){
			goLeft();
		}else{
			goRight();
		}
		
		if (getX() < 1) {
			motion = 1;
		}
		if (getX() > getGame().getWidth() - 65) {
			motion = 0;
		}
	}
	
	private int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void goLeft(){
		setX(getX() - velocity);
	}
	public void goRight(){
		setX(getX() + velocity);
	}

	@Override
	public void render(Graphics g) { 
		g.drawImage(getImage(), getX(), getY();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY();
	}
	
	@Override
	public void run() {
		while (running) {
			
		}
		stop();
	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;

		running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getMotion() {
		return motion;
	}

	public void setMotion(int motion) {
		this.motion = motion;
	}