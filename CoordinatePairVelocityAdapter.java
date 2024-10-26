/**
 * Abstract class for handling velocity using CoordinatePair interface
 */
public abstract class CoordinatePairVelocityAdapter implements CoordinatePair 
{
    // Class Fields
    private int xVelo;
    private int yVelo;


    // Getters
    @Override
    public final int getX() 
    {
        return this.xVelo;
    }

    @Override
    public final int getY() 
    {
        return this.yVelo;
    }

    public int getXVelocity()               // Method Delegation: getXVelocity() calls getX()
    {
        return this.getX();                 
    }

    public int getYVelocity()               // Method Delegation: getYVelocity() calls getY()
    {
        return this.getY();                 
    }


    // Setters
    @Override
    public void setX(int x) 
    {
        this.xVelo = x;
    }

    @Override
    public void setY(int y) 
    {
        this.yVelo = y;
    }

    public void setXVelocity(int xVelocity)             // Method Delegation: setXVelocity(...) calls setX(...)
    {
        this.setX(xVelocity);
    }

    public void setYVelocity(int yVelocity)             // Method Delegation: setYVelocity(...) calls setY(...)
    {
        this.setY(yVelocity);
    }

}
