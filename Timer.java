/**
 * The Timer class controls the game's tick rate and how fast players move.
 * It enforces updates within the grid at consistent intervals.
 *
 * Collaborators:
 * - PlayerObject
 * - Grid
 */


/**
 * Responsibilities:
 *      Determines Tick rate for game
 *      Controls how fast players move
 *      Enforces methods within the grid
 * 
 *  Collaborators:
 *      Player Object
 *      Grid
 */
public class Timer
{
    // Class Attibutes
    private int seconds;

    Timer(int seconds)
    {
        this.seconds = 9999;
        // This will be changed later, just adding it as a default
    }


    // Class Methods
    void starttimer()
    {
        for (int i = 0; i <= this.seconds; i++)
        {
            System.out.println("Current Score:" + i);
            // try
            // {
            //     Thread.sleep(1000);
            // }
            // This is increments the score by 1 per second
        }
    }

    public static void main(String[] args)
    {
        Timer time = new Timer(9999);
        // Timer.starttimer();
    }
}