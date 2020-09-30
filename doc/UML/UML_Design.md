# UML Design

Some of the UML Design Patterns used in the project along with their justification is listed below.

### Strategy Pattern for Ship behavior

There are 3 subclasses of the abstract Ship class, the Player class, the Enemy class, and the subclass of the Enemy, the Boss class. A Ship must have a move() function to change position on the screen as the game advances. Defining the move() function in the Ship class would mean that the subclasses would have to override their methodos with the appropriate behavior and the subclasses would have to modify their respective functions if the game logic requires chnage in movement behavior. In addition, any additional classes derived from the Ship class will inherit the move() function even if the class/object does not need to move. The strategy pattern allows the movement behavior to be separated from the Ship class and enables assignment of the behavior dynamically during runtime. For example, the player ship may learn a new movement skill as it advances through the game, or a boss encounter may have multiple stages, each of which has distincit movement patterns. 

