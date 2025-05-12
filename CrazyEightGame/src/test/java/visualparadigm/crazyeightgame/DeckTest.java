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
public class DeckTest 
{
    private Deck deck;

    @Before
    public void setUp() 
    {
        deck = new Deck();  
    }

    @Test
    public void teststartDeck() 
    {
        assertEquals(52, deck.cards.size());  
    }

    @Test
    public void testshuffle() 
    {
        Deck unshuffled = new Deck();
        deck.shuffle();
        assertNotEquals(unshuffled.cards.toString(), deck.cards.toString()); 
    }
}