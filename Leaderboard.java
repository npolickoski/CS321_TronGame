/**
 * The Leaderboard class ranks players based on their performance during the game.
 * Specifically, it tracks the players' duration of survival and ranks them accordingly.
 *
 * Collaborators:
 * - Lobby
 * - Grid
 * - Database
 */

class Player{
    private String player_name; //Player names

    private double player_time;  // Time player had

    public Player(String player_name, double player_time) {
        this.player_name = player_name;
        this.player_time = player_time;
    }

    public String getPlayerName() {
        return player_name; // Method accesses the player name
    }
    
    public double getPlayerTime() {
        return player_time; // This gets the player time
    }

public class Leaderboard 
{
    private Player[] players;
    private int playerCount;

    private static final int leaderboardCapacity = 10;

    public Leaderboard(){
        
        players = new Player[leaderboardCapacity];
        playerCount = 0;
    }

    public void addPlayer(String player_name, double player_time){
        if (playerCount<players.length) {
            players[playerCount] = new Player (player_name, player_time);
            playerCount ++;
        }
        else{
            leaderboardCapacity ++;
            System.out.println("Leaderboard Is full currently, try again");
        }
    }

    public Player[] playerRankings() {
        // Bubble sort:
        for (int i = 0; i < playerCount - 1; i++){
            for (int j = 0; j < playerCount - 1 - i ; j++){
                if (players[j].getPlayerTime() < players[j+1].getPlayerTime()){
                    Player temp  = players[j];
                    players[j] = players[j+1];
                    players[j+1] = temp;
                }
            }
        }
        return players;
    }
    public void showLeaderboard(){
        // For the leaderboard display
    }
}
