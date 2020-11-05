package briceashburn.ui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameLoop implements ActionListener 
{
	private GamePanel gamePanel;
	
	public GameLoop(GamePanel gamePanel)
	{
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		this.gamePanel.doOneLoop();
	}
}
