/**
 * The Game class represents a card game with multiple players and a deck.
 */
public class Game
{
    public Player[]     players; // Array of players in the game
    public Deck         deck; // Deck of cards used in the game
    public int          deckCount; // Number of cards drawn from the deck

     /**
     * Initializes a new game with players using the given names.
     * @param names Array of player names
     */
    public Game(String[] names)
    {
        deck = new Deck();
        deckCount = 0;
        players = new Player[names.length];
        for (int i = 0; i < names.length; i++)
        {
            players[i] = new Player(names[i], deck);
        }
    }
    /** Starts the game, looping through player turns until someone wins */
    public void start()
    {
        // Print each player's hand at the start
        for (Player p : players)
        {
            p.printHand();
            System.out.println();
        }
        Card top = deck.drawCard();
        deckCount++;
        System.out.println("(" + top + "):");
        int turn = 0;
        while (true)
        {
            Player current = players[turn];
            // Player plays if they have a matching card
            if (current.hasMatching(top))
            {
                Card play = current.playMatching(top);
                System.out.println(current.name + " has matching card in hand: " + play.rank + " *" + play.suit);
                top = play;
            }
            else
            {
                // Draw up to 3 cards to find a match
                boolean played = false;
                for (int d = 0; d < 3 && !played; d++)
                {
                    Card drawn = deck.drawCard();
                    if (drawn == null)
                    {
                        System.out.println("Deck is empty. No more cards to draw.");
                        break;
                    }
                    System.out.println(current.name + " drew card from deck " + (++deckCount) + " (" + drawn + ")");
                    current.drawCard(drawn);
                    if (drawn.rank == top.rank || drawn.suit == top.suit)
                    {
                        System.out.println("Card now matches: " + drawn.rank + " *" + drawn.suit);
                        top = drawn;
                        played = true;
                    }
                }
                if (!played)
                {
                    System.out.println("No suitable card after 3 draws");
                }
            }
            // Check if current player has emptied their hand (wins)
            if (current.isEmpty())
            {
                System.out.println("********** " + current.name + " won ***********");
                break;
            }
            System.out.println("(" + top + "):");
            turn = (turn + 1) % players.length;
        }
    }
}