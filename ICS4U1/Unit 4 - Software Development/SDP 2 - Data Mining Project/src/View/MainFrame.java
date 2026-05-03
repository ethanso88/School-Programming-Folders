package View;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    // Menu bar
    JMenuBar menuBar = new JMenuBar();

    // Menu items
    JMenuItem importsExportsItem = new JMenuItem("Imports & Exports");
    JMenuItem consumerCostsItem = new JMenuItem("Consumer Costs");
    JMenuItem farmProductItem = new JMenuItem("Farm Production");
    JMenuItem farmSustainabilityItem = new JMenuItem("Farm Sustainability");
    JMenuItem exitProgramItem = new JMenuItem("Exit Program");
    
    JMenuItem[] menuItems = {importsExportsItem, consumerCostsItem, farmProductItem, farmSustainabilityItem, exitProgramItem };

    Font smallFont = new Font("SansSerif", Font.PLAIN, 16);
    
    Component currentPanel;

    public MainFrame() {
        setTitle("Ontario's Agriculture and Food");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set layout to fill evenly
        menuBar.setLayout(new GridLayout(1, 5));
        menuBar.setBounds(0, 0, 1200, 35); // Match full frame width
        menuBar.setBackground(Color.LIGHT_GRAY);

        // Setup all menu items
        setupMenuItem(importsExportsItem);
        setupMenuItem(consumerCostsItem);
        setupMenuItem(farmProductItem);
        setupMenuItem(farmSustainabilityItem);
        setupMenuItem(exitProgramItem);

        // Add items to menu bar
        menuBar.add(importsExportsItem);
        menuBar.add(consumerCostsItem);
        menuBar.add(farmProductItem);
        menuBar.add(farmSustainabilityItem);
        menuBar.add(exitProgramItem);

        setVisible(true);
    }
    
    public void addMenuBar() {
    	setJMenuBar(menuBar);
    	revalidate();
    	repaint();
    }
    
    public void removeMenuBar() {
    	remove(menuBar);
    	revalidate();
    	repaint();
    }

    private void setupMenuItem(JMenuItem item) {
        item.setFont(smallFont);
        item.setHorizontalAlignment(SwingConstants.CENTER);
        item.setFocusPainted(false);
        item.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
        item.setBackground(Color.LIGHT_GRAY);
        item.setOpaque(true);
    }

	public JMenuItem[] getMenuItems() {
		return menuItems;
	}

	public Component getCurrentPanel() {
		return currentPanel;
	}
	
	public void setCurrentPanel(Component component) {
		currentPanel = component;
	}

}
