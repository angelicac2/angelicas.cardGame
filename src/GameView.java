import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    //initialize all 52 cards
    private Image imageX;
    private Image imageO;
    private Game backend;

    public GameView(Game backend) {
        this.backend = backend;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Blackjack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        //
    }
}
