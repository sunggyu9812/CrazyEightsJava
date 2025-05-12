package visualparadigm.crazyeightgame;

import java.util.Scanner;
import java.util.Stack;

public class Game 
{
    Deck deck;
    Stack<Card> discardPile = new Stack<>();
    Player[] players;
    Card topCard;
    int playerinfo;

    public Game() 
    {
        deck = new Deck();
        players = new Player[4];
        for (int i = 0; i < 4; i++) 
        {
            players[i] = new Player(i + 1);
        }
        playerinfo = 0;
    }

    public void dealCards() 
    {
        for (int i = 0; i < 5; i++) 
        {
            for (Player player : players) 
            {
                if (deck.cards.size() > 0)  
                {
                    player.hand.add(deck.cards.remove(0));
                }
            }
        }
        topCard = deck.cards.remove(0);
        System.out.println("Top card: " + topCard);
    }

    public void startGame() 
    {
        System.out.println("Crazy Eight Game Begins!");
        playGame();
    }

    public void playGame() 
    {
        while (true) 
        {
            Player player = players[playerinfo];
            System.out.println("\nPlayer " + player.id + " turn");
            System.out.println("Top card: " + topCard);
            player.hand();

            Card played = player.playCard(topCard);
            int drawCount = 0;

            while (played == null && drawCount < 3) 
            {
                if (deck.cards.isEmpty()) 
                {
                    if (!discardPile.isEmpty()) 
                    {
                        System.out.println("Reshuffling discard pile into deck...");
                        while (!discardPile.isEmpty()) 
                        {
                            deck.cards.add(discardPile.pop());
                        }
                        deck.shuffle();
                    } 
                    else 
                    {
                        System.out.println("Deck and discard pile are empty.");
                        break;
                    }
                }
                Card drawn = deck.cards.remove(0);
                System.out.println("Player " + player.id + " draws: " + drawn);
                player.hand.add(drawn);
                drawCount++;
                played = player.playCard(topCard);
            }

            if (played != null) 
            {
                System.out.println("Player " + player.id + " plays: " + played);
                discardPile.push(topCard);
                topCard = played;

                if (played.rank == 8) 
                {
                    Suit chosenSuit = player.mostCommonSuit();
                    System.out.println("Player " + player.id + " chooses suit: " + chosenSuit);
                    topCard = new Card(8, chosenSuit);
                }
            }
            else if (drawCount >= 3)
            {
                System.out.println("Player " + player.id + " skips turn.");
            }

            if (player.hand.isEmpty()) 
            {
                System.out.println("\nPlayer " + player.id + " wins, Congratulations!");
                break;
            }

            playerinfo = (playerinfo + 1) % players.length;
        }
    }

    public void showHand() 
    {
        for (Player player : players) 
        {
            player.hand();
        }
    }
}
