package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import Model.Card;
import Model.Deck;
import Model.Player;
import View.BohnanzaGameFrame;

public class PlayerTurnController implements TurnInterface, ActionListener{

    private int currentPlayer = 0;

    //fields
    private BohnanzaGameFrame gameFrame;
    private Deck deck;
    private Player[] players;
    private Card[] offerArea;

    //constructor
    public PlayerTurnController(BohnanzaGameFrame gameFrame, Deck deck, Player[] players, Card[] offerArea) {
        super();
        this.gameFrame = gameFrame;
        this.deck = deck;
        this.players = players;
        this.offerArea = offerArea;

//		gameFrame.getDrawPileButton().addActionListener(this);
    }

    // In PlayerTurnController.java, modify the initializeComponents() method:
    public void initializeComponents() {
        // Now we can safely access gameFrame components
        if (gameFrame != null && gameFrame.getDrawPileButton() != null) {
            gameFrame.getDrawPileButton().addActionListener(this);
        }

        if(gameFrame != null && gameFrame.getEndTurnButton() != null) {
            gameFrame.getEndTurnButton().addActionListener(this);
        }

        if(gameFrame != null && gameFrame.getOfferButton() != null) {
            gameFrame.getOfferButton().addActionListener(this);
        }

        // Initialize other UI components as needed
//	    if (gameFrame != null && gameFrame.getTractorLabel() != null) {
//	        enableTractorDragAndDrop(gameFrame.getTractorLabel());
//	    }

        // Add field purchase button listeners
        if (gameFrame != null) {
            if (gameFrame.getBuyPlayer1Field3Button() != null) {
                gameFrame.getBuyPlayer1Field3Button().addActionListener(e -> handleFieldPurchase(0));
            }
            if (gameFrame.getBuyPlayer2Field3Button() != null) {
                gameFrame.getBuyPlayer2Field3Button().addActionListener(e -> handleFieldPurchase(1));
            }
        }
    }

