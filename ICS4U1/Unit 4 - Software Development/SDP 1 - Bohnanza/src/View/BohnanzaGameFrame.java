package View;

import javax.swing.*;
import javax.swing.border.Border;

import Controller.BohnanzaController;
import Controller.PlayerTurnController;
import Model.Card;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class BohnanzaGameFrame extends JFrame {
	
	public JLabel getBackgroundLabel() {
		return backgroundLabel;
	}

	public void setBackgroundLabel(JLabel backgroundLabel) {
		this.backgroundLabel = backgroundLabel;
	}

	public JScrollPane[] getHandScrollPanes() {
		return handScrollPanes;
	}

	public void setHandScrollPanes(JScrollPane[] handScrollPanes) {
		this.handScrollPanes = handScrollPanes;
	}

	public JPanel[] getHandPanels() {
		return handPanels;
	}

	public void setHandPanels(JPanel[] handPanels) {
		this.handPanels = handPanels;
	}

	public JLabel getCardLabel() {
		return cardLabel;
	}

	public void setCardLabel(JLabel cardLabel) {
		this.cardLabel = cardLabel;
	}

	public LinkedList<JButton>[] getPlayerHandQueues() {
		return playerHandQueues;
	}

	public void setPlayerHandQueues(LinkedList<JButton>[] playerHandQueues) {
		this.playerHandQueues = playerHandQueues;
	}

	public ArrayList<JLabel>[] getPlayerHands() {
		return playerHands;
	}

	public void setPlayerHands(ArrayList<JLabel>[] playerHands) {
		this.playerHands = playerHands;
	}

	public JPanel[] getPlayer1Fields() {
		return player1Fields;
	}

	public void setPlayer1Fields(JPanel[] player1Fields) {
		this.player1Fields = player1Fields;
	}

	public JPanel[] getPlayer2Fields() {
		return player2Fields;
	}

	public void setPlayer2Fields(JPanel[] player2Fields) {
		this.player2Fields = player2Fields;
	}

	public JLabel getCardLabel2() {
		return cardLabel2;
	}

	public void setCardLabel2(JLabel cardLabel2) {
		this.cardLabel2 = cardLabel2;
	}

	public JLabel getCardLabel1() {
		return cardLabel1;
	}

	public void setCardLabel1(JLabel cardLabel1) {
		this.cardLabel1 = cardLabel1;
	}

	public JButton getBuyPlayer1Field3Button() {
		return buyPlayer1Field3Button;
	}

	public void setBuyPlayer1Field3Button(JButton buyPlayer1Field3Button) {
		this.buyPlayer1Field3Button = buyPlayer1Field3Button;
	}

	public JButton getBuyPlayer2Field3Button() {
		return buyPlayer2Field3Button;
	}

	public void setBuyPlayer2Field3Button(JButton buyPlayer2Field3Button) {
		this.buyPlayer2Field3Button = buyPlayer2Field3Button;
	}

	public JLabel getTractorLabel() {
		return tractorLabel;
	}

	public void setTractorLabel(JLabel tractorLabel) {
		this.tractorLabel = tractorLabel;
	}

	public JLabel[][] getFieldCardCounters() {
		return fieldCardCounters;
	}

	public void setFieldCardCounters(JLabel[][] fieldCardCounters) {
		this.fieldCardCounters = fieldCardCounters;
	}

	public JPanel getOfferArea() {
		return offerArea;
	}

	public void setOfferArea(JPanel offerArea) {
		this.offerArea = offerArea;
	}

	public JButton getOfferButton() {
		return offerButton;
	}

	public void setOfferButton(JButton offerButton) {
		this.offerButton = offerButton;
	}

	public JLabel[] getOfferAreaLabel() {
		return offerAreaLabel;
	}

	public void setOfferAreaLabel(JLabel[] offerAreaLabel) {
		this.offerAreaLabel = offerAreaLabel;
	}

	public JLabel[] getOfferAreaCounter() {
		return offerAreaCounter;
	}

	public void setOfferAreaCounter(JLabel[] offerAreaCounter) {
		this.offerAreaCounter = offerAreaCounter;
	}

	public JButton getDrawPileButton() {
		return drawPileButton;
	}

	public void setDrawPileButton(JButton drawPileButton) {
		this.drawPileButton = drawPileButton;
	}

	public JButton getDiscardPileButton() {
		return discardPileButton;
	}

	public void setDiscardPileButton(JButton discardPileButton) {
		this.discardPileButton = discardPileButton;
	}

	public JLabel[] getCoinCounters() {
		return coinCounters;
	}

	public void setCoinCounters(JLabel[] coinCounters) {
		this.coinCounters = coinCounters;
	}

	public int getPlayer1Coins() {
		return player1Coins;
	}

	public void setPlayer1Coins(int player1Coins) {
		this.player1Coins = player1Coins;
	}

	public int getPlayer2Coins() {
		return player2Coins;
	}

	public void setPlayer2Coins(int player2Coins) {
		this.player2Coins = player2Coins;
	}

	public JLabel[] getHandCardCounters() {
		return handCardCounters;
	}

	public void setHandCardCounters(JLabel[] handCardCounters) {
		this.handCardCounters = handCardCounters;
	}

	public JButton getEndTurnButton() {
		return endTurnButton;
	}

	public void setEndTurnButton(JButton endTurnButton) {
		this.endTurnButton = endTurnButton;
	}
	
	public boolean isPlayer1Turn() {
		return isPlayer1Turn;
	}

	public void setPlayer1Turn(boolean isPlayer1Turn) {
		this.isPlayer1Turn = isPlayer1Turn;
	}

	public JLabel getPlayerTurnLabel() {
		return playerTurnLabel;
	}

	public void setPlayerTurnLabel(JLabel playerTurnLabel) {
		this.playerTurnLabel = playerTurnLabel;
	}
	
	public JButton getInfoButton() {
		return infoButton;
	}

	public void setInfoButton(JButton infoButton) {
		this.infoButton = infoButton;
	}

	public String getPlayer1Name() {
		return player1Name;
	}

	public void setPlayer1Name(String player1Name) {
		this.player1Name = player1Name;
	}

	public String getPlayer2Name() {
		return player2Name;
	}

	public void setPlayer2Name(String player2Name) {
		this.player2Name = player2Name;
	}

	public CircleButton getHelpButton() {
		return helpButton;
	}

	public void setHelpButton(CircleButton helpButton) {
		this.helpButton = helpButton;
	}

	public int getPlantCount() {
		return plantCount;
	}

	public void setPlantCount(int plantCount) {
		this.plantCount = plantCount;
	}

	public int getDiscardCount() {
		return discardCount;
	}

	public void setDiscardCount(int discardCount) {
		this.discardCount = discardCount;
	}

	public int getMAX_PLANTS_PER_TURN() {
		return MAX_PLANTS_PER_TURN;
	}

	public int getMAX_DISCARDS_PER_TURN() {
		return MAX_DISCARDS_PER_TURN;
	}

	public void setController(PlayerTurnController controller) {
		this.controller = controller;
	}

	private JLabel backgroundLabel;
	private JScrollPane[] handScrollPanes;
	private JPanel[] handPanels;
	private JLabel cardLabel;

	private LinkedList<JButton>[] playerHandQueues = new LinkedList[2]; // 0 = Player 1, 1 = Player 2
	private ArrayList<JLabel>[] playerHands;

	private JPanel[] player1Fields;
	private JPanel[] player2Fields;
	private JLabel cardLabel2;
	private JLabel cardLabel1;
	private JButton buyPlayer1Field3Button;
	private JButton buyPlayer2Field3Button;
	private JLabel tractorLabel;

	private JLabel[][] fieldCardCounters; // [player][field]
	private JPanel offerArea;
	private JButton offerButton;
	private JLabel[] offerAreaLabel;
	private JLabel[] offerAreaCounter;

	private JButton drawPileButton;
	private JButton discardPileButton;

	private JLabel[] coinCounters; // [0] = Player 1, [1] = Player 2
	private int player1Coins = 3; // or whatever starting value you want
	private int player2Coins = 0;

	private JLabel[] handCardCounters;

	private JButton endTurnButton;
	private boolean isPlayer1Turn = true; // Initial turn
	private JLabel playerTurnLabel;
	private JButton infoButton;

	private String player1Name;
	private String player2Name;

	private JLabel player1Label;
	private JLabel player2Label;

	private CircleButton helpButton;

	private int plantCount = 0;
	private int discardCount = 0;
	private final int MAX_PLANTS_PER_TURN = 2;
	private final int MAX_DISCARDS_PER_TURN = 1;

	private PlayerTurnController controller;
//	private Deck deck = BohnanzaController.deck;
//	private Player[] players = BohnanzaController.players;
//	private Card[] offerArea1 = BohnanzaController.offerArea;

	@SuppressWarnings("unchecked")
	public BohnanzaGameFrame(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;

		// ✅ Now initialize controller with all 4 arguments
		controller = new PlayerTurnController(this, BohnanzaController.deck, BohnanzaController.players, BohnanzaController.offerArea);

		playerHands = new ArrayList[2]; // ✅ FIX: Initialize the array here

		initializeFrame();
		setupUI();
		setVisible(true);
		
	    // Initialize controller components after UI is built
	    if (controller != null) {
	        controller.initializeComponents();
	    }
	}

	public void initializeControllerComponents() {
	    if (controller != null) {
	        // Setup action listeners now that components exist
	        if (drawPileButton != null) {
	            drawPileButton.addActionListener(controller);
	        }
	        if (endTurnButton != null) {
	            endTurnButton.addActionListener(controller);
	        }
	        // Add other listeners as needed
	    }
	}

	private void setupUI() {
		setTitle("Bohnanza Game");
		setSize(1366, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("images/Game Screen Logo.png").getImage());
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(new Color(222, 184, 135));

	}

	private void initializeFrame() {
		setupBackgroundLabel();
		setupPlayerNameLabels();
		setupTractorImage();
		setupHandPanels();
		setupFieldPanels();
		setupOfferArea();
		setupPiles();
		setupCoinCounters();
		setupEndTurnButton();
		setupHelpButton();
		

	}

	private void setupBackgroundLabel() {
		backgroundLabel = new JLabel(new ImageIcon("images/Bohnanza Image 2.jpg"));
		backgroundLabel.setBounds(0, 0, 1366, 768);
		backgroundLabel.setLayout(null);
		add(backgroundLabel);
	}

	private void setupPlayerNameLabels() {
		player1Label = new JLabel(player1Name, SwingConstants.CENTER);
		player1Label.setFont(new Font("Arial", Font.BOLD, 20));
		player1Label.setBounds(50, 30, 300, 30);
		backgroundLabel.add(player1Label);

		player2Label = new JLabel(player2Name, SwingConstants.CENTER);
		player2Label.setFont(new Font("Arial", Font.BOLD, 20));
		player2Label.setBounds(500, 30, 300, 30);
		backgroundLabel.add(player2Label);
	}

	private void setupTractorImage() {
		ImageIcon tractorIcon = new ImageIcon("images/Tractor.png");
		Image scaledImage = tractorIcon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		tractorLabel = new JLabel(new ImageIcon(scaledImage));
		tractorLabel.setBounds(635, 15, 75, 75);
		backgroundLabel.add(tractorLabel);
		controller.enableTractorDragAndDrop(tractorLabel); // ✅ Make it draggable
	}

	private void setupHandPanels() {
		handPanels = new JPanel[2];
		handScrollPanes = new JScrollPane[2];
		handCardCounters = new JLabel[2];

		backgroundLabel.setLayout(null); // Absolute layout for background label

		for (int i = 0; i < 2; i++) {
			handPanels[i] = new JPanel();
			// BoxLayout for vertical stacking
			handPanels[i].setLayout(new BoxLayout(handPanels[i], BoxLayout.Y_AXIS));
			handPanels[i].setOpaque(false);
			handPanels[i].setPreferredSize(new Dimension(150, 4000)); // Adjust size as needed

			// Create cards and add them to the panel
			for (Component comp : handPanels[i].getComponents()) {
				if (comp instanceof JComponent) {
					((JComponent) comp).setAlignmentX(Component.CENTER_ALIGNMENT); // Align each card horizontally
				}
			}

			handScrollPanes[i] = new JScrollPane(handPanels[i]);
			handScrollPanes[i].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			handScrollPanes[i].setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Disable
																										// horizontal
																										// scrolling
			handScrollPanes[i].setOpaque(false);
			handScrollPanes[i].getViewport().setOpaque(false);
			handScrollPanes[i].setBorder(null);

			// Position the scroll pane
			int x = 0 + i * 1150;
			int y = 0;
			int visibleWidth = 200; // Fixed visible width
			int visibleHeight = 750; // Fixed visible height
			handScrollPanes[i].setBounds(x, y + 30, visibleWidth, visibleHeight - 30); // Shift scrollpane down

			// Add hand counter label
			handCardCounters[i] = new JLabel("0", SwingConstants.CENTER);
			handCardCounters[i].setFont(new Font("Arial", Font.BOLD, 18));
			handCardCounters[i].setForeground(Color.WHITE);
			handCardCounters[i].setOpaque(true);
			handCardCounters[i].setBackground(new Color(139, 69, 19));
			handCardCounters[i].setBounds(x, y, visibleWidth, 30);
			backgroundLabel.add(handCardCounters[i]);

			// Attach the hand card counter as a client property
			handPanels[i].putClientProperty("handCounter", handCardCounters[i]);

			backgroundLabel.add(handScrollPanes[i]);

			playerHands[i] = new ArrayList<>();
		}
	}

	public void setupCards(ArrayList<Card> hand, int player) {
	    // Clear any existing cards in the panel before adding new ones
	    handPanels[player].removeAll();

	    System.out.println("Setting up cards for player " + player + " with " + hand.size() + " cards.");

	    for (Card card : hand) {
	        System.out.println("Adding card: " + card.getImagePath());

	        ImageIcon originalIcon = new ImageIcon(card.getImagePath());
	        Image originalImage = originalIcon.getImage();

	        // Scale the image for display
	        Image scaledImage = originalImage.getScaledInstance(150, 236, Image.SCALE_SMOOTH);
	        ImageIcon resizedIcon = new ImageIcon(scaledImage);

	        // Create JLabel for the card
	        JLabel cardLabel = new JLabel(resizedIcon);
	        cardLabel.setPreferredSize(new Dimension(150, 236)); // Size for hand panel
	        cardLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	        // Store the owner and original icon in client properties
	        cardLabel.putClientProperty("owner", player); // Track ownership
	        cardLabel.putClientProperty("originalIcon", originalIcon); // Store original for later reset

	        // Enable drag and drop for this card
	        controller.enableCardDragAndDrop(cardLabel, player == 0 ? "Player1" : "Player2");

	        // Add the card label to the player's hand and the hand panel
	        playerHands[player].add(cardLabel);
	        handPanels[player].add(cardLabel); // Add card to the player's panel

	        // Revalidate and repaint the hand panel to ensure the card is shown
	        handPanels[player].revalidate();
	        handPanels[player].repaint();
	    }

	    // Update the hand card counter
	    handCardCounters[player].setText(String.valueOf(playerHands[player].size()));
	}


	private void setupFieldPanels() {
		player1Fields = new JPanel[3];
		player2Fields = new JPanel[3];
		fieldCardCounters = new JLabel[2][3];

		Font font = new Font("Arial", Font.PLAIN, 20);

		for (int i = 0; i < 3; i++) {
			// PLAYER 1 FIELD PANEL
			player1Fields[i] = new ImagePanel("images/Fields Image.jpg");
			player1Fields[i].setLayout(new GridBagLayout()); // Center layout
			player1Fields[i].setBounds(220, 7 + i * (225 + 20), 150, 225);

			cardLabel1 = new JLabel();
			cardLabel1.setPreferredSize(new Dimension(110, 160));
			cardLabel1.setOpaque(false);
			player1Fields[i].add(cardLabel1); // Centered by default in GridBagLayout
			player1Fields[i].putClientProperty("cardLabel", cardLabel1);
			backgroundLabel.add(player1Fields[i]);

			// PLAYER 2 FIELD PANEL
			player2Fields[i] = new ImagePanel("images/Fields Image.jpg");
			player2Fields[i].setLayout(new GridBagLayout());
			player2Fields[i].setBounds(980, 7 + i * (225 + 20), 150, 225);

			cardLabel2 = new JLabel();
			cardLabel2.setPreferredSize(new Dimension(110, 160));
			cardLabel2.setOpaque(false);
			player2Fields[i].add(cardLabel2);
			player2Fields[i].putClientProperty("cardLabel", cardLabel2);
			backgroundLabel.add(player2Fields[i]);

			// ========== COUNTERS ==========
			fieldCardCounters[0][i] = new JLabel("0", SwingConstants.CENTER);
			fieldCardCounters[0][i].setBounds(370, 207 + i * (225 + 20), 20, 25);
			fieldCardCounters[0][i].setFont(font);
			fieldCardCounters[0][i].setBackground(new Color(139, 69, 19));
			fieldCardCounters[0][i].setForeground(Color.WHITE);
			fieldCardCounters[0][i].setOpaque(true);
			backgroundLabel.add(fieldCardCounters[0][i]);

			fieldCardCounters[1][i] = new JLabel("0", SwingConstants.CENTER);
			fieldCardCounters[1][i].setBounds(960, 207 + i * (225 + 20), 20, 25);
			fieldCardCounters[1][i].setFont(font);
			fieldCardCounters[1][i].setBackground(new Color(139, 69, 19));
			fieldCardCounters[1][i].setForeground(Color.WHITE);
			fieldCardCounters[1][i].setOpaque(true);
			backgroundLabel.add(fieldCardCounters[1][i]);
		}

		// ======== PLAYER 1 BUTTON ========
		buyPlayer1Field3Button = new JButton("Buy P1 Field 3");
		buyPlayer1Field3Button.setBounds(200, 600, 150, 40); // Adjust Y-position as needed
		buyPlayer1Field3Button.setBackground(new Color(139, 69, 19));
		buyPlayer1Field3Button.setForeground(Color.WHITE);
		player1Fields[2].add(buyPlayer1Field3Button);

		// Dim the third field initially (make it look locked)
		player1Fields[2].setEnabled(false);
		player1Fields[2].setBackground(Color.DARK_GRAY);
		player1Fields[2].setOpaque(true);
		player1Fields[2].setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		player1Fields[2].setToolTipText("Locked – Buy this field to use it");

//		buyPlayer1Field3Button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int choice = JOptionPane.showConfirmDialog(null, "Do you want to buy Player 1's Field 3 for 3 coins?",
//						"Confirm Purchase", JOptionPane.YES_NO_OPTION);
//				if (choice == JOptionPane.YES_OPTION) {
//					if (player1Coins >= 3) {
//						player1Coins -= 3;
//						coinCounters[0].setText("Coins: " + player1Coins);
//						player1Fields[2].setEnabled(true);
//						player1Fields[2].setOpaque(false);
//						player1Fields[2].repaint();
//						player1Fields[2].remove(buyPlayer1Field3Button);
//						backgroundLabel.repaint();
//					} else {
//						JOptionPane.showMessageDialog(null, "You don't have enough coins to buy Field 3!",
//								"Insufficient Coins", JOptionPane.ERROR_MESSAGE);
//					}
//				}
//			}
//		});

		// ======== PLAYER 2 BUTTON ========
		buyPlayer2Field3Button = new JButton("Buy P2 Field 3");
		buyPlayer2Field3Button.setBounds(1000, 600, 150, 40);
		buyPlayer2Field3Button.setBackground(new Color(139, 69, 19));
		buyPlayer2Field3Button.setForeground(Color.WHITE);
		player2Fields[2].add(buyPlayer2Field3Button);

		// Dim the third field initially (make it look locked)
		player2Fields[2].setEnabled(false);
		player2Fields[2].setBackground(Color.DARK_GRAY);
		player2Fields[2].setOpaque(true);
		player2Fields[2].setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		player2Fields[2].setToolTipText("Locked – Buy this field to use it");

//		buyPlayer2Field3Button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int choice = JOptionPane.showConfirmDialog(null, "Do you want to buy Player 2's Field 3 for 3 coins?",
//						"Confirm Purchase", JOptionPane.YES_NO_OPTION);
//				if (choice == JOptionPane.YES_OPTION) {
//					if (player2Coins >= 3) {
//						player2Coins -= 3;
//						coinCounters[1].setText("Coins: " + player2Coins);
//						player2Fields[2].setEnabled(true);
//						player2Fields[2].setOpaque(false);
//						player2Fields[2].repaint();
//						player2Fields[2].remove(buyPlayer2Field3Button);
//						backgroundLabel.repaint();
//					} else {
//						JOptionPane.showMessageDialog(null, "You don't have enough coins to buy Field 3!",
//								"Insufficient Coins", JOptionPane.ERROR_MESSAGE);
//					}
//				}
//			}
//		});
//
	}

	public JPanel getFieldPanelAt(Point locationOnScreen) {
		for (JPanel[] fieldGroup : new JPanel[][] { player1Fields, player2Fields }) {
			for (JPanel field : fieldGroup) {
				Point fieldLoc = field.getLocationOnScreen();
				Rectangle bounds = new Rectangle(fieldLoc.x, fieldLoc.y, field.getWidth(), field.getHeight());
				if (bounds.contains(locationOnScreen)) {
					return field;
				}
			}
		}
		return null;
	}

	private void setupOfferArea() {

		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 2); // 2px thick

		offerArea = new JPanel();
		offerArea.setLayout(null); // ✅ Allow absolute positioning
		offerArea.setBounds(450, 300, 450, 250);
		offerArea.setBackground(Color.GREEN);
		backgroundLabel.add(offerArea);

		offerAreaLabel = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			offerAreaLabel[i] = new JLabel();
			offerAreaLabel[i].setBounds(30 + (i * 140), 35, 110, 160); // relative to offerArea
			offerAreaLabel[i].setOpaque(false);
			offerAreaLabel[i].setBackground(Color.WHITE); // optional: visible background
			offerAreaLabel[i].setBorder(blackBorder); // Apply border
			offerArea.add(offerAreaLabel[i]);
		}

		offerButton = new JButton("Offer");
		offerButton.setBounds(150, 210, 150, 30);
		offerButton.setFont(new Font("Arial", Font.PLAIN, 20));
		offerButton.setBackground(Color.YELLOW);
		offerButton.setBorder(blackBorder); // Apply border
		offerArea.add(offerButton);

		offerAreaCounter = new JLabel[3];

		for (int i = 0; i < 3; i++) {
			
			Font font = new Font("Arial", Font.PLAIN, 20);
			
			offerAreaCounter[i] = new JLabel("0", SwingConstants.CENTER);
			offerAreaCounter[i].setBounds(140 + (i * 140), 170, 20, 25);
			offerAreaCounter[i].setFont(font);
			offerAreaCounter[i].setBackground(new Color(139, 69, 19));
			offerAreaCounter[i].setForeground(Color.WHITE);
			offerAreaCounter[i].setOpaque(true);
			offerArea.add(offerAreaCounter[i]);
			
			controller.enableOfferCardDragAndDrop(offerAreaLabel[i], offerAreaCounter);
		}
	}

	private void setupPiles() {
		drawPileButton = new JButton(new ImageIcon("images/Back.png"));
		drawPileButton.setBounds(525, 100, 110, 160);
		backgroundLabel.add(drawPileButton);

		discardPileButton = new JButton("Discard Pile");
		discardPileButton.setBounds(715, 100, 110, 160);
		discardPileButton.setFont(new Font("Arial", Font.PLAIN, 14));
		discardPileButton.setBackground(new Color(252, 241, 3));
		backgroundLabel.add(discardPileButton);
	}

	private void setupCoinCounters() {
		coinCounters = new JLabel[2];

		// Create a black border
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 2); // 2px thick

		// Player 1 coin counter
		coinCounters[0] = new JLabel("Coins: " + player1Coins, SwingConstants.CENTER);
		coinCounters[0].setFont(new Font("Arial", Font.PLAIN, 20));
		coinCounters[0].setBounds(420, 650, 100, 30);
		coinCounters[0].setOpaque(true);
		coinCounters[0].setBackground(new Color(252, 241, 3));
		coinCounters[0].setBorder(blackBorder); // Apply border
		backgroundLabel.add(coinCounters[0]);

		// Player 2 coin counter
		coinCounters[1] = new JLabel("Coins: " + player2Coins, SwingConstants.CENTER);
		coinCounters[1].setFont(new Font("Arial", Font.PLAIN, 20));
		coinCounters[1].setBounds(830, 650, 100, 30);
		coinCounters[1].setOpaque(true);
		coinCounters[1].setBackground(new Color(252, 241, 3));
		coinCounters[1].setBorder(blackBorder); // Apply border
		backgroundLabel.add(coinCounters[1]);
	}

	private void setupEndTurnButton() {
	    endTurnButton = new JButton("End Turn");

	    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
	    endTurnButton.setFont(new Font("Arial", Font.PLAIN, 20));
	    endTurnButton.setBounds(600, 650, 150, 30);
	    endTurnButton.setForeground(Color.WHITE);
	    endTurnButton.setBackground(new Color(255, 0, 0));
	    endTurnButton.setBorder(blackBorder);
	    backgroundLabel.add(endTurnButton);

	    // Show whose turn it is initially
	    playerTurnLabel = new JLabel("Current Turn: " + player1Name);
	    playerTurnLabel.setFont(new Font("Arial", Font.BOLD, 18));
	    playerTurnLabel.setForeground(Color.BLACK);
	    playerTurnLabel.setBounds(600, 610, 300, 30);
	    backgroundLabel.add(playerTurnLabel);

	    // Remove the action listener from here - it will be handled by the controller
	}

	private void setupHelpButton() {
		helpButton = new CircleButton("?");

		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 2); // 2px thick

		helpButton.setBounds(650, 600, 30, 30);
		endTurnButton.setBorder(blackBorder);
		backgroundLabel.add(helpButton);

	}

