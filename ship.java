package shipClass;

//import Sprite location;
//import java.awt.event.KeyEvent;

public class ship extends sprite  {
	
	int shields;
	int health;

	var shipSprt = "image location.png";
	
	
	public void keyDetect(KeyEvent p)  { //detects key pressed by user
	
	int key = p.getKeyCode();

	if (key == KeyEvent.VK_A)  {
	
	xDir = -1; //moves the ship left
	}

	if (key == KeyEvent.VK_D)  {
	
	xDir = 1;  //moves the ship right
	}
     	}

	public void keyReleased(KeyEvent p)  { //detects release of key
	
	int key = p.getKeyCode();

	if (key == KeyEvent.VK_A)  {

		xDir = 0; // stops movement
	}

	if (key == KeyEvent.VK_D)  {
		xDir = 0; // stops movement
} 
	public void healthDmg()  {
		--health;
}

	public void shieldDmg()  {
		--shields;
}
}