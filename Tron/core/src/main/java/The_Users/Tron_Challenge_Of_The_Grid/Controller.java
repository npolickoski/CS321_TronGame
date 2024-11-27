// package The_Users.Tron_Challenge_Of_The_Grid;

// import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.Input;
// import com.badlogic.gdx.maps.Map;

// public class Controller 
// {
//     private int playerCount;

//     // Constructor
//     public Controller(int playerCount) 
//     {
//         this.playerCount = playerCount;
//     }
    
//     // Methods
//     public void handleInput(List<Player> players) 
//     {
//         for (int i = 1; i <= playerCount; i++) 
//         {
//             Map<String, Integer> controls = PlayerInputMapping.getControls(i);
            
//             Player player = players.get(i - 1); // Assuming players are in a list

//             if (Gdx.input.isKeyPressed(controls.get("UP"))) 
//             {
//                 player.move(Direction.UP);                          // TODO: Handle the projected position and, if valid, update
//             }
//             if (Gdx.input.isKeyPressed(controls.get("DOWN"))) 
//             {
//                 player.move(Direction.DOWN);
//             }
//             if (Gdx.input.isKeyPressed(controls.get("RIGHT"))) 
//             {
//                 player.move(Direction.RIGHT);
//             }
//             if (Gdx.input.isKeyPressed(controls.get("LEFT"))) 
//             {
//                 player.move(Direction.LEFT);
//             }
//         }
//     }
// }
