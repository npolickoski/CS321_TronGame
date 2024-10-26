/**
 * The PlayerVelocity class determines the velocity for each player and allows the tile 
 * marker to predict each tile a player will navigate towards to determine possible collsions.
 * 
 * Responsibilities:
 *      Standardizes the Velocity of all players on the grid
 *      Helps make predicted positions for each of the players for tile marker
 *      Helps determine collisions     
 * 
 * Collaborators:
 *      Player
 *      Player Status
 *      Tile Marker
 */
public class PlayerVelocity extends CoordinatePairVelocityAdapter
{
    
    // Class Attributes
    private static final int DEFAULT_VELOCITY = 0;

    // Class Constructors
    PlayerVelocity()
    {
        this.setXVelocity(DEFAULT_VELOCITY);
        this.setYVelocity(DEFAULT_VELOCITY);
    }

    PlayerVelocity(int xVelo, int yVelo)
    {
        this.setXVelocity(xVelo);
        this.setYVelocity(yVelo);
    }

    PlayerVelocity(PlayerVelocity velo)
    {
        this.setXVelocity(velo.getXVelocity());
        this.setYVelocity(velo.getYVelocity());
    }

    PlayerVelocity(Direction direction)
    {
        this.setXVelocity(direction.veloDirection.getXVelocity());
        this.setYVelocity(direction.veloDirection.getYVelocity());
    }

    // Class Methods

    PlayerVelocity Test()
    {
        PlayerVelocity velo = new PlayerVelocity(Direction.UP); 
        return velo;
    }

    // Getters

    // Setters
}