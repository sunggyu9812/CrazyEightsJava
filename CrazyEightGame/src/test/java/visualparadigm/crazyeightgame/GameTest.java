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
public class GameTest 
{
    private Game game;

    @Before
    public void setUp() 
    {
        game = new Game();  
        game.deck.shuffle();
    }

    @Test
    public void testdealCards() 
    {
        System.out.println("Testing dealCards()");
        game.dealCards();

        int expectedDeckSize = 52 - (4 * 5) - 1;
        assertEquals(expectedDeckSize, game.deck.cards.size());

        for (Player player : game.players) 
        {
            assertEquals(5, player.hand.size());
        }
    }

    @Test
    public void testshowHand() 
    {
        System.out.println("Testing showHand()");
        game.dealCards();  
        game.showHand();  
    }
}