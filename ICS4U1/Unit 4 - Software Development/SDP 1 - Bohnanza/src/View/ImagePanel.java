package View;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();
        setLayout(null); // you wanted manual layout
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the image to fill the entire panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
