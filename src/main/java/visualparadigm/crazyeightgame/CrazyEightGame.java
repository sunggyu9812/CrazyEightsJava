/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package visualparadigm.crazyeightgame;

/**
 *
 * @author Sunggyu Kang
 */
public class CrazyEightGame 
{

    public static void main(String[] args) 
    {
        Game game = new Game();
        game.deck.shuffle();
        game.dealCards();
        game.startGame();
    }
}
