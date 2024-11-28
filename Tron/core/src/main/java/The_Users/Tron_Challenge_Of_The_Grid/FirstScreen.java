
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

public class FirstScreen implements Screen 
{
    private int                 gridSize = 64;
    private Grid                grid;
    private SpriteBatch         batch;
    private Texture[]           tileTexture;
    private Texture[]           bikeTexture;
    private OrthographicCamera  camera;
    private FitViewport         viewport;

    private Player[]            players;
    private Player              player1;
    private Player              player2;
    private float               movementTimer = 0;

    @Override
    public void show() 
    {
        // Initialize the camera and viewport
        camera = new OrthographicCamera();
        viewport = new FitViewport(gridSize, gridSize, camera); // Logical 64x64 grid
        viewport.apply();

        // Initialize rendering tools
        batch = new SpriteBatch();
        
        tileTexture = new Texture[5]; // Array to hold 5 texture objects

        for (int i = 0; i < tileTexture.length; i++) 
        {
            String fileName = "100xTileResize" + (i + 1) + ".png"; // Dynamic file name
            tileTexture[i] = new Texture(fileName); // Assign texture to the array
        }

        bikeTexture = new Texture[4]; // Array to hold 5 texture objects

        for (int i = 0; i < bikeTexture.length; i++) 
        {
            String fileName = "100xBikeResize" + (i + 2) + ".png"; // Dynamic file name
            bikeTexture[i] = new Texture(fileName); // Assign texture to the array
        }


        // Create a grid
        grid = new Grid(gridSize, gridSize); // 64x64 grid

        players = new Player[4];

        players[0] = new Player(0, 0, PlayerColor.RED);
        players[1] = new Player(0, gridSize - 1, PlayerColor.WHITE);
        players[2] = new Player(gridSize - 1, 0, PlayerColor.GOLD);
        players[3] = new Player(gridSize - 1, gridSize - 1, PlayerColor.BLUE);
    }

    @Override
    public void render(float delta) 
    {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update camera
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        // Handle input and game logic
        input();
        logic();

        // Render the grid
        batch.begin();
        renderGrid();
        renderPlayer();
        // batch.draw(tileTexture[1], 0, 0, 1, 1); // Draw each tile as 1x1 unit
        // batch.draw(tileTexture[2], 0, gridSize - 1, 1, 1); // Draw each tile as 1x1 unit
        // batch.draw(tileTexture[3], gridSize - 1, gridSize - 1, 1, 1); // Draw each tile as 1x1 unit
        // batch.draw(tileTexture[4], gridSize - 1, 0, 1, 1); // Draw each tile as 1x1 unit
        // batch.draw(bikeTexture[0], 0, 0, 1, 1); // Draw each bike as 1x1 unit
        // batch.draw(bikeTexture[1], 0, gridSize - 1, 1, 1); // Draw each bike as 1x1 unit
        // batch.draw(bikeTexture[2], gridSize - 1, gridSize - 1, 1, 1); // Draw each bike as 1x1 unit
        // batch.draw(bikeTexture[3], gridSize - 1, 0, 1, 1); // Draw each bike as 1x1 unit
        batch.end();
    }

    private void renderGrid() 
    {
        // Render each tile in the grid
        for (int y = 0; y < grid.getRows(); y++)
        {
            for (int x = 0; x < grid.getCols(); x++) 
            {
                PlayerColor tileColor = grid.getTileColor(x, y);
                // batch.setColor(tileColor); // Set the tile color
                switch (tileColor) 
                {
                    case RED:
                        batch.draw(tileTexture[1], x, y, 1, 1); // Draw each tile as 1x1 unit
                        
                        break;
                    
                    case WHITE:
                        batch.draw(tileTexture[2], x, y, 1, 1); // Draw each tile as 1x1 unit
                    
                    break;
                    
                    case GOLD:
                        batch.draw(tileTexture[3], x, y, 1, 1); // Draw each tile as 1x1 unit
                    
                    break;
                    
                    case BLUE:
                        batch.draw(tileTexture[4], x, y, 1, 1); // Draw each tile as 1x1 unit
                    
                    break;

                    case CYAN:
                    default:
                        batch.draw(tileTexture[0], x, y, 1, 1); // Draw each tile as 1x1 unit
                    
                        break;
                }

            }
        }
    }

    private void renderPlayer()
    {
        for (int i = 0; i < players.length; i++) 
        {
            batch.draw(bikeTexture[i], players[i].getXPosition(), players[i].getYPosition(), 1, 1);
        }

    }

    private void input() 
    {
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

    private void logic() 
    {
        // Add game logic here (e.g., updating tile states)
        float delta = Gdx.graphics.getDeltaTime();

        movementTimer += delta;

        if (movementTimer > .125f) 
        {
            movementTimer = 0;
            for (Player player : players) 
            {
                if (player.isAlive())       // Mark tile
                {
                    grid.setTileColor(player.getXPosition(), player.getYPosition(), player.getColor());    
                }
                player.updatePosition();        // Move player

                if (player.isStarted()) 
                {
                    switch (grid.getTileColor(player.getXPosition(), player.getYPosition())) 
                    {
                        case CYAN:
                            
                            break;

                        case BLACK:
                            player.reverse();
                    
                        default:
                            player.eliminate();
                            break;
                    }          
                }
            }
        }


    }

    @Override
    public void resize(int width, int height) 
    {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() 
    {
        
    }

    @Override
    public void resume() 
    {
        
    }

    @Override
    public void hide() 
    {

    }

    @Override
    public void dispose() 
    {
        // Dispose of resources
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
