package The_Users.Grid;

import The_Users.Player.PlayerColor;

public class Tile 
{
    // Tile Attributes
    private int xPosition, yPosition;               // Tile position in the grid
    private PlayerColor tileColor;  // The current color of the tile


    // Tile Methods
    public Tile(int xPos, int yPos) 
    {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.tileColor = PlayerColor.CYAN; // Default to black (or unoccupied)
    }

    public int getX() 
    { 
        return xPosition; 
    }

    public int getY() 
    { 
        return yPosition; 
    }
    
    public PlayerColor getColor() 
    { 
        return tileColor; 
    }
    
    public void setColor(PlayerColor color) 
    { 
        this.tileColor = color; 
    }
}
