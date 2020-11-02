import java.awt.Image;

public class projToShipCol extends Sprite {

	public void projToShipCol(Sprite ship) {
		if (ship instanceof AlienShip) {
			game.shotSpriteRem(this);
			ship.health--;
			if(ship.health==0)
				game.removeAlienShip(ship);
		}
	}
}