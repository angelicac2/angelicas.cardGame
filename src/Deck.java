import java.util.ArrayList;
import java.lang.Math;
public class Deck {
    private int cardsLeft;
    private ArrayList<Card> cards;

    public Deck(String[] rank, String[] suit, int[] pointValue) {
        cards = new ArrayList<Card>();
        for (int count : suits) {
            for (int i = 0; i < rank.length; i++) {
                Card cards = new Card(rank[i], suit, value[i]);
            }
        }
        cardsLeft = cards.size();
        //shuffle cards here
    }
    public boolean isEmpty() {
        if (cardsLeft == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal() {
        if (isEmpty()) {
            return null;
        }
        else {
            cardsLeft--;
            return cards.get(cardsLeft);
        }
    }

    public void shuffle() {
        cardsLeft = cards.size();
        int r = (int) Math.random(cards.size());
        //finish this thing
    }
}
