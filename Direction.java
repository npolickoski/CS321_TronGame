public enum Direction 
{
    UP(new PlayerVelocity(0,1)), 
    DOWN(new PlayerVelocity(0,-1)), 
    RIGHT(new PlayerVelocity(1,0)), 
    LEFT(new PlayerVelocity(-1,0));

    public final PlayerVelocity veloDirection;

    private Direction(PlayerVelocity velocity) 
    {
        this.veloDirection = velocity;
    }
     
}


