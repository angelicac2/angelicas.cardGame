import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private Player player;
    private Player dealer;
    private Deck hand;
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
        hand = new Deck(rank, suit, values);
        hand.shuffle();
    }

    public void printInstructions() {
        System.out.println("Welcome to Blackjack. The game is simple, " + "\n" +
            "try to get as close to 21 as possible without going over. " + "\n" +
                "You will compete against the dealer. Good luck!");
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
                        card = new Card(Deck.rank)
                        System.out.println(card.toString());
                    }
                    else {
                        System.out.println("do you want to draw again?");
                        //if player wants to continue, if not the player holds
                        if ((word.nextLine()).equals("y")) {
                            //player draws
                            System.out.print("\n");
                            //draws another card
                            playerRolls(myDie, you);
                        }
                        else {
                            player.setHold();
                        }
                    }
                    if (player.getIsHolding()) {
                        break;
                    }
                }
                //check to see if dealer should still roll
                if (!dealer.getIsHolding())
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
