/**
 * 
 * 
 */
public class PlayerPosition
{
    // Class Fields
    private int DEFAULT_POSITION = 0;
    private int xPos;                       // x-axis position
    private int yPos;                       // y-axis position


    // Class Constructors
    PlayerPosition()
    {
        this.xPos = DEFAULT_POSITION;
        this.yPos = DEFAULT_POSITION;   
    }

    PlayerPosition(int xStart, int yStart)
    {
        this.xPos = xStart;
        this.yPos = yStart;
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
    public int getXPosition()
    {
        return this.xPos;
    }

    public int getYPosition()
    {
        return this.yPos;
    }

}  