package visualparadigm.crazyeightgame;

public class Card 
{
    int rank;
    Suit suit;

    public Card(int rank, Suit suit) 
    {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() 
    {
        return rank + " " + suit.name();
    }
}
