// package The_Users.Grid;

// import com.badlogic.gdx.graphics.g2d.SpriteBatch;
// import com.badlogic.gdx.graphics.Color;
// import com.badlogic.gdx.graphics.Texture;
// import com.badlogic.gdx.graphics.g2d.TextureRegion;

// import java.util.HashSet;
// import java.util.Set;

// // public class Grid {
// //     private Tile[][] tiles;
// //     private int rows, cols;
// //     private int tileSize;
// //     private TextureRegion tileTexture;
// //     private Set<Tile> updatedTiles;

// //     public Grid(int rows, int cols, int tileSize, Texture texture) {
// //         this.rows = rows;
// //         this.cols = cols;
// //         this.tileSize = tileSize;

// //         // Create a TextureRegion from the provided texture
// //         this.tileTexture = new TextureRegion(texture);

// //         // Initialize tiles
// //         tiles = new Tile[rows][cols];
// //         updatedTiles = new HashSet<>();
// //         for (int y = 0; y < rows; y++) {
// //             for (int x = 0; x < cols; x++) {
// //                 tiles[y][x] = new Tile(x, y);
// //             }
// //         }
// //     }

// //     public Tile getTile(int x, int y) {
// //         if (x >= 0 && x < cols && y >= 0 && y < rows) {
// //             return tiles[y][x];
// //         }
// //         return null; // Out of bounds
// //     }

// //     public void setTileColor(int x, int y, Color color) {
// //         Tile tile = getTile(x, y);
// //         if (tile != null) {
// //             tile.setColor(color);
// //             updatedTiles.add(tile); // Mark tile for re-rendering
// //         }
// //     }

// //     public void render(SpriteBatch batch) {
// //         // Render all tiles initially
// //         for (int y = 0; y < rows; y++) {
// //             for (int x = 0; x < cols; x++) {
// //                 Tile tile = tiles[y][x];
// //                 batch.setColor(tile.getColor());
// //                 batch.draw(tileTexture, tile.getX() * tileSize, tile.getY() * tileSize, tileSize, tileSize);
// //             }
// //         }
// //     }

// //     public void renderUpdatedTiles(SpriteBatch batch) {
// //         // Render only the tiles marked for update
// //         for (Tile tile : updatedTiles) {
// //             batch.setColor(tile.getColor());
// //             batch.draw(tileTexture, tile.getX() * tileSize, tile.getY() * tileSize, tileSize, tileSize);
// //         }
// //         updatedTiles.clear(); // Clear the set after updates
// //     }
// // }


// public class Grid {
//     private Tile[][] tiles;
//     private int rows, cols;
//     private Texture tileTexture;

//     public Grid(int rows, int cols, Texture texture) {
//         this.rows = rows;
//         this.cols = cols;
//         this.tileTexture = texture;

//         tiles = new Tile[rows][cols];
//         for (int y = 0; y < rows; y++) {
//             for (int x = 0; x < cols; x++) {
//                 tiles[y][x] = new Tile(x, y);
//             }
//         }
//     }

//     public void render(SpriteBatch batch) {
//         for (int y = 0; y < rows; y++) {
//             for (int x = 0; x < cols; x++) {
//                 Tile tile = tiles[y][x];
//                 batch.setColor(tile.getColor());
//                 batch.draw(tileTexture, tile.getX(), tile.getY(), 1, 1); // 1x1 logical units
//             }
//         }
//     }

//     public Tile getTile(int x, int y) {
//         if (x >= 0 && x < cols && y >= 0 && y < rows) {
//             return tiles[y][x];
//         }
//         return null; // Out of bounds
//     }

//     public void setTileColor(int x, int y, Color color) {
//         Tile tile = getTile(x, y);
//         if (tile != null) {
//             tile.setColor(color);
//         }
//     }
// }

package The_Users.Grid;

import com.badlogic.gdx.graphics.Color;
import The_Users.Player.PlayerColor;

public class Grid {
    private Tile[][] tiles;
    private int rows, cols;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        // Initialize tiles
        tiles = new Tile[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                tiles[y][x] = new Tile(x, y);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public PlayerColor getTileColor(int x, int y) {
        if (x >= 0 && x < cols && y >= 0 && y < rows) {
            return tiles[y][x].getColor();
        }
        return PlayerColor.BLACK; // Default for out-of-bounds
    }

    public void setTileColor(int x, int y, PlayerColor color) {
        if (x >= 0 && x < cols && y >= 0 && y < rows) {
            tiles[y][x].setColor(color);
        }
    }
}
