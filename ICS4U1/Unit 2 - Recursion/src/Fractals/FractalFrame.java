package Fractals;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class FractalFrame extends JFrame implements ActionListener {

    // Creating the menu bar and its components
    private JMenuBar menubar = new JMenuBar();
    private JMenu fractalMenu = new JMenu("Fractal");
    private JMenuItem[] fractalArray = new JMenuItem[5]; // Array to hold menu items for different fractals

    // Creating the control panel and fractal display panel
    private JPanel controlPanel = new JPanel();
    private FractalPanel fractalPanel = new FractalPanel(0); // Panel that displays the fractal

    // Buttons and labels for controlling the fractal
    private JButton changeColorButton = new JButton("Color");
    private JButton increaseLevelButton = new JButton("Increase Level");
    private JButton decreaseLevelButton = new JButton("Decrease Level");
    private JLabel levelLabel = new JLabel("Level: 0");

    // Constants for minimum and maximum levels of different fractals
    private static final int MIN_LEVEL = 0;
    private static final int MAX_DRAGON = 20, MAX_LO = 10, MAX_SIERPINSKI = 7, MAX_KOCH = 8, MAX_TREE = 12;

    // String to hold the current selected fractal type
    public static String fractalType = "";

    // Constructor that sets up the frame, menu, and control buttons
    public FractalFrame() {
        // Set the layout for the frame
        setLayout(new FlowLayout());
        setTitle("Hitarth Patel's Fractal App"); // Set the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the app closes when the window is closed
        setSize(1366, 768); // Set the size of the window

        // Create menu items for each fractal type
        fractalArray[0] = new JMenuItem("Dragon Curve");
        fractalArray[1] = new JMenuItem("Lo Fractal");
        fractalArray[2] = new JMenuItem("Sierpinski Triangle");
        fractalArray[3] = new JMenuItem("Koch Snowflake");
        fractalArray[4] = new JMenuItem("Fractal Tree");

        // Add menu items to the fractal menu and set action listeners
        for (JMenuItem item : fractalArray) {
            fractalMenu.add(item);
            item.addActionListener(this); // Each menu item triggers the actionPerformed method
        }

        // Add the fractal menu to the menu bar
        menubar.add(fractalMenu);
        setJMenuBar(menubar); // Set the menu bar for the frame

        // Setup the control buttons
        setupControlButtons();

        // Add the level label to the control panel
        controlPanel.add(levelLabel);

        // Add control panel and fractal display panel to the frame
        add(controlPanel);
        add(fractalPanel);

        setVisible(true); // Make the frame visible
    }

    // Method to setup the control buttons (Color, Increase Level, Decrease Level)
    private void setupControlButtons() {
        // Add color change button and set its action
        controlPanel.add(changeColorButton);
        changeColorButton.addActionListener(event -> {
            // Open a color chooser dialog
            Color color = JColorChooser.showDialog(FractalFrame.this, "Choose a color", Color.WHITE);
            if (color == null) // If no color is selected, set it to white
                color = Color.WHITE;
            fractalPanel.setColor(color); // Set the selected color to the fractal panel
        });

        // Add decrease level button and set its action
        controlPanel.add(decreaseLevelButton);
        decreaseLevelButton.addActionListener(event -> {
            // Get the current level of the fractal
            int level = fractalPanel.getLevel();
            if (level > MIN_LEVEL) { // Ensure the level doesn't go below the minimum
                level--; // Decrease the level
                levelLabel.setText("Level: " + level); // Update the label to show the new level
                fractalPanel.setLevel(level); // Update the fractal panel with the new level
                repaint(); // Repaint the panel to reflect the changes
            }
        });

        // Add increase level button and set its action
        controlPanel.add(increaseLevelButton);
        increaseLevelButton.addActionListener(event -> {
            // Get the current level of the fractal
            int level = fractalPanel.getLevel();
            int maxLevel = getMaxLevelForFractal(); // Get the maximum level for the current fractal
            if (level < maxLevel) { // Ensure the level doesn't exceed the maximum level
                level++; // Increase the level
                levelLabel.setText("Level: " + level); // Update the label to show the new level
                fractalPanel.setLevel(level); // Update the fractal panel with the new level
                repaint(); // Repaint the panel to reflect the changes
            }
        });
    }

    // Method to get the maximum level for the current fractal type
    private int getMaxLevelForFractal() {
        // Based on the selected fractal, return the corresponding maximum level
        if (fractalType.equals("Dragon Curve")) {
            return MAX_DRAGON;
        } else if (fractalType.equals("Lo Fractal")) {
            return MAX_LO;
        } else if (fractalType.equals("Sierpinski Triangle")) {
            return MAX_SIERPINSKI;
        } else if (fractalType.equals("Koch Snowflake")) {
            return MAX_KOCH;
        } else if (fractalType.equals("Fractal Tree")) {
            return MAX_TREE;
        } else {
            return MAX_DRAGON; // Default case for Dragon Curve
        }
    }

    // Action listener method to handle menu item clicks
    @Override
    public void actionPerformed(ActionEvent event) {
        // Check if the event source is a JMenuItem (a fractal type)
        if (event.getSource() instanceof JMenuItem) {
            JMenuItem menuItem = (JMenuItem) event.getSource();
            fractalType = menuItem.getText(); // Set the current fractal type based on the clicked menu item
            levelLabel.setText("Level: 0"); // Reset the level to 0
            fractalPanel.setLevel(0); // Reset the fractal panel level
            repaint(); // Repaint the panel to display the new fractal
        }
    }
}