//	private void enableTractorDragAndDrop(Component component) {
//		Point[] initialClick = new Point[1];
//		Point[] initialOffset = new Point[1];
//		Point[] originalLocation = new Point[1];
//		Container[] originalParent = new Container[1];
//		JLayeredPane layeredPane = getLayeredPane(); // Ensure this is the correct layered pane for drag layer
//
//		// Set the initial tractor position when dragging starts
//		final Point startingLocation = new Point(635, 15); // This is the starting point defined in setupTractorImage()
//
//		component.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				initialClick[0] = SwingUtilities.convertPoint(component, e.getPoint(), layeredPane);
//				component.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
//
//				originalLocation[0] = component.getLocation();
//				originalParent[0] = component.getParent();
//
//				initialOffset[0] = new Point(initialClick[0].x - component.getX(),
//						initialClick[0].y - component.getY());
//
//				if (originalParent[0] != null) {
//					originalParent[0].remove(component);
//					component.setSize(component.getPreferredSize());
//					layeredPane.add(component, JLayeredPane.DRAG_LAYER);
//					layeredPane.repaint();
//				}
//			}
//		});
//
//		component.addMouseMotionListener(new MouseMotionAdapter() {
//			public void mouseDragged(MouseEvent e) {
//				Point currentPoint = SwingUtilities.convertPoint(component, e.getPoint(), layeredPane);
//				int newX = currentPoint.x - initialOffset[0].x;
//				int newY = currentPoint.y - initialOffset[0].y;
//				component.setLocation(newX, newY);
//			}
//		});
//
//		component.addMouseListener(new MouseAdapter() {
//			public void mouseReleased(MouseEvent e) {
//				component.setCursor(Cursor.getDefaultCursor());
//
//				Point screenPoint = e.getLocationOnScreen();
//				JPanel fieldPanelAtRelease = getFieldPanelAt(screenPoint);
//
//				layeredPane.remove(component);
//
//				if (fieldPanelAtRelease != null) {
//					int result = JOptionPane.showOptionDialog(null, "Do you want to harvest or discard the plant?",
//							"Choose Action", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
//							new String[] { "Harvest", "Discard" }, "Harvest");
//
//					component.setLocation(startingLocation); // Always reset
//
//					if (result == 0 || result == 1) { // Harvest or Discard
//						// Remove the card image
//						JLabel cardLabel = (JLabel) fieldPanelAtRelease.getClientProperty("cardLabel");
//						if (cardLabel != null) {
//							cardLabel.setIcon(null);
//							fieldPanelAtRelease.revalidate();
//							fieldPanelAtRelease.repaint();
//						}
//
//						// Reset the counter label
//						for (int player = 0; player < 2; player++) {
//							JPanel[] fields = player == 0 ? player1Fields : player2Fields;
//							for (int i = 0; i < 3; i++) {
//								if (fields[i] == fieldPanelAtRelease) {
//									fieldCardCounters[player][i].setText("0");
//									break;
//								}
//							}
//						}
//					}
//				} else {
//					component.setLocation(startingLocation);
//				}
//
//				if (originalParent[0] != null) {
//					originalParent[0].add(component, 0);
//					originalParent[0].revalidate();
//					originalParent[0].repaint();
//				}
//
//				layeredPane.repaint();
//			}
//		});
//
//	}
//
//	private void enableCardDragAndDrop(Component component, String playerID) {
//		Point[] initialClick = new Point[1];
//		Point[] initialOffset = new Point[1];
//		Point[] originalLocation = new Point[1];
//		Container[] originalParent = new Container[1];
//		int[] originalIndex = new int[1];
//		boolean[] isFirstCardDragged = new boolean[1];
//		JLayeredPane layeredPane = getLayeredPane();
//
//		component.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				component.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
//				originalParent[0] = component.getParent();
//				originalLocation[0] = component.getLocation();
//
//				// ✅ Store if this is the first card
//				if (originalParent[0] != null) {
//					Component[] handCards = originalParent[0].getComponents();
//					isFirstCardDragged[0] = (handCards.length > 0 && handCards[0] == component);
//					// ✅ FIXED: Store the index in the parent
//					originalIndex[0] = originalParent[0].getComponentZOrder(component);
//				}
//
//				if (component instanceof JLabel) {
//					ImageIcon originalIcon = (ImageIcon) ((JLabel) component).getClientProperty("originalIcon");
//					if (originalIcon != null) {
//						Image smallImage = originalIcon.getImage().getScaledInstance(100, 157, Image.SCALE_SMOOTH);
//						((JLabel) component).setIcon(new ImageIcon(smallImage));
//						component.setSize(100, 157);
//					}
//				}
//
//				Point convertedLocation = SwingUtilities.convertPoint(component.getParent(), component.getLocation(),
//						layeredPane);
//
//				if (originalParent[0] != null) {
//					originalParent[0].remove(component);
//					component.setLocation(convertedLocation);
//					layeredPane.add(component, JLayeredPane.DRAG_LAYER);
//					layeredPane.repaint();
//				}
//
//				Point layeredPaneClick = SwingUtilities.convertPoint(component, e.getPoint(), layeredPane);
//				initialClick[0] = layeredPaneClick;
//				initialOffset[0] = new Point(layeredPaneClick.x - convertedLocation.x,
//						layeredPaneClick.y - convertedLocation.y);
//			}
//
//			public void mouseReleased(MouseEvent e) {
//				component.setCursor(Cursor.getDefaultCursor());
//
//				Point screenPoint = e.getLocationOnScreen();
//				JPanel fieldPanelAtRelease = getFieldPanelAt(screenPoint);
//				layeredPane.remove(component);
//
//				// 🟡 Handle Discard
//				if (isOverlapping(component, discardPileButton)) {
//					if (discardCount >= MAX_DISCARDS_PER_TURN) {
//						JOptionPane.showMessageDialog(null, "You can only discard one card per turn.",
//								"Discard Limit Reached", JOptionPane.WARNING_MESSAGE);
//						restoreToOriginal();
//						layeredPane.repaint();
//						return;
//					}
//
//					int result = JOptionPane.showConfirmDialog(null, "Do you want to discard this card?",
//							"Confirm Discard", JOptionPane.YES_NO_OPTION);
//					if (result == JOptionPane.YES_OPTION) {
//						if (component instanceof JLabel) {
//							Icon discardedIcon = ((JLabel) component).getIcon();
//							discardPileButton.setIcon(discardedIcon);
//							discardPileButton.setText("");
//						}
//
//						discardCount++;
//						layeredPane.remove(component);
//						layeredPane.repaint();
//						return;
//					} else {
//						restoreToOriginal();
//						layeredPane.repaint();
//						return;
//					}
//				}
//
//				// 🔵 Handle Planting on Field
//				if (fieldPanelAtRelease != null) {
//					if (plantCount >= MAX_PLANTS_PER_TURN) {
//						JOptionPane.showMessageDialog(null, "You can only plant two cards per turn.",
//								"Plant Limit Reached", JOptionPane.WARNING_MESSAGE);
//						restoreToOriginal();
//						layeredPane.repaint();
//						return;
//					}
//
//					// ✅ Rely only on isFirstCardDragged
//					if (!isFirstCardDragged[0]) {
//						JOptionPane.showMessageDialog(null, "You must plant the first card in your hand first.",
//								"Top Card Rule", JOptionPane.WARNING_MESSAGE);
//						restoreToOriginal();
//						layeredPane.repaint();
//						return;
//					}
//
//					int playerIndex = -1, fieldIndex = -1;
//					for (int i = 0; i < 3; i++) {
//						if (fieldPanelAtRelease == player1Fields[i]) {
//							playerIndex = 0;
//							fieldIndex = i;
//							break;
//						} else if (fieldPanelAtRelease == player2Fields[i]) {
//							playerIndex = 1;
//							fieldIndex = i;
//							break;
//						}
//					}
//
//					if (fieldIndex == 2 && !fieldPanelAtRelease.isEnabled()) {
//						JOptionPane.showMessageDialog(null, "You need to buy this field before using it!",
//								"Field Locked", JOptionPane.WARNING_MESSAGE);
//						restoreToOriginal();
//						layeredPane.repaint();
//						return;
//					}
//
//					Icon draggedIcon = (component instanceof JLabel) ? ((JLabel) component).getIcon() : null;
//					JLabel existingCardLabel = (JLabel) fieldPanelAtRelease.getClientProperty("cardLabel");
//					Icon fieldIcon = (existingCardLabel != null) ? existingCardLabel.getIcon() : null;
//
//					// ✅ FIXED: Use Image comparison
//					boolean canPlant = (fieldIcon == null || (draggedIcon != null
//							&& ((ImageIcon) draggedIcon).getImage() == ((ImageIcon) fieldIcon).getImage()));
//
//					Border originalBorder = fieldPanelAtRelease.getBorder();
//					fieldPanelAtRelease
//							.setBorder(BorderFactory.createLineBorder(canPlant ? Color.GREEN : Color.RED, 3));
//
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException ex) {
//					}
//
//					if (canPlant) {
//						int result = JOptionPane.showConfirmDialog(null, "Do you want to plant this card here?",
//								"Plant Card", JOptionPane.YES_NO_OPTION);
//						if (result == JOptionPane.YES_OPTION) {
//							plantCount++;
//
//							if (playerIndex != -1 && fieldIndex != -1) {
//								int count = Integer.parseInt(fieldCardCounters[playerIndex][fieldIndex].getText());
//								fieldCardCounters[playerIndex][fieldIndex].setText(String.valueOf(count + 1));
//							}
//
//							if (existingCardLabel == null) {
//								existingCardLabel = new JLabel();
//								existingCardLabel.setHorizontalAlignment(JLabel.CENTER);
//								existingCardLabel.setVerticalAlignment(JLabel.CENTER);
//								fieldPanelAtRelease.setLayout(new BorderLayout());
//								fieldPanelAtRelease.add(existingCardLabel, BorderLayout.CENTER);
//								fieldPanelAtRelease.putClientProperty("cardLabel", existingCardLabel);
//							}
//
//							existingCardLabel.setIcon(draggedIcon);
//
//							JLabel handCounter = (JLabel) ((JComponent) originalParent[0])
//									.getClientProperty("handCounter");
//							if (handCounter != null) {
//								int count = Integer.parseInt(handCounter.getText());
//								handCounter.setText(String.valueOf(count - 1));
//							}
//
//							fieldPanelAtRelease.revalidate();
//							fieldPanelAtRelease.repaint();
//						} else {
//							restoreToOriginal();
//						}
//					} else {
//						JOptionPane.showMessageDialog(null,
//								"You can't plant this card here because it's different from the one already planted.",
//								"Invalid Plant", JOptionPane.WARNING_MESSAGE);
//						restoreToOriginal();
//					}
//
//					fieldPanelAtRelease.setBorder(originalBorder);
//				} else {
//					restoreToOriginal();
//				}
//
//				layeredPane.repaint();
//			}
//
//			private boolean isOverlapping(Component dragged, Component target) {
//				Rectangle draggedBounds = dragged.getBounds();
//				Point draggedLocation = SwingUtilities.convertPoint(dragged.getParent(), draggedBounds.getLocation(),
//						getLayeredPane());
//
//				Rectangle targetBounds = SwingUtilities.convertRectangle(target.getParent(), target.getBounds(),
//						getLayeredPane());
//				Rectangle draggedRect = new Rectangle(draggedLocation, draggedBounds.getSize());
//
//				return targetBounds.intersects(draggedRect);
//			}
//
//			private void restoreToOriginal() {
//				if (component instanceof JLabel) {
//					ImageIcon originalIcon = (ImageIcon) ((JLabel) component).getClientProperty("originalIcon");
//					if (originalIcon != null) {
//						Image fullImage = originalIcon.getImage().getScaledInstance(150, 236, Image.SCALE_SMOOTH);
//						((JLabel) component).setIcon(new ImageIcon(fullImage));
//						component.setSize(150, 236); // ✅ Consistent with original size
//					}
//				}
//
//				if (originalParent[0] != null && originalIndex[0] >= 0) {
//					originalParent[0].add(component, originalIndex[0]);
//					originalParent[0].revalidate();
//					originalParent[0].repaint();
//				} else if (originalLocation[0] != null) {
//					component.setLocation(originalLocation[0]);
//				}
//			}
//		});
//
//		component.addMouseMotionListener(new MouseMotionAdapter() {
//			public void mouseDragged(MouseEvent e) {
//				Point currentPoint = SwingUtilities.convertPoint(component, e.getPoint(), layeredPane);
//				int newX = currentPoint.x - initialOffset[0].x;
//				int newY = currentPoint.y - initialOffset[0].y;
//				component.setLocation(newX, newY);
//			}
//		});
//	}
}