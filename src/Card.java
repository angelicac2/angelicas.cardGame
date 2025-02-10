import java.awt.*;
public class Card {
    private String rank;
    private String suit;
    private int value;
    private Image cardImage;

    public Card(String rank, String suit, int value, Image cardImage) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    public String rank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return value + " of " + suit;
    }
}
