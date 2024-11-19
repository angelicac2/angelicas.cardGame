public class Player {
    ArrayList<String> hand = new ArrayList<String>();
    ArrayList<Integer> points = new ArrayList<Integer>();

    public Player(String name) {
        points = 0;
    }

    public Player(String name, ArrayList<String> hand) {
        points = 0;
    }

    public ArrayList<String> getHand() {
        return hand;
    }

    public void setHand(ArrayList<String> hand) {
        this.hand = hand;
    }

    public ArrayList<Integer> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Integer> points) {
        this.points = points;
    }

    public void addPoints(int valuePoints) {
        points.add(valuePoints);
    }

    public void addCard(String newCard) {
        hand.add(newCard);
    }

    public String toString()
}
