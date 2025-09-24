/**
 * The Crazy8 class is an entry point for the Crazy 8 card game.
 */
public class Crazy8
{

    public static void main(String[] args)
    {
        // Names of players participating in the game
        String[] players = {"Anand", "Bobby", "Chuck", "David"};
        
        // Creates a new game with the players and starts it
        Game game = new Game(players);
        game.start();
    }
}