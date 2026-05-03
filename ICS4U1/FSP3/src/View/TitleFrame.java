package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleFrame {

    // Field components
    private JFrame frame;
    private JButton helpButton;
    private JTextField searchBar;
    private JPanel filterPanel;
    private JButton[] filterButtons;
    private JLabel[] filterIcons;

    // Material names and icon filenames in the requested order
    private static final String[] MATERIALS = {
        "Nanotubes", "Fullerenes", "Graphene", "Nanoparticles", "Quantum Dots", "Nanofibers", "Nanowires"
    };
    // Update these extensions to match your actual files!
    private static final String[] ICONS = {
        "nanotubes.jpg",
        "fullerenes.jpg",
        "graphene.jpg",
        "nanoparticles.jpg",
        "quantumdots.jpg",
        "nanofibers.jpg",
        "nanowires.jpg"
    };

    public TitleFrame() {
        frameSetup();
    }

    private void frameSetup() {
        // Frame Setup:
        frame = new JFrame("Nanoscale Material Database Application");
        frame.setSize(1366, 768);
        frame.getContentPane().setBackground(Color.decode("#145da0")); // Use the requested color
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

  // Frame Logo (replace text label with image)
String logoPath = "FSP/Icons/nmda_logo.png";
java.io.File logoFile = new java.io.File(logoPath);
if (logoFile.exists()) {
    // Load the image and scale it to a natural size (preserving aspect ratio)
    ImageIcon originalIcon = new ImageIcon(logoPath);
    Image img = originalIcon.getImage();
    int maxDim = 300; // bigger size
    int width = originalIcon.getIconWidth();
    int height = originalIcon.getIconHeight();
    double scale = (double) maxDim / Math.max(width, height);
    int scaledWidth = (int) (width * scale);
    int scaledHeight = (int) (height * scale);
    Image scaledImg = img.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
    ImageIcon logoIcon = new ImageIcon(scaledImg);
    int padding = 5; // smaller padding for closer to edges
    JLabel logoLabel = new JLabel(logoIcon);
    logoLabel.setBounds(padding, padding, scaledWidth, scaledHeight);
    frame.add(logoLabel);
} else {
    JLabel logoLabel = new JLabel("NMDA");
    logoLabel.setFont(new Font("Arial", Font.BOLD, 32));
    logoLabel.setForeground(Color.WHITE);
    int padding = 5;
    logoLabel.setBounds(padding, padding, 300, 40);
    frame.add(logoLabel);
}

        // Search Bar
        searchBar = new JTextField("Enter Material Here");
        searchBar.setFont(new Font("Arial", Font.PLAIN, 18));
        searchBar.setBounds(493, 120, 380, 40);
        frame.add(searchBar);

        // Help button (bigger and circular)
        helpButton = new CircularButton("?");
        helpButton.setFont(new Font("Arial", Font.BOLD, 32));
        helpButton.setBackground(Color.WHITE);
        helpButton.setForeground(Color.BLACK);
        helpButton.setBounds(1270, 20, 70, 70);
        frame.add(helpButton);

        // Filter panel (white border)
        filterPanel = new JPanel(null);
        filterPanel.setBackground(new Color(15, 15, 60));
        filterPanel.setBounds(120, 260, 1126, 260);
        filterPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        frame.add(filterPanel);

        // 7 Filter icons and buttons, evenly spaced
        int num = MATERIALS.length;
        filterIcons = new JLabel[num];
        filterButtons = new JButton[num];
        int iconY = 20;
        int iconSize = 70;
        int buttonY = 120;
        int buttonWidth = 150;
        int buttonHeight = 32;
        int gap = (filterPanel.getWidth() - num * iconSize) / (num + 1);

        for (int i = 0; i < num; i++) {
            int x = gap + i * (iconSize + gap);

            // Use relative file path for image loading
            String relPath = "FSP/Icons/" + ICONS[i];
            ImageIcon icon = null;
            java.io.File imgFile = new java.io.File(relPath);
            if (imgFile.exists()) {
                icon = new ImageIcon(new ImageIcon(relPath).getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
            }

            if (icon != null && icon.getIconWidth() > 0 && icon.getIconHeight() > 0) {
                JLabel iconLabel = new JLabel(icon);
                iconLabel.setBounds(x, iconY, iconSize, iconSize);
                iconLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
                filterPanel.add(iconLabel);
                filterIcons[i] = iconLabel;
            } else {
                filterIcons[i] = null; // No label if image not found
            }

            // Button (as link)
            filterButtons[i] = new JButton(MATERIALS[i]);
            filterButtons[i].setFont(new Font("Arial", Font.PLAIN, 16));
            filterButtons[i].setForeground(Color.CYAN);
            filterButtons[i].setBackground(new Color(15, 15, 60));
            filterButtons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            filterButtons[i].setFocusPainted(false);
            filterButtons[i].setBounds(x - (buttonWidth - iconSize) / 2, buttonY, buttonWidth, buttonHeight);
            filterPanel.add(filterButtons[i]);
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Custom circular button class for help button
    private static class CircularButton extends JButton {
        public CircularButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillOval(0, 0, getWidth(), getHeight());
            g2.setColor(getForeground());
            g2.setFont(getFont());
            FontMetrics fm = g2.getFontMetrics();
            int stringWidth = fm.stringWidth(getText());
            int stringHeight = fm.getAscent();
            g2.drawString(getText(), (getWidth() - stringWidth) / 2, (getHeight() + stringHeight) / 2 - 4);
            g2.dispose();
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2));
            g2.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
            g2.dispose();
        }

        @Override
        public boolean contains(int x, int y) {
            int radius = getWidth() / 2;
            int centerX = radius;
            int centerY = getHeight() / 2;
            return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
        }
    }

    public void dispose() {
        frame.dispose();
    }

    public JTextField getSearchBar() { return searchBar; }
    public JButton getHelpButton() { return helpButton; }
    public JButton[] getFilterButtons() { return filterButtons; }

}