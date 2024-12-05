import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private Player player;
    private Player dealer;
    private Deck deck;
    private Card card;
    String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] suit = {"clubs", "heart", "spades", "diamonds"};
    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    public Game() {
        Scanner user = new Scanner(System.in);
        System.out.println("Name: ");
        String name = user.nextLine();
        player = new Player(name);
        dealer = new Player("dealer");
        deck = new Deck(rank, suit, values);
        playGame();
    }

    public void printInstructions() {
        System.out.println("Welcome to Blackjack. The game is simple, " + "\n" +
            "try to get as close to 21 as possible without going over. " + "\n" +
                "You will compete against the dealer. Good luck!");
    }

    public int checkWin() {
        //dealer wins
        if (player.getPoints() > 21 || player.getPoints() < dealer.getPoints()) {
            return 3;
        }
        //player wins
        else if (dealer.getPoints() > 21 || player.getPoints() > dealer.getPoints()) {
            return 1;
        }
        //tie game
        else if (dealer.getPoints() == player.getPoints()) {
            return 2;
        }
        return 0;
    }

    public boolean shouldDealerHold() {
        if (dealer.getPoints() > 16) {
            return true;
        }
        return false;
    }

    public boolean playGame() {
        boolean firstPass = true;
        //boolean isHolding = false;
        printInstructions();
        System.out.println("Draw your first cards? (y/n): ");
        Scanner word = new Scanner(System.in);
        if (word.nextLine().equals("y")) {
            System.out.println();
            while(true) {
                //check if player is holding
                if (!player.getIsHolding()) {
                    if (firstPass == true) {
                        firstPass = false;
                        //(auto gets two cards) needs to be card class (don't know how to access this?)
                        player.getHand().add(deck.deal());
                        player.getHand().add(deck.deal());
                        dealer.getHand().add(deck.deal());
                        dealer.getHand().add(deck.deal());
                    }
                    else {
                        System.out.println("do you want to draw again?");
                        //if player wants to continue, if not the player holds
                        if ((word.nextLine()).equals("y")) {
                            System.out.print("\n");
                            //draws another card
                            player.getHand().add(deck.deal());
                        }
                        else {
                            player.setHold();
                        }
                    }
                    //don't ask the player for any more
                    if (player.getIsHolding()) {
                        break;
                    }
                }
                //check to see if dealer should still roll
                if (!dealer.getIsHolding())
                {
                    //dealer rolls
                    dealer.getHand().add(deck.deal());
                    //if the dealer's score is above 17, dealer doesn't roll; end game!
                    if (shouldDealerHold() == true) {
                        int winCondition = checkWin();
                        if (winCondition == 1) {
                            System.out.println("dealer wins!");
                            return true;
                        }
                        else if (winCondition == 2) {
                            System.out.println("tie game");
                            return true;
                        }
                        else if (winCondition == 3) {
                            System.out.println("player wins!!!");
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
