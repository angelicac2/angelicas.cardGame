import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GameView extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    //initialize all 52 cards
    private Image titlePage;
    private Image instructions;
    private Image scorePage;
    private Game backend;

    public GameView(Game backend) {
        titlePage = new ImageIcon("Resources/titlepage.png").getImage();
        instructions = new ImageIcon("Resources/instructions.png").getImage();
        scorePage = new ImageIcon("Resources/defaultscorepage.png").getImage();
        this.backend = backend;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Blackjack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        int state = Game.getState();
        switch (state) {
            case 0:
                g.drawImage(titlePage, 0, 0, this);
            case 1:
                g.drawImage(instructions, 0, 0, this);
            case 2:
                g.drawImage(scorePage, 0, 0, this);
        }
    }
}
