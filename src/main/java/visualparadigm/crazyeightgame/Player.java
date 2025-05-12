package visualparadigm.crazyeightgame;

import java.util.ArrayList;

public class Player 
{
    ArrayList<Card> hand;
    int id;

    public Player(int id) 
    {
        this.id = id;
        hand = new ArrayList<>();
    }

    public void hand() 
    {
        System.out.println("Player " + id + " hand: " + hand);
    }
    
    public Card playCard(Card topCard) 
    {
        Card eight = null;

        for (Card card : hand) 
        {
            if (card.rank == topCard.rank || card.suit == topCard.suit) 
            {
                hand.remove(card);
                return card;
            } 
            else if (card.rank == 8 && eight == null) 
            {
                eight = card;
            }
        }

        if (eight != null) 
        {
            hand.remove(eight);
            return eight;
        }

        return null;
    }

    public Suit mostCommonSuit() 
    {
        int[] counts = new int[Suit.values().length];

        for (Card card : hand) 
        {
            counts[card.suit.ordinal()]++;
        }

        System.out.println("Suit counts for Player " + id + ": "
        + "Spade=" + counts[Suit.Spade.ordinal()] + ", "
        + "Club=" + counts[Suit.Club.ordinal()] + ", "
        + "Diamond=" + counts[Suit.Diamond.ordinal()] + ", "
        + "Heart=" + counts[Suit.Heart.ordinal()]);

        int maxIndex = 0;
        for (int i = 1; i < counts.length; i++) 
        {
            if (counts[i] > counts[maxIndex]) 
            {
                maxIndex = i;
            }
        }

        return Suit.values()[maxIndex];
    }
}
