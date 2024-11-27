package The_Users.Tron_Challenge_Of_The_Grid;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GameDriver extends Game 
{
    @Override
    public void create() 
    {
        setScreen(new FirstScreen());
    }
}