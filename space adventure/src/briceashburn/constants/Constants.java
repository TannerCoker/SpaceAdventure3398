package briceashburn.constants;

public class Constants 
{
	private Constants()
	{
		
	}
	
	//JFrame Dimensions
	public static final String TITLE = "Space Adventure 3398";
	public static final int BOARD_WIDTH = 1500;
	public static final int BOARD_HEIGHT = 790;
	
	//Enemy1 related 
	public static final int ENEMY1_HEIGHT = 20;
	public static final int ENEMY1_WIDTH = 50;
	public static final int ENEMY1_INT_X = 400; // starting position
	public static final int ENEMY1_INT_Y = 100;
	public static final int ENEMY1_ROW = 4; // number is rows of ship 4*8=32
	public static final int ENEMY1_COLUMN = 8; // number of columns of enemy ship
	
	
	//speed of application
	public static final int GAME_SPEED = 10;
	
	//speed of laser
	public static final int LASER_HORIZONTAL_TRANSLATION = 100;
	
	
	//spaceship size
	public static final int PLAYER_WIDTH = 30;
	public static final int PLAYER_HEIGHT = 30;
	
	
	//Image Locations
	public static final String PLAYER_IMAGE_URL = "Images/player.png"; //image url points image location
	public static final String LASER_IMAGE_URL = "Images/laser.png";
	public static final String ENEMY1_IMAGE_URL = "Images/ship1.png";
	public static final String BACKGROUND_IMAGE_URL = "Images/background.png";;

}