    private void handleFieldPurchase(int playerIndex) {
        JButton buyButton = playerIndex == 0 ? gameFrame.getBuyPlayer1Field3Button() : gameFrame.getBuyPlayer2Field3Button();
        JPanel fieldPanel = playerIndex == 0 ? gameFrame.getPlayer1Fields()[2] : gameFrame.getPlayer2Fields()[2];
        JLabel coinCounter = gameFrame.getCoinCounters()[playerIndex];
        int currentCoins = playerIndex == 0 ? gameFrame.getPlayer1Coins() : gameFrame.getPlayer2Coins();

        int choice = JOptionPane.showConfirmDialog(gameFrame,
                "Do you want to buy Player " + (playerIndex + 1) + "'s Field 3 for 3 coins?",
                "Confirm Purchase", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            if (currentCoins >= 3) {
                // Update coins
                if (playerIndex == 0) {
                    gameFrame.setPlayer1Coins(currentCoins - 3);
                } else {
                    gameFrame.setPlayer2Coins(currentCoins - 3);
                }
                coinCounter.setText("Coins: " + (currentCoins - 3));

                // Enable the field
                fieldPanel.setEnabled(true);
                fieldPanel.setOpaque(false);
                fieldPanel.remove(buyButton);
                fieldPanel.repaint();
                gameFrame.getBackgroundLabel().repaint();
            } else {
                JOptionPane.showMessageDialog(gameFrame,
                        "You don't have enough coins to buy Field 3!",
                        "Insufficient Coins", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //getters and setters
    public BohnanzaGameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(BohnanzaGameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Card[] getOfferArea() {
        return offerArea;
    }

    public void setOfferArea(Card[] offerArea) {
        this.offerArea = offerArea;
    }

    //toString
    @Override
    public String toString() {
        return "PlayerTurnController [gameFrame=" + gameFrame + ", deck=" + deck + ", players="
                + Arrays.toString(players) + ", offerArea=" + Arrays.toString(offerArea) + "]";
    }

    //utility methods

    //this method plants a card and return true if planted correctly
    public boolean promptPlant(Card card, String message) {
        //asking the user which field to plant in
        Object[] fieldOptions = {"1", "2", "3"};
        int choice = JOptionPane.showOptionDialog(gameFrame, message,"Card Planter", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, fieldOptions, -1);

        //if user didnt choose an option return false
        if (choice == -1)
            return false;
        else {
            //if the plant was succesfull do nothing
            if (players[currentPlayer].plantCard(choice - 1, card)) {
            }
            //if the plant was not successfull there must be a different card already in the field so
            //it is harvested, discarded and the new card is planted
            else {
                Card cardToDiscard = players[currentPlayer].getBeanfields()[choice - 1];
                cardToDiscard.setTotalBeanCount(players[currentPlayer].harvestField(choice - 1));
                deck.discard(cardToDiscard);
                players[currentPlayer].getBeanfields()[choice -1] = null;

                players[currentPlayer].plantCard(choice - 1, card);
            }

            //setting the image in the field to the cards image
            //if (currentPlayer == 0)
            //((JLabel) gameFrame.getPlayer1Fields()[choice - 1].getComponent(0)).setIcon(new ImageIcon(card.getImagePath()));
            //else
            //((JLabel) gameFrame.getPlayer2Fields()[choice - 1].getComponent(0)).setIcon(new ImageIcon(card.getImagePath()));
            //updating the fields counter
            //gameFrame.getFieldCardCounters()[currentPlayer][choice - 1].setText(Integer.toString(card.getTotalBeanCount()));

            //return true since card was planted
            return true;
        }
    }

    //this method change the current player
    @Override
    public void startTurn() {
        if (currentPlayer == 0) {
            currentPlayer = 1;
            players[0].setCurrentTurn(false);
            players[1].setCurrentTurn(true);
        } else {
            currentPlayer = 0;
            players[1].setCurrentTurn(false);
            players[0].setCurrentTurn(true);
        }
    }

    //this method plants the players first card
    @Override
    public boolean plantInitialCard() {
        boolean planted = false;

        //keep asking the player to choose a field to plant their first card in until they do
        while (!planted) {
            planted = promptPlant(players[currentPlayer].getHand().peek(), "Which field would you like to plant your "
                    + "first card in? If the field chosen contains"
                    + "a different card it will be harvested.");
        }

        //remove the first card from the hand
        players[currentPlayer].removeFromHand(null);

        gameFrame.setupCards(players[currentPlayer].getHandAsList(), currentPlayer);

        return true;
    }

    //this method plants the users second card
    @Override
    public boolean plantSecondCard() {
        //plants the card in the selected field, does not plant if user clicks X since this is not mandatory
        if (promptPlant(players[currentPlayer].getHand().peek(), "Which field would you like to plant your "
                + "second card in? If the field chosen contains"
                + "a different card it will be harvested."
                + "Click X to not plant the card.")){
            gameFrame.setupCards(players[currentPlayer].getHandAsList(), currentPlayer);
        }
        return true;

    }

    //this method fills the offer area with card
    @Override
    public void drawAndOffer() {
        //flag to check whether the offer area is full
        boolean filled = false;

        //while offer area is not filled
        while (!filled) {
            //get the top card of the drawpile
            Card topCard = deck.getDrawPile().pop();

            // if the top card is the same as the top discard pile add it to there
            if (topCard.getBeantype() == deck.getTopDiscard().getBeantype()) {
                deck.getTopDiscard().setTotalBeanCount(deck.getTopDiscard().getTotalBeanCount() + topCard.getTotalBeanCount());

                deck.draw(); //removing top card


                //if the card was not added to the discard pile
            } else {
                //runs for each offer
                for (int i = 0; i < offerArea.length; i++) {
                    //if the top card is the same as an existing offer add it to there
                    if (topCard.getBeantype() == offerArea[i].getBeantype()) {
                        offerArea[i].setTotalBeanCount(offerArea[i].getTotalBeanCount() + topCard.getTotalBeanCount());

                        deck.draw(); //removing top card

                        //updating visuals
                        gameFrame.getOfferAreaCounter()[i].setText(Integer.toString(offerArea[i].getTotalBeanCount() + topCard.getTotalBeanCount()));

                        break;
                        //if an offer is empty and no other field contains the card add it to there
                    } else if (offerArea[i] == null) {
                        offerArea[i] = topCard;

                        deck.draw(); //removing top card

                        //updating visuals
                        gameFrame.getOfferAreaLabel()[i].setIcon(new ImageIcon(topCard.getImagePath()));
                        gameFrame.getOfferAreaCounter()[i].setText(Integer.toString(topCard.getTotalBeanCount()));
                        //if none of the above happen the offers are full so set the flag to false
                    } else
                        filled = true;
                }
            }
        }
    }

    @Override
    public void plantFromOffer() {

    }

    //this method adds two card to the back of the users hand
    @Override
    public void drawToHand() {
        if (players == null || currentPlayer < 0 || currentPlayer >= players.length) {
            JOptionPane.showMessageDialog(gameFrame,
                    "Player data not initialized correctly!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Player current = players[currentPlayer];
        if (current == null) {
            JOptionPane.showMessageDialog(gameFrame,
                    "Current player is null!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = 0; i < 2; i++) {
            Card drawnCard = deck != null ? deck.draw() : null;
            if (drawnCard != null) {
                current.addToHand(drawnCard);
                gameFrame.setupCards(current.getHandAsList(), currentPlayer);
            }
        }
    }

    // In PlayerTurnController.java
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameFrame.getDrawPileButton()) {
            drawToHand();
        }
        else if (e.getSource() == gameFrame.getEndTurnButton()) {
            endCurrentTurn();
        }
        else if (e.getSource() == gameFrame.getOfferButton()) {
            drawAndOffer();
        }
    }

    private void endCurrentTurn() {
        // 1. Toggle turn flag
        gameFrame.setPlayer1Turn(!gameFrame.isPlayer1Turn());

        // 2. Update UI label
        gameFrame.getPlayerTurnLabel().setText("Current Turn: " +
                (gameFrame.isPlayer1Turn() ? gameFrame.getPlayer1Name() : gameFrame.getPlayer2Name()));

        // 3. Reset turn counters
        gameFrame.setPlantCount(0);
        gameFrame.setDiscardCount(0);

        // 4. Switch active player in model
        startTurn(); // Your existing turn switching logic
    }

    public void enableTractorDragAndDrop(Component component) {
        Point[] initialClick = new Point[1];
        Point[] initialOffset = new Point[1];
        Point[] originalLocation = new Point[1];
        Container[] originalParent = new Container[1];
        JLayeredPane layeredPane = gameFrame.getLayeredPane(); // Ensure this is the correct layered pane for drag layer

        // Set the initial tractor position when dragging starts
        final Point startingLocation = new Point(635, 15); // This is the starting point defined in setupTractorImage()

        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick[0] = SwingUtilities.convertPoint(component, e.getPoint(), layeredPane);
                component.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

                originalLocation[0] = component.getLocation();
                originalParent[0] = component.getParent();

                initialOffset[0] = new Point(initialClick[0].x - component.getX(),
                        initialClick[0].y - component.getY());

                if (originalParent[0] != null) {
                    originalParent[0].remove(component);
                    component.setSize(component.getPreferredSize());
                    layeredPane.add(component, JLayeredPane.DRAG_LAYER);
                    layeredPane.repaint();
                }
            }
        });

        component.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currentPoint = SwingUtilities.convertPoint(component, e.getPoint(), layeredPane);
                int newX = currentPoint.x - initialOffset[0].x;
                int newY = currentPoint.y - initialOffset[0].y;
                component.setLocation(newX, newY);
            }
        });

        component.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                component.setCursor(Cursor.getDefaultCursor());

                Point screenPoint = e.getLocationOnScreen();
                JPanel fieldPanelAtRelease = gameFrame.getFieldPanelAt(screenPoint);

                layeredPane.remove(component);

                if (fieldPanelAtRelease != null) {
                    int result = JOptionPane.showOptionDialog(null, "Do you want to harvest or discard the plant?",
                            "Choose Action", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[] { "Harvest", "Discard" }, "Harvest");

                    component.setLocation(startingLocation); // Always reset

                    if (result == 0 || result == 1) { // Harvest or Discard
                        // Remove the card image
                        JLabel cardLabel = (JLabel) fieldPanelAtRelease.getClientProperty("cardLabel");
                        if (cardLabel != null) {
                            cardLabel.setIcon(null);
                            fieldPanelAtRelease.revalidate();
                            fieldPanelAtRelease.repaint();
                        }

                        // Reset the counter label
                        for (int player = 0; player < 2; player++) {
                            JPanel[] fields = player == 0 ? gameFrame.getPlayer1Fields() : gameFrame.getPlayer2Fields();
                            for (int i = 0; i < 3; i++) {
                                if (fields[i] == fieldPanelAtRelease) {
                                    gameFrame.getFieldCardCounters()[player][i].setText("0");
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    component.setLocation(startingLocation);
                }

                if (originalParent[0] != null) {
                    originalParent[0].add(component, 0);
                    originalParent[0].revalidate();
                    originalParent[0].repaint();
                }

                layeredPane.repaint();
            }
        });

    }

    public void enableCardDragAndDrop(Component component, String playerID) {
        Point[] initialClick = new Point[1];
        Point[] initialOffset = new Point[1];
        Point[] originalLocation = new Point[1];
        Container[] originalParent = new Container[1];
        int[] originalIndex = new int[1];
        boolean[] isFirstCardDragged = new boolean[1];
        JLayeredPane layeredPane = gameFrame.getLayeredPane();

        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                component.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                originalParent[0] = component.getParent();
                originalLocation[0] = component.getLocation();

                // Store if this is the first card
                if (originalParent[0] != null) {
                    Component[] handCards = originalParent[0].getComponents();
                    isFirstCardDragged[0] = (handCards.length > 0 && handCards[0] == component);
                    originalIndex[0] = originalParent[0].getComponentZOrder(component);
                }

                if (component instanceof JLabel) {
                    ImageIcon originalIcon = (ImageIcon) ((JLabel) component).getClientProperty("originalIcon");
                    if (originalIcon != null) {
                        Image smallImage = originalIcon.getImage().getScaledInstance(100, 157, Image.SCALE_SMOOTH);
                        ((JLabel) component).setIcon(new ImageIcon(smallImage));
                        component.setSize(100, 157);
                    }
                }

                Point convertedLocation = SwingUtilities.convertPoint(component.getParent(), component.getLocation(),
                        layeredPane);

                if (originalParent[0] != null) {
                    originalParent[0].remove(component);
                    component.setLocation(convertedLocation);
                    layeredPane.add(component, JLayeredPane.DRAG_LAYER);
                    layeredPane.repaint();
                }

                Point layeredPaneClick = SwingUtilities.convertPoint(component, e.getPoint(), layeredPane);
                initialClick[0] = layeredPaneClick;
                initialOffset[0] = new Point(layeredPaneClick.x - convertedLocation.x,
                        layeredPaneClick.y - convertedLocation.y);
            }

            public void mouseReleased(MouseEvent e) {
                component.setCursor(Cursor.getDefaultCursor());

                Point screenPoint = e.getLocationOnScreen();
                JPanel fieldPanelAtRelease = gameFrame.getFieldPanelAt(screenPoint);
                layeredPane.remove(component);

                // Handle Discard
                if (isOverlapping(component, gameFrame.getDiscardPileButton())) {
                    if (gameFrame.getDiscardCount() >= gameFrame.getMAX_DISCARDS_PER_TURN()) {
                        JOptionPane.showMessageDialog(null, "You can only discard one card per turn.",
                                "Discard Limit Reached", JOptionPane.WARNING_MESSAGE);
                        restoreToOriginal();
                        layeredPane.repaint();
                        return;
                    }

                    int result = JOptionPane.showConfirmDialog(null, "Do you want to discard this card?",
                            "Confirm Discard", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        if (component instanceof JLabel) {
                            Icon discardedIcon = ((JLabel) component).getIcon();
                            gameFrame.getDiscardPileButton().setIcon(discardedIcon);
                            gameFrame.getDiscardPileButton().setText("");
                        }
                        gameFrame.setDiscardCount(gameFrame.getDiscardCount() + 1);
                        layeredPane.remove(component);
                        layeredPane.repaint();
                        return;
                    } else {
                        restoreToOriginal();
                        layeredPane.repaint();
                        return;
                    }
                }

                // Handle Planting on Field
                if (fieldPanelAtRelease != null) {
                    if (gameFrame.getPlantCount() >= gameFrame.getMAX_PLANTS_PER_TURN()) {
                        JOptionPane.showMessageDialog(null, "You can only plant two cards per turn.",
                                "Plant Limit Reached", JOptionPane.WARNING_MESSAGE);
                        restoreToOriginal();
                        layeredPane.repaint();
                        return;
                    }

                    if (!isFirstCardDragged[0]) {
                        JOptionPane.showMessageDialog(null, "You must plant the first card in your hand first.",
                                "Top Card Rule", JOptionPane.WARNING_MESSAGE);
                        restoreToOriginal();
                        layeredPane.repaint();
                        return;
                    }

                    int playerIndex = -1, fieldIndex = -1;
                    for (int i = 0; i < 3; i++) {
                        if (fieldPanelAtRelease == gameFrame.getPlayer1Fields()[i]) {
                            playerIndex = 0;
                            fieldIndex = i;
                            break;
                        } else if (fieldPanelAtRelease == gameFrame.getPlayer2Fields()[i]) {
                            playerIndex = 1;
                            fieldIndex = i;
                            break;
                        }
                    }

                    if (fieldIndex == 2 && !fieldPanelAtRelease.isEnabled()) {
                        JOptionPane.showMessageDialog(null, "You need to buy this field before using it!",
                                "Field Locked", JOptionPane.WARNING_MESSAGE);
                        restoreToOriginal();
                        layeredPane.repaint();
                        return;
                    }

                    // Get the Card objects instead of comparing images
                    Card draggedCard = (Card) ((JLabel) component).getClientProperty("card");
                    JLabel existingCardLabel = (JLabel) fieldPanelAtRelease.getClientProperty("cardLabel");
                    Card fieldCard = existingCardLabel != null ?
                            (Card) existingCardLabel.getClientProperty("card") : null;

                    // Compare bean types
                    boolean canPlant = (fieldCard == null) ||
                            (draggedCard != null && draggedCard.getBeantype().equals(fieldCard.getBeantype()));

                    String errorMessage = fieldCard != null ?
                            "You can only plant " + fieldCard.getBeantype() + " beans in this field" :
                            "Invalid card type";

                    Border originalBorder = fieldPanelAtRelease.getBorder();
                    fieldPanelAtRelease.setBorder(BorderFactory.createLineBorder(canPlant ? Color.GREEN : Color.RED, 3));

                    try { Thread.sleep(100); } catch (InterruptedException ex) {}

                    if (canPlant) {
                        int result = JOptionPane.showConfirmDialog(null, "Do you want to plant this card here?",
                                "Plant Card", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            gameFrame.setPlantCount(gameFrame.getPlantCount() + 1);

                            if (playerIndex != -1 && fieldIndex != -1) {
                                int count = Integer.parseInt(gameFrame.getFieldCardCounters()[playerIndex][fieldIndex].getText());
                                gameFrame.getFieldCardCounters()[playerIndex][fieldIndex].setText(String.valueOf(count + 1));
                            }

                            if (existingCardLabel == null) {
                                existingCardLabel = new JLabel();
                                existingCardLabel.setHorizontalAlignment(JLabel.CENTER);
                                existingCardLabel.setVerticalAlignment(JLabel.CENTER);
                                fieldPanelAtRelease.setLayout(new BorderLayout());
                                fieldPanelAtRelease.add(existingCardLabel, BorderLayout.CENTER);
                                fieldPanelAtRelease.putClientProperty("cardLabel", existingCardLabel);
                            }

                            existingCardLabel.setIcon(((JLabel) component).getIcon());
                            existingCardLabel.putClientProperty("card", draggedCard);

                            JLabel handCounter = (JLabel) ((JComponent) originalParent[0])
                                    .getClientProperty("handCounter");
                            if (handCounter != null) {
                                int count = Integer.parseInt(handCounter.getText());
                                handCounter.setText(String.valueOf(count - 1));
                            }

                            fieldPanelAtRelease.revalidate();
                            fieldPanelAtRelease.repaint();
                        } else {
                            restoreToOriginal();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, errorMessage,
                                "Invalid Plant", JOptionPane.WARNING_MESSAGE);
                        restoreToOriginal();
                    }

                    fieldPanelAtRelease.setBorder(originalBorder);
                } else {
                    restoreToOriginal();
                }

                layeredPane.repaint();
            }

            private boolean isOverlapping(Component dragged, Component target) {
                Rectangle draggedBounds = dragged.getBounds();
                Point draggedLocation = SwingUtilities.convertPoint(dragged.getParent(), draggedBounds.getLocation(),
                        gameFrame.getLayeredPane());

                Rectangle targetBounds = SwingUtilities.convertRectangle(target.getParent(), target.getBounds(),
                        gameFrame.getLayeredPane());
                Rectangle draggedRect = new Rectangle(draggedLocation, draggedBounds.getSize());

                return targetBounds.intersects(draggedRect);
            }

            private void restoreToOriginal() {
                if (component instanceof JLabel) {
                    ImageIcon originalIcon = (ImageIcon) ((JLabel) component).getClientProperty("originalIcon");
                    if (originalIcon != null) {
                        Image fullImage = originalIcon.getImage().getScaledInstance(150, 236, Image.SCALE_SMOOTH);
                        ((JLabel) component).setIcon(new ImageIcon(fullImage));
                        component.setSize(150, 236);
                    }
                }

                if (originalParent[0] != null && originalIndex[0] >= 0) {
                    originalParent[0].add(component, originalIndex[0]);
                    originalParent[0].revalidate();
                    originalParent[0].repaint();
                } else if (originalLocation[0] != null) {
                    component.setLocation(originalLocation[0]);
                }
            }
        });

        component.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currentPoint = SwingUtilities.convertPoint(component, e.getPoint(), layeredPane);
                int newX = currentPoint.x - initialOffset[0].x;
                int newY = currentPoint.y - initialOffset[0].y;
                component.setLocation(newX, newY);
            }
        });
    }

    public void enableOfferCardDragAndDrop(JLabel offerCardLabel, JLabel[] offerAreaCounter) {
        Point[] initialClick = new Point[1];
        Point[] initialOffset = new Point[1];
        Point[] originalLocation = new Point[1];
        Container[] originalParent = new Container[1];
        int[] originalIndex = new int[1];
        JLayeredPane layeredPane = gameFrame.getLayeredPane();

        offerCardLabel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                offerCardLabel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                originalParent[0] = offerCardLabel.getParent();
                originalLocation[0] = offerCardLabel.getLocation();

                if (originalParent[0] != null) {
                    originalIndex[0] = originalParent[0].getComponentZOrder(offerCardLabel);
                }

                Point convertedLocation = SwingUtilities.convertPoint(offerCardLabel.getParent(), offerCardLabel.getLocation(), layeredPane);

                if (originalParent[0] != null) {
                    originalParent[0].remove(offerCardLabel);
                    offerCardLabel.setLocation(convertedLocation);
                    layeredPane.add(offerCardLabel, JLayeredPane.DRAG_LAYER);
                    layeredPane.repaint();
                }

                Point layeredPaneClick = SwingUtilities.convertPoint(offerCardLabel, e.getPoint(), layeredPane);
                initialClick[0] = layeredPaneClick;
                initialOffset[0] = new Point(layeredPaneClick.x - convertedLocation.x, layeredPaneClick.y - convertedLocation.y);
            }

            public void mouseReleased(MouseEvent e) {
                offerCardLabel.setCursor(Cursor.getDefaultCursor());
                Point screenPoint = e.getLocationOnScreen();
                JPanel fieldPanelAtRelease = gameFrame.getFieldPanelAt(screenPoint);
                layeredPane.remove(offerCardLabel);

                // 🟡 Discard
                if (isOverlapping(offerCardLabel, gameFrame.getDiscardPileButton())) {
                    int result = JOptionPane.showConfirmDialog(null, "Do you want to discard this offer card?",
                            "Confirm Discard", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        if (offerCardLabel instanceof JLabel) {
                            Icon discardedIcon = offerCardLabel.getIcon();
                            gameFrame.getDiscardPileButton().setIcon(discardedIcon);
                            gameFrame.getDiscardPileButton().setText("");
                        }
                        layeredPane.remove(offerCardLabel);
                        layeredPane.repaint();
                        return;
                    } else {
                        restoreToOriginal();
                        layeredPane.repaint();
                        return;
                    }
                }

                // 🔵 Plant
                if (fieldPanelAtRelease != null) {
                    int playerIndex = -1, fieldIndex = -1;
                    for (int i = 0; i < 3; i++) {
                        if (fieldPanelAtRelease == gameFrame.getPlayer1Fields()[i]) {
                            playerIndex = 0;
                            fieldIndex = i;
                            break;
                        } else if (fieldPanelAtRelease == gameFrame.getPlayer2Fields()[i]) {
                            playerIndex = 1;
                            fieldIndex = i;
                            break;
                        }
                    }

                    if (fieldIndex == 2 && !fieldPanelAtRelease.isEnabled()) {
                        JOptionPane.showMessageDialog(null, "You need to buy this field before using it!",
                                "Field Locked", JOptionPane.WARNING_MESSAGE);
                        restoreToOriginal();
                        layeredPane.repaint();
                        return;
                    }

                    Icon draggedIcon = offerCardLabel.getIcon();
                    JLabel existingCardLabel = (JLabel) fieldPanelAtRelease.getClientProperty("cardLabel");
                    Icon fieldIcon = (existingCardLabel != null) ? existingCardLabel.getIcon() : null;

                    boolean canPlant = (fieldIcon == null || (draggedIcon != null &&
                            ((ImageIcon) draggedIcon).getImage() == ((ImageIcon) fieldIcon).getImage()));

                    Border originalBorder = fieldPanelAtRelease.getBorder();
                    fieldPanelAtRelease.setBorder(BorderFactory.createLineBorder(canPlant ? Color.GREEN : Color.RED, 3));

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }

                    if (canPlant) {
                        int result = JOptionPane.showConfirmDialog(null, "Do you want to plant this offer card here?",
                                "Plant Card", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            if (playerIndex != -1 && fieldIndex != -1) {
                                try {
                                    int fieldCount = Integer.parseInt(gameFrame.getFieldCardCounters()[playerIndex][fieldIndex].getText());
                                    int offerCount = Integer.parseInt(gameFrame.getOfferAreaCounter()[playerIndex].getText());  // Use the player-specific counter
                                    gameFrame.getFieldCardCounters()[playerIndex][fieldIndex].setText(String.valueOf(fieldCount + offerCount));
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Error reading card counters.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }

                            if (existingCardLabel == null) {
                                existingCardLabel = new JLabel();
                                existingCardLabel.setHorizontalAlignment(JLabel.CENTER);
                                existingCardLabel.setVerticalAlignment(JLabel.CENTER);
                                fieldPanelAtRelease.setLayout(new BorderLayout());
                                fieldPanelAtRelease.add(existingCardLabel, BorderLayout.CENTER);
                                fieldPanelAtRelease.putClientProperty("cardLabel", existingCardLabel);
                            }

                            existingCardLabel.setIcon(draggedIcon);
                            fieldPanelAtRelease.revalidate();
                            fieldPanelAtRelease.repaint();
                        } else {
                            restoreToOriginal();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "You can't plant this card here because it's different from the one already planted.",
                                "Invalid Plant", JOptionPane.WARNING_MESSAGE);
                        restoreToOriginal();
                    }

                    fieldPanelAtRelease.setBorder(originalBorder);
                } else {
                    restoreToOriginal();
                }

                layeredPane.repaint();
            }

            private boolean isOverlapping(Component dragged, Component target) {
                Rectangle draggedBounds = dragged.getBounds();
                Point draggedLocation = SwingUtilities.convertPoint(dragged.getParent(), draggedBounds.getLocation(), gameFrame.getLayeredPane());
                Rectangle targetBounds = SwingUtilities.convertRectangle(target.getParent(), target.getBounds(), gameFrame.getLayeredPane());
                Rectangle draggedRect = new Rectangle(draggedLocation, draggedBounds.getSize());
                return targetBounds.intersects(draggedRect);
            }

            private void restoreToOriginal() {
                if (originalParent[0] != null && originalIndex[0] >= 0) {
                    originalParent[0].add(offerCardLabel, originalIndex[0]);
                    offerCardLabel.setLocation(originalLocation[0]);
                    originalParent[0].revalidate();
                    originalParent[0].repaint();
                } else if (originalLocation[0] != null) {
                    offerCardLabel.setLocation(originalLocation[0]);
                }
            }
        });

        offerCardLabel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currentPoint = SwingUtilities.convertPoint(offerCardLabel, e.getPoint(), layeredPane);
                int newX = currentPoint.x - initialOffset[0].x;
                int newY = currentPoint.y - initialOffset[0].y;
                offerCardLabel.setLocation(newX, newY);
            }
        });
    }


}