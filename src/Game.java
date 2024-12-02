import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private Player player;
    private Deck deck;
    public Game() {
        Scanner user = new Scanner(System.in);
        System.out.println("Name: ");
        String name = user.nextLine();
        player = new Player(name);
        deck = new Deck(
                new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        //deal user their hand
    }

    public void printInstructions() {
        System.out.println("Welcome to Blackjack. The game is simple, " + "\n" +
            "try to get as close to 21 as possible without going over. " + "\n" +
                "You will compete against the dealer. Good luck!");
    }

    public boolean playGame() {
        printInstructions();
        System.out.println("Do you want another card? (y/n): ");
        Scanner word = new Scanner(System.in);
        if (word.nextLine().equals("y")) {
            System.out.println();
            while(true) {
                //check if player is holding
                if (you.getIsHolding() == false) {
                    if (firstPass == true) {
                        firstPass = false;
                        playerRolls(myDie, you);
                    }
                    else {
                        System.out.println("do you want to roll again" +
                                "(y or n): ");
                        //if player wants to continue, if not the player holds
                        if ((word.nextLine()).equals("y")) {
                            //player rolls
                            System.out.print("\n");
                            playerRolls(myDie, you);
                        }
                        else {
                            you.setHold();
                        }
                    }
                    if () {
                        break;
                    }
                }
                //check to see if dealer should still roll
                if (dealer.getIsHolding() == false)
                {
                    //dealer rolls
                    gameRolls(myDie, dealer);
                    if (dealer.isBusted() == true) {
                        System.out.print("\n");
                        System.out.println("dealer busted");
                        break;
                    }
                    //if the dealer's score is above 16, dealer doesn't roll
                    dealer.shouldDealerHold();
                }
                //ending of game - check to see score of both player and dealer
                if (finalMessage(you.getIsHolding(), dealer.getIsHolding(), you.getScore(), dealer.getScore()) == true)
                {
                    break;
                }
            }
        }
    }
    }
    */
}
