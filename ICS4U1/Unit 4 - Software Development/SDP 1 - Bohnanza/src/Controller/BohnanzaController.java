package Controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;
import Model.Card;
import Model.Deck;
import Model.Player;
import View.BohnanzaGameFrame;
import View.BohnanzaStartFrame;

//this class sets up the game
public class BohnanzaController implements ActionListener{

    //fields
    private BohnanzaStartFrame startFrame;
    private static BohnanzaGameFrame gameFrame;
    public static Deck deck;
    public static Player[] players = new Player[2];
    public static Card[] offerArea = new Card[3];
    private PlayerTurnController playerController;

    //constructor
    public BohnanzaController() {
        startFrame = new BohnanzaStartFrame();

        startFrame.getAiButton().addActionListener(this);
        startFrame.getPvpButton().addActionListener(this);
        startFrame.getRulesButton().addActionListener(this);

    }

    //getters and setters
    public BohnanzaStartFrame getStartFrame() {
        return startFrame;
    }

    public void setStartFrame(BohnanzaStartFrame startFrame) {
        this.startFrame = startFrame;
    }

    public static BohnanzaGameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(BohnanzaGameFrame gameFrame) {
        BohnanzaController.gameFrame = gameFrame;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        BohnanzaController.deck = deck;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        BohnanzaController.players = players;
    }

    public Card[] getOfferArea() {
        return offerArea;
    }

    public void setOfferArea(Card[] offerArea) {
        BohnanzaController.offerArea = offerArea;
    }

    public PlayerTurnController getPlayerController() {
        return playerController;
    }

    public void setPlayerController(PlayerTurnController playerController) {
        this.playerController = playerController;
    }

    //toString
    @Override
    public String toString() {
        return "BohnanzaController [startFrame=" + startFrame + ", gameFrame=" + gameFrame + ", deck=" + deck
                + ", players=" + Arrays.toString(players) + ", offerArea=" + Arrays.toString(offerArea)
                + ", playerController=" + playerController + "]";
    }

    //utility methods

    //setting up the game when player clicks start
    public void setupGame(String name1, String name2, boolean twoPlayer) {
        createPlayers(twoPlayer);  // First create players
        generateDeck();            // Then generate deck
        dealHands();               // Then deal cards

        // Now create game frame with initialized players/deck
        gameFrame = new BohnanzaGameFrame(name1, name2);

        // Set up controller after game frame exists
        playerController = new PlayerTurnController(gameFrame, deck, players, offerArea);

        // Initialize controller components after frame is built
        gameFrame.initializeControllerComponents();

        // Now setup cards
        gameFrame.setupCards(players[0].getHandAsList(), 0);
        gameFrame.setupCards(players[1].getHandAsList(), 1);
    }

    //creating the player objects
    public void createPlayers(boolean twoPlayer) {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(null, new Card[3], 0, true, true);
        }

        //setting the second players turn to false and if it isnt a player setting isHuman to false
        players[1].setCurrentTurn(false);
        if (!twoPlayer) {
            players[2].setHuman(false);
        }
    }

    //creating a new deck for the game
    //creating a new deck for the game
    public void generateDeck() {
        Stack<Card> temp = new Stack<>();

        try {
            Scanner input = new Scanner(new File("sounds/Cards.txt"));
            input.useDelimiter(",|\r\n");

            while (input.hasNext()) {
                String type = input.next();
                int numCards = input.nextInt();
                int[] beanometer = {input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt()};

                for (int i = 0; i < numCards; i++) {
                    temp.push(new Card(type, 1, beanometer, "images/" + type + ".png", 0));
                }
            }

            input.close();

            deck = new Deck(temp, new Stack<>()); //ensure the deck is initialized with drawPile

            deck.shuffle(); //explicitly shuffle after the Deck is created

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //dealing 5 hands to each player at the beginning
    public void dealHands() {
        // Deal cards alternately (1 to player 1, 1 to player 2, etc)
        for (int j = 0; j < 5; j++) {
            for (Player player : players) {
                player.addToHand(deck.draw());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // If the Rules button is clicked
        if (e.getSource() == startFrame.getRulesButton()) {
            try {
                // Try to open the PDF file from the "rules" folder
                File pdfFile = new File("rules/Bohnanza Rules.pdf");
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    // Show error if file not found
                    JOptionPane.showMessageDialog(startFrame, "Bohnanza Rules file not found in /rules folder.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                // Handle any error that occurs when opening the file
                ex.printStackTrace();
                JOptionPane.showMessageDialog(startFrame, "Unable to open the rules file.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            // If the PvP button is clicked
        } else if (e.getSource() == startFrame.getPvpButton()) {

            // Prompt for player names
            String player1Name = JOptionPane.showInputDialog(startFrame, "Enter name for Player 1:");
            if (player1Name == null || player1Name.trim().isEmpty()) return; // Cancel or empty

            String player2Name = JOptionPane.showInputDialog(startFrame, "Enter name for Player 2:");
            if (player2Name == null || player2Name.trim().isEmpty()) return; // Cancel or empty

            startFrame.getMusic().stopMusic(); // Stop the background music
            startFrame.dispose(); // Close the current window

            setupGame(player1Name.trim(), player2Name.trim(), true);

            // If the AI button is clicked
        } else if (e.getSource() == startFrame.getAiButton()) {
            // Show a popup to let user select difficulty
            String player1Name = JOptionPane.showInputDialog(startFrame, "Enter your name:");
            if (player1Name == null || player1Name.trim().isEmpty()) return;

            String[] options = { "Easy", "Medium", "Hard" };
            String difficulty = (String) JOptionPane.showInputDialog(startFrame,
                    "Which level of AI would you like to play against?", "Select AI Difficulty",
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (difficulty != null) {
                JOptionPane.showMessageDialog(startFrame, "You selected: " + difficulty + " AI", "Difficulty Selected",
                        JOptionPane.INFORMATION_MESSAGE);

                startFrame.getMusic().stopMusic(); // Stop the background music
                startFrame.dispose(); // Close the current window

                setupGame(player1Name.trim(), "AI (" + difficulty + ")", false);
            }
        }
    }
}