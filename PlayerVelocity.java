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
public class PlayerVelocity
{
    // Class Attributes
    private int xVelo;
    private int yVelo;

    // Class Constructors

    // Class Methods

    // Getters
    public int getXVelocity()
    {
        return this.xVelo;
    }

    public int getYVelocity()
    {
        return this.yVelo;
    }
}