import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int points;
    private boolean holding;

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
        int handPoints = 0;
        for (int i = 0; i < hand.size(); i++) {
            handPoints+= (hand.get(i).getValue());
        }
        return handPoints;
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

    public void setHold() {
        holding = true;
    }

    public boolean getIsHolding() {
        return holding;
    }

    public String toString() {
        return name + " has " + points + "\n" + name + "'s cards: " + hand;
    }
}
