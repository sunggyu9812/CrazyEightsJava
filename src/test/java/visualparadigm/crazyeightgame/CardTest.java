/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package visualparadigm.crazyeightgame;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sungg
 */
public class CardTest 
{   
    @Test
    public void testtoString() 
    {
        Card card = new Card(1, Suit.Heart);
        assertEquals("1 Heart", card.toString());  
    }

}