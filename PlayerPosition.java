/**
 * 
 * 
 */
public class PlayerPosition extends CoordinatePairPositionAdapter
{
    // Class Fields
    private static final int DEFAULT_POSITION = 0;
    // private int xPos;                       // x-axis position
    // private int yPos;                       // y-axis position


    // Class Constructors
    PlayerPosition()
    {
        this.setXPosition(DEFAULT_POSITION);
        this.setYPosition(DEFAULT_POSITION);
    }

    PlayerPosition(int xStart, int yStart)
    {
        this.setXPosition(xStart);
        this.setYPosition(yStart);
    }

    PlayerPosition(PlayerPosition position)
    {
        
    }


    // Class Methods
    public boolean isValidPosition()
    {
        // TODO Check if the position is within the bounds of the grid. Call 
        // TODO Check if position is already marked
        // TODO Remove dummy return value
        return true;
    }

    // Getters

}  