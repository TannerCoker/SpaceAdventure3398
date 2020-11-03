import java.awt.Image;

public class projToShipCol extends Sprite {


	private Game game;

	public void projToShipCol(Sprite ship) {
		if (ship instanceof AlienShip) {
			game.shotSpriteRem(this);
			ship.health--;
			if(ship.health==0)
				game.removeAlienShip(ship);
		}

		else if (ship instanceof player) {
			game.shotSpriteRem(this) {
			ship.health--;
			if(ship.health==0)
				game.removePlayer(ship);
		}
	}
	}
}