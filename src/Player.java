import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> card = new ArrayList<Card>();
    private int points;

    public Player(String name) {
        points = 0;
    }

    public Player(String name, ArrayList<Card> hand) {
        points = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int valuePoints) {
        points += valuePoints;
    }

    public void addCard(Card newCard) {
        hand.add(newCard);
    }

    public String toString() {
        return name + " has " + points + "\n" + name + "'s cards: " + hand;
    }
}
