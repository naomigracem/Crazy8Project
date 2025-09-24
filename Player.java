/**
 * The Player class represents a player in the card game.
 */
public class Player
{
    public String   name; // Player's name
    public Card[]   hand; // Cards currently in the player's hand
    public int      handSize; // Number of cards in hand
    
     /**
     * Creates a player and draws an initial hand of 5 cards from the deck.
     * @param name Player's name
     * @param deck Deck to draw cards from
     */
    public Player(String name, Deck deck)
    {
        this.name = name;
        hand = new Card[52];
        handSize = 0;
        for (int i = 0; i < 5; i++)
        {
            hand[handSize++] = deck.drawCard();
        }
    }

    /** Prints the player's hand */
    public void printHand()
    {
        System.out.println(name + ":");
        for (int i = 0; i < handSize; i++)
        {
            System.out.println("  ." + hand[i]);
        }
    }
    /** Returns true if the player has a card matching the top card's rank or suit */
    public boolean hasMatching(Card top)
    {
        for (int i = 0; i < handSize; i++)
        {
            if (hand[i].rank == top.rank || hand[i].suit == top.suit)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Plays a matching card from the hand and removes it.
     * @param top Card to match
     * @return the played card, or null if no match
     */
    public Card playMatching(Card top)
    {
        for (int i = 0; i < handSize; i++)
        {
            if (hand[i].rank == top.rank || hand[i].suit == top.suit)
            {
                Card play = hand[i];
                hand[i] = hand[--handSize]; // Replace played card with last card in hand
                return play;
            }
        }
        return null;
    }

    /** Adds a card to the player's hand */
    public void drawCard(Card card)
    {
        hand[handSize++] = card;
    }

    /** Returns true if the player has no cards left */
    public boolean isEmpty()
    {
        return handSize == 0;
    }
}