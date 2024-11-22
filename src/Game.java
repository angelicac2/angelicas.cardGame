import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private String players;
    private ArrayList<Card> cards;
    private ArrayList<Deck> deck;

    public Game(String name, ArrayList<Card> card, ArrayList<Deck> deck) {
        Scanner user = new Scanner(System.in);
        System.out.println("Name: ");
        this.players = user.nextLine();
        this.cards = new ArrayList<Card>();
        this.deck = new ArrayList<Deck>();
    }

    public void printInstructions() {
        System.out.println("Welcome to Blackjack. The game is simple, " + "\n" +
            "try to get as close to 21 as possible without going over. " + "\n" +
                "You will compete against the dealer. Good luck!");
    }

    /*
    public boolean playGame() {
        //logic for winning and losing
    }
    */
}
