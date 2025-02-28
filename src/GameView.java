import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameView extends JFrame {
    // Initialize the size of the window
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private Image titlePage;
    private Image instructions;
    private Image scorePage;
    private Game backend;
    private ArrayList<Card> playerCards;
    private ArrayList<Card> dealerCards;


    public GameView(Game backend) {
        // Pass in the backgrounds created on Canva as images
        titlePage = new ImageIcon("Resources/titlepage.png").getImage();
        instructions = new ImageIcon("Resources/instructions.png").getImage();
        scorePage = new ImageIcon("Resources/defaultscorepage.png").getImage();
        // Pass in backend into frontend constructor
        this.backend = backend;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Blackjack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        // getState from backend tracks when the user presses enter
        int state = Game.getState();
        // Switch backgrounds when user presses enter
        if (state == 0) {
            g.drawImage(titlePage, 0, 0, this);
        }
        else if (state == 1) {
            g.drawImage(instructions, 0, 0, this);
        }
        else if (state == 2) {
            g.drawImage(scorePage, 0, 0, this);
            drawScorePage(g);
            if (backend.getIfWin() == 1) {
                getWinner(g);
            }
        }
    }

    // Draws the in-game moves of player
    public void drawScorePage(Graphics g) {
        // Create seperation down middle of screen
        g.setColor(Color.white);
        g.fillRect(498, 0, 4, 800);
        // Print dealer and player's points respectively
        g.setFont(new Font("Algerian", Font.BOLD, 100));
        g.drawString(String.valueOf(backend.getPlayerPoints()), 300, 715);
        g.drawString(String.valueOf(backend.getDealerPoints()), 800, 715);
        // Get the cards drawn from the backend, translate onto frontend
        playerCards = backend.getPlayerCards();
        dealerCards = backend.getDealerCards();
        for (int i = 0; i < playerCards.size(); i++) {
            // Get image that associates with what the player drew in the backend
            g.drawImage(playerCards.get(i).getCardImage(), 30 + i * 80, 50 + i * 100, 80, 130, this);
        }
        for (int i = 0; i < dealerCards.size(); i++) {
            g.drawImage(dealerCards.get(i).getCardImage(), 530 + i * 80, 50 + i * 100, 80, 130, this);
        }
    }

    // Prints the win status of the game, ends the game
    public void getWinner(Graphics g) {
        // Repaint cards to a black background
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 630);
        g.fillRect(498, 630, 4, 1000);
        g.setColor(Color.white);
        // Take in win status from backend, print the right status in the front end
        switch (backend.checkPoints()) {
            case 1:
                g.drawString("dealer busted.", 120, 400);
                break;
            case 2:
                g.drawString("tie game.", 280, 400);
                break;
            case 3:
                g.drawString("player busted.", 120, 400);
                break;
            case 4:
                g.drawString("dealer wins!", 180, 400);
                break;
            case 5:
                g.drawString("player wins!", 180, 400);
                break;
        }
    }
}
