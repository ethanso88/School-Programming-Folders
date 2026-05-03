package View;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

	private JButton consumerPriceIndex;
	private JButton internationalTrades;
	private JButton farmPriceIndex;
	private JButton farmSustainability;

	private JButton[] menuButtons = { consumerPriceIndex, internationalTrades, farmPriceIndex,
			farmSustainability };

	public MenuPanel() {
		setSize(1186, 663);
		setLayout(null);

		// Fonts
		Font smallFont = new Font("SansSerif", Font.PLAIN, 16);
		Font normalFont = new Font("SansSerif", Font.PLAIN, 24);
		Font largeFont = new Font("SansSerif", Font.BOLD, 36);

		// "Welcome to Ontario's"
		JLabel welcomeLabel = new JLabel("Welcome to Ontario's", SwingConstants.CENTER);
		welcomeLabel.setFont(normalFont);
		welcomeLabel.setBounds(343, 40, 500, 30);
		add(welcomeLabel);

		// "Agriculture and Food"
		JLabel titleLabel = new JLabel("Agriculture and Food", SwingConstants.CENTER);
		titleLabel.setFont(largeFont);
		titleLabel.setBounds(293, 80, 600, 50);
		add(titleLabel);

		// "database"
		JLabel dbLabel = new JLabel("database", SwingConstants.CENTER);
		dbLabel.setFont(normalFont);
		dbLabel.setBounds(343, 135, 500, 30);
		add(dbLabel);

		// "What would you like to explore first"
		JLabel promptLabel = new JLabel("What would you like to explore first", SwingConstants.CENTER);
		promptLabel.setFont(smallFont);
		promptLabel.setBounds(393, 180, 400, 25);
		add(promptLabel);

		// Four buttons in a row
		int buttonWidth = 200;
		int buttonHeight = 50;
		int spacing = 40;
		int startX = (1186 - (4 * buttonWidth + 3 * spacing)) / 2;
		int y = 230;

		String[] buttonLabels = { "Imports & Exports", "Consumer Costs", "Farm Production",
				"FarmSustainability" };
		for (int i = 0; i < 4; i++) {
			menuButtons[i] = new JButton(buttonLabels[i]);
			menuButtons[i].setFocusPainted(false);
			menuButtons[i].setBounds(startX + i * (buttonWidth + spacing), y, buttonWidth, buttonHeight);
			add(menuButtons[i]);
		}
	}

	public JButton[] getMenuButtons() {
		return menuButtons;
	}

}
