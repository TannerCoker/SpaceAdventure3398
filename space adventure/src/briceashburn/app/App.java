package briceashburn.app;

import java.awt.EventQueue;

import briceashburn.ui.GameMainFrame;

public class App {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(  ()  -> {
			new GameMainFrame(); // creates new thread
		});
	}

}
