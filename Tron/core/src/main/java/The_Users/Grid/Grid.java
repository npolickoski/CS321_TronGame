
package The_Users.Grid;

import com.badlogic.gdx.graphics.Color;
import The_Users.Player.PlayerColor;

/**
 * Represents a game grid consisting of tiles.
 * Each tile can have a color corresponding to a player's color.
 */
public class Grid 
{
    // Grid Attributes
    private Tile[][] tiles;     // 2D array to keep tiles together
    private int rows, cols;


    // Grid Methods
    /**
     * Constructs a grid with the specified number of rows and columns.
     * 
     * @param rows the number of rows in the grid
     * @param cols the number of columns in the grid
     */
    public Grid(int rows, int cols) 
    {
        this.rows = rows;
        this.cols = cols;

        // Initialize the grid with default tiles.
        tiles = new Tile[rows][cols];
        for (int y = 0; y < rows; y++) 
        {
            for (int x = 0; x < cols; x++) 
            {
                tiles[y][x] = new Tile(x, y);   // Create a new tile at each position.
            }
        }
    }

    /**
     * Gets the number of rows in the grid.
     * 
     * @return the number of rows
     */
    public int getRows() 
    {
        return rows;
    }

    /**
     * Gets the number of columns in the grid.
     * 
     * @return the number of columns
     */
    public int getCols() 
    {
        return cols;
    }

    /**
     * Retrieves the color of the tile at the specified coordinates.
     * If the coordinates are out of bounds, a default black color is returned.
     * 
     * @param x the x-coordinate of the tile
     * @param y the y-coordinate of the tile
     * @return the color of the tile, or {@link PlayerColor#BLACK} if out of bounds
     */
    public PlayerColor getTileColor(int x, int y) 
    {
        if (x >= 0 && x < cols && y >= 0 && y < rows) 
        {
            return tiles[y][x].getColor(); // Return the color of the tile.
        }

        return PlayerColor.BLACK; // Default color for out-of-bounds tiles.
    }

    /**
     * Sets the color of the tile at the specified coordinates.
     * If the coordinates are out of bounds, the operation is ignored.
     * 
     * @param x     the x-coordinate of the tile
     * @param y     the y-coordinate of the tile
     * @param color the color to set for the tile
     */
    public void setTileColor(int x, int y, PlayerColor color) 
    {
        if (x >= 0 && x < cols && y >= 0 && y < rows) 
        {
            tiles[y][x].setColor(color); // Set the color of the tile.
        }
    }
}


