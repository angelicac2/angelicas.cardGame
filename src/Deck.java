import java.util.ArrayList;
import java.lang.Math;
public class Deck {
    private int cardsLeft;
    private ArrayList<Card> cards;

    public Deck(String[] rank, String[] suit, int[] pointValue) {
        cards = new ArrayList<Card>();
        for (int count = 0; count < suit.length; count++) {
            for (int i = 0; i < rank.length; i++) {
                //fix this
                cards.add(new Card(rank[i], suit[count], pointValue[i]));
            }
        }
        cardsLeft = cards.size();
        //shuffle cards here
        shuffle();
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
            return cards.get(--cardsLeft);
        }
    }

    public void shuffle() {
        cardsLeft = cards.size();
        for (int i = 0; i < cards.size(); i++) {
            //generates random value
            int r = (int) (Math.random() * (i + 1));
            // Swap cards at i and r
            Card temp = cards.get(i);
            cards.set(i, cards.get(r));
            cards.set(r, temp);
        }
    }
}
