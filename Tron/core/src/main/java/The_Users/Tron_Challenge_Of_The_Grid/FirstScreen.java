
package The_Users.Tron_Challenge_Of_The_Grid;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.math.Vector3;

import The_Users.Grid.Grid;
import The_Users.Player.PlayerColor;

public class FirstScreen implements Screen 
{
    private int                 gridSize = 50;
    private Grid                grid;
    private SpriteBatch         batch;
    private Texture[]           tileTexture;
    private Texture[]           bikeTexture;
    private OrthographicCamera  camera;
    private FitViewport         viewport;

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
        batch.draw(tileTexture[1], 0, 0, 1, 1); // Draw each tile as 1x1 unit
        batch.draw(tileTexture[2], 0, gridSize - 1, 1, 1); // Draw each tile as 1x1 unit
        batch.draw(tileTexture[3], gridSize - 1, gridSize - 1, 1, 1); // Draw each tile as 1x1 unit
        batch.draw(tileTexture[4], gridSize - 1, 0, 1, 1); // Draw each tile as 1x1 unit
        batch.draw(bikeTexture[0], 0, 0, 1, 1); // Draw each bike as 1x1 unit
        batch.draw(bikeTexture[1], 0, gridSize - 1, 1, 1); // Draw each bike as 1x1 unit
        batch.draw(bikeTexture[2], gridSize - 1, gridSize - 1, 1, 1); // Draw each bike as 1x1 unit
        batch.draw(bikeTexture[3], gridSize - 1, 0, 1, 1); // Draw each bike as 1x1 unit
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

    private void input() 
    {
        if (Gdx.input.isTouched()) 
        {
            // Convert screen coordinates to grid coordinates
            Vector3 touchPos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            int gridX = (int) touchPos.x;
            int gridY = (int) touchPos.y;

            // Update the corresponding tile
            grid.setTileColor(gridX, gridY, PlayerColor.RED);
        }
    }

    private void logic() 
    {
        // Add game logic here (e.g., updating tile states)
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
