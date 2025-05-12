package visualparadigm.crazyeightgame;

import java.util.Random;
import java.util.ArrayList;

public class Deck 
{
    ArrayList<Card> cards;

    public Deck() 
    {
        cards = new ArrayList<>();
        startDeck();
    }

    void startDeck() 
    {
        for (Suit suit : Suit.values()) 
        {
            for (int rank = 1; rank <= 13; rank++) 
            {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() 
    {
        Random random = new Random();
        for (int count = 0; count < cards.size(); count++) 
        {
            int rndint = random.nextInt(cards.size());
            Card Swap = cards.get(count);
            cards.set(count, cards.get(rndint));
            cards.set(rndint, Swap);
        }
    }
}
