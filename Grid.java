/**
 * The Grid class represents the playable area of the game and extends the Database class.
 * It tracks the positions of players and handles updates to the tiles on the grid.
 * The Grid interacts with the Timer class to enforce tick-based updates, and updates the state
 * of each Tile accordingly. It also inherits the ability to manage game data from the Database class.
 *
 * Fields:
 * - timer: The Timer object that controls the tick rate of the game.
 * - tiles: An array of Tile objects representing the grid layout.
 *
 * Collaborators:
 * - Player: Represents the players in the game.
 * - Tile: Manages the status of individual grid sections.
 * - Timer: Controls the rate at which the game state is updated.
 * - Host: Responsible for managing the game lobby and player connections.
 * - Database: Inherited class used to manage game-related data.
 */

public class Grid extends Database
{
    // Class Fields
    private final int DEFAULT_SIZE = 64;
    private final int xSize;
    private final int ySize;  


    // Class Attributes 
    private Timer  timer;
    private Tile[] tiles;


    // Class Constructors
    Grid()
    {
        xSize = DEFAULT_SIZE;               // Initialize to default
        ySize = DEFAULT_SIZE;               // Initialize to default

        // TODO Handle timer and tiles
    }

    Grid(int xDimension, int yDimension)
    {
        if (xDimension <= 0) 
        {
            xSize = DEFAULT_SIZE;
        }
        else
        {
            xSize = xDimension;
        }
        
        if (yDimension <= 0) 
        {
            ySize = DEFAULT_SIZE;            
        }
        else
        {
            ySize = yDimension;
        }

        // TODO Handle timer and tiles
    }   

    // Class Methods
    public boolean isMarked(PlayerPosition position)
    {
        // TODO Check if a requested tile is already marked and return status
        // TODO Remove dummy return value
        return true;
    }

}
