import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private Scanner frontScanner = new Scanner(System.in);
    private GameView window;
    private Player player;
    private Player dealer;
    private Deck deck;
    private Card card;
    public static final int WELCOME = 0;
    public static final int INSTRUCTIONS = 1;
    public static final int PLAYING = 2;
    private static int state = 0;
    private int ifWin = 0;
    private boolean printedWin;
    String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] suit = {"spades", "hearts", "diamonds", "clubs"};
    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    // Constructor for game called in main
    public Game() {
        window = new GameView(this);
        player = new Player("player");
        dealer = new Player("dealer");
        deck = new Deck(rank, suit, values);
        printedWin = false;
        window.repaint();
        playGame();
    }

    // State of win status for front end
    public static int getState() {
        return state;
    }

    public void titlePage() {
        System.out.println("Blackjack by Angelica Chou (press enter to continue)");
    }

    public void printInstructions() {
        state = INSTRUCTIONS;
        System.out.println("Welcome to Blackjack. The game is simple, " + "\n" +
            "try to get as close to 21 as possible without going over. " + "\n" +
                "You will compete against the dealer. Good luck! (press enter to continue)");
        window.repaint();
    }

    public int checkPoints() {
        // Player busts && dealer is higher than player and both holding
        if (player.getPoints() > 21) {
            if (printedWin == false) {
                System.out.println("player busted.");
            }
            printedWin = true;
            return 3;
        }
        // Both are holding, dealer is greater than player
        else if (player.getIsHolding() == true && dealer.getIsHolding() == true && player.getPoints() < dealer.getPoints()) {
            if (printedWin == false) {
                System.out.println("Player has " + player.getPoints() + " and dealer has " + dealer.getPoints());
            }
            printedWin = true;
            return 4;
        }
        // Player wins bc dealer busts
        else if (dealer.getPoints() > 21) {
            if (printedWin == false) {
                System.out.println("dealer busted.");
            }
            printedWin = true;
            return 1;
        }
        // Both are holding, player wins with more points
        else if (player.getIsHolding() == true && dealer.getIsHolding() == true && player.getPoints() > dealer.getPoints()) {
            if (printedWin == false) {
                System.out.println("Player has " + player.getPoints() + " and dealer has " + dealer.getPoints());
            }
            printedWin = true;
            return 5;
        }
        // Tie game
        else if (player.getIsHolding() == true && dealer.getIsHolding() == true && dealer.getPoints() == player.getPoints()) {
            if (printedWin == false) {
                System.out.println("Player has " + player.getPoints() + " and dealer has " + dealer.getPoints());
            }
            printedWin = true;
            return 2;
        }
        window.repaint();
        return 0;
    }

    // Dealer's points getter for front end
    public int getDealerPoints() {
        return dealer.getPoints();
    }

    // Players points getter for front end
    public int getPlayerPoints() {
        return player.getPoints();
    }

    // Dealer hand getter for front end
    public ArrayList<Card> getDealerCards() {
        return dealer.getHand();
    }

    // Player hand getter for front end
    public ArrayList<Card> getPlayerCards() {
        return player.getHand();
    }

    // Final messages, end game
    public boolean checkWin() {
        int winCondition = checkPoints();
        if (winCondition == 1 || winCondition == 5) {
            System.out.println("player wins!");
            return true;
        }
        else if (winCondition == 2) {
            System.out.println("tie game");
            return true;
        }
        else if (winCondition == 3 || winCondition == 4) {
            System.out.println("dealer wins!!!");
            return true;
        }
        return false;
    }

    // Dealer holds when points reach greater than 17
    public boolean shouldDealerHold() {
        if (dealer.getPoints() > 17) {
            return true;
        }
        return false;
    }

    // If the game has reached a point where a win is being calculated, tell the front end
    public int getIfWin() {
        return this.ifWin;
    }

    // Main function to run actions of game
    public boolean playGame() {
        titlePage();
        while (!(frontScanner.nextLine().equals(""))) {}
        printInstructions();
        while (!(frontScanner.nextLine().equals(""))) {}
        state = PLAYING;
        window.repaint();
        // First pass, immediately draw two cards
        boolean firstPass = true;
        boolean answer = true;
        Scanner word = new Scanner(System.in);
        // Print instructions
        do {
            System.out.println("Draw your first cards? (y/n): ");
        } while (!word.nextLine().equals("y"));
            window.repaint();
            System.out.println();
            while(true) {
                // Check if player is holding
                if (!player.getIsHolding()) {
                    if (firstPass == true) {
                        firstPass = false;
                        // On the first pass, auto draw two cards
                        for (int i = 1; i < 3; i++) {
                            // Add cards to player hand
                            player.getHand().add(deck.deal());
                            System.out.println("your card #" + i + ": " + player.getHand().get(i - 1).toString());
                        }
                        System.out.println("your points: " + player.getPoints());
                        // Dealer draws two cards as well
                        for (int i = 1; i < 3; i++) {
                            dealer.getHand().add(deck.deal());
                            System.out.println("dealer card #" + i + ": " + dealer.getHand().get(i - 1).toString());
                        }
                        System.out.println("dealer's points: " + dealer.getPoints());
                        window.repaint();
                    }
                    // Continuing the game beyond first round
                    if (firstPass == false) {
                        while (answer == true) {
                            System.out.println("do you want to draw again? (y/n)");
                            // If player wants to continue, if not the player holds
                            if ((word.nextLine()).equals("y")) {
                                int count = (player.getHand().size() - 1) + 2;
                                System.out.print("\n");
                                // Draws another card
                                player.getHand().add(deck.deal());
                                // Accessing card from player's hand
                                System.out.println("your card #" + count + ": " + player.getHand().get(player.getHand().size() - 1).toString());
                                System.out.println("your points: " + player.getPoints());
                                // Checking to see if player's points are greater than 21, if it is, break out of loop
                                if (player.getPoints() > 21) {
                                    break;
                                }
                            }
                            // Setting player hold (player types no), doesn't ask player to draw more cards
                            else {
                                player.setHold();
                                answer = false;
                            }
                            window.repaint();
                        }
                        // Break out of larger loop
                        if (player.getPoints() > 21) {
                            if (checkWin() == true) {
                                // When checking win is sensed, tell front end
                                ifWin = 1;
                                window.repaint();
                                break;
                            }
                        }
                        window.repaint();
                    }
                    // Don't ask the player for anymore cards
                    if (player.getIsHolding()) {
                        // If the dealer is holding, check win
                        if (dealer.getIsHolding() == true) {
                            if (checkWin() == true) {
                                ifWin = 1;
                                window.repaint();
                                break;
                            }
                        }
                    }
                    window.repaint();
                }
                // Check to see if dealer should still roll if dealer isn't holding
                if (!dealer.getIsHolding() && firstPass == false)
                {
                    int countDealer = (dealer.getHand().size() - 1) + 2;
                    // Dealer rolls
                    dealer.getHand().add(deck.deal());
                    System.out.println("dealer card #" + countDealer + ": " + dealer.getHand().get(dealer.getHand().size() - 1).toString());
                    System.out.println("dealer's points: " + dealer.getPoints());
                    // Dealer busts if over 21
                    if (dealer.getPoints() > 21) {
                        if (checkWin() == true) {
                            ifWin = 1;
                            window.repaint();
                            break;
                        }
                    }
                    // If the dealer's score is above 17, dealer doesn't roll; end game!
                    if (shouldDealerHold() == true) {
                        System.out.println("the dealer is holding.");
                        dealer.setHold();
                        if (checkWin() == true) {
                            ifWin = 1;
                            window.repaint();
                            break;
                        }
                    }
                }
                window.repaint();
            }
        return true;
    }
}
