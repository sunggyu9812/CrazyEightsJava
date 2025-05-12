/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package visualparadigm.crazyeightgame;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sungg
 */
public class PlayerTest 
{
    private Player player;

    @Before
    public void setUp() 
    {
        player = new Player(1);  
    }

    @Test
    public void testaddCard() 
    {
        player.hand.add(new Card(1, Suit.Heart));
        assertEquals(1, player.hand.size());  
    }

    @Test
    public void testemptyHand() 
    {
        assertEquals(0, player.hand.size());  
    }
    @Test
    public void testPlayCardSavesEight() 
    {
        player.hand.add(new Card(8, Suit.Heart));
        player.hand.add(new Card(4, Suit.Spade));
        Card topCard = new Card(2, Suit.Spade);  
        Card played = player.playCard(topCard);
        assertEquals(4, played.rank);  
    }

    @Test
    public void testMostCommonSuit() 
    {
        player.hand.add(new Card(5, Suit.Club));
        player.hand.add(new Card(9, Suit.Club));
        player.hand.add(new Card(1, Suit.Spade));
        Suit suit = player.mostCommonSuit();
        assertEquals(Suit.Club, suit);  
    }
}