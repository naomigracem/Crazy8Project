/**
 * The Card class represents a playing card with a rank and suit.
 */

public class Card
{
    public int      rank; // 1–13, where 1 = Ace, 11 = Jack, etc.
    public int      suit; // 0 = Clubs, 1 = Diamonds, 2 = Hearts, 3 = Spades
    
    /**
    * Creates a card with the specified rank and suit.
     * @param rank Rank of the card (1–13)
    * @param suit Suit of the card (0 = Clubs, 1 = Diamonds, 2 = Hearts, 3 = Spades)
    */
    public Card(int rank, int suit)
    {
        this.rank = rank;
        this.suit = suit;
    }
    @Override
    public String toString()
    {
        return rank + " " + suit;
    }
}