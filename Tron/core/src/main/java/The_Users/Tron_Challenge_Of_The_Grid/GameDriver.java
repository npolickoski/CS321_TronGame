
package The_Users.Tron_Challenge_Of_The_Grid;

import com.badlogic.gdx.Game;

/**
 * The main game driver that initializes and manages the game's lifecycle.
 * 
 * <p>This class extends {@link com.badlogic.gdx.Game} and is shared across all platforms.
 * It sets the initial screen to the {@link FirstScreen}, starting the game.
 */
public class GameDriver extends Game
{
    /**
     * Overridden LibGDX function
     * Called when the game is first created. This method sets the initial screen to the 
     * {@link FirstScreen}, which contains the core game logic and rendering.
     */
    @Override
    public void create()
    {
        setScreen(new FirstScreen());
    }
}
