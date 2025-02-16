import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
        if (state == 0) {
            g.drawImage(titlePage, 0, 0, this);
        }
        else if (state == 1) {
            g.drawImage(instructions, 0, 0, this);
        }
        else if (state == 2) {
            g.drawImage(scorePage, 0, 0, this);
            drawScorePage(g);
        }
    }

    public void drawScorePage(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(498, 0, 4, 800);
        // Print everyones points
        g.setFont(new Font("Algerian", Font.BOLD, 100));
        g.drawString(String.valueOf(backend.getPlayerPoints()), 300, 715);
        g.drawString(String.valueOf(backend.getDealerPoints()), 800, 715);

        ArrayList<Card> playerCards = backend.getPlayerCards();
        ArrayList<Card> dealerCards = backend.getDealerCards();

        for (int i = 0; i < playerCards.size(); i++) {
            g.drawImage(playerCards.get(i).getCardImage(), 50 + i * 100, 50 + i * 100, 100, 150, this);
        }
        for (int i = 0; i < dealerCards.size(); i++) {
            g.drawImage(dealerCards.get(i).getCardImage(), 550 + i * 100, 50 + i * 100, 100, 150, this);
        }
    }
}
