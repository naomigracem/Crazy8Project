/**
 * The Deck class represents a standard deck of 52 playing cards.
 */
public class Deck
{
    public Card[]   cards; // Array holding all cards in the deck
    public int      top; // Index of the top card in the deck

    /**
    * Creates a standard 52-card deck, initializes the cards,
    * sets the top card index, and shuffles the deck.
    */
    public Deck()
    {
        cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit < 4; suit++)
        {
            for (int rank = 0; rank < 13; rank++)
            {
                cards[index++] = new Card(rank, suit);
            }
        }
        top = 51;
        shuffle(); // Shuffle deck on initialization
    }

    /** Shuffles the deck using Fisher-Yates algorithm */
    public void shuffle()
    {
        for (int i = cards.length - 1; i > 0; i--)
        {
            int j = (int)(Math.random() * (i + 1));
            Card temp   = cards[i];
            cards[i]    = cards[j];
            cards[j]    = temp;
        }
    }

    /** Draws the top card from the deck, returns null if empty */
    public Card drawCard()
    {
        if (top >= 0)
        {
            return cards[top--];
        }
        else
        {
            return null;
        }
    }
}