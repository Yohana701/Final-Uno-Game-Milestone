import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Card class to represent each UNO card
class Card {
    private String color;
    private String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}

// Deck class to manage the UNO cards
class Deck {
    private List<Card> drawPile;
    private List<Card> discardPile;

    public Deck() {
        drawPile = new ArrayList<>();
        discardPile = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck() {
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        String[] values = {"1", "2", "3", "4", "5", "6", "7"};

        for (String color : colors) {
            for (String value : values) {
                drawPile.add(new Card(color, value));
            }
        }

        // Adding special cards
        drawPile.add(new Card("Wild", "Wild"));
        drawPile.add(new Card("Wild", "Wild"));
        drawPile.add(new Card("Draw 1", "Red"));
        drawPile.add(new Card("Draw 1", "Blue"));
        drawPile.add(new Card("Draw 2", "Yellow"));
        drawPile.add(new Card("Draw 2", "Green"));
    }

    private void shuffleDeck() {
        Collections.shuffle(drawPile);
    }

    public Card drawCard() {
        if (drawPile.isEmpty()) {
            // Reshuffle discard pile into draw pile if empty
            drawPile.addAll(discardPile);
            discardPile.clear();
            shuffleDeck();
        }
        return drawPile.remove(drawPile.size() - 1);
    }

    public void discardCard(Card card) {
        discardPile.add(card);
    }

    public List<Card> getDrawPile() {
        return drawPile;
    }

    public List<Card> getDiscardPile() {
        return discardPile;
    }
}

public class UnoGame extends JFrame {
    private Deck deck;
    private JPanel playerPanel;
    private JPanel drawPilePanel;
    private JPanel discardPilePanel;
    private JLabel statusLabel;
    private JButton drawButton;
    private JButton playButton;
    private JButton unoButton;
    private JTextArea playerHandArea;

    public UnoGame() {
        setTitle("UNO Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        deck = new Deck();

        // Initialize UI components
        playerPanel = new JPanel();
        drawPilePanel = new JPanel();
        discardPilePanel = new JPanel();
        statusLabel = new JLabel("Player 1's Turn");
        drawButton = new JButton("Draw Card");
        playButton = new JButton("Play Card");
        unoButton = new JButton("UNO");
        playerHandArea = new JTextArea(5, 20);

        playerHandArea.setEditable(false);
        playerPanel.add(new JScrollPane(playerHandArea));

        drawPilePanel.add(new JLabel("Draw Pile"));
        discardPilePanel.add(new JLabel("Discard Pile"));

        add(playerPanel, BorderLayout.SOUTH);
        add(drawPilePanel, BorderLayout.CENTER);
        add(discardPilePanel, BorderLayout.NORTH);
        add(drawButton, BorderLayout.WEST);
        add(playButton, BorderLayout.EAST);
        add(unoButton, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card drawnCard = deck.drawCard();
                updatePlayerHand(drawnCard);
                statusLabel.setText("Drew a card: " + drawnCard);
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add play card logic here
                statusLabel.setText("Play card feature not implemented yet.");
            }
        });

        unoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add UNO feature logic here
                statusLabel.setText("UNO feature not implemented yet.");
            }
        });

        setVisible(true);
    }

    private void updatePlayerHand(Card card) {
        playerHandArea.append(card.toString() + "\n");
    }

    public static void main(String[] args) {
        new UnoGame();
    }
}
