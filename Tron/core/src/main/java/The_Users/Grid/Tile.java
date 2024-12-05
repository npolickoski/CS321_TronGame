
package The_Users.Grid;

import The_Users.Player.PlayerColor;

/**
 * Represents a single tile in the game grid.
 * Each tile has a position (x, y) and a color that can represent
 * the state or ownership of the tile in the game.
 */
public class Tile 
{
    // Tile Attributes
    private int xPosition, yPosition; // a tile's position in the grid
    private PlayerColor tileColor;    // current color of the tile


    // Tile Methods
    /**
     * Constructs a tile with specified x and y coordinates.
     * Initializes the tile's color to the default {@link PlayerColor#CYAN}.
     * 
     * @param xPos the x-coordinate of the tile
     * @param yPos the y-coordinate of the tile
     */
    public Tile(int xPos, int yPos) 
    {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.tileColor = PlayerColor.CYAN; // Default color for a new tile
    }

    /**
     * Gets the x-coordinate of the tile in the grid.
     * 
     * @return the x-coordinate of the tile
     */
    public int getX() 
    {
        return xPosition;
    }

    /**
     * Gets the y-coordinate of the tile in the grid.
     * 
     * @return the y-coordinate of the tile
     */
    public int getY() 
    {
        return yPosition;
    }

    /**
     * Gets the current color of the tile.
     * 
     * @return the color of the tile
     */
    public PlayerColor getColor() 
    {
        return tileColor;
    }

    /**
     * Sets the color of the tile.
     * 
     * @param color the new color to set for the tile
     */
    public void setColor(PlayerColor color) 
    {
        this.tileColor = color;
    }
}

