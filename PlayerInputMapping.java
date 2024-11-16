public class PlayerInputMapping 
{
    private static final Map<Integer, Map<String, Integer>> playerControls = new HashMap<>();

    static {
        // Player 1 Controls
        Map<String, Integer> player1Controls = new HashMap<>();
        player1Controls.put("UP", Input.Keys.W);
        player1Controls.put("LEFT", Input.Keys.A);
        player1Controls.put("DOWN", Input.Keys.S);
        player1Controls.put("RIGHT", Input.Keys.D);
        playerControls.put(1, player1Controls);

        // Player 2 Controls
        Map<String, Integer> player2Controls = new HashMap<>();
        player2Controls.put("UP", Input.Keys.I);
        player2Controls.put("LEFT", Input.Keys.J);
        player2Controls.put("DOWN", Input.Keys.K);
        player2Controls.put("RIGHT", Input.Keys.L);
        playerControls.put(2, player2Controls);

        // Player 3 Controls
        Map<String, Integer> player3Controls = new HashMap<>();
        player3Controls.put("UP", Input.Keys.UP);
        player3Controls.put("LEFT", Input.Keys.LEFT);
        player3Controls.put("DOWN", Input.Keys.DOWN);
        player3Controls.put("RIGHT", Input.Keys.RIGHT);
        playerControls.put(3, player3Controls);

        // Player 4 Controls
        Map<String, Integer> player4Controls = new HashMap<>();
        player4Controls.put("UP", Input.Keys.T);
        player4Controls.put("LEFT", Input.Keys.F);
        player4Controls.put("DOWN", Input.Keys.G);
        player4Controls.put("RIGHT", Input.Keys.H);
        playerControls.put(4, player4Controls);
    }

    public static Map<String, Integer> getControls(int playerNumber) 
    {
        return playerControls.get(playerNumber);
    }
}

