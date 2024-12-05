
package The_Users.Player;

import com.badlogic.gdx.graphics.Color;
import The_Users.Player.PlayerColor;

public class Player 
{
    // Player Attributes
    private int xPosition, yPosition;   // Current x/y position on the grid
    private int xVelocity, yVelocity;   // Velocity along x/y-axis (-1, 0, 1)
    private PlayerColor playerColor;    // The player's unique color (enum)
    private boolean alive;              // Tracks if the player is alive or eliminated
    private boolean started;            // tracks if player has started moving


    // Player Methods
    /**
     * Constructor for Player with specified color.
     * 
     * @param startX       Starting X position on the grid.
     * @param startY       Starting Y position on the grid.
     * @param color        The player's color (PlayerColor enum).
     */
    public Player(int startX, int startY, PlayerColor color) 
    {
        this.xPosition = startX;
        this.yPosition = startY;
        this.xVelocity = 0;         // Default stationary
        this.yVelocity = 0;         // Default stationary
        this.playerColor = color;
        this.alive = true;          // Player starts alive
        this.started = false;       // Player starts stationary, needed to not kill player after marking initial square
    }

    /**
     * Constructor for Player with default color (CYAN).
     * 
     * @param startX       Starting X position on the grid.
     * @param startY       Starting Y position on the grid.
     */
    public Player(int startX, int startY) 
    {
        this(startX, startY, PlayerColor.getDefault());
    }

    /**
     * Updates the player's forward position based on velocity.
     * Checks if the player is alive before updating.
     */
    public void updatePosition() 
    {
        if (alive) 
        {
            xPosition += xVelocity;
            yPosition += yVelocity;
        }
    }

    /**
     * Updates the player's reverse position based on velocity.
     */
    public void reverse() 
    {
        xPosition -= xVelocity;
        yPosition -= yVelocity;
    }

    /**
     * Sets the player's direction using velocity.
     * 
     * @param xVelocity Velocity in the X direction (-1, 0, 1).
     * @param yVelocity Velocity in the Y direction (-1, 0, 1).
     */
    public void setDirection(int xVelocity, int yVelocity) 
    {
        this.started = true;

        // Ensure only one direction is set at a time
        if (Math.abs(xVelocity) + Math.abs(yVelocity) <= 1) 
        {
            this.xVelocity = xVelocity;
            this.yVelocity = yVelocity;
        } 
        else 
        {
            throw new IllegalArgumentException("Invalid velocity: Players can only move in one direction.");
        }
    }

    /**
     * Eliminates the player from the game.
     */
    public void eliminate() 
    {
        this.alive = false;
        stopMovement();         // Stops movement upon elimination
    }

    /**
     * Checks if the player is alive.
     * 
     * @return True if the player is alive, false otherwise.
     */
    public boolean isAlive() 
    {
        return alive;
    }

     /**
     * Checks if the player has started moving.
     * 
     * @return True if the player has started moving, false otherwise.
     */
    public boolean isStarted() 
    {
        return started;
    }

    /**
     * Gets the player's current X position.
     * 
     * @return X position on the grid.
     */
    public int getXPosition() 
    {
        return xPosition;
    }

    /**
     * Gets the player's current Y position.
     * 
     * @return Y position on the grid.
     */
    public int getYPosition() 
    {
        return yPosition;
    }

    /**
     * Gets the player's color (PlayerColor enum).
     * 
     * @return The player's color.
     */
    public PlayerColor getColor() 
    {
        return playerColor;
    }

    /**
     * Sets the player's color (PlayerColor enum).
     * 
     * @param color New color for the player.
     */
    public void setColor(PlayerColor color) 
    {
        this.playerColor = color;
    }

    /**
     * Gets the libGDX Color object for rendering.
     * 
     * @return The libGDX Color object corresponding to the player's color.
     */
    public Color getLibGDXColor() 
    {
        return playerColor.getGdxColor();
    }

    /**
     * Resets the player's velocity to stationary (0, 0).
     */
    public void stopMovement() 
    {
        this.xVelocity = 0;
        this.yVelocity = 0;
    }

    /**
     * Provides a string representation of the player's attributes.
     * 
     * @return A string describing the player's state.
     */
    @Override
    public String toString() 
    {
        return "Player{" +
               "xPosition=" + xPosition +
               ", yPosition=" + yPosition +
               ", xVelocity=" + xVelocity +
               ", yVelocity=" + yVelocity +
               ", playerColor=" + playerColor +
               ", alive=" + alive +
               '}';
    }
}
