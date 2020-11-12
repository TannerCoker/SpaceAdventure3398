package briceashburn.callbacks;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import briceashburn.ui.GamePanel;

public class GameEventListener extends KeyAdapter {

	private GamePanel board;
	
	
	public GameEventListener(GamePanel board)
	{
		this.board = board;
	}
	
	@Override
	public void keyReleased(KeyEvent c)
	{
		this.board.keyReleased(c);
	}
	
	@Override
	public void keyPressed(KeyEvent c)
	{
		this.board.keyPressed(c);
	}
}
