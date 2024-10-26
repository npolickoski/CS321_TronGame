/**
 * Abstract class for handling position using CoordinatePair interface
 */
public abstract class CoordinatePairPositionAdapter implements CoordinatePair 
{
    // Class Fields
    private int xPos;
    private int yPos;


    // Getters
    @Override
    public final int getX() 
    {
        return this.xPos;
    }

    @Override
    public final int getY() 
    {
        return this.yPos;
    }

    public int getXPosition()                // Method Delegation: getXPosition() calls getX()
    {
        return this.getX();
    }

    public int getYPosition()                // Method Delegation: getYPosition() calls getY()
    {
        return this.getY();
    }


    // Setters
    @Override
    public void setX(int x) 
    {
        this.xPos = x;
    }

    @Override
    public void setY(int y) 
    {
        this.yPos = y;
    }

    public void setXPosition(int xPosition)         // Method Delegation: setXPosition(...) calls setX(...)
    {
        this.setX(xPosition);
    }

    public void setYPosition(int yPosition)         // Method Delegation: setYPosition(...) calls setY(...)
    {
        this.setY(yPosition);
    }
}
