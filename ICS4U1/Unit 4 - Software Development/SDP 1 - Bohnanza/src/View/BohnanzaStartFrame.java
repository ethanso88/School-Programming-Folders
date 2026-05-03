// This class defines the start screen for the Bohnanza game.
// It includes buttons for Player vs Player, AI mode, and Rules,
// and plays background music when the frame is launched.

package View;

// Importing necessary libraries
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BohnanzaStartFrame extends JFrame {

	// UI components for the screen
	private JLabel backgroundLabel;
	private JButton pvpButton;
	private JButton aiButton;
	private JButton rulesButton;

	// Music player object to control background music
	private MusicPlayer music;

	// Constructor that sets up the frame and starts music
	public BohnanzaStartFrame() {

		// Play background music when the frame is initialized
		music = new MusicPlayer();
		music.playMusic("sounds/Bonanza theme sung by Johnny Cash.wav");

		// Initialize the UI layout and elements
		initializeFrame();
		setupUI();
		setVisible(true); // Make the frame visible
	}

	// Sets basic frame properties like size, title, icon, etc.
	private void setupUI() {
		setSize(450, 730); // Set frame size
		setTitle("Bohnanza 2 player version - Title Frame"); // Set window title
		setIconImage(new ImageIcon("images/Game Screen Logo.png").getImage()); // Set window icon
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program on window close
		getContentPane().setBackground(Color.DARK_GRAY); // Set background color
		setLayout(null); // Use absolute positioning
	}

	// Adds UI components to the frame
	private void initializeFrame() {
		setupBackgroundLabel(); // Add image
		setupPVPButton(); // Add PvP button
		setupVsAIButton(); // Add AI button
		setupRulesButton(); // Add Rules button
	}

	// Adds the game image as the background
	private void setupBackgroundLabel() {
		backgroundLabel = new JLabel(new ImageIcon("images/Bohnanza Image 1.jpg"));
		backgroundLabel.setBounds(15, 0, 403, 550);
		backgroundLabel.setLayout(null);
		add(backgroundLabel);
	}

	// Sets up the Player vs Player button
	private void setupPVPButton() {
		pvpButton = new JButton();
		pvpButton.setBounds(15, 625, 150, 50);
		pvpButton.setBackground(new Color(252, 241, 3)); // Yellow
		pvpButton.setFont(new Font("Montserrat", Font.PLAIN, 20));
		pvpButton.setText("PvP");
		pvpButton.setFocusPainted(false);
		pvpButton.setForeground(Color.BLACK);
//		pvpButton.addActionListener(this);
		add(pvpButton);
	}

	// Sets up the Versus AI button
	private void setupVsAIButton() {
		aiButton = new JButton();
		aiButton.setBounds(265, 625, 150, 50);
		aiButton.setBackground(new Color(252, 241, 3)); // Yellow
		aiButton.setFont(new Font("Montserrat", Font.PLAIN, 20));
		aiButton.setText("Vs AI");
		aiButton.setFocusPainted(false);
		aiButton.setForeground(Color.BLACK);
//		aiButton.addActionListener(this);
		add(aiButton);
	}

	// Sets up the Rules button
	private void setupRulesButton() {
		rulesButton = new JButton();
		rulesButton.setBounds(140, 560, 150, 50);
		rulesButton.setBackground(new Color(252, 241, 3)); // Yellow
		rulesButton.setFont(new Font("Montserrat", Font.PLAIN, 20));
		rulesButton.setText("Rules");
		rulesButton.setFocusPainted(false);
		rulesButton.setForeground(Color.BLACK);
//		rulesButton.addActionListener(this);
		add(rulesButton);
	}

	// Handles button click events
//	@Override
//	public void actionPerformed(ActionEvent event) {
//		Object source = event.getSource();
//
//		// If the Rules button is clicked
//		if (source == rulesButton) {
//			try {
//				// Try to open the PDF file from the "rules" folder
//				File pdfFile = new File("rules/Bohnanza Rules.pdf");
//				if (pdfFile.exists()) {
//					Desktop.getDesktop().open(pdfFile);
//				} else {
//					// Show error if file not found
//					JOptionPane.showMessageDialog(this, "Bohnanza Rules file not found in /rules folder.", "Error",
//							JOptionPane.ERROR_MESSAGE);
//				}
//			} catch (Exception e) {
//				// Handle any error that occurs when opening the file
//				e.printStackTrace();
//				JOptionPane.showMessageDialog(this, "Unable to open the rules file.", "Error",
//						JOptionPane.ERROR_MESSAGE);
//			}
//
//			// If the PvP button is clicked
//		} else if (source == pvpButton) {
//			
//			// Prompt for player names
//			String player1Name = JOptionPane.showInputDialog(this, "Enter name for Player 1:");
//			if (player1Name == null || player1Name.trim().isEmpty()) return; // Cancel or empty
//
//			String player2Name = JOptionPane.showInputDialog(this, "Enter name for Player 2:");
//			if (player2Name == null || player2Name.trim().isEmpty()) return; // Cancel or empty
//
//			// Pass names to game frame
//			new BohnanzaGameFrame(player1Name.trim(), player2Name.trim());
//			music.stopMusic(); // Stop the background music
//			this.dispose(); // Close the current window
//
//			// If the AI button is clicked
//		} else if (source == aiButton) {
//			// Show a popup to let user select difficulty
//			String player1Name = JOptionPane.showInputDialog(this, "Enter your name:");
//			if (player1Name == null || player1Name.trim().isEmpty()) return;
//
//			String[] options = { "Easy", "Medium", "Hard" };
//			String difficulty = (String) JOptionPane.showInputDialog(this,
//					"Which level of AI would you like to play against?", "Select AI Difficulty",
//					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//
//			if (difficulty != null) {
//				JOptionPane.showMessageDialog(this, "You selected: " + difficulty + " AI", "Difficulty Selected",
//						JOptionPane.INFORMATION_MESSAGE);
//
//				new BohnanzaGameFrame(player1Name.trim(), "AI (" + difficulty + ")");
//				music.stopMusic(); // Stop the background music
//				this.dispose(); // Close the current window
//			}
//		}
//	}

	public MusicPlayer getMusic() {
		return music;
	}

	public void setMusic(MusicPlayer music) {
		this.music = music;
	}

	public JButton getPvpButton() {
		return pvpButton;
	}

	public void setPvpButton(JButton pvpButton) {
		this.pvpButton = pvpButton;
	}

	public JButton getAiButton() {
		return aiButton;
	}

	public void setAiButton(JButton aiButton) {
		this.aiButton = aiButton;
	}

	public JButton getRulesButton() {
		return rulesButton;
	}

	public void setRulesButton(JButton rulesButton) {
		this.rulesButton = rulesButton;
	}
}
