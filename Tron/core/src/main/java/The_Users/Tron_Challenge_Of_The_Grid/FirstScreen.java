
package The_Users.Tron_Challenge_Of_The_Grid;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.math.Vector3;

import The_Users.Grid.Grid;
import The_Users.Player.Player;
import The_Users.Player.PlayerColor;

/**
 * Represents the first screen of the Tron game, implementing game logic,
 * rendering, input handling, and resource management.
 */
public class FirstScreen implements Screen
{
    // FirstScreen Attributes
    private int gridSize = 64;                  // Grid size for the game board
    private Grid grid;                          // Game grid
    private SpriteBatch batch;                  // Rendering batch
    private Texture[] tileTexture;              // Array of textures for tiles
    private Texture[] bikeTexture;              // Array of textures for bikes
    private OrthographicCamera camera;          // Camera for viewing the game
    private FitViewport viewport;               // Viewport for screen adaptation
    private Player[] players;                   // Array of players in the game
    private float movementTimer = 0;            // Timer to control player movement


    // FirstScreen Methods
    /**
     * Overridden LibGDX function
     * Initializes the screen, including textures, grid, camera, and players.
     */
    @Override
    public void show()
    {
        // Initialize the camera and viewport
        camera = new OrthographicCamera();
        viewport = new FitViewport(gridSize, gridSize, camera); // Logical 64x64 grid
        viewport.apply();

        // Initialize rendering tools
        batch = new SpriteBatch();
        
        // Load tile textures
        tileTexture = new Texture[5];
        for (int i = 0; i < tileTexture.length; i++)
        {
            String fileName = "100xTileResize" + (i + 1) + ".png";
            tileTexture[i] = new Texture(fileName);
        }

        // Load bike textures
        bikeTexture = new Texture[4];
        for (int i = 0; i < bikeTexture.length; i++)
        {
            String fileName = "100xBikeResize" + (i + 2) + ".png";
            bikeTexture[i] = new Texture(fileName);
        }

        // Initialize the grid
        grid = new Grid(gridSize, gridSize);

        // Create and position players
        players = new Player[4];
        players[0] = new Player(0, 0, PlayerColor.RED);
        players[1] = new Player(0, gridSize - 1, PlayerColor.WHITE);
        players[2] = new Player(gridSize - 1, 0, PlayerColor.GOLD);
        players[3] = new Player(gridSize - 1, gridSize - 1, PlayerColor.BLUE);
    }

    /**
     * Overridden LibGDX function
     * Handles rendering the game, updating logic, and processing input.
     * 
     * @param delta time elapsed since the last frame
     */
    @Override
    public void render(float delta)
    {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update camera and set the batch projection
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        // Handle input and update game logic
        input();
        logic();

        // Render the grid and players
        batch.begin();
        renderGrid();
        renderPlayer();
        batch.end();
    }

    /**
     * Renders the game grid, drawing tiles with their respective colors.
     */
    private void renderGrid()
    {
        for (int y = 0; y < grid.getRows(); y++)
        {
            for (int x = 0; x < grid.getCols(); x++)
            {
                PlayerColor tileColor = grid.getTileColor(x, y);
                switch (tileColor)
                {
                    case RED:
                        batch.draw(tileTexture[1], x, y, 1, 1);
                        break;
                    case WHITE:
                        batch.draw(tileTexture[2], x, y, 1, 1);
                        break;
                    case GOLD:
                        batch.draw(tileTexture[3], x, y, 1, 1);
                        break;
                    case BLUE:
                        batch.draw(tileTexture[4], x, y, 1, 1);
                        break;
                    case CYAN:
                    default:
                        batch.draw(tileTexture[0], x, y, 1, 1);
                        break;
                }
            }
        }
    }

    /**
     * Renders all players on the grid using their respective textures.
     */
    private void renderPlayer()
    {
        for (int i = 0; i < players.length; i++)
        {
            batch.draw(bikeTexture[i], players[i].getXPosition(), players[i].getYPosition(), 1, 1);
        }
    }

    /**
     * Processes user input to control all players movements.
     */
    private void input() 
    {
        // Player 1 Controls
        if (Gdx.input.isKeyPressed(Input.Keys.W)) 
        {
            players[0].setDirection(0, 1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.A)) 
        {
            players[0].setDirection(-1, 0);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S)) 
        {
            players[0].setDirection(0, -1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D)) 
        {
            players[0].setDirection(1, 0);
        } 

        // Player 2 Controls
        if (Gdx.input.isKeyPressed(Input.Keys.T)) 
        {
            players[1].setDirection(0, 1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.F)) 
        {
            players[1].setDirection(-1, 0);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.G)) 
        {
            players[1].setDirection(0, -1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.H)) 
        {
            players[1].setDirection(1, 0);
        }

        // Player 3 Controls
        if (Gdx.input.isKeyPressed(Input.Keys.I)) 
        {
            players[2].setDirection(0, 1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.J)) 
        {
            players[2].setDirection(-1, 0);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.K)) 
        {
            players[2].setDirection(0, -1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.L)) 
        {
            players[2].setDirection(1, 0);
        }

        // Player 4 Controls
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) 
        {
            players[3].setDirection(0, 1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) 
        {
            players[3].setDirection(-1, 0);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) 
        {
            players[3].setDirection(0, -1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) 
        {
            players[3].setDirection(1, 0);
        }
    }

    /**
     * Implements game logic, including player movement and collision detection.
     */
    private void logic()
    {
        float delta = Gdx.graphics.getDeltaTime();
        movementTimer += delta;

        if (movementTimer > 0.125f)
        {
            movementTimer = 0;
            for (Player player : players)
            {
                if (player.isAlive()) 
                {
                    grid.setTileColor(player.getXPosition(), player.getYPosition(), player.getColor());
                }
                player.updatePosition();

                if (player.isStarted())
                {
                    switch (grid.getTileColor(player.getXPosition(), player.getYPosition()))
                    {
                        case CYAN:
                            break;
                        case BLACK:
                            player.reverse();
                            break;
                        default:
                            player.eliminate();
                            break;
                    }
                }
            }
        }
    }

    /**
     * Overridden LibGDX function
     * Scales the window appropriately upon a change.
     */
    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height, true);
    }

    /**
     * Overridden LibGDX function
     * No functionality as not needed to change
     * Must be overridden for LibGDX inheritance to work correctly
     */
    @Override
    public void pause() {}

    /**
     * Overridden LibGDX function
     * No functionality as not needed to change
     * Must be overridden for LibGDX inheritance to work correctly
     */
    @Override
    public void resume() {}

    /**
     * Overridden LibGDX function
     * No functionality as not needed to change
     * Must be overridden for LibGDX inheritance to work correctly
     */
    @Override
    public void hide() {}

    /**
     * Overridden LibGDX function
     * Releases resources used by the screen.
     */
    @Override
    public void dispose()
    {
        batch.dispose();
        for (Texture texture : tileTexture)
        {
            texture.dispose();
        }
        for (Texture texture : bikeTexture)
        {
            texture.dispose();
        }
    }
}

