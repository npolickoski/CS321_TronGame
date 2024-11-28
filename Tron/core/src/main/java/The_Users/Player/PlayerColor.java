package The_Users.Player;

import com.badlogic.gdx.graphics.Color;

public enum PlayerColor 
{
    CYAN(Color.CYAN), 
    RED(Color.RED), 
    WHITE(Color.WHITE), 
    GOLD(Color.GOLD), 
    BLUE(Color.BLUE),
    BLACK(Color.BLACK);

    private final Color gdxColor; // Corresponding libGDX Color

    /**
     * Constructor for the enum values.
     *
     * @param gdxColor The libGDX Color associated with this PlayerColor.
     */
    PlayerColor(Color gdxColor) 
    {
        this.gdxColor = gdxColor;
    }

    /**
     * Gets the libGDX Color associated with this PlayerColor.
     *
     * @return The libGDX Color.
     */
    public Color getGdxColor() 
    {
        return gdxColor;
    }

    /**
     * Provides the default PlayerColor (CYAN).
     *
     * @return The default PlayerColor.
     */
    public static PlayerColor getDefault() 
    {
        return CYAN;
    }
}
