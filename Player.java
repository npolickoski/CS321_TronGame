/**
 * The PlayerObject class represents the player in the game.
 * It handles player movement, marking tiles as the player moves, and keeps track of the player's color.
 *
 * Collaborators:
 * - Controller
 * - TileMarker
 * - PlayerColor
 */
public class Player
{
    // Class Attributes
    private PlayerColor    color;
    private PlayerStatus   status;
    private PlayerPosition position;
    private PlayerVelocity velocity;


    // Class Constructors
    public Player()
    {
        // TODO Handle constructors
    }


    // Getters
    public PlayerColor getColor()
    {
        return this.color;
    }

    public PlayerStatus getStatus()
    {
        return this.status;
    }

    public PlayerPosition getCurrentPosition()
    {
        return this.position;
    }

    public PlayerPosition getProjectedPosition()
    {
        PlayerPosition ProjectedPosition = new PlayerPosition(this.position.getXPosition() + this.velocity.getXVelocity(), this.position.getYPosition() + this.velocity.getYVelocity());
        return ProjectedPosition;
    }
    

    // Setters
    public void setColor(PlayerColor setCol)
    {
        this.color = setCol; 
    }

    public void setStatus(PlayerStatus setStat)
    {
        this.status = setStat; 
    }

    public void setPosition(PlayerPosition setPos)
    {
        this.position = setPos; 
    }
}